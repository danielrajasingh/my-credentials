package medium;

import java.util.*;

public class TargetSum {
    /* Problem: Target Sum | Link: https://leetcode.com/problems/target-sum
    Difficulty: Medium | Topic: Array, Dynamic Programming, Backtracking | Count ways sum to target.
    APPROACH: DP or backtracking. O(n*sum). */

    public static int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) sum += num;
        if (sum < Math.abs(target) || (sum + target) % 2 != 0) return 0;
        return subsetSum(nums, (sum + target) / 2);
    }

    private static int subsetSum(int[] nums, int sum) {
        int[] dp = new int[sum + 1];
        dp[0] = 1;
        for (int num : nums) {
            for (int i = sum; i >= num; i--) {
                dp[i] += dp[i - num];
            }
        }
        return dp[sum];
    }

    public static void main(String[] args) {
        System.out.println("Ways: " + findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
        System.out.println("Expected: 5\n");
    }
}
