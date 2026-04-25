/*
========================================
[PROBLEM] Best Time to Buy and Sell Stock
[DIFFICULTY] EASY
[TOPIC] Array, Dynamic Programming, Greedy
========================================

PROBLEM EXPLANATION:
You are given an array prices where prices[i] is the price of a given stock 
on the ith day.

You want to maximize your profit by choosing a single day to buy one stock 
and choosing a different day in the future to sell that stock.

Return the maximum profit you can achieve from this transaction. 
If you cannot achieve any profit, return 0.

Example 1:
Input: prices = [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price=1) and sell on day 5 (price=6), profit=6-1=5

Example 2:
Input: prices = [7,6,4,3,1]
Output: 0
Explanation: No transaction is done, max profit = 0

Example 3:
Input: prices = [2,4,1]
Output: 2
Explanation: Buy on day 1 (price=2), sell on day 2 (price=4), profit=2

KEY OBSERVATIONS / INTUITION:
- Track minimum price seen so far
- Calculate potential profit at each step
- Update maximum profit

APPROACH (Step-by-Step):
   Step 1: Initialize minPrice to first element
   Step 2: Iterate through prices
   Step 3: Update minPrice if current price is lower
   Step 4: Calculate profit = current price - minPrice
   Step 5: Update maxProfit if profit is higher

TIME & SPACE COMPLEXITY ANALYSIS:
   Time Complexity:  O(n) - Single pass
   Space Complexity: O(1) - Only variables

DRY RUN EXAMPLE:
Input: prices = [7,1,5,3,6,4]
Process:
  i=0: minPrice=7, maxProfit=0
  i=1: price=1<7, minPrice=1, profit=0
  i=2: price=5, minPrice=1, profit=4, maxProfit=4
  i=3: price=3, minPrice=1, profit=2, maxProfit=4
  i=4: price=6, minPrice=1, profit=5, maxProfit=5
  i=5: price=4, minPrice=1, profit=3, maxProfit=5
Output: 5

ONE-LINE MEMORY TRICK:
"Track min price, calculate profit at each step"

MENTAL VISUALIZATION:
Think of finding the best day to buy (lowest) and sell (highest after buy).

IMPORTANT EDGE CASES:
* Less than 2 elements -> return 0
* Decreasing prices -> return 0
* Single element -> return 0

SOLUTION STRATEGY:
1. Track minimum price seen so far
2. Calculate potential profit at each position
3. Update maximum profit

========================================
*/

package medium;

public class BestTimeToBuyAndSellStock {
    
    /**
     * Find max profit using single pass
     */
    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        
        int minPrice = prices[0];
        int maxProfit = 0;
        
        for (int i = 1; i < prices.length; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - minPrice);
        }
        
        return maxProfit;
    }
    
    public static void main(String[] args) {
        // Test Case 1
        int[] prices1 = {7, 1, 5, 3, 6, 4};
        System.out.print("Input: ");
        printArray(prices1);
        System.out.println("Output: " + maxProfit(prices1));
        System.out.println("Expected: 5\n");
        
        // Test Case 2
        int[] prices2 = {7, 6, 4, 3, 1};
        System.out.print("Input: ");
        printArray(prices2);
        System.out.println("Output: " + maxProfit(prices2));
        System.out.println("Expected: 0\n");
        
        // Test Case 3
        int[] prices3 = {2, 4, 1};
        System.out.print("Input: ");
        printArray(prices3);
        System.out.println("Output: " + maxProfit(prices3));
        System.out.println("Expected: 2\n");
        
        // Test Case 4
        int[] prices4 = {2, 4, 1, 7};
        System.out.print("Input: ");
        printArray(prices4);
        System.out.println("Output: " + maxProfit(prices4));
        System.out.println("Expected: 6\n");
        
        // Test Case 5
        int[] prices5 = {1};
        System.out.print("Input: ");
        printArray(prices5);
        System.out.println("Output: " + maxProfit(prices5));
        System.out.println("Expected: 0");
    }
    
    private static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) System.out.print(",");
        }
        System.out.println("]");
    }
}
