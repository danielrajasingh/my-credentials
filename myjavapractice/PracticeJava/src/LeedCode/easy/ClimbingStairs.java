package easy;

public class ClimbingStairs {
    /*
    ========================================
    Problem: Climbing Stairs
    Link: https://leetcode.com/problems/climbing-stairs
    Difficulty: Easy
    Topic: Math, Dynamic Programming, Memoization
    ========================================
    
    PROBLEM EXPLANATION:
    You're climbing stairs with n steps. Each time you can climb 1 or 2 steps.
    How many distinct ways can you reach the top?
    
    Example: n=3 → [1+1+1, 1+2, 2+1] → 3 ways
    Example: n=2 → [1+1, 2] → 2 ways
    
    KEY OBSERVATIONS:
    - dp[i] = ways to reach step i
    - dp[i] = dp[i-1] + dp[i-2] (come from step i-1 or i-2)
    - Base cases: dp[0]=1, dp[1]=1
    - This is Fibonacci sequence!
    
    APPROACH (DP):
    1. Initialize dp[n+1]
    2. dp[0]=1, dp[1]=1
    3. For i from 2 to n: dp[i]=dp[i-1]+dp[i-2]
    4. Return dp[n]
    
    TIME COMPLEXITY: O(n) - single pass
    SPACE COMPLEXITY: O(n) - dp array, can optimize to O(1)
    
    DRY RUN:
    n=3
    dp[0]=1, dp[1]=1
    dp[2]=1+1=2
    dp[3]=2+1=3
    Result: 3 ✓
    
    MEMORY TRICK:
    "Fibonacci: combine ways from previous two steps"
    
    VISUALIZATION:
    n=3:
    Step 0: 1 way (already there)
    Step 1: 1 way (1 step)
    Step 2: 2 ways (1+1, or 2)
    Step 3: 3 ways (from step 1: 1+1+1, from step 2: 1+2, 2+1)
    */

    public static int climbStairs(int n) {
        if (n <= 1) {
            return 1;
        }

        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    public static void main(String[] args) {
        // Test case 1
        System.out.println("Input: n=3");
        System.out.println("Output: " + climbStairs(3));
        System.out.println("Expected: 3\n");

        // Test case 2
        System.out.println("Input: n=2");
        System.out.println("Output: " + climbStairs(2));
        System.out.println("Expected: 2\n");

        // Test case 3
        System.out.println("Input: n=1");
        System.out.println("Output: " + climbStairs(1));
        System.out.println("Expected: 1\n");

        // Test case 4
        System.out.println("Input: n=5");
        System.out.println("Output: " + climbStairs(5));
        System.out.println("Expected: 8\n");
    }
}
