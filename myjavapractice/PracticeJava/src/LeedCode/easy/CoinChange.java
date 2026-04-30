/*
========================================
[PROBLEM] Coin Change
[DIFFICULTY] EASY
[TOPIC] Math, Dynamic Programming, Memoization
========================================

PROBLEM EXPLANATION:
You are given an integer array coins representing coins of different denominations 
and an integer amount representing a total amount of money.

Return the fewest number of coins that you need to make up that amount. 
If that amount of money cannot be made up by any combination of the coins, return -1.

You may assume that you have an infinite number of each kind of coin.

Example 1:
Input: coins = [1,2,5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1

Example 2:
Input: coins = [2], amount = 3
Output: -1

Example 3:
Input: coins = [1], amount = 0
Output: 0

KEY OBSERVATIONS / INTUITION:
- This is a classic unbounded knapsack problem
- Use DP: dp[i] = minimum coins to make amount i
- For each amount, try all coins and find minimum

APPROACH (Step-by-Step):
   Step 1: Initialize dp array with amount+1 (infinity)
   Step 2: dp[0] = 0 (zero coins for amount 0)
   Step 3: For each amount from 1 to target
   Step 4: Try each coin, if coin <= amount and dp[amount-coin] is valid
   Step 5: Update dp[amount] = min(dp[amount], dp[amount-coin] + 1)
   Step 6: Return dp[amount] if valid, else -1

TIME & SPACE COMPLEXITY ANALYSIS:
   Time Complexity:  O(amount * n) - where n is number of coins
   Space Complexity: O(amount) - dp array

DRY RUN EXAMPLE:
Input: coins = [1,2,5], amount = 11
Process:
  dp[0] = 0
  dp[1] = 1 (1)
  dp[2] = 1 (2)
  dp[3] = 2 (2+1)
  dp[4] = 2 (2+2)
  dp[5] = 1 (5)
  dp[6] = 2 (5+1)
  dp[7] = 2 (5+2)
  dp[8] = 3 (5+2+1)
  dp[9] = 3 (5+2+2)
  dp[10] = 2 (5+5)
  dp[11] = 3 (5+5+1)
Output: 3

ONE-LINE MEMORY TRICK:
"DP with infinity - try all coins for each amount"

MENTAL VISUALIZATION:
Think of building up from amount 0, each amount builds on smaller amounts.

IMPORTANT EDGE CASES:
* amount = 0 -> return 0
* No valid combination -> return -1
* Single coin denomination

SOLUTION STRATEGY:
1. Use 1D DP array
2. Initialize with amount+1 (impossible value)
3. For each amount, try all coins
4. Track minimum coins needed

========================================
*/

package easy;

import java.util.*;

public class CoinChange {
    
    public static int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i && dp[i - coin] != amount + 1) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }
    
    public static void main(String[] args) {
        // Test Case 1
        int[] coins1 = {1, 2, 5};
        int amount1 = 11;
        System.out.print("Input: coins=");
        System.out.print(Arrays.toString(coins1));
        System.out.println(", amount=" + amount1);
        System.out.println("Output: " + coinChange(coins1, amount1));
        System.out.println("Expected: 3\n");
        
        // Test Case 2
        int[] coins2 = {2};
        int amount2 = 3;
        System.out.print("Input: coins=");
        System.out.print(Arrays.toString(coins2));
        System.out.println(", amount=" + amount2);
        System.out.println("Output: " + coinChange(coins2, amount2));
        System.out.println("Expected: -1\n");
        
        // Test Case 3
        int[] coins3 = {1};
        int amount3 = 0;
        System.out.print("Input: coins=");
        System.out.print(Arrays.toString(coins3));
        System.out.println(", amount=" + amount3);
        System.out.println("Output: " + coinChange(coins3, amount3));
        System.out.println("Expected: 0\n");
        
        // Test Case 4
        int[] coins4 = {1, 2, 5};
        int amount4 = 100;
        System.out.print("Input: coins=");
        System.out.print(Arrays.toString(coins4));
        System.out.println(", amount=" + amount4);
        System.out.println("Output: " + coinChange(coins4, amount4));
        System.out.println("Expected: 20\n");
        
        // Test Case 5
        int[] coins5 = {2, 5, 10, 1};
        int amount5 = 27;
        System.out.print("Input: coins=");
        System.out.print(Arrays.toString(coins5));
        System.out.println(", amount=" + amount5);
        System.out.println("Output: " + coinChange(coins5, amount5));
        System.out.println("Expected: 4");
    }
}
