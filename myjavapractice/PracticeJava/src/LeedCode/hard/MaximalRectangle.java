package hard;

import java.util.*;

public class MaximalRectangle {
    /* Problem: Maximal Rectangle | Link: https://leetcode.com/problems/maximal-rectangle
    Difficulty: Hard | Topic: Array, Dynamic Programming, Stack, Matrix, Monotonic Stack | Largest rectangle.
    APPROACH: Histogram on each row. O(m*n). */

    public static int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) return 0;
        int m = matrix.length, n = matrix[0].length;
        int[] heights = new int[n];
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                heights[j] = matrix[i][j] == '1' ? heights[j] + 1 : 0;
            }
            max = Math.max(max, largestRectangleInHistogram(heights));
        }
        return max;
    }

    private static int largestRectangleInHistogram(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        for (int i = 0; i <= heights.length; i++) {
            int h = i == heights.length ? 0 : heights[i];
            while (!stack.isEmpty() && heights[stack.peek()] > h) {
                int hh = heights[stack.pop()];
                int w = stack.isEmpty() ? i : i - stack.peek() - 1;
                max = Math.max(max, hh * w);
            }
            stack.push(i);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println("Maximal rectangle works\n");
    }
}
