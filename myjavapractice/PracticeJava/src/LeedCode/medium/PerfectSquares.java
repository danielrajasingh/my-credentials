package medium;

import java.util.*;

public class PerfectSquares {
    /* Problem: Perfect Squares | Link: https://leetcode.com/problems/perfect-squares
    Difficulty: Medium | Topic: Math, Dynamic Programming, Breadth-First Search | Min perfect squares.
    APPROACH: DP or BFS. O(n sqrt(n)). */

    public static int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println("Min squares of 7: " + numSquares(7));
        System.out.println("Expected: 2\n");
    }
}
