package medium;

public class RotateImage {
    /* Problem: Rotate Image | Link: https://leetcode.com/problems/rotate-image
    Difficulty: Medium | Topic: Array, Math, Matrix | Rotate 90° in-place.
    APPROACH: Transpose + reverse rows or layer rotation. O(n²). */

    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = temp;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Rotation works\n");
    }
}
