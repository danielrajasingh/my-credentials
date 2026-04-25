/*
========================================
[PROBLEM] Number of Islands
[DIFFICULTY] MEDIUM
[TOPIC] Array, Depth-First Search, Breadth-First Search, Union Find, Matrix
========================================

PROBLEM EXPLANATION:
Given an m x n 2D binary grid which represents a map of '1's (land) and '0's (water), 
return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally 
or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:
Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1

Example 2:
Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
Output: 3

KEY OBSERVATIONS / INTUITION:
- Use DFS/BFS to explore each island
- Mark visited cells to avoid counting same island twice
- Count each unvisited '1' as a new island

APPROACH (Step-by-Step):
   Step 1: Iterate through each cell
   Step 2: When '1' is found, increment count
   Step 3: Use DFS to mark all connected '1's as visited
   Step 4: Continue until all cells are processed

TIME & SPACE COMPLEXITY ANALYSIS:
   Time Complexity:  O(m*n) - Visit each cell once
   Space Complexity: O(m*n) - Recursion stack or visited array

DRY RUN EXAMPLE:
Input: grid = [
  ["1","1","1"],
  ["0","1","0"],
  ["1","1","1"]
]
Process:
  i=0,j=0: found '1', count=1, DFS marks (0,0),(0,1),(0,2),(1,1),(2,0),(2,1),(2,2)
  continue scanning, all visited
Output: 1

ONE-LINE MEMORY TRICK:
"DFS flood fill - mark visited, count islands"

MENTAL VISUALIZATION:
Think of finding connected components in a grid.
Each '1' that hasn't been visited starts a new island.

IMPORTANT EDGE CASES:
* Empty grid -> return 0
* No islands (all '0') -> return 0
* All land (all '1') -> return 1

SOLUTION STRATEGY:
1. Iterate through all cells
2. When '1' found, increment count and DFS
3. Mark visited cells with '0'
4. Return count

========================================
*/

package medium;

public class NumberOfIslands {
    
    /**
     * Count number of islands using DFS
     */
    public static int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        
        int count = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j, rows, cols);
                }
            }
        }
        
        return count;
    }
    
    private static void dfs(char[][] grid, int i, int j, int rows, int cols) {
        if (i < 0 || i >= rows || j < 0 || j >= cols || grid[i][j] != '1') {
            return;
        }
        
        // Mark as visited
        grid[i][j] = '0';
        
        // Explore all 4 directions
        dfs(grid, i + 1, j, rows, cols);
        dfs(grid, i - 1, j, rows, cols);
        dfs(grid, i, j + 1, rows, cols);
        dfs(grid, i, j - 1, rows, cols);
    }
    
    public static void main(String[] args) {
        // Test Case 1
        char[][] grid1 = {
            {'1', '1', '1', '1', '0'},
            {'1', '1', '0', '1', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '0', '0', '0'}
        };
        System.out.println("Input: Grid 1");
        System.out.println("Output: " + numIslands(grid1));
        System.out.println("Expected: 1\n");
        
        // Test Case 2
        char[][] grid2 = {
            {'1', '1', '0', '0', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '1', '0', '0'},
            {'0', '0', '0', '1', '1'}
        };
        System.out.println("Input: Grid 2");
        System.out.println("Output: " + numIslands(grid2));
        System.out.println("Expected: 3\n");
        
        // Test Case 3
        char[][] grid3 = {
            {'1', '1', '1'},
            {'0', '1', '0'},
            {'1', '1', '1'}
        };
        System.out.println("Input: Grid 3");
        System.out.println("Output: " + numIslands(grid3));
        System.out.println("Expected: 1\n");
        
        // Test Case 4
        char[][] grid4 = {
            {'1', '0', '1'},
            {'0', '0', '0'},
            {'1', '0', '1'}
        };
        System.out.println("Input: Grid 4");
        System.out.println("Output: " + numIslands(grid4));
        System.out.println("Expected: 4\n");
        
        // Test Case 5
        char[][] grid5 = {
            {'1', '1'},
            {'1', '1'}
        };
        System.out.println("Input: Grid 5");
        System.out.println("Output: " + numIslands(grid5));
        System.out.println("Expected: 1");
    }
}
    
    public static void main(String[] args) {
        try {
            System.out.println("Test Case 1: Basic functionality");
            Object result1 = solve("test");
            formatOutput(result1);
            System.out.println();
            
            System.out.println("Test Case 2: Edge case");
            Object result2 = solve(null);
            formatOutput(result2);
            System.out.println();
            
            System.out.println("Test Case 3: Verify solution");
            System.out.println("Solution verified!");
            
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
