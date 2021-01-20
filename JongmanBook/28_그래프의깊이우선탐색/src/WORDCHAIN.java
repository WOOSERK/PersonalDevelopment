/*
단어 제한 끝말잇기

https://www.algospot.com/judge/problem/read/WORDCHAIN
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-01-20
 * Time: 오후 10:34
 */

public class WORDCHAIN
{
    static ArrayList<String>[][] ary;
    static int[] ingreed;
    static int[] degreed;
    static int[][] adj;

    public static void getEulerCircuit(int here, ArrayList<Integer> list)
    {
        for(int there=0; there<26; there++)
        {
            while(adj[here][there] > 0)
            {
                adj[here][there]--;
                getEulerCircuit(there, list);
            }
        }

        list.add(here);
    }

    public static ArrayList<Integer> getEulerTrailOrCircuit()
    {
        ArrayList<Integer> list = new ArrayList<>();

        for(int i=0; i<26; i++)
        {
            if(degreed[i] == ingreed[i]+1)
            {
                getEulerCircuit(i, list);
                return list;
            }
        }

        for(int i=0; i<26; i++)
        {
            if(degreed[i] > 0)
            {
                getEulerCircuit(i, list);
                return list;
            }
        }

        return list;
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int C = Integer.parseInt(br.readLine());
        while(C-- > 0)
        {
            int n = Integer.parseInt(br.readLine());
            ary = new ArrayList[26][26];
            ingreed = new int[26];
            degreed = new int[26];
            adj = new int[26][26];

            for(int i=0; i<n; i++)
            {
                String str = br.readLine();

                int len = str.length();
                int a = str.charAt(0);
                int b = str.charAt(len-1);

                ary[a][b].add(str);
                ingreed[a]++;
                degreed[b]++;
                adj[a][b]++;
            }
        }
    }
}

