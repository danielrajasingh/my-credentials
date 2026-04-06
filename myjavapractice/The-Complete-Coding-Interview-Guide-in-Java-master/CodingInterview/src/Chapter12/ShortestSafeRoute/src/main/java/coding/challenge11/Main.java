package Chapter12.ShortestSafeRoute.src.main.java.coding.challenge11;
 
public class Main {
/*
Let’s go step-by-step and make this very clear, structured, and interview-ready.

🟡 1. What is the question?

You are given:

A 2D grid (matrix) of size m × n
Values:
1 → safe cell
0 → unsafe cell (danger, cannot step on or near)
⚠️ Important Constraint:

👉 A 0 (unsafe cell) also activates its 8 neighbors

So:

You must avoid not only 0 cells, but also cells adjacent to 0

🎯 Goal:

Find the shortest path:

From any safe cell in the first column
👉 to
any cell in the last column

Allowed moves:
Up, Down, Left, Right (4 directions only)
🟡 2. Key Constraints

You can only:

Step on safe cells (1)
Avoid:
unsafe cells (0)
cells adjacent to unsafe cells
🟡 3. Problem Type

👉 This is a:

Shortest path in grid → BFS problem

🟡 4. Key Idea

👉 Treat grid as a graph:

Each cell = node
Moves = edges (up/down/left/right)

👉 BFS is used because:

It finds the shortest path in unweighted graphs

🟡 5. Important Step: Preprocessing (VERY IMPORTANT)

👉 First, mark unsafe zones

A cell is unsafe if:

It is 0
OR adjacent to 0
So we build a safe board
🟡 6. Algorithm
Step 1: Mark unsafe cells
For every 0, mark:
itself
its 8 neighbors as unsafe
Step 2: BFS Initialization
Create a queue
Add all safe cells in first column
Set their distance = 0
Mark visited
Step 3: BFS Traversal

While queue not empty:

Pop cell
If it is in last column → return distance
Explore 4 directions:
up, down, left, right
If valid and safe:
mark visited
push with distance +1
Step 4: If no path found

Return -1

🟡 7. Solution (Code Implementation)
import java.util.*;

public class ShortestSafeRoute {

    static class Cell {
        int r, c, dist;
        Cell(int r, int c, int dist) {
            this.r = r;
            this.c = c;
            this.dist = dist;
        }
    }

    static int M, N;

    static int[] ROW_4 = {-1, 0, 1, 0};
    static int[] COL_4 = {0, -1, 0, 1};

    public static int shortestPath(int[][] board) {
        M = board.length;
        N = board[0].length;

        boolean[][] safe = preprocess(board);
        boolean[][] visited = new boolean[M][N];

        Queue<Cell> queue = new LinkedList<>();

        // Start from all safe cells in first column
        for (int i = 0; i < M; i++) {
            if (safe[i][0]) {
                queue.add(new Cell(i, 0, 0));
                visited[i][0] = true;
            }
        }

        while (!queue.isEmpty()) {
            Cell curr = queue.poll();

            // If reached last column
            if (curr.c == N - 1) {
                return curr.dist + 1;
            }

            // Explore 4 directions
            for (int k = 0; k < 4; k++) {
                int nr = curr.r + ROW_4[k];
                int nc = curr.c + COL_4[k];

                if (isValid(nr, nc) && safe[nr][nc] && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    queue.add(new Cell(nr, nc, curr.dist + 1));
                }
            }
        }

        return -1;
    }

    // Check bounds
    static boolean isValid(int r, int c) {
        return r >= 0 && r < M && c >= 0 && c < N;
    }

    // Preprocess unsafe cells
    static boolean[][] preprocess(int[][] board) {
        boolean[][] safe = new boolean[M][N];

        // Initially all safe
        for (int i = 0; i < M; i++) {
            Arrays.fill(safe[i], true);
        }

        int[] ROW_8 = {-1,-1,-1,0,1,1,1,0};
        int[] COL_8 = {-1,0,1,1,1,0,-1,-1};

        // Mark unsafe zones
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 0) {
                    safe[i][j] = false;

                    for (int k = 0; k < 8; k++) {
                        int nr = i + ROW_8[k];
                        int nc = j + COL_8[k];

                        if (isValid(nr, nc)) {
                            safe[nr][nc] = false;
                        }
                    }
                }
            }
        }

        return safe;
    }

    public static void main(String[] args) {
        int[][] board = {
            {1,1,1,1},
            {1,0,1,1},
            {1,1,1,1},
            {0,1,1,1}
        };

        System.out.println(shortestPath(board));
    }
}
🟡 8. Complexity Analysis
⏱ Time:
O(m × n)
🧠 Space:
O(m × n)
🟡 9. Key Insights
🔑 This is a graph shortest path problem
🔑 Use BFS (not DFS)
🔑 Preprocess unsafe zones
🔑 Multi-source BFS (first column)
🟡 10. Common Mistakes

❌ Ignoring 8-direction unsafe expansion
❌ Using DFS (wrong for shortest path)
❌ Not marking visited
❌ Starting from one cell only (instead of all first column cells)

🟡 11. Pattern Recognition

This is a high-level BFS pattern used in:

Grid shortest path
Multi-source BFS
Pathfinding problems
🟡 12. Summary

👉 Problem:

Find shortest safe path from first to last column

👉 Trick:

Mark unsafe zones first
Use multi-source BFS

👉 Key:

Shortest path = first time reaching destination in BFS

If you want next, I can:

Show step-by-step dry run
Compare with Dijkstra vs BFS
Give harder variations (Google-level)
 */
    public static void main(String[] args) {

        int[][] board
                = {
                    {0, 1, 1, 1, 0, 1, 1, 1, 1, 1},
                    {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                    {1, 1, 0, 1, 1, 1, 1, 1, 1, 1},
                    {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                    {1, 1, 1, 1, 1, 0, 1, 1, 0, 1},
                    {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                    {1, 0, 1, 1, 1, 1, 1, 1, 1, 1},
                    {1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                    {1, 1, 1, 1, 1, 0, 1, 1, 1, 1},
                    {1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
                };

        int dist = Sensors.shortestPath(board);

        if (dist != -1) {
            System.out.print("\n\nThe shortest safe path has length of " + dist);
        } else {
            System.out.print("\n\nNo route is safe to reach the destination");
        }
    }
}
