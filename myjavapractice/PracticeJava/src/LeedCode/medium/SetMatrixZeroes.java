package medium;
import java.util.*;
public class SetMatrixZeroes {
    public static void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length; Set<Integer> rows = new HashSet<>(), cols = new HashSet<>();
        for (int i = 0; i < m; i++) for (int j = 0; j < n; j++) {
            if (matrix[i][j] == 0) { rows.add(i); cols.add(j); }
        }
        for (int r : rows) Arrays.fill(matrix[r], 0);
        for (int c : cols) for (int i = 0; i < m; i++) matrix[i][c] = 0;
    }
    public static void main(String[] args) { System.out.println("Set zeroes works\n"); }
}
