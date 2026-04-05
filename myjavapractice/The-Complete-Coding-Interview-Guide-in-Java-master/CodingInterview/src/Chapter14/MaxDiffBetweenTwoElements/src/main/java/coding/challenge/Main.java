package Chapter14.MaxDiffBetweenTwoElements.src.main.java.coding.challenge;
 
public class Main {
/*
    Let’s break this Maximum Difference with order constraint problem step by step 👇

    ✅ 1. What is the Question?

    You are given an array:

    arr = [1, 34, 21, 7, 4, 8, 10]

    👉 You must find:

    Maximum difference arr[j] - arr[i] such that j > i

    ✔️ Important Rule
    The larger number must come after the smaller number
    Order matters (this is NOT just max - min)
    🔍 Examples
    Input:  [1, 34, 21, 7, 4, 8, 10]
    Output: 33   (34 - 1)

    Input:  [17, 9, 2, 26, 32, 27, 3]
    Output: 30   (32 - 2)
    ❌ 2. Naive Approach
    Idea:
    Try all pairs (i, j) where j > i
    Complexity:
    O(n²) ❌
    ❌ 3. Sorting Approach
    Sort array
    Return max - min
    Problem:
    ❌ Breaks index order
    Complexity:
    O(n log n)
    ✅ 4. Optimal Approach (O(n) 🔥)

    👉 Key idea:

    Keep track of the minimum value seen so far

    ✅ 5. Algorithm
    🔹 Step 1: Initialize
    min_so_far = arr[0]
    max_diff = arr[1] - arr[0]
    🔹 Step 2: Traverse array

    For each element arr[i]:

    ✔️ Compute difference
    diff = arr[i] - min_so_far
    ✔️ Update max difference
    max_diff = max(max_diff, diff)
    ✔️ Update minimum
    min_so_far = min(min_so_far, arr[i])
    ✅ 6. Intuition 🔥
    Always keep the smallest element so far
    Try to maximize difference with current element
    If you find a smaller number → update reference
    ✅ 7. Dry Run
    arr = [3, 5, 2, 1, 7, 4]

    min_so_far = 3
    max_diff = 5 - 3 = 2

    i=2 → 2 → new min → min_so_far = 2

    i=3 → 1 → new min → min_so_far = 1

    i=4 → 7 → diff = 7 - 1 = 6 → max_diff = 6

    i=5 → 4 → diff = 4 - 1 = 3
    ✅ 8. Java Implementation
    public class MaxDifference {

        public static int maxDiff(int[] arr) {

            int n = arr.length;

            if (n < 2) {
                throw new IllegalArgumentException("Array must have at least 2 elements");
            }

            int minSoFar = arr[0];
            int maxDiff = arr[1] - arr[0];

            for (int i = 1; i < n; i++) {

                int diff = arr[i] - minSoFar;

                if (diff > maxDiff) {
                    maxDiff = diff;
                }

                if (arr[i] < minSoFar) {
                    minSoFar = arr[i];
                }
            }

            return maxDiff;
        }

        public static void main(String[] args) {

            int[] arr1 = {1, 34, 21, 7, 4, 8, 10};
            System.out.println(maxDiff(arr1)); // 33

            int[] arr2 = {17, 9, 2, 26, 32, 27, 3};
            System.out.println(maxDiff(arr2)); // 30
        }
    }
    ✅ 9. Complexity Analysis
    Type	Complexity
    Time	O(n)
    Space	O(1)
    ⚠️ 10. Edge Cases
    Case	Result
    Strictly decreasing	negative result
    Strictly increasing	max - min
    Small array	handle error
    All same elements	0
    ❌ Common Mistakes
    ❌ Comparing all pairs (O(n²))
    ❌ Sorting the array
    ❌ Not preserving index order
    ❌ Forgetting to update minimum
    ✅ 11. Short Interview Answer

    Traverse the array while maintaining the minimum value seen so far. At each step, compute the difference between the current element and the minimum, and update the maximum difference accordingly.

    🔥 12. Key Insight

    👉 This problem is a "prefix minimum + difference tracking" problem.

    👉 Similar patterns appear in:

    Stock Buy & Sell
    Maximum profit problems

    If you want next level:

    I can show visual graph explanation
    Or solve Stock Buy and Sell (very similar 🔥)
    Or give tricky variations asked in interviews 🚀
 */
    public static void main(String[] args) {
      
        int[] integers = {4, 1, 8, 3, 8, 2, 6, 7, 4, 9};

        int md = Arrays.maxDiff(integers);
        System.out.println("Max diff: " + md);
    }
}
