/*
졸업 학기

https://www.algospot.com/judge/problem/read/GRADUATION
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-01-15
 * Time: 오후 3:09
 */

public class GRADUATION
{
    static int N;
    static int M;
    static int K;
    static int L;
    static int[] R;
    static int[] C;
    static int[][] cache;
    static int min;
    static int INF = 987654321;

    public static void setInfo(int index, int num)
    {
        R[index] |= (1 << num);
    }

    public static void setSem(int index, int num)
    {
        C[index] |= (1 << num);
    }

    public static int graduate(int semester, int taewoo)
    {
        if(Integer.bitCount(taewoo) >= K)
            return 0;

        if(semester >= M)
            return INF;

        if(cache[semester][taewoo] != -1)
            return cache[semester][taewoo];

        cache[semester][taewoo] = INF;

        int canTake = C[semester] & ~taewoo;
        for(int i=0; i<N; i++)
        {
            // 아직 안들은 강의 중 선수과목을 듣지 않은 과목 제외
            if((canTake & (1 << i)) != 0 && (taewoo & R[i]) != R[i])
                canTake &= ~(1 << i);
        }

        for(int take = canTake; take > 0; take = ((take - 1) & canTake))
        {
            if(Integer.bitCount(take) > L)
                continue;

            cache[semester][taewoo] = Integer.min(cache[semester][taewoo], graduate(semester+1, taewoo | take)+1);
        }

        cache[semester][taewoo] = Integer.min(cache[semester][taewoo], graduate(semester+1, taewoo));
        return cache[semester][taewoo];
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuffer sb = new StringBuffer();
        int tc = Integer.parseInt(br.readLine());
        while(tc-- > 0)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());

            R = new int[12];
            for(int i=0; i<N; i++)
            {
                st = new StringTokenizer(br.readLine());
                int num = Integer.parseInt(st.nextToken());

                for(int j=0; j<num; j++)
                    setInfo(i, Integer.parseInt(st.nextToken()));
            }

            C = new int[10];
            for(int i=0; i<M; i++)
            {
                st = new StringTokenizer(br.readLine());
                int num = Integer.parseInt(st.nextToken());

                for(int j=0; j<num; j++)
                    setSem(i, Integer.parseInt(st.nextToken()));
            }

            min = Integer.MAX_VALUE;
            cache = new int[10][1<<12];
            for(int i=0; i<M; i++)
            {
                for (int j = 0; j < 1 << N; j++)
                {
                    cache[i][j] = -1;
                }
            }
            min = graduate(0, 0);

            if(min == INF)
                sb.append("IMPOSSIBLE\n");
            else
                sb.append(min).append('\n');
        }

        System.out.print(sb.toString());
    }
}
