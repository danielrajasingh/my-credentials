package Chapter14.PeaksAndValleys.src.main.java.coding.challenge;
 
import java.util.Arrays;

public class Main {
                /*This is a pattern-rearrangement problem that tests your understanding of arrays and local ordering. Let’s break it down clearly 👇

                ✅ 1. What is the Question?

                You are given an array of integers (terrain elevations):

                [4, 5, 8, 3, 2, 1, 7, 8, 5, 9]

                👉 You must:

                Rearrange the array so that it forms an alternating sequence of peaks and valleys

                ✅ 2. What are Peaks and Valleys?
                🔺 Peak:
                arr[i] ≥ arr[i-1] AND arr[i] ≥ arr[i+1]
                🔻 Valley:
                arr[i] ≤ arr[i-1] AND arr[i] ≤ arr[i+1]
                ✅ 3. Expected Pattern

                We want something like:

                valley ≤ peak ≥ valley ≤ peak ≥ valley ...

                👉 Example:

                [4, 8, 5, 3, 5, 2, 7, 1, 8, 5, 9]
                ❌ Naive Approach
                Step:
                Sort array
                Swap adjacent elements
                Complexity:
                O(n log n) ❌
                ✅ 4. Optimized Approach (O(n) 🔥)

                👉 Key idea:

                For every odd index, make sure it is a peak

                ✅ 5. Algorithm (Step-by-Step)

                Loop through array:

                for i = 1 to n-1 step 2:

                At each i:

                Look at:
                arr[i-1], arr[i], arr[i+1]
                Find maximum among these three
                Swap max element with arr[i]

                👉 This ensures:

                arr[i] becomes a peak
                ✅ 6. Why This Works (Important Insight 🔥)
                You only fix local triplets
                Fixing one peak does NOT break previous ones
                Because:
                Already processed elements remain valid
                ✅ 7. Dry Run
                Input: [4, 5, 8]

                i=1 → max(4,5,8)=8 → swap with 5
                Result: [4,8,5]

                Next:

                [5,3,2] → max=5 → swap → [3,5,2]
                ✅ 8. Java Implementation
                public class PeaksAndValleys {

                    public static void sortPeaksValleys(int[] arr) {

                        for (int i = 1; i < arr.length; i += 2) {

                            int maxIndex = maxIndex(arr, i - 1, i, i + 1);

                            if (i != maxIndex) {
                                swap(arr, i, maxIndex);
                            }
                        }
                    }

                    private static int maxIndex(int[] arr, int a, int b, int c) {

                        int len = arr.length;

                        int valA = (a >= 0 && a < len) ? arr[a] : Integer.MIN_VALUE;
                        int valB = (b >= 0 && b < len) ? arr[b] : Integer.MIN_VALUE;
                        int valC = (c >= 0 && c < len) ? arr[c] : Integer.MIN_VALUE;

                        int max = Math.max(valA, Math.max(valB, valC));

                        if (valA == max) return a;
                        else if (valB == max) return b;
                        else return c;
                    }

                    private static void swap(int[] arr, int i, int j) {
                        int temp = arr[i];
                        arr[i] = arr[j];
                        arr[j] = temp;
                    }

                    public static void main(String[] args) {

                        int[] arr = {4, 5, 8, 3, 2, 1, 7, 8, 5, 9};

                        sortPeaksValleys(arr);

                        for (int num : arr) {
                            System.out.print(num + " ");
                        }
                    }
                }
                ✅ 9. Complexity Analysis
                Type	Complexity
                Time	O(n)
                Space	O(1)
                ✅ 10. Edge Cases 🚨
                Case	Handling
                Small array (size < 3)	Already valid
                Duplicate values	Works fine
                Already peaks/valleys	Minimal swaps
                All same values	No change
                ❌ Common Mistakes
                ❌ Sorting entire array unnecessarily
                ❌ Not checking boundaries
                ❌ Swapping wrong elements
                ❌ Trying to enforce both peaks & valleys explicitly
                ✅ 11. Short Interview Answer (Perfect Summary)

                Iterate through odd indices and ensure each is a peak by swapping it with the maximum of its neighbors, achieving an alternating peaks and valleys pattern in O(n) time.

                🚀 Bonus (Follow-ups)

                They may ask:

                👉 Make valleys at odd indices instead
                👉 Return all valid arrangements
                👉 Handle circular array
                👉 Find number of peaks

                If you want next level:

                I can give visual diagram explanation
                Or compare O(n log n) vs O(n) approaches
                Or give a hard variation with constraints 🔥

                 */
    public static void main(String[] args) {

        int[] integers = {4, 5, 8, 3, 2, 1, 7, 8, 5, 9};

        System.out.println("Before sorting: " + Arrays.toString(integers));
        PeaksValleys.sort(integers);
        System.out.println("After sorting: " + Arrays.toString(integers));

    }
}
