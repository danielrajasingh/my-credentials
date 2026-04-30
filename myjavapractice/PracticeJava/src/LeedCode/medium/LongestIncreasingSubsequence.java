/*
========================================
[PROBLEM] Longest Increasing Subsequence
[DIFFICULTY] MEDIUM
[TOPIC] Array, Binary Search, Dynamic Programming
========================================

PROBLEM EXPLANATION:
Given an integer array nums, return the length of the longest strictly 
increasing subsequence.

Example 1:
Input: nums = [10,9,2,5,3,7,101,18]
Output: 4
Explanation: The longest increasing subsequence is [2,3,7,101], 
therefore the length is 4.

Example 2:
Input: nums = [0,1,0,3,2,3]
Output: 4

Example 3:
Input: nums = [7,7,7,7,7,7,7]
Output: 1

KEY OBSERVATIONS / INTUITION:
- Use binary search for O(n log n) solution
- Maintain a tails array with smallest tail for each length
- Use ceiling index to replace or extend

APPROACH (Step-by-Step):
   Step 1: Create tails array
   Step 2: For each number, find its position in tails
   Step 3: If greater than all tails, extend
   Step 4: Otherwise, replace at ceiling position
   Step 5: Return length of tails

TIME & SPACE COMPLEXITY ANALYSIS:
   Time Complexity:  O(n log n) - Binary search for each element
   Space Complexity: O(n) - Tails array

DRY RUN EXAMPLE:
Input: nums = [10,9,2,5,3,7,101,18]
Process:
  10: tails=[10]
  9: replace 0, tails=[9]
  2: replace 0, tails=[2]
  5: tails=[2,5]
  3: replace 1, tails=[2,3]
  7: extend, tails=[2,3,7]
  101: extend, tails=[2,3,7,101]
  18: replace 3, tails=[2,3,7,18]
Output: 4

ONE-LINE MEMORY TRICK:
"Binary search on tails - replace or extend"

MENTAL VISUALIZATION:
Think of maintaining a sorted list of smallest tails. For each number, either extend the list or replace an existing element to keep it minimal.

IMPORTANT EDGE CASES:
* Empty array -> return 0
* Single element -> return 1
* All same elements -> return 1

SOLUTION STRATEGY:
1. Use binary search to find position
2. Replace or extend tails array
3. Return length of tails

========================================
*/

package medium;

import java.util.*;

public class LongestIncreasingSubsequence {
    
    public static int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        
        List<Integer> tails = new ArrayList<>();
        
        for (int num : nums) {
            int pos = Collections.binarySearch(tails, num);
            if (pos < 0) {
                pos = -(pos + 1);
            }
            if (pos >= tails.size()) {
                tails.add(num);
            } else {
                tails.set(pos, num);
            }
        }
        
        return tails.size();
    }
    
    public static void main(String[] args) {
        // Test Case 1
        int[] nums1 = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.print("Input: ");
        printArray(nums1);
        System.out.println("Output: " + lengthOfLIS(nums1));
        System.out.println("Expected: 4\n");
        
        // Test Case 2
        int[] nums2 = {0, 1, 0, 3, 2, 3};
        System.out.print("Input: ");
        printArray(nums2);
        System.out.println("Output: " + lengthOfLIS(nums2));
        System.out.println("Expected: 4\n");
        
        // Test Case 3
        int[] nums3 = {7, 7, 7, 7, 7, 7, 7};
        System.out.print("Input: ");
        printArray(nums3);
        System.out.println("Output: " + lengthOfLIS(nums3));
        System.out.println("Expected: 1\n");
        
        // Test Case 4
        int[] nums4 = {1, 3, 6, 7, 9, 4, 10, 5, 6};
        System.out.print("Input: ");
        printArray(nums4);
        System.out.println("Output: " + lengthOfLIS(nums4));
        System.out.println("Expected: 6\n");
        
        // Test Case 5
        int[] nums5 = {1};
        System.out.print("Input: ");
        printArray(nums5);
        System.out.println("Output: " + lengthOfLIS(nums5));
        System.out.println("Expected: 1");
    }
    
    private static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) System.out.print(",");
        }
        System.out.println("]");
    }
}
