/*
록 페스티벌

https://www.algospot.com/judge/problem/read/FESTIVAL
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-01-12
 * Time: 오후 3:16
 */

public class FESTIVAL
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int C = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();
        while(C-- > 0)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());
            int[] ary = new int[1001];

            st = new StringTokenizer(br.readLine());
            for(int i=1; i<=N; i++)
                ary[i] = Integer.parseInt(st.nextToken());

            double min = 1000;
            for(int k=L; k<=N; k++)
            {
                int sum = 0;
                for(int i=1; i<=N; i++)
                {
                    sum += ary[i];

                    if(i >= k)
                    {
                        sum = sum - ary[i-k];
                        min = Double.min(min, ((double)sum / k));
                    }
                }
            }

            sb.append(String.format("%.10f\n", min));
        }

        System.out.print(sb.toString());
    }
}
