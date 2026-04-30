/*
========================================
[PROBLEM] Maximum Product Subarray
[DIFFICULTY] EASY
[TOPIC] Array, Dynamic Programming
========================================

PROBLEM EXPLANATION:
Given an integer array nums, find the contiguous subarray (containing at least one number) 
which has the largest product and return its product.

Example 1:
Input: nums = [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.

Example 2:
Input: nums = [-2,0,-1]
Output: 0
Explanation: The result cannot be 1 because subarray is not the whole array.

Example 3:
Input: nums = [-2,3,-4]
Output: 24
Explanation: [-2,3,-4] has the largest product 24.

KEY OBSERVATIONS / INTUITION:
- Need to track both max and min because negative * negative = positive
- At each position, max product = max(prevMax * current, prevMin * current, current)
- At each position, min product = min(prevMax * current, prevMin * current, current)

APPROACH (Step-by-Step):
   Step 1: Initialize maxSoFar, minSoFar, result all to first element
   Step 2: Iterate through array from index 1
   Step 3: Calculate tempMax = maxSoFar * current (might be max)
   Step 4: Calculate tempMin = minSoFar * current (might be min)
   Step 5: Update maxSoFar = max(current, tempMax, tempMin)
   Step 6: Update minSoFar = min(current, tempMax, tempMin)
   Step 7: Update result = max(result, maxSoFar)

TIME & SPACE COMPLEXITY ANALYSIS:
   Time Complexity:  O(n) - Single pass
   Space Complexity: O(1) - Constant extra space

DRY RUN EXAMPLE:
Input: nums = [2,3,-2,4]
Process:
  i=0: max=2, min=2, result=2
  i=1: max=3*2=6, min=3*2=6 -> max=6, min=3, result=6
  i=2: max=6*(-2)=-12, min=3*(-2)=-6 -> max=4, min=-12, result=6
  i=3: max=4*(-2)=-48, min=-12*(-2)=24 -> max=24, min=-48, result=24
Output: 24

ONE-LINE MEMORY TRICK:
"Track both max and min - negative can become positive"

MENTAL VISUALIZATION:
Think of two runners - one tracks max product, one tracks min product.
At each step, they update based on current element and their previous values.

IMPORTANT EDGE CASES:
* Single element -> return that element
* Contains zero -> product becomes 0
* All negative -> need even count of negatives

SOLUTION STRATEGY:
1. Track max ending at current position
2. Track min ending at current position
3. Update both at each step
4. Keep global max result

========================================
*/

package easy;

public class MaximumProductSubarray {
    
    public static int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        
        int maxSoFar = nums[0];
        int minSoFar = nums[0];
        int result = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            int tempMax = maxSoFar * nums[i];
            int tempMin = minSoFar * nums[i];
            
            maxSoFar = Math.max(nums[i], Math.max(tempMax, tempMin));
            minSoFar = Math.min(nums[i], Math.min(tempMax, tempMin));
            
            result = Math.max(result, maxSoFar);
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        // Test Case 1
        int[] nums1 = {2, 3, -2, 4};
        System.out.print("Input: ");
        printArray(nums1);
        System.out.println("Output: " + maxProduct(nums1));
        System.out.println("Expected: 6\n");
        
        // Test Case 2
        int[] nums2 = {-2, 0, -1};
        System.out.print("Input: ");
        printArray(nums2);
        System.out.println("Output: " + maxProduct(nums2));
        System.out.println("Expected: 0\n");
        
        // Test Case 3
        int[] nums3 = {-2, 3, -4};
        System.out.print("Input: ");
        printArray(nums3);
        System.out.println("Output: " + maxProduct(nums3));
        System.out.println("Expected: 24\n");
        
        // Test Case 4
        int[] nums4 = {0, 2};
        System.out.print("Input: ");
        printArray(nums4);
        System.out.println("Output: " + maxProduct(nums4));
        System.out.println("Expected: 2\n");
        
        // Test Case 5
        int[] nums5 = {-3, -1, -1};
        System.out.print("Input: ");
        printArray(nums5);
        System.out.println("Output: " + maxProduct(nums5));
        System.out.println("Expected: 3");
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
