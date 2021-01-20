/*
안녕히, 그리고 물고기는 고마웠어요!

http://algospot.com/judge/problem/read/SOLONG
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-01-20
 * Time: 오전 12:23
 */

public class SOLONG
{
    static class Trie
    {
        class Node
        {
            int[] children;
            int valid;

            public Node()
            {
                children = new int[26];
                for(int i=0; i<26; i++)
                    children[i] = -1;

                valid = -1;
            }
        }

        ArrayList<Node> trie;
        int root;

        public Trie()
        {
            trie = new ArrayList<>();
            root = -1;
        }

        int init()
        {
            trie.add(new Node());

            return trie.size() - 1;
        }

        void add(int node, String str, int index)
        {
            if(root == -1)
                root = index;

            if(index == str.length())
            {
                trie.get(node).valid = index;
                return;
            }

            int c = str.charAt(index) - 'a';
            if(trie.get(node).children[c] == -1)
            {
                int next = init();
                trie.get(node).children[c] = next;
            }

            int child = trie.get(node).children[c];
            add(child, str, index+1);
        }

        int search(int node, String str, int index)
        {
            if(node == -1)
                return -1;

            if(index == str.length())
                return trie.get(node).valid;

            int c = str.charAt(index) - 'a';
            int child = trie.get(node).children[c];
            return search(child, str, index+1);
        }

        int type(int node, String str, int index)
        {
            if(index == str.length())
                return 0;

            if(root == index)
                return 1;

            int next = str.charAt(index) - 'a';
            return 1 + type(next, str, index+1);
        }
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int C = Integer.parseInt(br.readLine());
        while(C-- > 0)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            for(int i=0; i<N; i++)
            {

            }
        }
    }
}
