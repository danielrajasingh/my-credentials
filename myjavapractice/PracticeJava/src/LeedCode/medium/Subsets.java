package medium;

import java.util.*;

public class Subsets {
    /* Problem: Subsets | Link: https://leetcode.com/problems/subsets
    Difficulty: Medium | Topic: Array, Backtracking | Generate all subsets.
    APPROACH: Backtracking or iterative. O(2^n). */

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums, 0);
        return result;
    }

    private static void backtrack(List<List<Integer>> result, List<Integer> current, int[] nums, int start) {
        result.add(new ArrayList<>(current));
        for (int i = start; i < nums.length; i++) {
            current.add(nums[i]);
            backtrack(result, current, nums, i + 1);
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println("Subsets: " + subsets(new int[]{1, 2, 2}));
    }
}
