/*
========================================
[PROBLEM] Minimum Window Substring
[DIFFICULTY] MEDIUM
[TOPIC] Hash Table, String, Sliding Window
========================================

PROBLEM EXPLANATION:
Given two strings s and t of lengths m and n respectively, return the minimum window 
substring of s such that every character in t (including duplicates) is present in the window.
If there is no such substring, return the empty string "".

A substring is a contiguous sequence of characters within the string.

Example 1:
Input: s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"
Explanation: The minimum window substring "BANC" contains 'B', 'A', and 'C' from t.

Example 2:
Input: s = "a", t = "a"
Output: "a"

Example 3:
Input: s = "a", t = "aa"
Output: ""
Explanation: There is no valid window substring.

KEY OBSERVATIONS / INTUITION:
- Use sliding window with two pointers
- Need to track character frequency in t
- Expand right pointer until all characters are covered
- Then shrink from left to find minimum

APPROACH (Step-by-Step):
   Step 1: Create frequency map for t
   Step 2: Use sliding window - left and right pointers
   Step 3: Expand right, update window counts
   Step 4: When window is valid, try to shrink from left
   Step 5: Track minimum window found
   Step 6: Continue until right reaches end

TIME & SPACE COMPLEXITY ANALYSIS:
   Time Complexity:  O(m + n) - where m is length of s
   Space Complexity: O(1) - fixed size arrays for 128 chars

DRY RUN EXAMPLE:
Input: s = "ADOBECODEBANC", t = "ABC"
Process:
  t freq: A=1, B=1, C=1
  Expand right until all chars covered -> "ADOBECODEBANC"
  Shrink left -> "BANC" (length 4)
Output: "BANC"

ONE-LINE MEMORY TRICK:
"Slide and shrink - expand until valid, then minimize"

MENTAL VISUALIZATION:
Think of a sliding window that expands to capture all needed characters, then shrinks to find the smallest valid window.

IMPORTANT EDGE CASES:
* t is empty -> return ""
* s is shorter than t -> return ""
* t has duplicates -> need that many of each char

SOLUTION STRATEGY:
1. Use sliding window approach
2. Track required count vs current count
3. Expand right to include all required chars
4. Shrink left to minimize while still valid
5. Track minimum window length and position

========================================
*/

package medium;

public class MinimumWindowSubstring {
    
    public static String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }
        
        int[] required = new int[128];
        int[] window = new int[128];
        
        for (char c : t.toCharArray()) {
            required[c]++;
        }
        
        int left = 0, right = 0;
        int requiredCount = t.length();
        int formed = 0;
        int[] ans = {-1, 0, 0};
        
        while (right < s.length()) {
            char c = s.charAt(right);
            window[c]++;
            
            if (required[c] > 0 && window[c] <= required[c]) {
                formed++;
            }
            
            while (formed == requiredCount) {
                c = s.charAt(left);
                
                if (ans[0] == -1 || (right - left + 1) < ans[0]) {
                    ans[0] = right - left + 1;
                    ans[1] = left;
                    ans[2] = right;
                }
                
                window[c]--;
                if (required[c] > 0 && window[c] < required[c]) {
                    formed--;
                }
                left++;
            }
            
            right++;
        }
        
        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
    }
    
    public static void main(String[] args) {
        // Test Case 1
        String s1 = "ADOBECODEBANC";
        String t1 = "ABC";
        System.out.println("Input: s=\"" + s1 + "\", t=\"" + t1 + "\"");
        System.out.println("Output: \"" + minWindow(s1, t1) + "\"");
        System.out.println("Expected: \"BANC\"\n");
        
        // Test Case 2
        String s2 = "a";
        String t2 = "a";
        System.out.println("Input: s=\"" + s2 + "\", t=\"" + t2 + "\"");
        System.out.println("Output: \"" + minWindow(s2, t2) + "\"");
        System.out.println("Expected: \"a\"\n");
        
        // Test Case 3
        String s3 = "a";
        String t3 = "aa";
        System.out.println("Input: s=\"" + s3 + "\", t=\"" + t3 + "\"");
        System.out.println("Output: \"" + minWindow(s3, t3) + "\"");
        System.out.println("Expected: \"\"\n");
        
        // Test Case 4
        String s4 = "cabwefwwcvyqhwcwyqkcwtxcadsccbcwccbcadsaa";
        String t4 = "cwa";
        System.out.println("Input: s=\"" + s4 + "\", t=\"" + t4 + "\"");
        System.out.println("Output: \"" + minWindow(s4, t4) + "\"");
        System.out.println("Expected: \"cabw\"\n");
        
        // Test Case 5
        String s5 = "abc";
        String t5 = "b";
        System.out.println("Input: s=\"" + s5 + "\", t=\"" + t5 + "\"");
        System.out.println("Output: \"" + minWindow(s5, t5) + "\"");
        System.out.println("Expected: \"b\"");
    }
}
