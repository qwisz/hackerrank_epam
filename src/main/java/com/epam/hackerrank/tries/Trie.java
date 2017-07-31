package com.epam.hackerrank.tries;

import java.util.Map;
import java.util.TreeMap;

public class Trie {

    class TrieNode {
        Map<Character, TrieNode> children = new TreeMap<Character, TrieNode>();
        boolean leaf;
        public int size = 0;

        public TrieNode getChildren(char ch) {
            return children.get(ch);
        }
    }

    TrieNode root = new TrieNode();

    public void put(String s) {
        TrieNode v = root;
        for (char ch : s.toLowerCase().toCharArray()) {
            if (!v.children.containsKey(ch)) {
                v.children.put(ch, new TrieNode());
            }
            v = v.children.get(ch);
            v.size++;
        }
        v.leaf = true;
    }

    public int count(String pattern) {
        TrieNode current = root;
        for (char ch : pattern.toCharArray()) {
            current = current.getChildren(ch);
            if (current == null) {
                return 0;
            }
        }
        return current.size;
    }
}
