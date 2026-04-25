/*
========================================
[PROBLEM] TrappingRainWater
[DIFFICULTY] EASY
[TOPIC] Array, Two Pointers, Dynamic Programming, Stack, Monotonic Stack
========================================

PROBLEM EXPLANATION:
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

Example 1:
Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. 
In this case, 6 units of rain water are being trapped.

Example 2:
Input: height = [4,2,0,3,2,5]
Output: 61

KEY OBSERVATIONS / INTUITION:
- Water trapped at each position = min(maxLeft, maxRight) - height[i]
- Use two pointers: left from start, right from end
- Track max from left and max from right
- At each step, process the smaller side

APPROACH (Step-by-Step):
   Step 1: Initialize left, right pointers and maxLeft, maxRight
   Step 2: Move pointers towards center
   Step 3: If height[left] <= height[right], process left side
   Step 4: Else process right side
   Step 5: Calculate water and update max

TIME & SPACE COMPLEXITY ANALYSIS:
   Time Complexity:  O(n) - Single pass with two pointers
   Space Complexity: O(1) - Only using constant extra space

DRY RUN EXAMPLE:
Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Process:
  left=0, right=11, maxLeft=0, maxRight=1
  height[0]=0 <= height[11]=1: process left
  water += maxLeft - height[0] = 0-0=0, maxLeft=0
  left=1: height[1]=1 > maxLeft=0, maxLeft=1
  left=2: height[2]=0 <= maxRight=1, water += 1-0=1
  ... continue until left meets right
Output: 6

ONE-LINE MEMORY TRICK:
"TRAP: Two pointers, min(LeftMax, RightMax) - height"

MENTAL VISUALIZATION:
Think of valleys between mountains. Water can only fill up to the height of the shorter mountain on either side. Use two pointers approaching from both ends to find how much water each position can hold.

IMPORTANT EDGE CASES:
* Empty array -> return 0
* Single element -> return 0
* Strictly increasing/decreasing -> return 0

SOLUTION STRATEGY:
1. Use two pointers from both ends
2. At each step, process the smaller height side
3. Calculate water based on min of maxes minus current height

========================================
*/

package easy;

public class TrappingRainWater {
    
    /**
     * Calculate trapped water using two pointer approach
     */
    public static int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        
        int left = 0;
        int right = height.length - 1;
        int maxLeft = 0;
        int maxRight = 0;
        int water = 0;
        
        while (left < right) {
            if (height[left] <= height[right]) {
                // Process from left
                if (height[left] >= maxLeft) {
                    maxLeft = height[left];
                } else {
                    water += maxLeft - height[left];
                }
                left++;
            } else {
                // Process from right
                if (height[right] >= maxRight) {
                    maxRight = height[right];
                } else {
                    water += maxRight - height[right];
                }
                right--;
            }
        }
        
        return water;
    }
    
    public static void main(String[] args) {
        // Test Case 1
        int[] height1 = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.print("Input: ");
        printArray(height1);
        System.out.println("Output: " + trap(height1));
        System.out.println("Expected: 6\n");
        
        // Test Case 2
        int[] height2 = {4, 2, 0, 3, 2, 5};
        System.out.print("Input: ");
        printArray(height2);
        System.out.println("Output: " + trap(height2));
        System.out.println("Expected: 9\n");
        
        // Test Case 3
        int[] height3 = {5, 4, 1, 2};
        System.out.print("Input: ");
        printArray(height3);
        System.out.println("Output: " + trap(height3));
        System.out.println("Expected: 1\n");
        
        // Test Case 4
        int[] height4 = {};
        System.out.print("Input: ");
        printArray(height4);
        System.out.println("Output: " + trap(height4));
        System.out.println("Expected: 0\n");
        
        // Test Case 5
        int[] height5 = {1, 0, 2};
        System.out.print("Input: ");
        printArray(height5);
        System.out.println("Output: " + trap(height5));
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
