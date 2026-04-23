package easy;

public class RunningSumOf1dArray {
    /*
    ========================================
    Problem: Running Sum of 1D Array
    Link: https://leetcode.com/problems/running-sum-of-1d-array
    Difficulty: Easy
    Topic: Array
    ========================================
    
    PROBLEM EXPLANATION:
    Given an array nums, return an array with running sum where each element
    at index i is the sum of all elements from index 0 to i.
    
    Example: [1, 2, 3, 4] -> [1, 3, 6, 10]
    
    KEY OBSERVATIONS:
    - Simple linear pass through array
    - Each position stores cumulative sum up to that point
    - No sorting or special data structure needed
    - Can modify array in-place or use new array
    
    APPROACH:
    1. Create output array of same length
    2. Set first element as nums[0]
    3. For each i from 1 to n-1: output[i] = output[i-1] + nums[i]
    4. Return output array
    
    TIME COMPLEXITY: O(n) - single pass through array
    SPACE COMPLEXITY: O(n) - for output array (or O(1) if modifying in-place)
    
    DRY RUN:
    Input: [1, 2, 3, 4]
    i=0: result[0] = 1
    i=1: result[1] = 1 + 2 = 3
    i=2: result[2] = 3 + 3 = 6
    i=3: result[3] = 6 + 4 = 10
    Output: [1, 3, 6, 10] ✓
    
    MEMORY TRICK:
    "Cumulative sum = previous running sum + current element"
    
    VISUALIZATION:
    [1, 2, 3, 4]
     ↓
    [1, 3, 6, 10]  (each cell sums all left neighbors including itself)
    */

    public static int[] runningSum(int[] nums) {
        int[] result = new int[nums.length];
        result[0] = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            result[i] = result[i - 1] + nums[i];
        }
        
        return result;
    }

    public static void main(String[] args) {
        // Test case 1
        int[] nums1 = {1, 2, 3, 4};
        int[] output1 = runningSum(nums1);
        System.out.println("Input: [1, 2, 3, 4]");
        System.out.print("Output: [");
        for (int i = 0; i < output1.length; i++) {
            System.out.print(output1[i]);
            if (i < output1.length - 1) System.out.print(", ");
        }
        System.out.println("]");
        
        // Test case 2
        int[] nums2 = {3, 1, 2, 10, 1};
        int[] output2 = runningSum(nums2);
        System.out.println("\nInput: [3, 1, 2, 10, 1]");
        System.out.print("Output: [");
        for (int i = 0; i < output2.length; i++) {
            System.out.print(output2[i]);
            if (i < output2.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }
}
