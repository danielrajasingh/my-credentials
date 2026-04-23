package easy;

import java.util.*;

public class BestTimeToBuyAndSellStock {
    /* Problem: Best Time to Buy and Sell Stock | Link: https://leetcode.com/problems/best-time-to-buy-and-sell-stock
    Difficulty: Easy | Topic: Array, Dynamic Programming | Max profit from one transaction.
    APPROACH: Track min price, calc profit at each step. O(n). */

    public static int maxProfit(int[] prices) {
        int minPrice = prices[0], maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            maxProfit = Math.max(maxProfit, prices[i] - minPrice);
            minPrice = Math.min(minPrice, prices[i]);
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        System.out.println("Max profit: " + maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println("Expected: 5\n");
    }
}
