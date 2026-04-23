package medium;

public class LongestPalindromicSubstring {
    /*
    ========================================
    Problem: Longest Palindromic Substring
    Link: https://leetcode.com/problems/longest-palindromic-substring
    Difficulty: Medium
    Topic: String, Dynamic Programming
    ========================================
    
    PROBLEM EXPLANATION:
    Given a string s, return the longest palindromic substring in s.
    A palindrome reads the same forwards and backwards.
    
    Example: s="babad" → "bab" or "aba" (length 3)
    Example: s="cbbd" → "bb" (length 2)
    
    KEY OBSERVATIONS:
    - Brute force: check all substrings O(n³)
    - DP approach: dp[i][j] = is s[i..j] a palindrome? O(n²) time, O(n²) space
    - Expand around center: for each center, expand outward O(n²) time, O(1) space
    - Center can be single char (odd) or between two chars (even)
    
    APPROACH (Expand Around Center - Optimal):
    1. For each possible center (single char or between two chars)
    2. Expand left and right while chars match and in bounds
    3. Track longest palindrome found
    4. Return substring
    
    TIME COMPLEXITY: O(n²) - n centers, each expansion is O(n)
    SPACE COMPLEXITY: O(1) - only tracking indices
    
    DRY RUN:
    s="babad"
    Center at 0 (b): single char "b"
    Center at 1 (a): expand → "bab" (length 3)
    Center at 2 (b): single char "b"
    Center at 3 (a): expand → "aba" (length 3)
    Center at 4 (d): single char "d"
    Also check centers between chars (no palindromes)
    Result: "bab" or "aba" (length 3) ✓
    
    MEMORY TRICK:
    "Expand from center: odd palindromes (single center), even (between two)"
    
    VISUALIZATION:
    s: b a b a d
       └─●─┘     (center at 1, expand: bab)
           └─●─┘ (center at 3, expand: aba)
    Center can be a char or space between chars
    */

    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }

        int start = 0;
        int maxLen = 1;

        for (int i = 0; i < s.length(); i++) {
            // Odd length palindromes (single character center)
            int len1 = expandAroundCenter(s, i, i);
            // Even length palindromes (between two characters)
            int len2 = expandAroundCenter(s, i, i + 1);

            int len = Math.max(len1, len2);

            if (len > maxLen) {
                maxLen = len;
                start = i - (len - 1) / 2;
            }
        }

        return s.substring(start, start + maxLen);
    }

    private static int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1; // length of palindrome
    }

    public static void main(String[] args) {
        // Test case 1
        String s1 = "babad";
        System.out.println("Input: s=\"" + s1 + "\"");
        System.out.println("Output: \"" + longestPalindrome(s1) + "\"");
        System.out.println("Expected: \"bab\" or \"aba\"\n");

        // Test case 2
        String s2 = "cbbd";
        System.out.println("Input: s=\"" + s2 + "\"");
        System.out.println("Output: \"" + longestPalindrome(s2) + "\"");
        System.out.println("Expected: \"bb\"\n");

        // Test case 3
        String s3 = "a";
        System.out.println("Input: s=\"" + s3 + "\"");
        System.out.println("Output: \"" + longestPalindrome(s3) + "\"");
        System.out.println("Expected: \"a\"\n");

        // Test case 4
        String s4 = "racecar";
        System.out.println("Input: s=\"" + s4 + "\"");
        System.out.println("Output: \"" + longestPalindrome(s4) + "\"");
        System.out.println("Expected: \"racecar\"\n");
    }
}
