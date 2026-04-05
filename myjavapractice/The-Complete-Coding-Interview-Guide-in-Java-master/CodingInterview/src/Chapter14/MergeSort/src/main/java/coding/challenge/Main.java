package Chapter14.MergeSort.src.main.java.coding.challenge;

import java.util.Arrays;

public class Main {
/*
Let’s go step by step again: Question → Analysis → Solution → Implementation

✅ 1. What is the Question?

👉 You are given:

✔ An unsorted array

👉 Your task:

✔ Sort the array using Merge Sort

🔹 Example
Input:
[52, 28, 91, 19, 76, 33]

Output:
[19, 28, 33, 52, 76, 91]
🧠 2. Clear Analysis
🔹 What is Merge Sort?

👉 Merge Sort is a Divide and Conquer algorithm

It works in 3 steps:

1. Divide

Split the array into two halves

2. Conquer

Recursively sort each half

3. Combine

Merge the two sorted halves

🔹 Key Idea

👉 Keep splitting until each sub-array has:

1 element → already sorted

Then:
👉 Merge them back in sorted order

🔹 Visual Flow
[52, 28, 91, 19]
→ [52, 28]   [91, 19]
→ [52] [28]   [91] [19]
→ merge → [28, 52]   [19, 91]
→ merge → [19, 28, 52, 91]
🔹 Merge Step (Most Important)

👉 Combine two sorted arrays:

Compare elements from both arrays
Take the smaller one
Repeat until both are merged
🔹 Why Merge Sort?

✔ Always O(n log n)
✔ Works well for large data
✔ Stable sorting algorithm
✔ Good for linked lists & external sorting

🔹 Space Requirement

👉 Needs extra space:

Temporary arrays → O(n)
💡 3. Solution Approach
🔹 Algorithm
If array size ≤ 1 → return (base case)
Split array into:
left half
right half
Recursively:
sort left
sort right
Merge both sorted halves
🔹 Key Functions
sort() → recursive sorting
merge() → combines sorted arrays
leftHalf() / rightHalf() → splitting
💻 4. Implementation
✅ Merge Sort Code
import java.util.*;

public class MergeSort {

    public static void sort(int[] arr) {

        if (arr.length <= 1) return;

        int mid = arr.length / 2;

        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, arr.length);

        // Recursively sort both halves
        sort(left);
        sort(right);

        // Merge sorted halves
        merge(arr, left, right);
    }

    private static void merge(int[] result, int[] left, int[] right) {

        int i = 0, l = 0, r = 0;

        while (l < left.length && r < right.length) {

            if (left[l] <= right[r]) {
                result[i++] = left[l++];
            } else {
                result[i++] = right[r++];
            }
        }

        // Copy remaining elements
        while (l < left.length) {
            result[i++] = left[l++];
        }

        while (r < right.length) {
            result[i++] = right[r++];
        }
    }

    public static void main(String[] args) {

        int[] arr = {52, 28, 91, 19, 76, 33};

        sort(arr);

        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
⚡ 5. Time & Space Complexity
Case	Complexity
Best	O(n log n)
Average	O(n log n)
Worst	O(n log n)
Space	O(n)
🔍 6. Intuition (Very Important)

👉 Think like this:

Instead of sorting directly
Break the problem into smaller sorted problems
Then combine them
🚀 7. Key Interview Points

✔ Why Merge Sort is divide & conquer
✔ Why it is always O(n log n)
✔ Why it uses extra space
✔ What makes it stable (<= condition)
✔ Difference from QuickSort & HeapSort

🧾 Final Summary
Question: Sort an array using Merge Sort
Core idea: Divide → Sort → Merge
Approach:
Split array
Recursively sort halves
Merge sorted halves
Time complexity: O(n log n)
Space complexity: O(n)

If you want next, I can:

✅ Give a step-by-step dry run (very important)
✅ Explain merge process visually
✅ Compare Merge Sort vs QuickSort vs Heap Sort
✅ Give interview tricky variations
 */
    public static void main(String[] args) {

        // initialize an array integers        
        int[] integers = {4, 5, 2, 7, 1};

        System.out.println("\n\nSort via Merge sort:");
        System.out.println("----------------------");

        MergeSort.sort(integers);
        System.out.println("Sorted: " + Arrays.toString(integers));
    }
}
