package medium;

import java.util.*;

public class NumberOfIslands {
    /*
    ========================================
    Problem: Number of Islands
    Link: https://leetcode.com/problems/number-of-islands
    Difficulty: Medium
    Topic: Array, Depth-First Search, Breadth-First Search, Union Find, Matrix
    ========================================
    
    PROBLEM EXPLANATION:
    Given an m x n 2D binary grid (grid) where 1 represents land and 0 represents water,
    count the number of islands. An island is formed by connecting adjacent lands
    horizontally or vertically. Diagonals don't count.
    
    Example: grid=[["1","1","1","1","0"],
                   ["1","1","0","1","0"],
                   ["1","1","0","0","0"],
                   ["0","0","0","0","0"]]
    Output: 1 (all connected)
    
    KEY OBSERVATIONS:
    - This is a connected components problem
    - Use DFS or BFS to explore each island
    - Mark visited cells to avoid revisiting
    - Count each time we start exploring from new land cell
    - 4 directions: up, down, left, right
    
    APPROACH (DFS):
    1. Create visited matrix or modify grid
    2. Iterate through each cell
    3. When finding unvisited land ('1'):
       - Increment island count
       - Use DFS to mark all connected land as visited
    4. Return island count
    
    TIME COMPLEXITY: O(m * n) - visit each cell once
    SPACE COMPLEXITY: O(m * n) - visited matrix and recursion stack
    
    DRY RUN:
    grid=[["1","1","1"],
          ["1","1","0"],
          ["1","0","1"]]
    Start at (0,0): DFS marks all connected 1s → island count=1
    Continue scanning... find (2,2): DFS marks it → island count=2
    Result: 2 ✓
    
    MEMORY TRICK:
    "DFS/BFS: count components, mark visited to avoid duplicates"
    
    VISUALIZATION:
    1 1 1        Island 1 (all connected)
    1 1 0
    1 0 1        Island 2 (single cell)
    */

    public static int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int m = grid.length;
        int n = grid[0].length;
        int islands = 0;
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    dfs(grid, visited, i, j, m, n);
                    islands++;
                }
            }
        }

        return islands;
    }

    private static void dfs(char[][] grid, boolean[][] visited, int i, int j, int m, int n) {
        if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j] || grid[i][j] == '0') {
            return;
        }

        visited[i][j] = true;

        // Explore 4 directions
        dfs(grid, visited, i - 1, j, m, n); // up
        dfs(grid, visited, i + 1, j, m, n); // down
        dfs(grid, visited, i, j - 1, m, n); // left
        dfs(grid, visited, i, j + 1, m, n); // right
    }

    public static void main(String[] args) {
        // Test case 1
        char[][] grid1 = {
            {'1', '1', '1', '1', '0'},
            {'1', '1', '0', '1', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '0', '0', '0'}
        };
        System.out.println("Test case 1:");
        System.out.println("Output: " + numIslands(grid1));
        System.out.println("Expected: 1\n");

        // Test case 2
        char[][] grid2 = {
            {'1', '1', '0', '0', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '1', '0', '0'},
            {'0', '0', '0', '1', '1'}
        };
        System.out.println("Test case 2:");
        System.out.println("Output: " + numIslands(grid2));
        System.out.println("Expected: 3\n");

        // Test case 3
        char[][] grid3 = {{'1'}};
        System.out.println("Test case 3:");
        System.out.println("Output: " + numIslands(grid3));
        System.out.println("Expected: 1\n");
    }
}
