package com.epam.hackerrank.tries;


import java.util.Scanner;

public class Contacts {

    public static void main(String[] args) {
        Trie trie = new Trie();

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int i = 0; i < n; i++){
            String op = in.next();
            String contact = in.next();

            if (op.equals("add"))
                trie.put(contact);
            if (op.equals("find"))
                System.out.println(trie.count(contact));
        }
    }
}
