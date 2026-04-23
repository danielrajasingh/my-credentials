package easy;

import java.util.*;

public class BestTimeToBuyAndSellStockII {
    /* Problem: Best Time to Buy and Sell Stock II | Link: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii
    Difficulty: Easy | Topic: Array, Dynamic Programming, Greedy | Max profit multiple.
    APPROACH: Sum all positive differences. O(n). */

    public static int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            profit += Math.max(0, prices[i] - prices[i - 1]);
        }
        return profit;
    }

    public static void main(String[] args) {
        System.out.println("Profit: " + maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println("Expected: 7\n");
    }
}
