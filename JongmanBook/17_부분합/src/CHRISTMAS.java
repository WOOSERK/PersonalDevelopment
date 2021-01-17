/*
크리스마스 인형

https://www.algospot.com/judge/problem/read/CHRISTMAS
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-01-15
 * Time: 오후 7:19
 */

public class CHRISTMAS
{
    static int N;
    static int K;
    static int[] psum;

    public static long firstSolution()
    {
        long ret = 0;
        long[] count = new long[100000];
        for(int i=0; i<=N; i++)
            count[psum[i]]++;

        for(int i=0; i<K; i++)
        {
            if(count[i] >= 2)
                ret = (ret + ((count[i] * (count[i] - 1)) / 2)) % 20091101;
        }

        return ret;
    }

    public static long secondSolution()
    {
        int[] ret = new int[100001];
        int[] prev = new int[100001];
        for(int i=0; i<K; i++)
            prev[i] = -1;

        for(int i=0; i<=N; i++)
        {
            if(i > 0)
                ret[i] = ret[i-1];
            else
                ret[i] = 0;

            int loc = prev[psum[i]];
            if(loc != -1)
                ret[i] = Integer.max(ret[i], ret[loc] + 1);

            prev[psum[i]] = i;
        }

        return ret[N];
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

            int[] doll = new int[100001];
            st = new StringTokenizer(br.readLine());
            for(int i=1; i<=N; i++)
                doll[i] = Integer.parseInt(st.nextToken());

            psum = new int[100001];
            for(int i=1; i<=N; i++)
                psum[i] = (psum[i-1] + doll[i]) % K;

            sb.append(firstSolution()).append(' ').append(secondSolution()).append('\n');
        }

        System.out.print(sb.toString());
    }
}
