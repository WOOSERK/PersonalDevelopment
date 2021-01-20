/*
변화하는 중간값

https://www.algospot.com/judge/problem/read/RUNNINGMEDIAN
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-01-19
 * Time: 오후 3:51
 */

public class RUNNINGMEDIAN
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
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            long A = 1983;
            PriorityQueue<Long> minHeap = new PriorityQueue<>();
            PriorityQueue<Long> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
            long sum = 0;
            for(int i=0; i<N; i++)
            {
                if(i != 0)
                    A = (A * a + b) % 20090711;

                if(minHeap.size() == maxHeap.size())
                    maxHeap.add(A);
                else
                    minHeap.add(A);

                if(!minHeap.isEmpty() && !maxHeap.isEmpty() && minHeap.peek() < maxHeap.peek())
                {
                    long min = minHeap.poll();
                    long max = maxHeap.poll();

                    minHeap.add(max);
                    maxHeap.add(min);
                }

                sum = (sum + maxHeap.peek()) % 20090711;
            }

            sb.append(sum).append('\n');
        }

        System.out.print(sb.toString());
    }
}
