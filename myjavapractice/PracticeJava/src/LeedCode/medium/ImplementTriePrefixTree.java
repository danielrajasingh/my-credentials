package medium;

import java.util.*;

public class ImplementTriePrefixTree {
    /* Problem: Implement Trie (Prefix Tree) | Link: https://leetcode.com/problems/implement-trie-prefix-tree
    Difficulty: Medium | Topic: Hash Table, String, Design, Trie | Trie data structure.
    APPROACH: TrieNode array for children. O(L). */

    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        boolean isEnd = false;
    }

    static class Trie {
        TrieNode root = new TrieNode();

        void insert(String word) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                node = node.children.computeIfAbsent(c, k -> new TrieNode());
            }
            node.isEnd = true;
        }

        boolean search(String word) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                node = node.children.get(c);
                if (node == null) return false;
            }
            return node.isEnd;
        }

        boolean startsWith(String prefix) {
            TrieNode node = root;
            for (char c : prefix.toCharArray()) {
                node = node.children.get(c);
                if (node == null) return false;
            }
            return true;
        }
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println("Found apple: " + trie.search("apple"));
    }
}
