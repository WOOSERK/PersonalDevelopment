/*
울타리 잘라내기

https://www.algospot.com/judge/problem/read/FENCE
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-01-13
 * Time: 오후 5:40
 */

public class FENCE
{
    static int N;
    static int[] ary;

    public static int foo(int left, int right)
    {
        if(left == right)
            return ary[left];

        int mid = (left + right) / 2;

        int ret = Integer.max(foo(left, mid), foo(mid+1, right));

        int lo = mid, hi = mid+1;
        int height = Integer.min(ary[lo], ary[hi]);

        ret = Integer.max(ret, height * 2);

        while(left < lo || hi < right)
        {
            if(hi < right && (lo == left || ary[lo-1] < ary[hi+1]))
            {
                ++hi;
                height = Integer.min(height, ary[hi]);
            }
            else
            {
                --lo;
                height = Integer.min(height, ary[lo]);
            }

            ret = Integer.max(ret, height * (hi - lo + 1));
        }

        return ret;
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuffer sb = new StringBuffer();
        int C = Integer.parseInt(br.readLine());
        while(C-- > 0)
        {
            N = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());
            ary = new int[20001];
            for(int i=0; i<N; i++)
                ary[i] = Integer.parseInt(st.nextToken());

            sb.append(foo(0, N-1)).append('\n');
        }

        System.out.print(sb.toString());
    }
}
