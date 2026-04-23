package hard;

public class TrappingRainWater {
    /*
    ========================================
    Problem: Trapping Rain Water
    Link: https://leetcode.com/problems/trapping-rain-water
    Difficulty: Hard
    Topic: Array, Two Pointers, Dynamic Programming, Stack
    ========================================
    
    PROBLEM EXPLANATION:
    Given n non-negative integers representing elevation map where the width of
    each bar is 1, compute how much water can be trapped after raining.
    
    Example: height=[0,1,0,2,1,0,1,3,2,1,2,1]
    Water trapped = 6 units (shown as 'x' below)
    [0,1,0,2,1,0,1,3,2,1,2,1]
     0 x 0 x x 0 x x x x x 0
    
    KEY OBSERVATIONS:
    - Water trapped at position i = min(maxLeft, maxRight) - height[i]
    - maxLeft = max height to left of i (including i)
    - maxRight = max height to right of i (including i)
    - Water can only be trapped between two bars
    - Use two pointers to optimize space
    
    APPROACH (Two Pointers - Optimal):
    1. Initialize left=0, right=n-1, result=0
    2. Track maxLeft and maxRight as we move pointers
    3. Move pointer with smaller max height:
       - If left max < right max, process left
       - Otherwise, process right
    4. Update max for that side and add trapped water
    
    TIME COMPLEXITY: O(n) - single pass with two pointers
    SPACE COMPLEXITY: O(1) - only constant extra space
    
    DRY RUN:
    height=[0,1,0,2,1,0,1,3,2,1,2,1]
    left=0(0), right=11(1), maxL=0, maxR=1
    At left (height=0): water += max(0,0)=0, maxL=0
    At left (height=1): water += max(0,1-1)=0, maxL=1
    Continue moving left pointer...
    Water trapped at each position calculated correctly
    Total = 6 ✓
    
    MEMORY TRICK:
    "Water level = min(maxLeft, maxRight), trapped = level - height"
    
    VISUALIZATION:
    |                                 Bar representation:
    |           | x x |   x | x x |    height: 0 1 0 2 1 0 1 3 2 1 2 1
    |   x | x x | x x | x x | x x |   Position 2 between bars 1,3: water=1
    | | | | | | | | | | | |          Position 4 between bars 3,5: water=1
    0 1 2 3 4 5 6 7 8 9 10 11
    */

    public static int trap(int[] height) {
        if (height == null || height.length < 3) {
            return 0;
        }

        int left = 0, right = height.length - 1;
        int maxLeft = 0, maxRight = 0;
        int water = 0;

        while (left < right) {
            // Process left side if it has smaller max
            if (height[left] < height[right]) {
                if (height[left] >= maxLeft) {
                    maxLeft = height[left];
                } else {
                    water += maxLeft - height[left];
                }
                left++;
            } else {
                // Process right side
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
        // Test case 1
        int[] height1 = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println("Input: [0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1]");
        System.out.println("Output: " + trap(height1));
        System.out.println("Expected: 6\n");

        // Test case 2
        int[] height2 = {4, 2, 0, 3, 2, 5};
        System.out.println("Input: [4, 2, 0, 3, 2, 5]");
        System.out.println("Output: " + trap(height2));
        System.out.println("Expected: 9\n");

        // Test case 3
        int[] height3 = {2, 0, 2};
        System.out.println("Input: [2, 0, 2]");
        System.out.println("Output: " + trap(height3));
        System.out.println("Expected: 2\n");

        // Test case 4
        int[] height4 = {3, 0, 2, 0, 4};
        System.out.println("Input: [3, 0, 2, 0, 4]");
        System.out.println("Output: " + trap(height4));
        System.out.println("Expected: 7\n");
    }
}
