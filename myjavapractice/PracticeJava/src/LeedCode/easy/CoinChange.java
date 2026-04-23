package easy;

public class CoinChange {
    /*
    ========================================
    Problem: Coin Change
    Link: https://leetcode.com/problems/coin-change
    Difficulty: Easy (Medium in practice)
    Topic: Array, Dynamic Programming, Breadth-First Search
    ========================================
    
    PROBLEM EXPLANATION:
    Given coin denominations and amount, return minimum number of coins
    needed to make that amount. Return -1 if impossible.
    
    Example: coins=[1,2,5], amount=5 → [5] → 1 coin
    Example: coins=[2], amount=3 → impossible → -1
    
    KEY OBSERVATIONS:
    - dp[i] = minimum coins needed to make amount i
    - dp[i] = min(dp[i-coin] + 1) for each coin where coin <= i
    - dp[0] = 0 (zero coins for zero amount)
    - Initialize dp with infinity except dp[0]
    
    APPROACH (DP):
    1. Create dp array of size amount+1, initialize with infinity
    2. dp[0] = 0
    3. For each amount from 1 to target:
       - For each coin:
         - If coin <= amount: dp[amount] = min(dp[amount], dp[amount-coin]+1)
    4. Return dp[amount] if not infinity, else -1
    
    TIME COMPLEXITY: O(amount * len(coins)) - nested loops
    SPACE COMPLEXITY: O(amount) - dp array
    
    DRY RUN:
    coins=[1,2,5], amount=5
    dp=[0, inf, inf, inf, inf, inf]
    i=1: coin 1 → dp[1]=dp[0]+1=1
    i=2: coin 1 → dp[2]=min(inf,1+1)=2, coin 2 → dp[2]=min(2,0+1)=1
    i=3: coin 1 → dp[3]=min(inf,1+1)=2, coin 2 → dp[3]=min(2,1+1)=2
    i=4: coin 1 → dp[4]=2+1=3, coin 2 → dp[4]=min(3,1+1)=2
    i=5: coin 1 → dp[5]=2+1=3, coin 2 → dp[5]=min(3,2+1)=3, coin 5 → dp[5]=min(3,0+1)=1
    Result: 1 ✓
    
    MEMORY TRICK:
    "DP: for each amount, try all coins, take minimum"
    
    VISUALIZATION:
    amount=5: 5
    amount=5: 2+2+1 (3 coins)
    amount=5: 5 (1 coin) - minimum
    */

    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i && dp[i - coin] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        // Test case 1
        int[] coins1 = {1, 2, 5};
        System.out.println("Input: coins=[1,2,5], amount=5");
        System.out.println("Output: " + coinChange(coins1, 5));
        System.out.println("Expected: 1\n");

        // Test case 2
        int[] coins2 = {2};
        System.out.println("Input: coins=[2], amount=3");
        System.out.println("Output: " + coinChange(coins2, 3));
        System.out.println("Expected: -1\n");

        // Test case 3
        int[] coins3 = {10};
        System.out.println("Input: coins=[10], amount=10");
        System.out.println("Output: " + coinChange(coins3, 10));
        System.out.println("Expected: 1\n");

        // Test case 4
        int[] coins4 = {1, 2, 5};
        System.out.println("Input: coins=[1,2,5], amount=27");
        System.out.println("Output: " + coinChange(coins4, 27));
        System.out.println("Expected: 4 ([5,5,5,5,5,1,1])\n");
    }
}
