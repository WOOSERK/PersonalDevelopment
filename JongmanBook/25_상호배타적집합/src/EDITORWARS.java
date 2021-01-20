/*
에디터 전쟁

https://www.algospot.com/judge/problem/read/EDITORWARS
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-01-19
 * Time: 오후 4:39
 */

public class EDITORWARS
{
    static int[] parent;
    static int[] rank;
    static int[] enemy;
    static int[] size;

    public static int find(int n)
    {
        if(parent[n] == n)
            return n;

        return parent[n] = find(parent[n]);
    }

    public static int merge(int a, int b)
    {
        if(a == -1 || b == -1)
            return Integer.max(a, b);

        a = find(a);
        b = find(b);
        if(a == b)
            return a;

        if(rank[a] > rank[b])
        {
            int tmp = a;
            a = b;
            b = tmp;
        }

        size[b] += size[a];
        parent[a] = b;
        if(rank[a] == rank[b])
            ++rank[b];

        return b;
    }

    public static boolean ack(int a, int b)
    {
        a = find(a);
        b = find(b);

        if(enemy[a] == b)
            return false;

        int u = merge(a, b);
        int v = merge(enemy[a], enemy[b]);
        enemy[u] = v;

        if(v != -1)
            enemy[v] = u;

        return true;
    }

    public static boolean dis(int a, int b)
    {
        a = find(a);
        b = find(b);

        if(a == b)
            return false;

        int u = merge(a, enemy[b]);
        int v = merge(b, enemy[a]);
        enemy[u] = v;
        enemy[v] = u;

        return true;
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuffer sb = new StringBuffer();
        int C = Integer.parseInt(br.readLine());
        while(C-- > 0)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            parent = new int[10000];
            rank = new int[10000];
            enemy = new int[10000];
            size = new int[10000];
            boolean isCon = false;

            for(int i=0; i<N; i++)
            {
                parent[i] = i;
                enemy[i] = -1;
                size[i] = 1;
            }

            int i=0;
            for(; i<M; i++)
            {
                st = new StringTokenizer(br.readLine());

                String command = st.nextToken();
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                if(command.equals("ACK"))
                {
                    if(!isCon && !ack(a, b))
                    {
                        sb.append("CONTRADICTION AT ").append(i + 1).append('\n');
                        isCon = true;
                    }
                }
                else
                {
                    if(!isCon && !dis(a, b))
                    {
                        sb.append("CONTRADICTION AT ").append(i + 1).append('\n');
                        isCon = true;
                    }
                }
            }

            if(!isCon)
            {
                int sum = 0;
                for(int j=0; j<N; j++)
                {
                    if(parent[j] == j)
                    {
                        int e = enemy[j];

                        if(e > j)
                            continue;

                        int s = size[j];
                        int es = (e == -1 ? 0 : size[e]);

                        sum += Integer.max(s, es);
                    }
                }

                sb.append("MAX PARTY SIZE IS ").append(sum).append('\n');
            }
        }

        System.out.print(sb.toString());
    }
}
