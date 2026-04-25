/*
========================================
[PROBLEM] Longest Palindromic Substring
[DIFFICULTY] MEDIUM
[TOPIC] String, Dynamic Programming
========================================

PROBLEM EXPLANATION:
Given a string s, return the longest palindromic substring in s.

Example 1:
Input: s = "babad"
Output: "bab"
Explanation: "bab" is a palindrome, "aba" is also a valid answer.

Example 2:
Input: s = "cbbd"
Output: "bb"

Example 3:
Input: s = "a"
Output: "a"

Example 4:
Input: s = "ac"
Output: "a"

KEY OBSERVATIONS / INTUITION:
- A palindrome reads the same forward and backward
- For each center (character or gap between characters), expand outward
- Track the longest palindrome found

APPROACH (Step-by-Step):
   Step 1: Handle edge cases (empty, single char)
   Step 2: For each position, check odd-length palindromes
   Step 3: For each position, check even-length palindromes
   Step 4: Track and return the longest

TIME & SPACE COMPLEXITY ANALYSIS:
   Time Complexity:  O(n^2) - Each center expands O(n)
   Space Complexity: O(1) - Only variables, no extra space

DRY RUN EXAMPLE:
Input: s = "babad"
Process:
  i=0: center at 'b' -> expand "b" (len=1)
  i=1: center at 'a' -> expand "aba" (len=3) -> longest="bab"
  i=2: center at 'b' -> expand "bab" (len=3) -> longest="bab" or "aba"
  i=3: center at 'a' -> expand "a" (len=1)
  i=4: center at 'd' -> expand "d" (len=1)
Output: "bab" or "aba"

ONE-LINE MEMORY TRICK:
"Expand around centers - odd and even positions"

MENTAL VISUALIZATION:
Think of each character as a potential center of a palindrome.
Expand outward from each center to find the longest palindrome.

IMPORTANT EDGE CASES:
* Empty string -> return ""
* Single character -> return that character
* All same characters -> return entire string
* No palindrome longer than 1 -> return first character

SOLUTION STRATEGY:
1. Use expand around center approach
2. Check both odd and even length palindromes
3. Keep track of start and end indices
4. Return substring using indices

========================================
*/

package medium;

public class LongestPalindromicSubstring {
    
    private static int start = 0;
    private static int maxLen = 0;
    
    /**
     * Find longest palindromic substring using expand around center
     */
    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        
        start = 0;
        maxLen = 1;
        
        for (int i = 0; i < s.length(); i++) {
            // Odd length palindrome (center at i)
            expandAroundCenter(s, i, i);
            // Even length palindrome (center between i and i+1)
            expandAroundCenter(s, i, i + 1);
        }
        
        return s.substring(start, start + maxLen);
    }
    
    private static void expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            int currentLen = right - left + 1;
            if (currentLen > maxLen) {
                start = left;
                maxLen = currentLen;
            }
            left--;
            right++;
        }
    }
    
    public static void main(String[] args) {
        // Test Case 1
        String s1 = "babad";
        System.out.print("Input: \"");
        System.out.print(s1);
        System.out.println("\"");
        System.out.println("Output: \"" + longestPalindrome(s1) + "\"");
        System.out.println("Expected: \"bab\" or \"aba\"\n");
        
        // Test Case 2
        String s2 = "cbbd";
        System.out.print("Input: \"");
        System.out.print(s2);
        System.out.println("\"");
        System.out.println("Output: \"" + longestPalindrome(s2) + "\"");
        System.out.println("Expected: \"bb\"\n");
        
        // Test Case 3
        String s3 = "a";
        System.out.print("Input: \"");
        System.out.print(s3);
        System.out.println("\"");
        System.out.println("Output: \"" + longestPalindrome(s3) + "\"");
        System.out.println("Expected: \"a\"\n");
        
        // Test Case 4
        String s4 = "ac";
        System.out.print("Input: \"");
        System.out.print(s4);
        System.out.println("\"");
        System.out.println("Output: \"" + longestPalindrome(s4) + "\"");
        System.out.println("Expected: \"a\"\n");
        
        // Test Case 5
        String s5 = "aaaa";
        System.out.print("Input: \"");
        System.out.print(s5);
        System.out.println("\"");
        System.out.println("Output: \"" + longestPalindrome(s5) + "\"");
        System.out.println("Expected: \"aaaa\"");
    }
}
