/*
Synchronizing Clocks

https://www.algospot.com/judge/problem/read/CLOCKSYNC
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-01-13
 * Time: 오전 1:48
 */

public class CLOCKSYNC
{
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    static int[] ary;
    static int[] cnt;
    static int min;

    public static void init()
    {
        for(int i=0; i<16; i++)
            list.add(new ArrayList<Integer>());

        int[][] ary = {{0, 0}, {0, 1}, {0, 2},
                {1, 3}, {1, 7}, {1, 9}, {1, 11},
                {2, 4}, {2, 10}, {2, 14}, {2, 15},
                {3, 0}, {3, 4}, {3, 5}, {3, 6}, {3, 7},
                {4, 6}, {4, 7}, {4, 8}, {4, 10}, {4, 12},
                {5, 0}, {5, 2}, {5, 14}, {5, 15},
                {6, 3}, {6, 14}, {6, 15},
                {7, 4}, {7, 5}, {7, 7}, {7, 14}, {7, 15},
                {8, 1}, {8, 2}, {8, 3}, {8, 4}, {8, 5},
                {9, 3}, {9, 4}, {9, 5}, {9, 9}, {9, 13}
        };

        for(int[] num : ary)
            list.get(num[0]).add(num[1]);
    }

    public static void push(int index)
    {
        ArrayList<Integer> tmp = list.get(index);
        cnt[index] = (cnt[index] + 1) % 4;

        for(int num : tmp)
        {
            if(ary[num] + 3 > 12)
                ary[num] = 3;
            else
                ary[num] += 3;
        }
    }

    public static boolean check()
    {
        for(int i=0; i<16; i++)
        {
            if(ary[i] != 12)
                return false;
        }

        return true;
    }

    public static void foo(int index)
    {
        if(index == 10)
        {
            if(check())
            {
                int ans = 0;
                for(int i=0; i<10; i++)
                    ans += cnt[i];

                min = Integer.min(min, ans);
            }

            return;
        }

        for(int i=0; i<4; i++)
        {
            push(index);
            foo(index+1);
        }
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        init();

        StringBuffer sb = new StringBuffer();

        int C = Integer.parseInt(br.readLine());
        while(C-- > 0)
        {
            ary = new int[16];
            cnt = new int[10];
            min = Integer.MAX_VALUE;

            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int i=0; i<16; i++)
                ary[i] = Integer.parseInt(st.nextToken());

            foo(0);

            if(min == Integer.MAX_VALUE)
                sb.append(-1).append('\n');
            else
                sb.append(min).append('\n');
        }

        System.out.print(sb.toString());
    }
}
