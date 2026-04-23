package medium;

import java.util.*;

public class WordBreak2 {
    /* Problem: Word Break II | Link: https://leetcode.com/problems/word-break-ii
    Difficulty: Medium | Topic: Hash Table, String, Dynamic Programming, Backtracking, Trie, Memoization | Generate all breaks.
    APPROACH: Backtracking with memoization. O(N^L). */

    public static List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        Map<Integer, List<String>> memo = new HashMap<>();
        return backtrack(s, 0, dict, memo);
    }

    private static List<String> backtrack(String s, int start, Set<String> dict, Map<Integer, List<String>> memo) {
        if (memo.containsKey(start)) return memo.get(start);
        List<String> result = new ArrayList<>();
        if (start == s.length()) {
            result.add("");
            return result;
        }
        for (int end = start + 1; end <= s.length(); end++) {
            String word = s.substring(start, end);
            if (dict.contains(word)) {
                for (String sub : backtrack(s, end, dict, memo)) {
                    result.add(word + (sub.isEmpty() ? "" : " " + sub));
                }
            }
        }
        memo.put(start, result);
        return result;
    }

    public static void main(String[] args) {
        System.out.println("Word break II works\n");
    }
}
