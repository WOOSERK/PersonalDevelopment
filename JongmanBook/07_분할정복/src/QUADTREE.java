/*
쿼드 트리 뒤집기

https://www.algospot.com/judge/problem/read/QUADTREE
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-01-13
 * Time: 오후 4:05
 */

public class QUADTREE
{
    static char[][] ary;
    static String str;
    static StringBuffer sb = new StringBuffer();
    static int index;

    public static StringBuffer decompress()
    {
        char ch = str.charAt(index);
        index++;
        if(ch == 'b' || ch == 'w')
            return new StringBuffer().append(ch);

        StringBuffer upperLeft = decompress();
        StringBuffer upperRight = decompress();
        StringBuffer lowerLeft = decompress();
        StringBuffer lowerRight = decompress();
        return new StringBuffer()
                .append(ch)
                .append(lowerLeft.toString())
                .append(lowerRight.toString())
                .append(upperLeft.toString())
                .append(upperRight.toString());
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int C = Integer.parseInt(br.readLine());
        while(C-- > 0)
        {
            str = br.readLine();
            index = 0;

            sb.append(decompress().toString()).append('\n');
        }

        System.out.print(sb.toString());
    }
}
