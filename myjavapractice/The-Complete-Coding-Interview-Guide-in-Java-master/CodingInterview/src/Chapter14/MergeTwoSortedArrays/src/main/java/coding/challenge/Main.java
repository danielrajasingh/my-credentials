package Chapter14.MergeTwoSortedArrays.src.main.java.coding.challenge;
 
import java.util.Arrays;

public class Main {
/*
            Let’s break this down clearly step by step.

            ✅ 1. What is the Question?

            You are given:

            👉 Two sorted arrays:

            p (already has extra space at the end)
            q

            👉 Your task:

            ✔ Merge q into p so that p remains sorted
            ✔ Do it in-place (no extra array)

            🔹 Example
            p = [-1, 3, 8, 0, 0]
            q = [2, 4]

            Output:
            p = [-1, 2, 3, 4, 8]
            🧠 2. Clear Analysis
            🔹 Key Observations
            Both arrays are already sorted
            p has extra space at the end
            We should avoid shifting elements (expensive)
            🔹 Important Trick

            👉 Instead of merging from the front, we merge from the back

            Why?

            The largest elements are at the end
            We can place them directly into the empty spaces in p
            🔹 Two Pointers Approach

            We use:

            pIdx → last valid element in p
            qIdx → last element in q
            mIdx → last position in p
            🔹 Strategy
            Compare p[pIdx] and q[qIdx]
            Place the larger one at the end (mIdx)
            Move pointers backward
            Repeat until q is fully merged
            🔹 Why Not Merge from Start?

            If we merge from the beginning:

            ❌ We would need to shift elements
            ❌ Time complexity becomes worse (O(n²))

            💡 3. Solution Idea

            👉 Use 3 pointers and merge from the end

            Algorithm Steps
            Initialize pointers:
            pIdx = last valid index in p
            qIdx = last index in q
            mIdx = last index in p
            While qIdx >= 0:
            If p[pIdx] > q[qIdx]:
            Place p[pIdx] at p[mIdx]
            Decrement pIdx
            Else:
            Place q[qIdx] at p[mIdx]
            Decrement qIdx
            Decrement mIdx
            If any elements remain in q, copy them into p
            💻 4. Implementation
            public class MergeSortedArrays {

                public static void merge(int[] p, int[] q) {

                    int pLast = p.length - q.length; // number of valid elements in p

                    int pIdx = pLast - 1;            // last element in p
                    int qIdx = q.length - 1;         // last element in q
                    int mIdx = p.length - 1;        // last index in p

                    // Merge from back
                    while (qIdx >= 0) {

                        if (pIdx >= 0 && p[pIdx] > q[qIdx]) {
                            p[mIdx] = p[pIdx];
                            pIdx--;
                        } else {
                            p[mIdx] = q[qIdx];
                            qIdx--;
                        }

                        mIdx--;
                    }
                }

                public static void main(String[] args) {
                    int[] p = { -1, 3, 8, 0, 0 };
                    int[] q = { 2, 4 };

                    merge(p, q);

                    for (int num : p) {
                        System.out.print(num + " ");
                    }
                }
            }
            ⚡ 5. Time & Space Complexity
            Complexity	Value
            Time	O(n + m)
            Space	O(1)
            🔍 6. Intuition (Important for Interviews)

            👉 Think like this:

            We want to avoid shifting elements
            So we fill from the end (right to left)
            Always place the largest remaining element
            🚀 7. Key Interview Points

            ✔ Why we merge from the end
            ✔ Why no extra space is needed
            ✔ Why the algorithm is O(n + m)
            ✔ Difference from normal merge (merge sort)

            🧾 Final Summary
            Question: Merge two sorted arrays in-place
            Core idea: Use 3 pointers from the end
            Approach: Compare and place larger elements at the back
            Time complexity: O(n + m)
            Space complexity: O(1)

            If you want next, I can:
            ✅ Show a step-by-step dry run
            ✅ Give tricky variations (like merging k arrays)
            ✅ Provide common interview follow-up questions
            ✅ Draw diagrams to visualize the pointer movement
 */
    public static void main(String[] args) {

        // 0, 0, 0, 0, 0, 0 are spots needed for adding q in p
        int[] p = {-3, -2, 0, 3, 8, 12, 16, 17, 24, 39, 0, 0, 0, 0, 0, 0};
        int[] q = {-4, -2, -1, 1, 4, 36};

        SortArrays.merge(p, q);

        System.out.println("Result: " + Arrays.toString(p));
    }
}
