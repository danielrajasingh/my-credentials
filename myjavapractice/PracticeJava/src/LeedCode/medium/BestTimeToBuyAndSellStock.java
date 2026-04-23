package medium;

public class BestTimeToBuyAndSellStock {
    /*
    ========================================
    Problem: Best Time to Buy and Sell Stock
    Link: https://leetcode.com/problems/best-time-to-buy-and-sell-stock
    Difficulty: Medium
    Topic: Array, Dynamic Programming
    ========================================
    
    PROBLEM EXPLANATION:
    Given an array prices where prices[i] is the price on day i,
    you can buy and sell stock once to maximize profit.
    You must buy before you sell.
    
    Example: prices=[7,1,5,3,6,4] → buy at 1, sell at 6 → profit=5
    Example: prices=[7,6,4,3,2,1] → no profit possible → return 0
    
    KEY OBSERVATIONS:
    - Single pass solution: track minimum price seen so far
    - At each price, calculate profit if sold today
    - Update max profit accordingly
    - Time: O(n), Space: O(1)
    - Cannot sell before buying (need to track minimum before current)
    
    APPROACH:
    1. Initialize minPrice = prices[0], maxProfit = 0
    2. For each price from index 1 to n-1:
       - Calculate profit if we sell at current price
       - Update maxProfit with maximum profit
       - Update minPrice if current price is lower
    3. Return maxProfit
    
    TIME COMPLEXITY: O(n) - single pass through array
    SPACE COMPLEXITY: O(1) - only tracking two variables
    
    DRY RUN:
    prices=[7,1,5,3,6,4]
    i=0: minPrice=7, maxProfit=0
    i=1: profit=1-7=-6, maxProfit=0, minPrice=1
    i=2: profit=5-1=4, maxProfit=4, minPrice=1
    i=3: profit=3-1=2, maxProfit=4, minPrice=1
    i=4: profit=6-1=5, maxProfit=5, minPrice=1
    i=5: profit=4-1=3, maxProfit=5, minPrice=1
    Result: 5 ✓
    
    MEMORY TRICK:
    "Track minimum price, calculate profit from it, update max profit"
    
    VISUALIZATION:
    prices: 7 1 5 3 6 4
    minPrice: 7→1→1→1→1→1
    profit:  0 0 4 2 5 3
    maxProfit: 0→0→4→4→5→5 = 5
    
    Buy at 1 (day 1), sell at 6 (day 4) for profit=5
    */

    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }

        int minPrice = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            int profit = prices[i] - minPrice;
            maxProfit = Math.max(maxProfit, profit);
            minPrice = Math.min(minPrice, prices[i]);
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        // Test case 1
        int[] prices1 = {7, 1, 5, 3, 6, 4};
        System.out.println("Input: [7, 1, 5, 3, 6, 4]");
        System.out.println("Output: " + maxProfit(prices1));
        System.out.println("Expected: 5 (buy at 1, sell at 6)\n");

        // Test case 2
        int[] prices2 = {7, 6, 4, 3, 2, 1};
        System.out.println("Input: [7, 6, 4, 3, 2, 1]");
        System.out.println("Output: " + maxProfit(prices2));
        System.out.println("Expected: 0 (no profit possible)\n");

        // Test case 3
        int[] prices3 = {2, 4, 1, 7, 5, 11};
        System.out.println("Input: [2, 4, 1, 7, 5, 11]");
        System.out.println("Output: " + maxProfit(prices3));
        System.out.println("Expected: 10 (buy at 1, sell at 11)\n");

        // Test case 4
        int[] prices4 = {1};
        System.out.println("Input: [1]");
        System.out.println("Output: " + maxProfit(prices4));
        System.out.println("Expected: 0\n");
    }
}
