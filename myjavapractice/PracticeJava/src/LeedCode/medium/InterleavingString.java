package medium;

public class InterleavingString {
    /*
    ========================================
    Problem: Interleaving String
    Link: https://leetcode.com/problems/interleaving-string
    Difficulty: Medium
    Topic: String, Dynamic Programming
    ========================================
    
    PROBLEM EXPLANATION:
    Given three strings s1, s2, s3, check if s3 is formed by interleaving s1 and s2.
    Interleaving means weaving characters from s1 and s2 while maintaining their order.
    
    Example: s1="aab", s2="cab", s3="aaacab"
    One valid interleaving: a(s1) a(s1) a(s2) c(s2) a(s1) b(s2) = "aaacab"
    
    KEY OBSERVATIONS:
    - If len(s3) ≠ len(s1) + len(s2), return false immediately
    - Use DP: dp[i][j] = can we form s3[0..i+j-1] from s1[0..i-1] and s2[0..j-1]
    - At each position, we can take from s1 or s2 (but not both)
    - Order of characters in s1 and s2 must be preserved
    
    APPROACH:
    1. Check length constraint
    2. Create 2D DP: (len(s1)+1) x (len(s2)+1)
    3. Base case: dp[0][0] = true
    4. Fill first row (all from s1) and first column (all from s2)
    5. Fill remaining cells:
       - If last char from s1 matches: dp[i][j] |= dp[i-1][j]
       - If last char from s2 matches: dp[i][j] |= dp[i][j-1]
    6. Return dp[len(s1)][len(s2)]
    
    TIME COMPLEXITY: O(m * n) where m=len(s1), n=len(s2)
    SPACE COMPLEXITY: O(m * n) for DP table
    
    DRY RUN:
    s1="aab", s2="cab", s3="aaacab"
    DP formation:
        ""  c  a  b
    ""  T  F  F  F
    a   T  F  T  F
    a   T  F  T  F
    b   T  F  T  T
    Result: dp[3][3] = true ✓
    
    MEMORY TRICK:
    "Interleaving: pick from s1 or s2, maintain order of both"
    
    VISUALIZATION:
    s1: a a b
    s2:     c a b
    s3: a a a c a b (weaving s1 and s2)
        ^ ^ ^ ^ ^ ^ (pick one at each step)
    */

    public static boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length();
        int n = s2.length();
        
        if (m + n != s3.length()) {
            return false;
        }
        
        // dp[i][j] = can we form s3[0..i+j-1] from s1[0..i-1] and s2[0..j-1]
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        
        // Fill first row (all characters from s1)
        for (int i = 1; i <= m; i++) {
            dp[i][0] = dp[i - 1][0] && s1.charAt(i - 1) == s3.charAt(i - 1);
        }
        
        // Fill first column (all characters from s2)
        for (int j = 1; j <= n; j++) {
            dp[0][j] = dp[0][j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1);
        }
        
        // Fill remaining cells
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // Take from s1
                if (s1.charAt(i - 1) == s3.charAt(i + j - 1) && dp[i - 1][j]) {
                    dp[i][j] = true;
                }
                // Take from s2
                if (s2.charAt(j - 1) == s3.charAt(i + j - 1) && dp[i][j - 1]) {
                    dp[i][j] = true;
                }
            }
        }
        
        return dp[m][n];
    }

    public static void main(String[] args) {
        // Test case 1
        String s1_1 = "aabcc";
        String s2_1 = "dbbca";
        String s3_1 = "aadbbcbcac";
        System.out.println("Input: s1=\"aabcc\", s2=\"dbbca\", s3=\"aadbbcbcac\"");
        System.out.println("Output: " + isInterleave(s1_1, s2_1, s3_1));
        System.out.println("Expected: true\n");
        
        // Test case 2
        String s1_2 = "aabcc";
        String s2_2 = "dbbca";
        String s3_2 = "aadbbbaccc";
        System.out.println("Input: s1=\"aabcc\", s2=\"dbbca\", s3=\"aadbbbaccc\"");
        System.out.println("Output: " + isInterleave(s1_2, s2_2, s3_2));
        System.out.println("Expected: false\n");
        
        // Test case 3
        String s1_3 = "aab";
        String s2_3 = "cab";
        String s3_3 = "aaacab";
        System.out.println("Input: s1=\"aab\", s2=\"cab\", s3=\"aaacab\"");
        System.out.println("Output: " + isInterleave(s1_3, s2_3, s3_3));
        System.out.println("Expected: true\n");
    }
}
