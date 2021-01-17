/*
팬미팅

https://www.algospot.com/judge/problem/read/FANMEETING
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-01-13
 * Time: 오후 11:25
 */

public class FANMEETING
{

    public static ArrayList<Integer> karatsuba(ArrayList<Integer> A, ArrayList<Integer> B)
    {
        int an = A.size();
        int bn = A.size();
        if(an < bn)
            return karatsuba(B, A);

        if(an == 0 || bn == 0)
            return new ArrayList<>();

        return A;
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuffer sb = new StringBuffer();
        int C = Integer.parseInt(br.readLine());

        while(C-- > 0)
        {
            String members = br.readLine();
            String fans = br.readLine();
            int N = members.length();
            int M = members.length();
            ArrayList<Integer> A = new ArrayList<>();
            ArrayList<Integer> B = new ArrayList<>();

            for(int i=0; i<N; i++)
                A.add(members.charAt(i) == 'M' ? 1 : 0);
            for(int i=0; i<M; i++)
                B.add(fans.charAt(i) == 'M' ? 1 : 0);

            ArrayList<Integer> ans = karatsuba(A, B);
            int allHugs = 0;
            for(int i=N-1; i<M; i++)
                if(ans.get(i) == 0)
                    ++allHugs;

            sb.append(allHugs).append('\n');
        }

        System.out.print(sb.toString());
    }
}
