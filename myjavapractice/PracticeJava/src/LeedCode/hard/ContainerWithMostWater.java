package hard;

public class ContainerWithMostWater {
    /*
    ========================================
    Problem: Container With Most Water
    Link: https://leetcode.com/problems/container-with-most-water
    Difficulty: Hard
    Topic: Array, Two Pointers, Greedy
    ========================================
    
    PROBLEM EXPLANATION:
    Given an integer array height where height[i] represents the height of bar i,
    find two lines that form a container with most water.
    Water capacity = width * min(height[i], height[j]) where i < j
    
    Example: height=[1,8,6,2,5,4,8,3,7]
    Container between indices 1(8) and 8(7) with width=7, height=min(8,7)=7
    Area = 7 * 7 = 49
    
    KEY OBSERVATIONS:
    - Brute force: check all pairs O(n²)
    - Better: use two pointers O(n)
    - Start with widest container (i=0, j=n-1)
    - Move pointer with smaller height inward (can only improve with larger height)
    - Area = width * min(height[left], height[right])
    
    APPROACH (Two Pointers):
    1. Initialize left=0, right=n-1, maxArea=0
    2. While left < right:
       - Calculate area with current pointers
       - Update maxArea
       - Move the pointer with smaller height inward
    3. Return maxArea
    
    TIME COMPLEXITY: O(n) - single pass with two pointers
    SPACE COMPLEXITY: O(1) - only tracking pointers and maxArea
    
    DRY RUN:
    height=[1,8,6,2,5,4,8,3,7]
    left=0(1), right=8(7): width=8, height=min(1,7)=1, area=8 → maxArea=8
    Move left (height=1 is smaller)
    left=1(8), right=8(7): width=7, height=min(8,7)=7, area=49 → maxArea=49
    Move right (height=7 is smaller)
    left=1(8), right=7(3): width=6, height=min(8,3)=3, area=18 → maxArea=49
    Continue until pointers meet...
    Result: 49 ✓
    
    MEMORY TRICK:
    "Two pointers: start wide, move smaller pointer inward, maximize area"
    
    VISUALIZATION:
    height: 1 8 6 2 5 4 8 3 7
    Indices: 0 1 2 3 4 5 6 7 8
    
    Initial: |_________| (width=8, height=1, area=8)
                        ^
    Move inner: |_____| (width=7, height=7, area=49)
                      ^
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
            int currentHeight = Math.min(height[left], height[right]);
            int area = width * currentHeight;
            maxArea = Math.max(maxArea, area);

            // Move pointer with smaller height
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {
        // Test case 1
        int[] height1 = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println("Input: [1, 8, 6, 2, 5, 4, 8, 3, 7]");
        System.out.println("Output: " + maxArea(height1));
        System.out.println("Expected: 49\n");

        // Test case 2
        int[] height2 = {1, 1};
        System.out.println("Input: [1, 1]");
        System.out.println("Output: " + maxArea(height2));
        System.out.println("Expected: 1\n");

        // Test case 3
        int[] height3 = {4, 3, 2, 1, 4};
        System.out.println("Input: [4, 3, 2, 1, 4]");
        System.out.println("Output: " + maxArea(height3));
        System.out.println("Expected: 16\n");

        // Test case 4
        int[] height4 = {2, 3, 4, 5, 18, 17, 6};
        System.out.println("Input: [2, 3, 4, 5, 18, 17, 6]");
        System.out.println("Output: " + maxArea(height4));
        System.out.println("Expected: 17\n");
    }
}
