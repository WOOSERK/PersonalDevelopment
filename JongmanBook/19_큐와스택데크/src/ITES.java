/*
외계 신호 분석

https://algospot.com/judge/problem/read/ITES
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-01-17
 * Time: 오후 6:07
 */

public class ITES
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuffer sb = new StringBuffer();
        int C = Integer.parseInt(br.readLine());

        while(C-- > 0)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int K = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());

            long num = 1983;
            long sum = 0;
            int cnt = 0;
            Queue<Long> signals = new LinkedList<>();
            for(int i=0; i<N; i++)
            {
                long signal = (num % 10000 + 1);
                sum += signal;

                signals.add(signal);

                while(sum > K)
                    sum -= signals.poll();

                if(sum == K)
                    cnt++;

                num = (num * 214013 + 2531011) % (1L << 32);
            }

            sb.append(cnt).append('\n');
        }

        System.out.print(sb.toString());
    }
}
