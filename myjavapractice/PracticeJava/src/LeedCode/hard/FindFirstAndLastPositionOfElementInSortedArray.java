package hard;

import java.util.*;

public class FindFirstAndLastPositionOfElementInSortedArray {
    /*
    Problem: Find First and Last Position of Element in Sorted Array
    Link: https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array
    Difficulty: Hard | Topic: Array, Binary Search
    
    EXPLANATION: Find first/last occurrence of target in sorted array. Return [-1,-1] if not found.
    Example: nums=[5,7,7,8,8,10], target=8 → [3,4]
    
    APPROACH: Binary search twice - find first occurrence, find last occurrence. O(log n).
    */

    public static int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }

        int first = findFirst(nums, target);
        int last = findLast(nums, target);
        return new int[]{first, last};
    }

    private static int findFirst(int[] nums, int target) {
        int left = 0, right = nums.length - 1, result = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                result = mid;
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }

    private static int findLast(int[] nums, int target) {
        int left = 0, right = nums.length - 1, result = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                result = mid;
                left = mid + 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {5, 7, 7, 8, 8, 10};
        System.out.println("Input: nums=[5,7,7,8,8,10], target=8");
        System.out.println("Output: " + Arrays.toString(searchRange(nums1, 8)));
        System.out.println("Expected: [3,4]\n");
    }
}
