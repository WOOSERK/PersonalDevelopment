/*
트리 순회 순서 변경

https://algospot.com/judge/problem/read/TRAVERSAL
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-01-18
 * Time: 오후 6:52
 */

public class TRAVERSAL
{
    static int[] pre = new int[101];
    static int[] in = new int[101];
    static StringBuffer sb = new StringBuffer();

    public static void postOrder(int pStart, int pEnd, int iStart, int iEnd)
    {
        int root = pre[pStart];

        if(pStart > pEnd)
            return;

        int leftSize = 0;
        for(int i=iStart; i<=iEnd; i++)
        {
            if(in[i] == root)
            {
                leftSize = i - iStart;
                break;
            }
        }

        postOrder(pStart+1, pStart+leftSize, iStart, iStart+leftSize-1);
        postOrder(pStart+leftSize+1, pEnd, iStart+leftSize+1, iEnd);

        sb.append(root).append(' ');
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int C = Integer.parseInt(br.readLine());

        while(C-- > 0)
        {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++)
                pre[i] = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++)
                in[i] = Integer.parseInt(st.nextToken());

            postOrder(0, N-1, 0, N-1);
            sb.append('\n');
        }

        System.out.print(sb.toString());
    }
}
