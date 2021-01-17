/*
조세푸스 문제

https://algospot.com/judge/problem/read/JOSEPHUS
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-01-17
 * Time: 오후 4:17
 */

public class JOSEPHUS
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuffer sb = new StringBuffer();
        int C = Integer.parseInt(br.readLine());
        while(C-- > 0)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            LinkedList<Integer> list = new LinkedList<>();

            for(int i=1; i<=N; i++)
                list.add(i);

            int size = list.size();
            int index = 0;
            while(true)
            {
                if(size == 2)
                    break;

                list.remove(index);
                size--;
                index = (index + K-1) % (size);
            }

            sb.append(list.get(0)).append(' ').append(list.get(1)).append('\n');
        }

        System.out.print(sb.toString());
    }
}
