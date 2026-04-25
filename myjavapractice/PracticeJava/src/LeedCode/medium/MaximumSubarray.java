/*
========================================
[PROBLEM] MaximumSubarray
[DIFFICULTY] MEDIUM
[TOPIC] Array, Dynamic Programming, Divide and Conquer
========================================

PROBLEM EXPLANATION:
Given an integer array nums, find the subarray with the largest sum, and return its sum.

Example 1:
Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: The subarray [4,-1,2,1] has the largest sum 6.

Example 2:
Input: nums = [1]
Output: 1
Explanation: The subarray [1] has the largest sum 1.

Example 3:
Input: nums = [5,4,-1,7,8]
Output: 23
Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.

KEY OBSERVATIONS / INTUITION:
- Use Kadane's algorithm: at each position, decide to either extend previous sum or start fresh
- If previous sum is negative, better to start fresh from current element
- Track global maximum while iterating

APPROACH (Step-by-Step):
   Step 1: Initialize currentSum and maxSum to first element
   Step 2: Iterate from second element
   Step 3: At each position, take max of (current element) or (current element + previous sum)
   Step 4: Update global max if current sum is greater
   Step 5: Return maxSum

TIME & SPACE COMPLEXITY ANALYSIS:
   Time Complexity:  O(n) - Single pass through array
   Space Complexity: O(1) - Only using constant extra space

DRY RUN EXAMPLE:
Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Process:
  i=0: current=-2, max=-2
  i=1: current=max(1, -2+1)=1, max=1
  i=2: current=max(-3, 1-3)=-2, max=1
  i=3: current=max(4, -2+4)=4, max=4
  i=4: current=max(-1, 4-1)=3, max=4
  i=5: current=max(2, 3+2)=5, max=5
  i=6: current=max(1, 5+1)=6, max=6
  i=7: current=max(-5, 6-5)=1, max=6
  i=8: current=max(4, 1+4)=5, max=6
Output: 6

ONE-LINE MEMORY TRICK:
"KADANE: Keep Adding, Negative? Start Fresh - Track Maximum"

MENTAL VISUALIZATION:
Think of a battery that drains when negative. When your "energy" (running sum) goes negative, it's better to restart fresh from the current position rather than carry the negative burden.

IMPORTANT EDGE CASES:
* Single element array -> return that element
* All negative numbers -> return largest (least negative) element
* All positive numbers -> return sum of all elements

SOLUTION STRATEGY:
1. Use Kadane's algorithm (dynamic programming)
2. At each step, decide to extend or restart
3. Track both current sum and global maximum

========================================
*/

package medium;

public class MaximumSubarray {
    
    /**
     * Find the subarray with the largest sum using Kadane's algorithm
     */
    public static int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        // Initialize current sum and max sum to first element
        int currentSum = nums[0];
        int maxSum = nums[0];
        
        // Iterate from second element
        for (int i = 1; i < nums.length; i++) {
            // Either start fresh from current element or extend previous sum
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            
            // Update global maximum
            maxSum = Math.max(maxSum, currentSum);
        }
        
        return maxSum;
    }
    
    public static void main(String[] args) {
        // Test Case 1
        int[] nums1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.print("Input: ");
        printArray(nums1);
        System.out.println("Output: " + maxSubArray(nums1));
        System.out.println("Expected: 6\n");
        
        // Test Case 2
        int[] nums2 = {1};
        System.out.print("Input: ");
        printArray(nums2);
        System.out.println("Output: " + maxSubArray(nums2));
        System.out.println("Expected: 1\n");
        
        // Test Case 3
        int[] nums3 = {5, 4, -1, 7, 8};
        System.out.print("Input: ");
        printArray(nums3);
        System.out.println("Output: " + maxSubArray(nums3));
        System.out.println("Expected: 23\n");
        
        // Test Case 4
        int[] nums4 = {-1};
        System.out.print("Input: ");
        printArray(nums4);
        System.out.println("Output: " + maxSubArray(nums4));
        System.out.println("Expected: -1\n");
        
        // Test Case 5
        int[] nums5 = {-2, -1};
        System.out.print("Input: ");
        printArray(nums5);
        System.out.println("Output: " + maxSubArray(nums5));
        System.out.println("Expected: -1");
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
