/*
========================================
[PROBLEM] LongestSubstringWithoutRepeatingCharacters
[DIFFICULTY] EASY
[TOPIC] Hash Table, String, Sliding Window
========================================

PROBLEM EXPLANATION:
Given a string s, find the length of the longest substring without repeating characters.

Example 1:
Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.

Example 2:
Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.

Example 3:
Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.

KEY OBSERVATIONS / INTUITION:
- Use sliding window technique with two pointers
- Maintain a HashSet to track characters in current window
- When we find a duplicate, shrink the window from the left
- Track maximum length seen so far

APPROACH (Step-by-Step):
   Step 1: Initialize left pointer, HashSet, and maxLength
   Step 2: Iterate through string with right pointer
   Step 3: If char exists in set, remove from left until no duplicate
   Step 4: Add current char to set and update maxLength
   Step 5: Return maxLength

TIME & SPACE COMPLEXITY ANALYSIS:
   Time Complexity:  O(n) - Single pass through string
   Space Complexity: O(min(n, m)) - Where m is charset size

DRY RUN EXAMPLE:
Input: s = "abcabcbb"
Process:
  i=0: 'a' -> set={a}, len=1, max=1
  i=1: 'b' -> set={a,b}, len=2, max=2
  i=2: 'c' -> set={a,b,c}, len=3, max=3
  i=3: 'a' -> duplicate! remove 'a', set={b,c}, len=2
  i=4: 'b' -> duplicate! remove 'b', set={c}, len=1
  i=5: 'c' -> duplicate! remove 'c', set={}, len=0
  i=6: 'b' -> set={b}, len=1
  i=7: 'b' -> duplicate! remove 'b', set={}, len=0
Output: 3

ONE-LINE MEMORY TRICK:
"SLIDE: Set tracks unique chars, Left shrinks when duplicate found"

MENTAL VISUALIZATION:
Think of a sliding window on a fence. When you encounter a color already in the window, you must move the start of the window past that color to maintain uniqueness.

IMPORTANT EDGE CASES:
* Empty string -> return 0
* String with all same characters -> return 1
* String with all unique characters -> return length of string

SOLUTION STRATEGY:
1. Use sliding window with two pointers
2. Use HashSet to track characters in current window
3. When duplicate found, shrink from left
4. Track maximum window size

========================================
*/

package easy;

import java.util.*;

public class LongestSubstringWithoutRepeatingCharacters {
    
    /**
     * Find length of longest substring without repeating characters
     * Using sliding window technique
     */
    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        int maxLength = 0;
        int left = 0;
        HashSet<Character> charSet = new HashSet<>();
        
        for (int right = 0; right < s.length(); right++) {
            char current = s.charAt(right);
            
            // If duplicate found, shrink window from left
            while (charSet.contains(current)) {
                charSet.remove(s.charAt(left));
                left++;
            }
            
            // Add current character to set
            charSet.add(current);
            
            // Update maximum length
            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        return maxLength;
    }
    
    public static void main(String[] args) {
        // Test Case 1
        String s1 = "abcabcbb";
        System.out.println("Input: \"" + s1 + "\"");
        System.out.println("Output: " + lengthOfLongestSubstring(s1));
        System.out.println("Expected: 3\n");
        
        // Test Case 2
        String s2 = "bbbbb";
        System.out.println("Input: \"" + s2 + "\"");
        System.out.println("Output: " + lengthOfLongestSubstring(s2));
        System.out.println("Expected: 1\n");
        
        // Test Case 3
        String s3 = "pwwkew";
        System.out.println("Input: \"" + s3 + "\"");
        System.out.println("Output: " + lengthOfLongestSubstring(s3));
        System.out.println("Expected: 3\n");
        
        // Test Case 4
        String s4 = "";
        System.out.println("Input: \"\"");
        System.out.println("Output: " + lengthOfLongestSubstring(s4));
        System.out.println("Expected: 0\n");
        
        // Test Case 5
        String s5 = "au";
        System.out.println("Input: \"" + s5 + "\"");
        System.out.println("Output: " + lengthOfLongestSubstring(s5));
        System.out.println("Expected: 2");
    }
}
