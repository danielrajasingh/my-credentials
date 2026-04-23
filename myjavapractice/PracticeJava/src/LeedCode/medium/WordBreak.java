package medium;

import java.util.*;

public class WordBreak {
    /*
    ========================================
    Problem: Word Break
    Link: https://leetcode.com/problems/word-break
    Difficulty: Medium
    Topic: Hash Table, String, Dynamic Programming
    ========================================
    
    PROBLEM EXPLANATION:
    Given string s and wordDict, determine if s can be segmented
    into words from dictionary (each word used at most once).
    
    Example: s="leetcode", dict=["leet","code"] → true
    Example: s="catsandog", dict=["cat","cats","and","sand","dog"] → false
    
    KEY OBSERVATIONS:
    - dp[i] = can we form s[0..i-1] using dict words?
    - dp[i] = true if any dp[j] is true AND s[j..i-1] in dict
    - Use HashSet for O(1) lookup
    
    APPROACH (DP):
    1. Create dp array of size n+1, dp[0]=true
    2. For i from 1 to n:
       - For j from 0 to i-1:
         - If dp[j] && s[j:i] in dict: dp[i]=true, break
    3. Return dp[n]
    
    TIME COMPLEXITY: O(n² * m) where m = average word length for comparison
    SPACE COMPLEXITY: O(n) - dp array
    
    DRY RUN:
    s="leetcode", dict=["leet","code"]
    dp[0]=true
    dp[1]: no word, false
    dp[2]: no word, false
    dp[3]: no word, false
    dp[4]: dp[0]+"leet" in dict, true
    dp[5]: dp[4]+"e" not in dict, false
    dp[6]: dp[4]+"ee" not in dict, false
    dp[7]: dp[4]+"eed" not in dict, false
    dp[8]: dp[4]+"code" in dict, true ✓
    Result: true ✓
    
    MEMORY TRICK:
    "DP: for each position, find word from prev position"
    
    VISUALIZATION:
    s: l e e t c o d e
       0 1 2 3 4 5 6 7 8
    dp:[T F F F T F F F T]
         └─ leet─┘ └─ code─┘
    */

    public static boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && dict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        // Test case 1
        List<String> dict1 = new ArrayList<>(Arrays.asList("leet", "code"));
        System.out.println("Input: s=\"leetcode\", wordDict=[\"leet\",\"code\"]");
        System.out.println("Output: " + wordBreak("leetcode", dict1));
        System.out.println("Expected: true\n");

        // Test case 2
        List<String> dict2 = new ArrayList<>(Arrays.asList("cat", "cats", "and", "sand", "dog"));
        System.out.println("Input: s=\"catsandog\", wordDict=[\"cat\",\"cats\",\"and\",\"sand\",\"dog\"]");
        System.out.println("Output: " + wordBreak("catsandog", dict2));
        System.out.println("Expected: false\n");

        // Test case 3
        List<String> dict3 = new ArrayList<>(Arrays.asList("apple", "pie"));
        System.out.println("Input: s=\"applepenapple\", wordDict=[\"apple\",\"pen\"]");
        System.out.println("Output: " + wordBreak("applepenapple", dict3));
        System.out.println("Expected: true\n");

        // Test case 4
        List<String> dict4 = new ArrayList<>(Arrays.asList("a"));
        System.out.println("Input: s=\"b\", wordDict=[\"a\"]");
        System.out.println("Output: " + wordBreak("b", dict4));
        System.out.println("Expected: false\n");
    }
}
