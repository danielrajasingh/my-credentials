package medium;

import java.util.*;

public class CombinationSum {
    /*
    Problem: Combination Sum | Link: https://leetcode.com/problems/combination-sum
    Difficulty: Medium | Topic: Array, Backtracking
    
    Find all combinations that sum to target. Elements reusable. Example: candidates=[2,3,6,7], target=7 → [[2,2,3],[7]]
    
    APPROACH: Backtrack - for each candidate, either use it (keep in recursion) or skip it.
    */

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }

    private static void backtrack(List<List<Integer>> result, List<Integer> current, int[] candidates, int remain, int start) {
        if (remain == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] > remain) break;
            current.add(candidates[i]);
            backtrack(result, current, candidates, remain - candidates[i], i);
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] candidates1 = {2, 3, 6, 7};
        System.out.println("Input: candidates=[2,3,6,7], target=7");
        System.out.println("Output: " + combinationSum(candidates1, 7));
        System.out.println("Expected: [[2,2,3],[7]]\n");

        int[] candidates2 = {2};
        System.out.println("Input: candidates=[2], target=1");
        System.out.println("Output: " + combinationSum(candidates2, 1));
        System.out.println("Expected: []\n");
    }
}
