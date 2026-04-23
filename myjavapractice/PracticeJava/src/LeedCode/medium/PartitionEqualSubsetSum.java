package medium;

import java.util.*;

public class PartitionEqualSubsetSum {
    /* Problem: Partition Equal Subset Sum | Link: https://leetcode.com/problems/partition-equal-subset-sum
    Difficulty: Medium | Topic: Array, Dynamic Programming | Check if can partition.
    APPROACH: 0/1 knapsack DP. O(n*sum). */

    public static boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) sum += num;
        if (sum % 2 != 0) return false;
        boolean[] dp = new boolean[sum / 2 + 1];
        dp[0] = true;
        for (int num : nums) {
            for (int i = sum / 2; i >= num; i--) {
                dp[i] = dp[i] || dp[i - num];
            }
        }
        return dp[sum / 2];
    }

    public static void main(String[] args) {
        System.out.println("Can partition: " + canPartition(new int[]{1, 5, 11, 5}));
        System.out.println("Expected: true\n");
    }
}
