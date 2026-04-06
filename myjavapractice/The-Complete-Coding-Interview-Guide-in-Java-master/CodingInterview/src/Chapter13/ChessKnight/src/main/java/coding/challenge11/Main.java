package Chapter13.ChessKnight.src.main.java.coding.challenge11;
 
public class Main {
/*
Here’s a clear breakdown of Coding Challenge 11 – Chess Knight Minimum Moves.

✅ What is the Question?

You are given:

An N × N chessboard
A knight starting at a cell (startRow, startCol)
A target cell (targetRow, targetCol)

👉 You need to find:

The minimum number of moves required for the knight to reach the target cell

✅ Knight Movement Rules

A knight can move in 8 possible directions:

(±2, ±1)
(±1, ±2)
Example moves:
(r+2, c+1)
(r+1, c+2)
(r-1, c+2)
(r-2, c+1)
(r-2, c-1)
(r-1, c-2)
(r+1, c-2)
(r+2, c-1)
✅ Analysis
🔹 Key Insight

This problem is:

👉 Shortest path in an unweighted graph

Each cell = node
Each move = edge (cost = 1)
🔹 Best Algorithm

👉 Breadth-First Search (BFS)

Why BFS?

BFS explores level by level
First time we reach target → minimum moves
🔹 Approach
Start from the initial position
Use a queue
Track:
Position (row, col)
Distance (number of moves)
Mark visited cells to avoid cycles
Explore all 8 knight moves
Return distance when target is reached
🔹 Complexity
Time: O(N²) (worst case visiting all cells)
Space: O(N²) (visited + queue)
✅ Solution (Concept)
Enqueue starting cell with distance = 0
While queue not empty:
Dequeue cell
If it is the target → return distance
Explore 8 moves
Add valid unvisited cells to queue with distance + 1
✅ Implementation (Java)
class Node {
    int r, c, distance;

    Node(int r, int c, int distance) {
        this.r = r;
        this.c = c;
        this.distance = distance;
    }
}

public class ChessKnight {

    // Knight moves
    static int[] ROW = {2, 2, 1, 1, -1, -1, -2, -2};
    static int[] COL = {1, -1, 2, -2, 2, -2, 1, -1};

    public int minKnightMoves(int n, int startR, int startC, int targetR, int targetC) {

        boolean[][] visited = new boolean[n][n];

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(startR, startC, 0));
        visited[startR][startC] = true;

        while (!queue.isEmpty()) {

            Node current = queue.poll();

            // If target reached
            if (current.r == targetR && current.c == targetC) {
                return current.distance;
            }

            // Explore 8 moves
            for (int i = 0; i < 8; i++) {
                int newR = current.r + ROW[i];
                int newC = current.c + COL[i];

                if (isValid(newR, newC, n) && !visited[newR][newC]) {
                    visited[newR][newC] = true;
                    queue.add(new Node(newR, newC, current.distance + 1));
                }
            }
        }

        return -1; // not reachable
    }

    private boolean isValid(int r, int c, int n) {
        return r >= 0 && c >= 0 && r < n && c < n;
    }
}
✅ Key Takeaways
Model the problem as a graph
Use BFS for shortest path
Each move = 1 step cost
Use visited array to avoid revisiting cells
First time reaching target = minimum moves
✅ Simple Intuition

“From the starting cell, explore all possible knight moves level by level until we reach the target — the first time we reach it is the shortest path.”

If you want next, I can:

Show a step-by-step BFS simulation
Give optimized variants (A* search / heuristics)
Provide interview tricky questions on this problem 🚀
 */
    public static void main(String[] args) {

        ChessKnight ck = new ChessKnight();

        int movesNr = ck.countknightMoves(0, 7, 7, 0, 8);

        System.out.println("Minimum number of needed moves: " + movesNr);
    }
}
