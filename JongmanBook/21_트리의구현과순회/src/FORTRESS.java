/*
요새

https://algospot.com/judge/problem/read/FORTRESS
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-01-18
 * Time: 오후 10:34
 */

public class FORTRESS
{
    public static int n;
    public static int[] y = new int[100];
    public static int[] x = new int[100];
    public static int[] radius = new int[100];

    public static int sqr(int x)
    {
        return x*x;
    }

    public static int sqrdist(int a, int b)
    {
        return sqr(y[a] - y[b]) + sqr(x[a] - x[b]);
    }

    public static boolean encloses(int a, int b)
    {
        return radius[a] > radius[b] && sqrdist(a, b) < sqr(radius[a] - radius[b]);
    }

    public static boolean isChild(int parent, int child)
    {
        if(!encloses(parent, child))
            return false;

        for(int i=0; i<n; i++)
        {
            if(i != parent && i != child && encloses(parent, child))
                return false;
        }

        return true;
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int C = Integer.parseInt(br.readLine());
        while(C-- > 0)
        {
            int N = Integer.parseInt(br.readLine());


        }
    }
}
