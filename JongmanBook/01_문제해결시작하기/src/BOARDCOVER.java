/*
게임판 덮기

https://www.algospot.com/judge/problem/read/BOARDCOVER
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-01-12
 * Time: 오후 8:06
 */

public class BOARDCOVER
{
    static int H;
    static int W;
    static char[][] ary;
    static int cnt;
    // [4][2][2]
    static int[][][] d = {{{1, 0}, {0, 1}}, {{0, 1}, {1, 1}}, {{1, 0}, {1, 1}}, {{1, 0}, {1, -1}}};

    public static void foo()
    {
        int i = -1;
        int j = -1;

        for(int r=0; r<H; r++)
        {
            for(int c=0; c<W; c++)
            {
                if(ary[r][c] == '.')
                {
                    i = r;
                    j = c;
                    break;
                }
            }
            if(i != -1)
                break;
        }

        if(i == -1)
        {
            cnt++;
            return;
        }

        for(int k=0; k<4; k++)
        {
            boolean ok = true;

            for(int l=0; l<2; l++)
            {
                int newI = i + d[k][l][0];
                if(newI < 0 || newI >= H)
                {
                    ok = false;
                    break;
                }

                int newJ = j + d[k][l][1];
                if(newJ < 0 || newJ >= W)
                {
                    ok = false;
                    break;
                }

                if(ary[newI][newJ] != '.')
                {
                    ok = false;
                    break;
                }
            }

            if(ok)
            {
                int fI = i + d[k][0][0];
                int fJ = j + d[k][0][1];

                int sI = i + d[k][1][0];
                int sJ = j + d[k][1][1];

                ary[i][j] = '!';
                ary[fI][fJ] = '!';
                ary[sI][sJ] = '!';

                foo();

                ary[i][j] = '.';
                ary[fI][fJ] = '.';
                ary[sI][sJ] = '.';
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

            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());

            ary = new char[21][21];
            cnt = 0;
            int dotCnt = 0;
            for(int i=0; i<H; i++)
            {
                String str = br.readLine();

                for(int j=0; j<W; j++)
                {
                    ary[i][j] = str.charAt(j);
                    if(ary[i][j] == '.')
                        dotCnt++;
                }
            }

            if(dotCnt % 3 != 0)
                sb.append(0).append('\n');
            else
            {
                foo();
                sb.append(cnt).append('\n');
            }
        }

        System.out.print(sb.toString());
    }
}
