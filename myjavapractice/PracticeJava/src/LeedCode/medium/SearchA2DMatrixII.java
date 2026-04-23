package medium;

import java.util.*;

public class SearchA2DMatrixII {
    /* Problem: Search a 2D Matrix II | Link: https://leetcode.com/problems/search-a-2d-matrix-ii
    Difficulty: Medium | Topic: Array, Binary Search, Divide and Conquer, Matrix | Search in sorted.
    APPROACH: Start top-right/bottom-left eliminate row/col. O(m+n). */

    public static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int row = 0, col = n - 1;
        while (row < m && col >= 0) {
            if (matrix[row][col] == target) return true;
            else if (matrix[row][col] < target) row++;
            else col--;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println("Found: " + searchMatrix(new int[][]{{1, 4, 7, 11}, {2, 5, 8, 12}, {3, 6, 9, 16}, {10, 13, 14, 17}}, 5));
        System.out.println("Expected: true\n");
    }
}
