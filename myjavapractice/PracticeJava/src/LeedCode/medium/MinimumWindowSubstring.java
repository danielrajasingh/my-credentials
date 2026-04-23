package medium;

import java.util.*;

public class MinimumWindowSubstring {
    /*
    ========================================
    Problem: Minimum Window Substring
    Link: https://leetcode.com/problems/minimum-window-substring
    Difficulty: Medium
    Topic: Hash Table, String, Sliding Window
    ========================================
    
    PROBLEM EXPLANATION:
    Given strings s and t, find minimum window in s that contains
    all characters in t (including frequency).
    
    Example: s="ADOBECODEBANC", t="ABC"
    Output: "BANC" (contains A,B,C with correct frequencies)
    
    KEY OBSERVATIONS:
    - Use sliding window with two pointers
    - Track character frequencies needed from t
    - Expand window until all chars found
    - Contract window to find minimum
    - Update result when valid window found
    
    APPROACH (Sliding Window):
    1. Create frequency map for t
    2. Use left=0, right=0, formed=0
    3. Expand right pointer, add chars to window
    4. When formed==required chars:
       - Try to contract from left (shrink window)
       - Track minimum window
    5. Return minimum window substring
    
    TIME COMPLEXITY: O(n + m) - each char visited at most twice
    SPACE COMPLEXITY: O(charset size) - for maps
    
    DRY RUN:
    s="ADOBECODEBANC", t="ABC"
    required={'A':1, 'B':1, 'C':1}
    Expand: ADOBEC (6 chars)
    Now have A,B,E,C - formed=3 (have all)
    Contract: DOBEC (5 chars)
    Still have A,B,C
    Continue...
    Minimum: "BANC" (4 chars) ✓
    
    MEMORY TRICK:
    "Sliding window: expand for all chars, contract for minimum"
    
    VISUALIZATION:
    s: A D O B E C O D E B A N C
    t: A B C
    
    Expand: [A D O B E C]
    Contract: [D O B E C]
    Minimum: [B A N C]
    */

    public static String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }

        Map<Character, Integer> dictT = new HashMap<>();
        for (char c : t.toCharArray()) {
            dictT.put(c, dictT.getOrDefault(c, 0) + 1);
        }

        int required = dictT.size();
        int formed = 0;
        Map<Character, Integer> window = new HashMap<>();

        int[] ans = {Integer.MAX_VALUE, 0, 0};

        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            window.put(c, window.getOrDefault(c, 0) + 1);

            if (dictT.containsKey(c) && window.get(c).intValue() == dictT.get(c).intValue()) {
                formed++;
            }

            while (left <= right && formed == required) {
                char c1 = s.charAt(left);

                if (right - left + 1 < ans[0]) {
                    ans[0] = right - left + 1;
                    ans[1] = left;
                    ans[2] = right;
                }

                window.put(c1, window.get(c1) - 1);
                if (dictT.containsKey(c1) && window.get(c1).intValue() < dictT.get(c1).intValue()) {
                    formed--;
                }

                left++;
            }
        }

        return ans[0] == Integer.MAX_VALUE ? "" : s.substring(ans[1], ans[2] + 1);
    }

    public static void main(String[] args) {
        // Test case 1
        System.out.println("Input: s=\"ADOBECODEBANC\", t=\"ABC\"");
        System.out.println("Output: \"" + minWindow("ADOBECODEBANC", "ABC") + "\"");
        System.out.println("Expected: \"BANC\"\n");

        // Test case 2
        System.out.println("Input: s=\"a\", t=\"a\"");
        System.out.println("Output: \"" + minWindow("a", "a") + "\"");
        System.out.println("Expected: \"a\"\n");

        // Test case 3
        System.out.println("Input: s=\"a\", t=\"aa\"");
        System.out.println("Output: \"" + minWindow("a", "aa") + "\"");
        System.out.println("Expected: \"\"\n");

        // Test case 4
        System.out.println("Input: s=\"ab\", t=\"b\"");
        System.out.println("Output: \"" + minWindow("ab", "b") + "\"");
        System.out.println("Expected: \"b\"\n");
    }
}
