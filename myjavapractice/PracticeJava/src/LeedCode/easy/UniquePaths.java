package easy;

public class UniquePaths {
    /* Problem: Unique Paths | Link: https://leetcode.com/problems/unique-paths
    Difficulty: Easy | Topic: Math, Dynamic Programming, Combinatorics | Count paths m×n grid.
    APPROACH: DP grid, paths[i][j] = paths[i-1][j] + paths[i][j-1]. O(m*n). */

    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) dp[i][j] = 1;
                else dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        System.out.println("Paths 3x7: " + uniquePaths(3, 7));
        System.out.println("Expected: 28\n");
    }
}
