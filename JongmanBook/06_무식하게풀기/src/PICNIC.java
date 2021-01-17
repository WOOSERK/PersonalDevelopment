/*
소풍

https://www.algospot.com/judge/problem/read/PICNIC
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-01-12
 * Time: 오후 5:15
 */

public class PICNIC
{
    static int n;
    static int m;
    static boolean[][] friend;
    static boolean[] isEnd;
    static int cnt;

    public static void foo()
    {
        int next = -1;
        for(int i=0; i<n; i++)
        {
            if(!isEnd[i])
            {
                next = i;
                break;
            }
        }

        if(next == -1)
        {
            cnt++;
            return;
        }

        for(int i=next+1; i<n; i++)
        {
            if(!isEnd[i] && friend[next][i])
            {
                isEnd[next] = isEnd[i] = true;
                foo();
                isEnd[next] = isEnd[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int C = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();
        while(C-- > 0)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            friend = new boolean[10][10];
            isEnd = new boolean[10];
            cnt = 0;

            st = new StringTokenizer(br.readLine());
            for(int i=0; i<m; i++)
            {
                int f1 = Integer.parseInt(st.nextToken());
                int f2 = Integer.parseInt(st.nextToken());
                friend[f1][f2] = true;
                friend[f2][f1] = true;
            }

            foo();

            sb.append(cnt).append('\n');
        }

        System.out.print(sb.toString());
    }
}
