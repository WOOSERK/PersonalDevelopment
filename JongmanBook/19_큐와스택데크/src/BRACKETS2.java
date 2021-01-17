/*
짝이 맞지 않는 괄호

https://algospot.com/judge/problem/read/BRACKETS2
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-01-17
 * Time: 오후 5:30
 */

public class BRACKETS2
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuffer sb = new StringBuffer();
        int C = Integer.parseInt(br.readLine());
        while(C-- > 0)
        {
            String str = br.readLine();
            int len = str.length();

            Stack<Character> stack = new Stack<>();
            int i=0;
            for(; i<len; i++)
            {
                char ch = str.charAt(i);

                if(!stack.isEmpty())
                {
                    char sch = stack.peek();

                    if(ch == ')')
                    {
                        if(sch == '(')
                            stack.pop();
                        else
                            break;
                    }
                    else if(ch == '}')
                    {
                        if(sch == '{')
                            stack.pop();
                        else
                            break;
                    }
                    else if(ch == ']')
                    {
                        if(sch == '[')
                            stack.pop();
                        else
                            break;
                    }
                    else
                        stack.push(ch);
                }
                else
                    stack.push(ch);
            }

            if(i == len && stack.isEmpty())
                sb.append("YES\n");
            else
                sb.append("NO\n");
        }

        System.out.print(sb.toString());
    }
}
