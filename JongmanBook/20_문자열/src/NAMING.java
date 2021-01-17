/*
접두사/접미사

https://www.algospot.com/judge/problem/read/NAMING
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-01-17
 * Time: 오후 11:05
 */

public class NAMING
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuffer sb = new StringBuffer();

        String fa = br.readLine();
        String mo = br.readLine();

        String str = sb.append(fa).append(mo).toString();

        sb = new StringBuffer();

        int[] fail = new int[400001];
        int len = str.length();
        int j = 0;
        for(int i = 1; i < len; i++)
        {
            while(j > 0 && str.charAt(i) != str.charAt(j))
                j = fail[j-1];

            if(str.charAt(i) == str.charAt(j))
                fail[i] = ++j;
        }

        int k = len;
        while(k > 0)
        {
            sb.insert(0, k).insert(0, " ");
            k = fail[k-1];
        }

        System.out.println(sb.toString());
    }
}
