package medium;

import java.util.*;

public class SearchInsertPosition {
    /* Problem: Search Insert Position | Link: https://leetcode.com/problems/search-insert-position
    Difficulty: Medium | Topic: Array, Binary Search | Find index or insert.
    APPROACH: Binary search. O(log n). */

    public static int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) left = mid + 1;
            else right = mid;
        }
        return left;
    }

    public static void main(String[] args) {
        System.out.println("Insert at: " + searchInsert(new int[]{1, 3, 5, 6}, 5));
        System.out.println("Expected: 2\n");
    }
}
