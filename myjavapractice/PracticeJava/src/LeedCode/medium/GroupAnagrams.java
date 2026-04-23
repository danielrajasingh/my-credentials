package medium;

import java.util.*;

public class GroupAnagrams {
    /* Problem: Group Anagrams | Link: https://leetcode.com/problems/group-anagrams
    Difficulty: Medium | Topic: Hash Table, String | Group anagram words.
    APPROACH: Sort each word, use as key. O(n k log k). */

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(s);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "ate", "eat", "eta", "ate"};
        System.out.println("Groups: " + groupAnagrams(strs));
    }
}
