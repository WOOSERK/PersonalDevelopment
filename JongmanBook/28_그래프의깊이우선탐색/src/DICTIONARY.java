/*
고대어 사전

https://www.algospot.com/judge/problem/read/DICTIONARY
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-01-20
 * Time: 오후 12:37
 */

public class DICTIONARY
{
    static int n;
    static String[] strs;
    static boolean[][] adj;
    static boolean[] check;
    static ArrayList<Integer> ary;
    static StringBuffer sb;

    public static void dfs(int v)
    {
        check[v] = true;

        for(int i=0; i<26; i++)
        {
            if(adj[v][i] && !check[i])
                dfs(i);
        }

        ary.add(v);
    }

    public static boolean foo()
    {
        for(int i=0; i<26; i++)
        {
            for(int j=i+1; j<26; j++)
            {
                if(adj[ary.get(j)][ary.get(i)])
                    return false;
            }
        }

        return true;
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        sb = new StringBuffer();
        int C = Integer.parseInt(br.readLine());

        while (C-- > 0)
        {
            n = Integer.parseInt(br.readLine());
            strs = new String[1000];
            for (int i = 0; i < n; i++)
                strs[i] = br.readLine();

            adj = new boolean[26][26];
            for(int j=1; j<n; j++)
            {
                int i = j - 1;
                int len = Integer.min(strs[i].length(), strs[j].length());

                for(int k=0; k<len; k++)
                {
                    char chi = strs[i].charAt(k);
                    char chj = strs[j].charAt(k);

                    if(chi != chj)
                    {
                        int a = chi - 'a';
                        int b = chj - 'a';
                        adj[a][b] = true;
                        break;
                    }
                }
            }

            ary = new ArrayList<>();
            check = new boolean[26];

            for(int i=0; i<26; i++)
            {
                if(!check[i])
                    dfs(i);
            }

            Collections.reverse(ary);

            if(foo())
            {
                for(int i=0; i<26; i++)
                {
                    char ch = (char)(ary.get(i).intValue() + 'a');
                    sb.append(ch);
                }

                sb.append('\n');
            }
            else
                sb.append("INVALID HYPOTHESIS\n");
        }

        System.out.print(sb.toString());
    }
}
