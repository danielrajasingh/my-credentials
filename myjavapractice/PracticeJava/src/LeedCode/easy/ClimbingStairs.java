/*
========================================
[PROBLEM] Climbing Stairs
[DIFFICULTY] EASY
[TOPIC] Math, Dynamic Programming, Memoization
========================================

PROBLEM EXPLANATION:
You are climbing a staircase. It takes n steps to reach the top.
Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Example 1:
Input: n = 2
Output: 2
Explanation: There are two ways: (1+1) or (2)

Example 2:
Input: n = 3
Output: 3
Explanation: There are three ways: (1+1+1), (1+2), (2+1)

Example 3:
Input: n = 4
Output: 5
Explanation: There are five ways: (1+1+1+1), (1+1+2), (1+2+1), (2+1+1), (2+2)

KEY OBSERVATIONS / INTUITION:
- This is the Fibonacci sequence!
- ways(n) = ways(n-1) + ways(n-2)
- Base cases: ways(1)=1, ways(2)=2

APPROACH (Step-by-Step):
   Step 1: Handle base cases (n=1 return 1, n=2 return 2)
   Step 2: Use dynamic programming
   Step 3: dp[i] = dp[i-1] + dp[i-2]
   Step 4: Optimize to O(1) space by tracking only two variables

TIME & SPACE COMPLEXITY ANALYSIS:
   Time Complexity:  O(n) - Single pass
   Space Complexity: O(1) - Only two variables

DRY RUN EXAMPLE:
Input: n = 5
Process:
  i=1: ways=1
  i=2: ways=2
  i=3: ways=3 (2+1)
  i=4: ways=5 (3+2)
  i=5: ways=8 (5+3)
Output: 8

ONE-LINE MEMORY TRICK:
"Fibonacci - add previous two ways"

MENTAL VISUALIZATION:
Think of climbing as building up from the bottom, each step can come from 1 or 2 steps below.

IMPORTANT EDGE CASES:
* n=1 -> return 1
* n=2 -> return 2
* n=0 -> return 1 (empty path)

SOLUTION STRATEGY:
1. Use iterative DP with O(1) space
2. Track prev1 (ways to reach current) and prev2 (ways to reach previous)
3. At each step, newWays = prev1 + prev2
4. Shift prev2 to prev1, and newWays to prev2

========================================
*/

package easy;

public class ClimbingStairs {
    
    public static int climbStairs(int n) {
        if (n <= 2) return n;
        
        int prev2 = 1;  // ways to reach step 1
        int prev1 = 2;  // ways to reach step 2
        
        for (int i = 3; i <= n; i++) {
            int curr = prev1 + prev2;
            prev2 = prev1;
            prev1 = curr;
        }
        
        return prev1;
    }
    
    public static void main(String[] args) {
        // Test Case 1
        int n1 = 2;
        System.out.println("Input: n=" + n1);
        System.out.println("Output: " + climbStairs(n1));
        System.out.println("Expected: 2\n");
        
        // Test Case 2
        int n2 = 3;
        System.out.println("Input: n=" + n2);
        System.out.println("Output: " + climbStairs(n2));
        System.out.println("Expected: 3\n");
        
        // Test Case 3
        int n3 = 4;
        System.out.println("Input: n=" + n3);
        System.out.println("Output: " + climbStairs(n3));
        System.out.println("Expected: 5\n");
        
        // Test Case 4
        int n4 = 5;
        System.out.println("Input: n=" + n4);
        System.out.println("Output: " + climbStairs(n4));
        System.out.println("Expected: 8\n");
        
        // Test Case 5
        int n5 = 1;
        System.out.println("Input: n=" + n5);
        System.out.println("Output: " + climbStairs(n5));
        System.out.println("Expected: 1");
    }
}
