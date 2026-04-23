package medium;

public class MaximumSubarray {
    /*
    ========================================
    Problem: Maximum Subarray
    Link: https://leetcode.com/problems/maximum-subarray
    Difficulty: Medium
    Topic: Array, Divide and Conquer, Dynamic Programming
    ========================================
    
    PROBLEM EXPLANATION:
    Find the contiguous subarray (with at least one element) which has the largest sum.
    Return the sum of that subarray.
    
    Example: nums=[-2,1,-3,4,-1,2,1,-5,4] → [4,-1,2,1] → sum=6
    
    KEY OBSERVATIONS:
    - This is the classic Kadane's Algorithm problem
    - DP approach: track max sum ending at each position
    - maxCurrent[i] = max(nums[i], maxCurrent[i-1] + nums[i])
    - Answer is max of all maxCurrent values
    - Can optimize to O(1) space by tracking only current state
    
    APPROACH (Kadane's Algorithm):
    1. Initialize maxSum = nums[0], currentSum = nums[0]
    2. For each element from index 1 to n-1:
       - currentSum = max(nums[i], currentSum + nums[i])
       - maxSum = max(maxSum, currentSum)
    3. Return maxSum
    
    TIME COMPLEXITY: O(n) - single pass through array
    SPACE COMPLEXITY: O(1) - only tracking two variables
    
    DRY RUN:
    nums=[-2,1,-3,4,-1,2,1,-5,4]
    i=0: maxSum=-2, currentSum=-2
    i=1: currentSum=max(1,-2+1)=1, maxSum=1
    i=2: currentSum=max(-3,1-3)=-2, maxSum=1
    i=3: currentSum=max(4,-2+4)=4, maxSum=4
    i=4: currentSum=max(-1,4-1)=3, maxSum=4
    i=5: currentSum=max(2,3+2)=5, maxSum=5
    i=6: currentSum=max(1,5+1)=6, maxSum=6
    Result: 6 ✓
    
    MEMORY TRICK:
    "Kadane: track best ending here, compare with best overall"
    
    VISUALIZATION:
    nums: [-2] [1] [-3] [4] [-1] [2] [1] [-5] [4]
    Run:  -2   1   -2   4   3    5   6    1   5
    (currentSum at each step, track max = 6)
    */

    public static int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Integer.MIN_VALUE;
        }

        int maxSum = nums[0];
        int currentSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        // Test case 1
        int[] nums1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("Input: [-2, 1, -3, 4, -1, 2, 1, -5, 4]");
        System.out.println("Output: " + maxSubArray(nums1));
        System.out.println("Expected: 6 (subarray [4, -1, 2, 1])\n");

        // Test case 2
        int[] nums2 = {5};
        System.out.println("Input: [5]");
        System.out.println("Output: " + maxSubArray(nums2));
        System.out.println("Expected: 5\n");

        // Test case 3
        int[] nums3 = {-2};
        System.out.println("Input: [-2]");
        System.out.println("Output: " + maxSubArray(nums3));
        System.out.println("Expected: -2\n");

        // Test case 4
        int[] nums4 = {-5, -2, -3, -1, -4};
        System.out.println("Input: [-5, -2, -3, -1, -4]");
        System.out.println("Output: " + maxSubArray(nums4));
        System.out.println("Expected: -1 (single element)\n");
    }
}
