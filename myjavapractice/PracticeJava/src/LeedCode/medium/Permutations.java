package medium;

import java.util.*;

public class Permutations {
    /*
    Problem: Permutations | Link: https://leetcode.com/problems/permutations
    Difficulty: Medium | Topic: Array, Backtracking
    
    Generate all permutations of array. Example: [1,2,3] → [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
    
    APPROACH: Backtracking - build permutations by choosing each element and recursing on remaining.
    */

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums, new boolean[nums.length]);
        return result;
    }

    private static void backtrack(List<List<Integer>> result, List<Integer> current, int[] nums, boolean[] used) {
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                used[i] = true;
                current.add(nums[i]);
                backtrack(result, current, nums, used);
                current.remove(current.size() - 1);
                used[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3};
        System.out.println("Input: [1,2,3]");
        System.out.println("Output: " + permute(nums1));
        System.out.println("Expected: 6 permutations\n");

        int[] nums2 = {0, 1};
        System.out.println("Input: [0,1]");
        System.out.println("Output: " + permute(nums2));
        System.out.println("Expected: 2 permutations\n");
    }
}
