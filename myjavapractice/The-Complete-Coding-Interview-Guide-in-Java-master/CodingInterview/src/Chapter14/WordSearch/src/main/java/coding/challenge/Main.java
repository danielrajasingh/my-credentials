package Chapter14.WordSearch.src.main.java.coding.challenge;

public class Main {
/*
    This is a classic backtracking / DFS grid problem (very common in Amazon & Google interviews). Let’s break it down clearly 👇

    ✅ 1. What is the Question?

    You are given:

    A 2D board (matrix) of characters
    A word (string)

    👉 You must:

    Return true if the word exists in the grid, otherwise false

    ✔️ Rules
    You can move:
    Up, Down, Left, Right (no diagonals ❌)
    You must match characters in order
    ❌ You cannot reuse the same cell twice
    🔍 Example
    Board:
    A B C E
    S F C S
    A D E E

    Word = "ABCCED" → true
    Word = "SEE"    → true
    Word = "ABCB"   → false
    ✅ 2. Key Idea (Core Insight 🔥)

    👉 This is a path-finding problem in a grid

    We use:

    DFS (Depth-First Search) + Backtracking

    ✅ 3. Why Backtracking?

    Because:

    We try a path
    If it fails → undo and try another path
    ✅ 4. Algorithm (Step-by-Step)
    🔹 Step 1: Start from every cell

    For each cell (i, j):

    If it matches first character → start DFS
    🔹 Step 2: DFS Logic

    At each step:

    Check bounds
    Check character match
    If last character → return true
    🔹 Step 3: Mark visited
    Temporarily mark cell as visited (e.g., #)
    🔹 Step 4: Explore 4 directions
    Up, Down, Left, Right
    🔹 Step 5: Backtrack
    Restore original value
    ✅ 5. DFS Flow
    match → go deeper → success → return true
               ↓
            fail → backtrack → try next
    ✅ 6. Java Implementation
    public class WordSearch {

        public static boolean exist(char[][] board, String word) {

            int m = board.length;
            int n = board[0].length;

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {

                    if (dfs(board, word, i, j, 0)) {
                        return true;
                    }
                }
            }

            return false;
        }

        private static boolean dfs(char[][] board, String word,
                                   int i, int j, int index) {

            // If all characters matched
            if (index == word.length()) {
                return true;
            }

            // Boundary and mismatch check
            if (i < 0 || j < 0 || i >= board.length || j >= board[0].length
                    || board[i][j] != word.charAt(index)) {
                return false;
            }

            // Mark as visited
            char temp = board[i][j];
            board[i][j] = '#';

            // Explore all 4 directions
            boolean found =
                    dfs(board, word, i + 1, j, index + 1) ||
                    dfs(board, word, i - 1, j, index + 1) ||
                    dfs(board, word, i, j + 1, index + 1) ||
                    dfs(board, word, i, j - 1, index + 1);

            // Backtrack
            board[i][j] = temp;

            return found;
        }

        public static void main(String[] args) {

            char[][] board = {
                    {'A','B','C','E'},
                    {'S','F','C','S'},
                    {'A','D','E','E'}
            };

            System.out.println(exist(board, "ABCCED")); // true
            System.out.println(exist(board, "SEE"));    // true
            System.out.println(exist(board, "ABCB"));   // false
        }
    }
    ✅ 7. Complexity Analysis
    Type	Complexity
    Time	O(m × n × 4^k)
    Space	O(k) recursion stack

    Where:

    m × n = grid size
    k = word length
    ✅ 8. Edge Cases 🚨
    Case	Result
    Empty board	false
    Empty word	true
    Word longer than cells	false
    Repeated characters	handled via backtracking
    ✅ 9. Common Interview Mistakes ❌
    ❌ Not marking visited cells
    ❌ Forgetting to backtrack
    ❌ Allowing diagonal movement
    ❌ Reusing same cell
    ❌ Not checking bounds
    ✅ 10. Short Interview Answer (Perfect Summary)

    Use DFS with backtracking, start from each cell, explore all four directions while matching characters, and ensure cells are not reused.
    🚀 Bonus (Follow-up Questions)
    They may ask:
    👉 Return the path coordinates
    👉 Count total occurrences
    👉 Allow diagonal movement
    👉 Optimize using Trie (Word Search II – HARD 🔥)
    If you want next level:
    I can show visual recursion tree
    Or solve Word Search II (multiple words using Trie)
    Or give a Google-level tricky variant 🚀
 */
    public static void main(String[] args) {

        char[][] board
                = {
                    {'T', 'A', 'C'},
                    {'A', 'B', 'L'},
                    {'X', 'I', 'E'}
                };               
        
        boolean resultTable = Words.exist(board, "TABLE");
        boolean resultTaxi = Words.exist(board, "TAXI");

        System.out.println("Found 'TABLE'? " + resultTable);
        System.out.println("Found 'TAXI'? " + resultTaxi);
    }
}
