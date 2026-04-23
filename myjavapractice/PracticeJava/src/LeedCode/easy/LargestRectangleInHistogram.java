package easy;

import java.util.Stack;

public class LargestRectangleInHistogram {
    /* Problem: Largest Rectangle in Histogram | Link: https://leetcode.com/problems/largest-rectangle-in-histogram
    Difficulty: Easy | Topic: Array, Stack | Find max area rectangle in histogram.
    APPROACH: Monotonic stack. O(n). */

    public static int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                int h = heights[stack.pop()];
                int w = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, h * w);
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int h = heights[stack.pop()];
            int w = stack.isEmpty() ? heights.length : heights.length - stack.peek() - 1;
            maxArea = Math.max(maxArea, h * w);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] heights = {2, 1, 5, 6, 2, 3};
        System.out.println("Max area: " + largestRectangleArea(heights));
        System.out.println("Expected: 10\n");
    }
}
