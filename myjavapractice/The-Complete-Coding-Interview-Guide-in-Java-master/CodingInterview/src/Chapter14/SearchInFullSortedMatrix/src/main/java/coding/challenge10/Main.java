package Chapter14.SearchInFullSortedMatrix.src.main.java.coding.challenge10;
 
public class Main {
/*
            Let’s break this down clearly in an interview-ready format.

            ✅ 1. What is the question?

            You are given a fully sorted matrix (also called a row-wise and globally sorted matrix) where:

            Each row is sorted in ascending order
            The first element of each row is greater than the last element of the previous row

            👉 Your task is to check if a given number exists in the matrix.

            Example:
            Matrix:
            [
              [1, 3, 5],
              [7, 9, 11],
              [13, 15, 17]
            ]

            Search: 9 → true
            Search: 6 → false
            ✅ 2. Clear Analysis
            Key Observations:
            The matrix behaves like a single sorted array
            There is a strict global order across rows
            Why this is powerful:

            Because of the ordering:

            Row 1 < Row 2 < Row 3 ...

            👉 We can treat the matrix as a flattened 1D sorted array

            Brute Force:
            Check each element → O(m × n)
            Optimal Insight:

            👉 Use Binary Search on a virtual array

            We do NOT flatten the matrix physically — just map indices.

            Mapping Trick:

            If we imagine the matrix as a 1D array:

            Total elements = rows * cols
            Middle index = (left + right) / 2

            Now convert 1D index → 2D:

            row = mid / cols
            col = mid % cols
            Why this works:
            Binary search works because the data is fully sorted
            We reduce search space by half each step → O(log(mn))
            ✅ 3. Solution Approach
            Steps:

            Treat matrix as 1D array from:

            0 → (rows * cols) - 1
            Apply binary search:
            Compute mid

            Map mid to matrix:

            matrix[mid / cols][mid % cols]
            Compare with target:
            If equal → found
            If smaller → search right
            If larger → search left
            ✅ 4. Implementation (Java)
            public static boolean search(int[][] matrix, int target) {
                if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
                    return false;
                }

                int rows = matrix.length;
                int cols = matrix[0].length;

                int left = 0;
                int right = rows * cols - 1;

                while (left <= right) {
                    int mid = left + (right - left) / 2;

                    int midElement = matrix[mid / cols][mid % cols];

                    if (midElement == target) {
                        return true;
                    } else if (midElement < target) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }

                return false;
            }
            ✅ 5. Complexity
            Approach	Time Complexity	Space
            Brute Force	O(m × n)	O(1)
            Binary Search	O(log(m × n))	O(1)
            ✅ 6. Key Interview Insight

            👉 Whenever you see:

            Fully sorted matrix (global order)
            Can be flattened logically

            Think:

            “Binary search on a virtual array”

            🔥 Quick Comparison of 3 Related Problems
            Problem Type	Approach
            Row + Column sorted (not fully sorted)	Start from top-right (O(m+n))
            Fully sorted matrix	Binary search (O(log mn))
            Plain sorted array	Standard binary search

            If you want next:

            🔥 Comparison: Coding Challenge 10 vs 11 (very important interview trick)
            🧠 Visualization of index mapping (mid → row, col)
            📊 Practice problems based on this pattern
 */
    public static void main(String[] args) {

        int[][] matrix = {
            {1, 3, 7, 8},
            {10, 16, 19, 22},
            {28, 36, 39, 53}
        };

        int elementToFind = 19;

        System.out.println("Found (" + elementToFind + "): "
                + Matrices.search(matrix, elementToFind));
    }
}
