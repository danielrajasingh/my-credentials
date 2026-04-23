package medium;

import java.util.*;

public class FindAllNumbersDisappearedInArray {
    /* Problem: Find All Numbers Disappeared in an Array | Link: https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array
    Difficulty: Medium | Topic: Array, Hash Table | Find missing 1 to n.
    APPROACH: Mark visited with negative indices. O(n). */

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        for (int num : nums) {
            int idx = Math.abs(num) - 1;
            nums[idx] = -Math.abs(nums[idx]);
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) result.add(i + 1);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("Disappeared: " + findDisappearedNumbers(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));
        System.out.println("Expected: [5,6]\n");
    }
}
