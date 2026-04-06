package Chapter14.SearchInSortedMatrix.src.main.java.coding.challenge11;
 
public class Main {

    /*
                Let’s structure this like an interview answer.

            ✅ 1. What is the question?

            You are given a 2D matrix where:

            Each row is sorted in ascending order
            Each column is also sorted in ascending order

            👉 Your task is to determine whether a given number exists in the matrix.

            Example:
            Matrix:
            [
              [1, 4, 7, 11],
              [2, 5, 8, 12],
              [3, 6, 9, 16],
              [10,13,14,17]
            ]

            Search: 5 → true
            Search: 15 → false
            ✅ 2. Clear Analysis
            Key Observations:
            Rows are sorted → left to right increases
            Columns are sorted → top to bottom increases
            Naive Approach:
            Search each row using binary search
            Time complexity: O(m log n)
            (m = rows, n = columns)
            Better Insight (Optimal Approach):

            Because of sorting in both directions, we can eliminate entire rows or columns in one step.

            Critical Idea:

            Start from a corner of the matrix.

            👉 Best starting point:

            Top-right corner OR bottom-left corner
            Why Top-Right Works?

            Let’s start at:

            (i = 0, j = cols - 1)

            At any position:

            If current value == target → ✅ found
            If current value > target → move left (smaller values)
            If current value < target → move down (larger values)
            Why this works:
            Moving left → decrease value
            Moving down → increase value
            So we efficiently eliminate rows/columns in each step
            ✅ 3. Solution Approach
            Algorithm (Top-Right Strategy):

            Start at:

            row = 0
            col = last column
            While within bounds:
            If matrix[row][col] == target → return true
            If matrix[row][col] > target → move left (col--)
            If matrix[row][col] < target → move down (row++)
            If loop ends → return false
            ✅ 4. Implementation (Java)
            public static boolean search(int[][] matrix, int target) {
                if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
                    return false;
                }

                int row = 0;
                int col = matrix[0].length - 1;

                while (row < matrix.length && col >= 0) {
                    if (matrix[row][col] == target) {
                        return true;
                    } else if (matrix[row][col] > target) {
                        col--;   // move left
                    } else {
                        row++;   // move down
                    }
                }

                return false;
            }
            ✅ 5. Complexity
            Approach	Time Complexity	Space
            Row-wise Binary Search	O(m log n)	O(1)
            Optimal Approach	O(m + n)	O(1)
            ✅ 6. Interview Insight

            This is a classic pattern:

            👉 “Start from a corner and eliminate possibilities step-by-step”

            Top-right → move left / down
            Bottom-left → move up / right
            🚀 Quick Intuition to Remember

            If value is too big → go left
            If value is too small → go down

            If you want next:

            🔥 Similar problems (Search in 2D matrix II, peak element, etc.)
            🧠 Visualization step-by-step
            🧩 Pattern recognition cheatsheet for interviews
     */
    public static void main(String[] args) {

        int[][] matrix = {
            {11, 22, 48, 77, 78, 84},
            {12, 24, 55, 78, 83, 90},
            {25, 56, 58, 80, 85, 95},
            {33, 57, 60, 85, 86, 99}
        };

        int elementToFind1 = 80;
        int elementToFind2 = 77;
        int elementToFind3 = 92;

        System.out.println("Iterative approach (" + elementToFind1 + "): "
                + Matrices.search(matrix, elementToFind1));
        System.out.println("Iterative approach (" + elementToFind2 + "): "
                + Matrices.search(matrix, elementToFind2));
        System.out.println("Iterative approach (" + elementToFind3 + "): "
                + Matrices.search(matrix, elementToFind3));

        System.out.println();
        System.out.println();

        System.out.println("Recursive approach (" + elementToFind1 + "): "
                + Matrices.searchRecursive(matrix, elementToFind1));
        System.out.println("Recursive approach (" + elementToFind2 + "): "
                + Matrices.searchRecursive(matrix, elementToFind2));
        System.out.println("Recursive approach (" + elementToFind3 + "): "
                + Matrices.searchRecursive(matrix, elementToFind3));
    }
}
