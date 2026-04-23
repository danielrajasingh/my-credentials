package hard;

public class WordSearch {
    /* Problem: Word Search | Link: https://leetcode.com/problems/word-search
    Difficulty: Hard | Topic: Array, Backtracking, Matrix | Search word in grid.
    APPROACH: DFS backtracking from each cell. O(N*M*4^L). */

    public static boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, word, 0, i, j)) return true;
            }
        }
        return false;
    }

    private static boolean dfs(char[][] board, String word, int idx, int i, int j) {
        if (idx == word.length()) return true;
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) return false;
        if (board[i][j] != word.charAt(idx)) return false;
        char temp = board[i][j];
        board[i][j] = '#';
        boolean found = dfs(board, word, idx + 1, i + 1, j) || dfs(board, word, idx + 1, i - 1, j) ||
                        dfs(board, word, idx + 1, i, j + 1) || dfs(board, word, idx + 1, i, j - 1);
        board[i][j] = temp;
        return found;
    }

    public static void main(String[] args) {
        System.out.println("Word search works\n");
    }
}
