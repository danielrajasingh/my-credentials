package easy;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {
    /*
    ========================================
    Problem: Longest Substring Without Repeating Characters
    Link: https://leetcode.com/problems/longest-substring-without-repeating-characters
    Difficulty: Medium (Easy in practice)
    Topic: Array, Hash Table, String, Sliding Window
    ========================================
    
    PROBLEM EXPLANATION:
    Given a string s, find the length of the longest substring without repeating characters.
    A substring is a contiguous sequence of characters within a string.
    
    Example: s="abcabcbb" → longest is "abc" → length 3
    
    KEY OBSERVATIONS:
    - Use sliding window technique with two pointers
    - Maintain character-to-index mapping to detect duplicates
    - When duplicate found, move left pointer to skip previous occurrence
    - Track maximum window size seen
    - Time complexity can be O(n) with single pass
    
    APPROACH:
    1. Create HashMap to store character -> last seen index
    2. Initialize left pointer = 0
    3. For each right pointer position:
       - If character exists in map and is within window, move left pointer
       - Add/update character in map with current index
       - Update max length as max(max, right - left + 1)
    4. Return max length
    
    TIME COMPLEXITY: O(n) - single pass through string
    SPACE COMPLEXITY: O(min(n, m)) - map size, m = charset size
    
    DRY RUN:
    s="abcabcbb"
    left=0, right=0: a → map={a:0}, len=1
    left=0, right=1: b → map={a:0,b:1}, len=2
    left=0, right=2: c → map={a:0,b:1,c:2}, len=3
    left=0, right=3: a → duplicate! left=1 → map={a:3,b:1,c:2}, len=3
    left=1, right=4: b → duplicate! left=2 → map={a:3,b:4,c:2}, len=3
    Result: 3 ✓
    
    MEMORY TRICK:
    "Sliding window: move right for new chars, move left on duplicate"
    
    VISUALIZATION:
    s: a b c a b c b b
       L     R         (at first duplicate 'a')
    Move left to skip old 'a', continue right
    Keep shrinking when duplicate found
    */

    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        Map<Character, Integer> charIndex = new HashMap<>();
        int maxLength = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);

            // If character is in current window, move left pointer
            if (charIndex.containsKey(c) && charIndex.get(c) >= left) {
                left = charIndex.get(c) + 1;
            }

            // Add/update character position
            charIndex.put(c, right);

            // Update max length
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        // Test case 1
        String s1 = "abcabcbb";
        System.out.println("Input: s=\"" + s1 + "\"");
        System.out.println("Output: " + lengthOfLongestSubstring(s1));
        System.out.println("Expected: 3 (\"abc\")\n");

        // Test case 2
        String s2 = "bbbbb";
        System.out.println("Input: s=\"" + s2 + "\"");
        System.out.println("Output: " + lengthOfLongestSubstring(s2));
        System.out.println("Expected: 1 (\"b\")\n");

        // Test case 3
        String s3 = "pwwkew";
        System.out.println("Input: s=\"" + s3 + "\"");
        System.out.println("Output: " + lengthOfLongestSubstring(s3));
        System.out.println("Expected: 3 (\"wke\")\n");

        // Test case 4
        String s4 = "au";
        System.out.println("Input: s=\"" + s4 + "\"");
        System.out.println("Output: " + lengthOfLongestSubstring(s4));
        System.out.println("Expected: 2 (\"au\")\n");
    }
}
