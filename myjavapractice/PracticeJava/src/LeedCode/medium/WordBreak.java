/*
========================================
[PROBLEM] Word Break
[DIFFICULTY] MEDIUM
[TOPIC] Array, Dynamic Programming, Greedy
========================================

PROBLEM EXPLANATION:
Given a string s and a dictionary of strings wordDict, return true if s can be segmented 
into a space-separated sequence of one or more dictionary words.

Note that the same word in the dictionary may be reused multiple times in the segmentation.

Example 1:
Input: s = "leetcode", wordDict = ["leet","code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".

Example 2:
Input: s = "applepenapple", wordDict = ["apple","pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".

Example 3:
Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
Output: false

KEY OBSERVATIONS / INTUITION:
- Use DP: dp[i] = true if s[0:i] can be segmented
- For each position, check all possible word endings
- If dp[j] is true and s[j:i] is in dictionary, then dp[i] is true

APPROACH (Step-by-Step):
   Step 1: Convert wordDict to HashSet for O(1) lookup
   Step 2: Create dp array of size n+1, dp[0] = true
   Step 3: For each position i from 1 to n
   Step 4: Check all j from 0 to i-1
   Step 5: If dp[j] is true and s[j:i] in wordSet, set dp[i] = true
   Step 6: Return dp[n]

TIME & SPACE COMPLEXITY ANALYSIS:
   Time Complexity:  O(n^2 * L) - where n is string length, L is avg word length
   Space Complexity: O(n + m) - dp array + wordSet

DRY RUN EXAMPLE:
Input: s = "leetcode", wordDict = ["leet","code"]
Process:
  dp[0] = true
  i=4: check "leet" -> dp[0]=true, "leet" in dict -> dp[4]=true
  i=8: check "code" -> dp[4]=true, "code" in dict -> dp[8]=true
Output: true

ONE-LINE MEMORY TRICK:
"DP with set - check if prefix can break and remainder is word"

MENTAL VISUALIZATION:
Think of building the string piece by piece, each piece must be a valid word from dictionary.

IMPORTANT EDGE CASES:
* Empty string -> return true
* No valid segmentation -> return false
* Single character word

SOLUTION STRATEGY:
1. Use DP approach
2. Convert dictionary to HashSet for fast lookup
3. For each position, check all possible previous positions
4. If prefix is breakable and substring is a word, mark as breakable

========================================
*/

package medium;

import java.util.*;

public class WordBreak {
    
    public static boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        int n = s.length();
        
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        
        return dp[n];
    }
    
    public static void main(String[] args) {
        // Test Case 1
        String s1 = "leetcode";
        List<String> dict1 = Arrays.asList("leet", "code");
        System.out.println("Input: s=\"" + s1 + "\", wordDict=" + dict1);
        System.out.println("Output: " + wordBreak(s1, dict1));
        System.out.println("Expected: true\n");
        
        // Test Case 2
        String s2 = "applepenapple";
        List<String> dict2 = Arrays.asList("apple", "pen");
        System.out.println("Input: s=\"" + s2 + "\", wordDict=" + dict2);
        System.out.println("Output: " + wordBreak(s2, dict2));
        System.out.println("Expected: true\n");
        
        // Test Case 3
        String s3 = "catsandog";
        List<String> dict3 = Arrays.asList("cats", "dog", "sand", "and", "cat");
        System.out.println("Input: s=\"" + s3 + "\", wordDict=" + dict3);
        System.out.println("Output: " + wordBreak(s3, dict3));
        System.out.println("Expected: false\n");
        
        // Test Case 4
        String s4 = "cars";
        List<String> dict4 = Arrays.asList("car", "ca", "rs");
        System.out.println("Input: s=\"" + s4 + "\", wordDict=" + dict4);
        System.out.println("Output: " + wordBreak(s4, dict4));
        System.out.println("Expected: true\n");
        
        // Test Case 5
        String s5 = "";
        List<String> dict5 = Arrays.asList("a");
        System.out.println("Input: s=\"" + s5 + "\", wordDict=" + dict5);
        System.out.println("Output: " + wordBreak(s5, dict5));
        System.out.println("Expected: true");
    }
}
