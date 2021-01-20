/*
팰린드롬 만들기

https://www.algospot.com/judge/problem/read/PALINDROMIZE
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-01-17
 * Time: 오후 11:57
 */

public class PALINDROMIZE
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuffer sb = new StringBuffer();
        int C = Integer.parseInt(br.readLine());
        while(C-- > 0)
        {
            String str = br.readLine();
            String rev = new StringBuffer().append(str).reverse().toString();

            int len = str.length();
            int j = 0;
            int[] fail = new int[100001];
            for(int i=1; i<len; i++)
            {
                while(j > 0 && rev.charAt(i) != rev.charAt(j))
                    j = fail[j-1];

                if(rev.charAt(i) == rev.charAt(j))
                    fail[i] = ++j;
            }

            int begin = 0, matched = 0;

            while(begin < len)
            {
                if(matched < len && str.charAt(begin + matched) == rev.charAt(matched))
                {
                    ++matched;
                    if(begin + matched == len)
                    {
                        sb.append(2*len - matched).append('\n');
                        break;
                    }
                }
                else
                {
                    if(matched == 0)
                        ++begin;
                    else {
                        begin += matched - fail[matched-1];
                        matched = fail[matched-1];
                    }
                }
            }

/*
            String rev = new StringBuffer().append(str).reverse().toString();
            int[] p = new int[100001];
            j = 0;
            for(int i=0; i<len; )
            {
                while(j > 0 && str.charAt(i + j) != rev.charAt(j))
                    j = fail[j-1];

                if(str.charAt(i + j) == rev.charAt(j))
                {
                    p[i+j] = ++j;
                    if(i + j == len)
                        break;
                }
                else
                    i++;
            }

            sb.append(2*len - p[len-1]).append('\n');
*/
        }
        System.out.print(sb.toString());
    }
}
