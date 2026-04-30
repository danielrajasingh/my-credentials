/*
========================================
[PROBLEM] Jump Game
[DIFFICULTY] MEDIUM
[TOPIC] Array, Dynamic Programming, Breadth-First Search
========================================

PROBLEM EXPLANATION:
Given an array of non-negative integers nums, you are initially positioned at the first index of the array.
Each element in the array represents your maximum jump length at that position.
Return true if you can reach the last index, or false otherwise.

Example 1:
Input: nums = [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.

Example 2:
Input: nums = [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, so you can never reach it.

KEY OBSERVATIONS / INTUITION:
- Greedy approach: track the farthest we can reach
- At each position, update the farthest reachable index
- If at any point current index > farthest reachable, we can't proceed

APPROACH (Step-by-Step):
   Step 1: Initialize maxReach = 0 (farthest reachable index)
   Step 2: Iterate through each index
   Step 3: If current index > maxReach, return false (can't reach this point)
   Step 4: Update maxReach = max(maxReach, i + nums[i])
   Step 5: If maxReach >= last index, return true

TIME & SPACE COMPLEXITY ANALYSIS:
   Time Complexity:  O(n) - Single pass
   Space Complexity: O(1) - Constant space

DRY RUN EXAMPLE:
Input: nums = [2,3,1,1,4]
Process:
  i=0: maxReach = 0+2 = 2
  i=1: maxReach = max(2, 1+3) = 4 >= 4 -> can reach end
Output: true

ONE-LINE MEMORY TRICK:
"Track farthest reach - if current > farthest, stuck"

MENTAL VISUALIZATION:
Think of it as tracking how far you can explore, like a flashlight that illuminates further as you move.

IMPORTANT EDGE CASES:
* Single element -> return true
* First element is 0 -> return false (unless only one element)
* Can directly reach end -> return true

SOLUTION STRATEGY:
1. Use greedy approach
2. Track maximum reachable index
3. Check if current position is reachable
4. Return true if can reach or exceed last index

========================================
*/

package medium;

public class JumpGame {
    
    public static boolean canJump(int[] nums) {
        int maxReach = 0;
        int n = nums.length;
        
        for (int i = 0; i < n; i++) {
            if (i > maxReach) {
                return false;
            }
            maxReach = Math.max(maxReach, i + nums[i]);
            if (maxReach >= n - 1) {
                return true;
            }
        }
        
        return true;
    }
    
    public static void main(String[] args) {
        // Test Case 1
        int[] nums1 = {2, 3, 1, 1, 4};
        System.out.print("Input: ");
        printArray(nums1);
        System.out.println("Output: " + canJump(nums1));
        System.out.println("Expected: true\n");
        
        // Test Case 2
        int[] nums2 = {3, 2, 1, 0, 4};
        System.out.print("Input: ");
        printArray(nums2);
        System.out.println("Output: " + canJump(nums2));
        System.out.println("Expected: false\n");
        
        // Test Case 3
        int[] nums3 = {0};
        System.out.print("Input: ");
        printArray(nums3);
        System.out.println("Output: " + canJump(nums3));
        System.out.println("Expected: true\n");
        
        // Test Case 4
        int[] nums4 = {1, 0, 2};
        System.out.print("Input: ");
        printArray(nums4);
        System.out.println("Output: " + canJump(nums4));
        System.out.println("Expected: false\n");
        
        // Test Case 5
        int[] nums5 = {2, 0, 0};
        System.out.print("Input: ");
        printArray(nums5);
        System.out.println("Output: " + canJump(nums5));
        System.out.println("Expected: true");
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
