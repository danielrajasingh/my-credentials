/*
========================================
[PROBLEM] House Robber
[DIFFICULTY] MEDIUM
[TOPIC] Array, Dynamic Programming
========================================

PROBLEM EXPLANATION:
You are a professional robber planning to rob houses along a street. 
Each house has a certain amount of money stashed, the only constraint 
stopping you from robbing each of them is that adjacent houses have 
security systems connected and it will automatically contact the police 
if two adjacent houses were broken into on the same night.

Given an integer array nums representing the amount of money of each house, 
return the maximum amount of money you can rob tonight without alerting the police.

Example 1:
Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
Total = 1 + 3 = 4

Example 2:
Input: nums = [2,7,9,3,1]
Output: 12
Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
Total = 2 + 9 + 1 = 12

KEY OBSERVATIONS / INTUITION:
- At each house, decide to rob or skip
- If rob, add current to max from 2 houses ago
- If skip, take max from previous house

APPROACH (Step-by-Step):
   Step 1: Handle edge cases (empty, single element)
   Step 2: Initialize dp[0] = nums[0], dp[1] = max(nums[0], nums[1])
   Step 3: For each house i from 2 to n-1
   Step 4: dp[i] = max(dp[i-1], dp[i-2] + nums[i])
   Step 5: Return dp[n-1]

TIME & SPACE COMPLEXITY ANALYSIS:
   Time Complexity:  O(n) - Single pass
   Space Complexity: O(1) - Can optimize to O(1)

DRY RUN EXAMPLE:
Input: nums = [2,7,9,3,1]
Process:
  dp[0] = 2
  dp[1] = max(2,7) = 7
  dp[2] = max(7, 2+9) = 11
  dp[3] = max(11, 7+3) = 10
  dp[4] = max(10, 11+1) = 12
Output: 12

ONE-LINE MEMORY TRICK:
"dp[i] = max(dp[i-1], dp[i-2] + nums[i])"

MENTAL VISUALIZATION:
Think of deciding whether to rob each house. If you rob current house, you can't rob the previous one, so add current to max from 2 houses ago.

IMPORTANT EDGE CASES:
* Empty array -> return 0
* Single house -> return that amount
* Two houses -> return max of both

SOLUTION STRATEGY:
1. Use dynamic programming
2. Track previous two states
3. At each house, choose max of rob or skip

========================================
*/

package medium;

public class HouseRobber {
    
    public static int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        
        int prev2 = nums[0];
        int prev1 = Math.max(nums[0], nums[1]);
        
        for (int i = 2; i < nums.length; i++) {
            int current = Math.max(prev1, prev2 + nums[i]);
            prev2 = prev1;
            prev1 = current;
        }
        
        return prev1;
    }
    
    public static void main(String[] args) {
        // Test Case 1
        int[] nums1 = {1, 2, 3, 1};
        System.out.print("Input: ");
        printArray(nums1);
        System.out.println("Output: " + rob(nums1));
        System.out.println("Expected: 4\n");
        
        // Test Case 2
        int[] nums2 = {2, 7, 9, 3, 1};
        System.out.print("Input: ");
        printArray(nums2);
        System.out.println("Output: " + rob(nums2));
        System.out.println("Expected: 12\n");
        
        // Test Case 3
        int[] nums3 = {2, 1, 1, 2};
        System.out.print("Input: ");
        printArray(nums3);
        System.out.println("Output: " + rob(nums3));
        System.out.println("Expected: 4\n");
        
        // Test Case 4
        int[] nums4 = {1};
        System.out.print("Input: ");
        printArray(nums4);
        System.out.println("Output: " + rob(nums4));
        System.out.println("Expected: 1\n");
        
        // Test Case 5
        int[] nums5 = {1, 2};
        System.out.print("Input: ");
        printArray(nums5);
        System.out.println("Output: " + rob(nums5));
        System.out.println("Expected: 2");
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
