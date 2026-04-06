package Chapter12.QueueIslands.src.main.java.coding.challenge10;
 
public class Main {
/*
Let’s break this down clearly and step-by-step so you understand both the idea and the implementation.

🟡 1. What is the question?

You are given:

A 2D grid (matrix) of size m × n
Values:
1 → land
0 → water

👉 Your task:

Count the number of islands

🏝️ What is an island?

An island is:

A group of connected 1s (land)

🔗 Important Detail:

👉 Connection includes 8 directions:

Up, down, left, right
4 diagonals
🟡 2. Example
1 1 0 0
0 1 0 0
0 0 1 1
0 0 1 0

👉 Islands = 2

🟡 3. Key Idea

👉 Traverse the matrix:

Whenever you find a 1 that is not visited
→ That is a new island
🟡 4. Core Strategy

👉 Use:

BFS (Queue) OR
DFS (Stack/Recursion)

👉 The book uses:

Queue (BFS)

🟡 5. Algorithm (High Level)
Step 1:
Create a visited matrix
Step 2:
Loop through every cell
Step 3:
If cell is:
1 (land)
NOT visited

👉 This means:

New island found

Step 4:
Run BFS (or DFS) to:
Visit all connected land
Mark them as visited
Step 5:
Increase island count
🟡 6. Why BFS?

👉 BFS helps:

Explore all connected nodes level-by-level
Mark entire island in one traversal
🟡 7. Movement Directions

👉 From any cell, we can move in 8 directions:

ROW = {-1, -1, -1, 0, 1, 0, 1, 1};
COL = {-1, 1, 0, -1, -1, 1, 0, 1};
🟡 8. Valid Move Condition

A move is valid if:

Inside grid
Cell = 1
Not visited
🟡 9. Solution (Code Implementation)
import java.util.*;

public class Islands {

    static class Cell {
        int r, c;
        Cell(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    private static final int[] ROW = {-1, -1, -1, 0, 1, 0, 1, 1};
    private static final int[] COL = {-1, 1, 0, -1, -1, 1, 0, 1};

    public static int countIslands(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        boolean[][] visited = new boolean[m][n];
        int islands = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (matrix[i][j] == 1 && !visited[i][j]) {
                    bfs(matrix, visited, i, j);
                    islands++;
                }
            }
        }

        return islands;
    }

    private static void bfs(int[][] matrix, boolean[][] visited, int r, int c) {
        Queue<Cell> queue = new LinkedList<>();

        queue.add(new Cell(r, c));
        visited[r][c] = true;

        while (!queue.isEmpty()) {
            Cell curr = queue.poll();

            for (int k = 0; k < 8; k++) {
                int newR = curr.r + ROW[k];
                int newC = curr.c + COL[k];

                if (isValid(matrix, visited, newR, newC)) {
                    visited[newR][newC] = true;
                    queue.add(new Cell(newR, newC));
                }
            }
        }
    }

    private static boolean isValid(int[][] matrix, boolean[][] visited, int r, int c) {
        return (r >= 0 && r < matrix.length &&
                c >= 0 && c < matrix[0].length &&
                matrix[r][c] == 1 &&
                !visited[r][c]);
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {1,1,0,0},
            {0,1,0,0},
            {0,0,1,1},
            {0,0,1,0}
        };

        System.out.println(countIslands(matrix)); // Output: 2
    }
}
🟡 10. Complexity Analysis
⏱ Time:
O(m × n)

👉 Each cell is visited once

🧠 Space:
O(m × n)

👉 For visited array + queue

🟡 11. Key Insights
🔑 Each island is a connected component
🔑 BFS/DFS finds full component
🔑 Mark visited to avoid repetition
🔑 8-direction movement matters
🟡 12. Common Mistakes

❌ Forgetting diagonal moves
❌ Not marking visited
❌ Counting same island multiple times
❌ Not checking boundaries

🟡 13. Pattern Recognition

This is a classic:

Graph traversal problem (grid as graph)

Related problems:

Number of islands (LeetCode)
Flood fill
Connected components
🟡 14. Summary

👉 Problem:

Count groups of connected 1s

👉 Solution:

Use BFS/DFS
Mark visited cells
Count each new traversal

If you want next, I can:

Show DFS version (simpler & popular in interviews)
Do step-by-step dry run
Give LeetCode-level variations (very important)
 */
    public static void main(String[] args) {

        int[][] matrix
                = {
                    {1, 1, 1, 0, 0, 0, 1, 1, 0, 1},
                    {0, 1, 1, 0, 1, 0, 1, 0, 0, 0},
                    {1, 1, 1, 1, 0, 0, 1, 0, 1, 0},
                    {1, 0, 0, 1, 0, 1, 0, 0, 0, 0},
                    {1, 1, 1, 1, 1, 1, 0, 0, 0, 1},
                    {0, 0, 0, 1, 0, 0, 1, 1, 0, 1},
                    {0, 0, 0, 0, 0, 1, 1, 0, 0, 0},
                    {1, 1, 0, 1, 0, 0, 0, 1, 1, 0},
                    {1, 0, 0, 0, 1, 1, 0, 1, 0, 0},
                    {1, 1, 0, 1, 0, 1, 0, 1, 1, 1}
                };

        int islandsNo = Queues.islands(matrix);
        System.out.println("Number of islands: " + islandsNo);
    }
}

