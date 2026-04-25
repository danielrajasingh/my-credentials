/*
========================================
[PROBLEM] Container With Most Water
[DIFFICULTY] MEDIUM
[TOPIC] Array, Two Pointers, Greedy
========================================

PROBLEM EXPLANATION:
You are given an integer array height of length n. There are n vertical lines 
drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).

Find two lines that together with the x-axis form a container, such that 
the container contains the most water.

Return the maximum amount of water a container can store.

Example 1:
Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49
Explanation: The max area is between height[1]=8 and height[8]=7.
Width = 8-1 = 7, height = min(8,7) = 7, area = 49

Example 2:
Input: height = [1,1]
Output: 1

Example 3:
Input: height = [4,3,2,1,4]
Output: 16

KEY OBSERVATIONS / INTUITION:
- Use two pointers from both ends
- Move the pointer with smaller height inward
- Track maximum area found

APPROACH (Step-by-Step):
   Step 1: Initialize left=0, right=n-1
   Step 2: Calculate area = width * min(height[left], height[right])
   Step 3: Update max area
   Step 4: Move pointer with smaller height
   Step 5: Repeat until left >= right

TIME & SPACE COMPLEXITY ANALYSIS:
   Time Complexity:  O(n) - Single pass with two pointers
   Space Complexity: O(1) - Only variables

DRY RUN EXAMPLE:
Input: height = [1,8,6,2,5,4,8,3,7]
Process:
  left=0, right=8: area=1*7=7, max=7, height[0]=1<7, left++
  left=1, right=8: area=7*7=49, max=49, height[8]=7<8, right--
  left=1, right=7: area=6*3=18, max=49, height[7]=3<8, right--
  left=1, right=6: area=5*8=40, max=49, height[6]=8=8, right--
  left=1, right=5: area=4*4=16, max=49, height[5]=4<8, right--
  left=1, right=4: area=3*4=12, max=49, height[4]=5<8, right--
  left=1, right=3: area=2*2=4, max=49, height[3]=2<8, right--
  left=1, right=2: area=1*6=6, max=49, height[2]=6<8, right--
Output: 49

ONE-LINE MEMORY TRICK:
"Two pointers from ends, move smaller height inward"

MENTAL VISUALIZATION:
Think of two vertical lines forming a container with water.
The water level is determined by the shorter line.

IMPORTANT EDGE CASES:
* Less than 2 elements -> return 0
* All same heights -> any pair works
* Strictly increasing/decreasing -> check optimal pairs

SOLUTION STRATEGY:
1. Use two pointers from both ends
2. Calculate area at each step
3. Move the pointer with smaller height
4. Track maximum area

========================================
*/

package hard;

public class ContainerWithMostWater {
    
    /**
     * Find max area using two pointers
     */
    public static int maxArea(int[] height) {
        if (height == null || height.length < 2) {
            return 0;
        }
        
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
        
        while (left < right) {
            int width = right - left;
            int h = Math.min(height[left], height[right]);
            maxArea = Math.max(maxArea, width * h);
            
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        
        return maxArea;
    }
    
    public static void main(String[] args) {
        // Test Case 1
        int[] height1 = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.print("Input: ");
        printArray(height1);
        System.out.println("Output: " + maxArea(height1));
        System.out.println("Expected: 49\n");
        
        // Test Case 2
        int[] height2 = {1, 1};
        System.out.print("Input: ");
        printArray(height2);
        System.out.println("Output: " + maxArea(height2));
        System.out.println("Expected: 1\n");
        
        // Test Case 3
        int[] height3 = {4, 3, 2, 1, 4};
        System.out.print("Input: ");
        printArray(height3);
        System.out.println("Output: " + maxArea(height3));
        System.out.println("Expected: 16\n");
        
        // Test Case 4
        int[] height4 = {1, 2, 1};
        System.out.print("Input: ");
        printArray(height4);
        System.out.println("Output: " + maxArea(height4));
        System.out.println("Expected: 2\n");
        
        // Test Case 5
        int[] height5 = {1, 2, 4, 8};
        System.out.print("Input: ");
        printArray(height5);
        System.out.println("Output: " + maxArea(height5));
        System.out.println("Expected: 4");
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
