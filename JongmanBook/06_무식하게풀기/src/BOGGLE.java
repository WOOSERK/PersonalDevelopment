/*
보글 게임

https://www.algospot.com/judge/problem/read/BOGGLE
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-01-12
 * Time: 오후 4:56
 */

public class BOGGLE
{
    static char[][] ary;
    static int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};

    public static boolean dfs(int index, int r, int c, String str)
    {
        if(index == str.length())
            return true;

        for(int k=0; k<8; k++)
        {
            int newR = r + dr[k];
            if(newR < 0 || newR >= 5)
                continue;

            int newC = c + dc[k];
            if(newC < 0 || newC >= 5)
                continue;

            if(ary[newR][newC] == str.charAt(index))
            {
                if(dfs(index+1, newR, newC, str))
                    return true;
            }
        }

        return false;
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int C = Integer.parseInt(br.readLine());

        StringBuffer sb = new StringBuffer();
        while(C-- > 0)
        {
            ary = new char[5][5];

            for(int i=0; i<5; i++)
            {
                String str = br.readLine();

                for(int j=0; j<5; j++)
                    ary[i][j] = str.charAt(j);
            }

            int N = Integer.parseInt(br.readLine());

            for(int i=0; i<N; i++)
            {
                String str = br.readLine();

                boolean found = false;
                char ch = str.charAt(0);
                sb.append(str);
                for(int r=0; r<5; r++)
                {
                    for(int c=0; c<5; c++)
                    {
                        if(ary[r][c] == ch)
                        {
                            if(dfs(1, r, c, str))
                            {
                                found = true;
                                sb.append(' ').append("YES\n");
                                break;
                            }
                        }
                    }

                    if(found)
                        break;
                }

                if(!found)
                    sb.append(' ').append("NO\n");
            }
        }

        System.out.print(sb.toString());
    }
}
