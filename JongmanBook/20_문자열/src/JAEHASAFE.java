/*
재하의 금고

https://algospot.com/judge/problem/read/JAEHASAFE
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-01-18
 * Time: 오후 4:32
 */

public class JAEHASAFE
{
    public static int roll(String str, String target, int len, int ref)
    {
        int ret = 0;

        int k = 0;
        int[] pi = new int[10001];
        for(int i=1; i<len; i++)
        {
            while(k > 0 && str.charAt(i) != str.charAt(k))
                k = pi[k-1];

            if(str.charAt(i) == str.charAt(k))
                pi[i] = ++k;
        }

        if(ref % 2 == 0)
        {
            for(int begin=len; begin>=0; begin--)
            {
                int matched = 0;
                for(int j=begin; j<begin+len; j++)
                {
                    while(matched > 0 && str.charAt(j%len) != target.charAt(matched))
                        matched = pi[matched-1];

                    if(str.charAt(j%len) == target.charAt(matched))
                    {
                        matched++;
                        if(matched == len)
                            return begin;
                    }
                }
            }
        }
        else
        {
            for(int begin=0; begin<len; begin++)
            {
                int matched = 0;
                for(int j=begin; j<begin+len; j++)
                {
                    while(matched > 0 && str.charAt(j%len) != target.charAt(matched))
                        matched = pi[matched-1];

                    if(str.charAt(j%len) == target.charAt(matched))
                    {
                        matched++;
                        if(matched == len)
                            return begin;
                    }
                }
            }
        }

        return ret;
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int C = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();
        while(C-- > 0)
        {
           int N = Integer.parseInt(br.readLine());

           String[] target = new String[102];
           target[0] = br.readLine();
           int len = target[0].length();

           for(int i=1; i<=N; i++)
               target[i] = br.readLine();

           int sum = 0;
           for(int i=0; i<N; i++)
               sum += roll(target[i], target[i+1], len, i);

           sb.append(sum).append('\n');
        }

        System.out.print(sb.toString());
    }
}
