package easy;

import java.util.*;

public class MaximalSquare {
    /* Problem: Maximal Square | Link: https://leetcode.com/problems/maximal-square
    Difficulty: Easy | Topic: Array, Dynamic Programming, Matrix | Find largest square.
    APPROACH: 2D DP dp[i][j]=min(left,up,diag)+1. O(m*n). */

    public static int maximalSquare(char[][] matrix) {
        if (matrix.length == 0) return 0;
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n];
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = (i == 0 || j == 0) ? 1 : Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max * max;
    }

    public static void main(String[] args) {
        System.out.println("Maximal square works\n");
    }
}
