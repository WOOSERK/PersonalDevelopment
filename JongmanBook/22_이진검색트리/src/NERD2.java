/*
너드인가, 너드가 아닌가? 2

https://www.algospot.com/judge/problem/read/NERD2
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-01-19
 * Time: 오후 12:13
 */

public class NERD2
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuffer sb = new StringBuffer();

        int C = Integer.parseInt(br.readLine());
        while(C-- > 0)
        {
            int N = Integer.parseInt(br.readLine());
            int sum = 0;

            TreeMap<Integer, Integer> map = new TreeMap<>();
            for(int i=0; i<N; i++)
            {
                StringTokenizer st = new StringTokenizer(br.readLine());

                int p = Integer.parseInt(st.nextToken());
                int q = Integer.parseInt(st.nextToken());

                Integer it = map.higherKey(q);

                if(it == null || map.get(it) < p)
                    map.put(q, p);

                while(true)
                {
                    it = map.lowerKey(q);
                    if(it == null)
                        break;

                    if(map.get(it) < p)
                        map.remove(it);
                    else
                        break;
                }

                sum += map.size();
            }

            sb.append(sum).append('\n');
        }

        System.out.print(sb.toString());
    }
}
