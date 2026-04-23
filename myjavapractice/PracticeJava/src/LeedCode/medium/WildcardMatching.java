package medium;

public class WildcardMatching {
    /*
    ========================================
    Problem: Wildcard Matching
    Link: https://leetcode.com/problems/wildcard-matching
    Difficulty: Medium
    Topic: String, Dynamic Programming, Greedy
    ========================================
    
    PROBLEM EXPLANATION:
    Pattern matching with '?' and '*' wildcards:
    - '?' matches any single character
    - '*' matches any sequence (0 or more) of characters
    Return true if pattern matches entire string.
    
    Example: s="aa", p="*" → true (star matches two 'a's)
    
    KEY OBSERVATIONS:
    - DP approach: dp[i][j] = does s[0..i-1] match p[0..j-1]?
    - Star can match 0 chars: dp[i][j] = dp[i][j-1]
    - Star can match 1+ chars: dp[i][j] = dp[i-1][j]
    - '?' matches single char: dp[i][j] = dp[i-1][j-1]
    - Greedy approach can also work (two pointers)
    
    APPROACH (DP):
    1. Create 2D DP table: (len(s)+1) x (len(p)+1)
    2. Base case: dp[0][0] = true (empty string, empty pattern)
    3. Handle leading stars in pattern
    4. Fill table with transitions
    5. Return dp[len(s)][len(p)]
    
    TIME COMPLEXITY: O(m * n) where m=len(s), n=len(p)
    SPACE COMPLEXITY: O(m * n) for DP table
    
    DRY RUN:
    s="aa", p="*a"
    DP table:
        ""  *  a
    ""  T  T  F
    a   F  T  T
    a   F  T  T
    Result: true ✓
    
    MEMORY TRICK:
    "Star: skip in pattern OR skip in string"
    "Question: match single char, move both"
    
    VISUALIZATION:
    s: [a][a]
    p: [*][a]
    * can expand to match "a", then 'a' matches 'a'
    */

    public static boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        
        // dp[i][j] = does s[0..i-1] match p[0..j-1]
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        
        // Handle patterns like *, **, ***, etc.
        for (int j = 1; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 1];
            }
        }
        
        // Fill DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j - 1) == '*') {
                    // Star can match 0 chars (skip star) or match 1+ chars (skip in s)
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                } else if (p.charAt(j - 1) == '?' || p.charAt(j - 1) == s.charAt(i - 1)) {
                    // '?' matches any single char, or chars are equal
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }
        
        return dp[m][n];
    }

    public static void main(String[] args) {
        // Test case 1
        String s1 = "aa";
        String p1 = "a";
        System.out.println("Input: s=\"aa\", p=\"a\"");
        System.out.println("Output: " + isMatch(s1, p1));
        System.out.println("Expected: false\n");
        
        // Test case 2
        String s2 = "aa";
        String p2 = "*";
        System.out.println("Input: s=\"aa\", p=\"*\"");
        System.out.println("Output: " + isMatch(s2, p2));
        System.out.println("Expected: true\n");
        
        // Test case 3
        String s3 = "cb";
        String p3 = "?a";
        System.out.println("Input: s=\"cb\", p=\"?a\"");
        System.out.println("Output: " + isMatch(s3, p3));
        System.out.println("Expected: false\n");
        
        // Test case 4
        String s4 = "adceb";
        String p4 = "*a*b";
        System.out.println("Input: s=\"adceb\", p=\"*a*b\"");
        System.out.println("Output: " + isMatch(s4, p4));
        System.out.println("Expected: true\n");
    }
}
