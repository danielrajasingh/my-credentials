package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSum {
    /*
    ========================================
    Problem: 3Sum
    Link: https://leetcode.com/problems/3sum
    Difficulty: Medium
    Topic: Array, Two Pointers, Sorting
    ========================================
    
    PROBLEM EXPLANATION:
    Given an array nums of n integers, find all unique triplets in the array
    that sum to 0. Return a list of lists, each containing a unique triplet.
    
    Example: nums=[-1,0,1,2,-1,-4]
    Output: [[-1,-1,2],[-1,0,1]]
    
    KEY OBSERVATIONS:
    - Must find ALL unique triplets (handle duplicates)
    - Brute force is O(n³), can optimize to O(n²)
    - Sort array first to use two-pointer technique
    - For each number, use two-pointer to find pair that sums to negative of it
    - Skip duplicates to avoid duplicate triplets
    
    APPROACH (Sorting + Two Pointers):
    1. Sort the array
    2. For each index i (fixed element):
       - If nums[i] > 0, break (can't sum to 0)
       - Skip duplicates at i
       - Use two pointers: left=i+1, right=n-1
       - While left < right:
         - If sum == 0: add triplet, skip duplicates, move both pointers
         - If sum < 0: move left right (need bigger)
         - If sum > 0: move right left (need smaller)
    3. Return list of triplets
    
    TIME COMPLEXITY: O(n²) - O(n log n) sort + O(n²) for nested loops
    SPACE COMPLEXITY: O(1) or O(n) for output (excluding output space)
    
    DRY RUN:
    nums=[-1,0,1,2,-1,-4]
    Sorted: [-4,-1,-1,0,1,2]
    i=0(-4): left=1(-1), right=5(2) → sum=-3 < 0, left++
            left=2(-1), right=5(2) → sum=-3 < 0, left++
    i=1(-1): left=2(-1), right=5(2) → sum=0 ✓ add [-1,-1,2]
    i=2(-1): left=3(0), right=5(2) → sum=1 > 0, right--
            left=3(0), right=4(1) → sum=0 ✓ add [-1,0,1]
    Result: [[-1,-1,2],[-1,0,1]] ✓
    
    MEMORY TRICK:
    "Sort, fix one, two-pointer for other two, skip duplicates"
    
    VISUALIZATION:
    Sorted array: [-4, -1, -1, 0, 1, 2]
    For each i, search for pair in remaining elements:
    i=-4: [L..R] → search for sum=4 in [-1,-1,0,1,2]
    i=-1: [L..R] → search for sum=1 in [-1,0,1,2]
    Two pointers move based on sum comparison
    */

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return result;
        }

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            // Optimization: if current number is positive, can't sum to 0
            if (nums[i] > 0) {
                break;
            }

            // Skip duplicates
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // Skip duplicates for left pointer
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    // Skip duplicates for right pointer
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }

                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        // Test case 1
        int[] nums1 = {-1, 0, 1, 2, -1, -4};
        System.out.println("Input: [-1, 0, 1, 2, -1, -4]");
        System.out.println("Output: " + threeSum(nums1));
        System.out.println("Expected: [[-1,-1,2],[-1,0,1]]\n");

        // Test case 2
        int[] nums2 = {0, 0, 0, 0};
        System.out.println("Input: [0, 0, 0, 0]");
        System.out.println("Output: " + threeSum(nums2));
        System.out.println("Expected: [[0,0,0]]\n");

        // Test case 3
        int[] nums3 = {-2, 0, 1, 1, 2};
        System.out.println("Input: [-2, 0, 1, 1, 2]");
        System.out.println("Output: " + threeSum(nums3));
        System.out.println("Expected: [[-2,0,2],[-2,1,1]]\n");

        // Test case 4
        int[] nums4 = {-1, -1, -1, 0, 1, 2, 3};
        System.out.println("Input: [-1, -1, -1, 0, 1, 2, 3]");
        System.out.println("Output: " + threeSum(nums4));
        System.out.println("Expected: [[-1,-1,2],[-1,0,1]]\n");
    }
}
