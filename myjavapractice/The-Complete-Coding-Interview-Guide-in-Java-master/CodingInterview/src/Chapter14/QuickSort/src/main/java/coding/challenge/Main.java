package Chapter14.QuickSort.src.main.java.coding.challenge;

import java.util.Arrays;
import java.util.Comparator;

public class Main {
/*
Let’s break down Quick Sort the same way: Question → Analysis → Solution → Implementation

✅ 1. What is the Question?

👉 You are given:

✔ An unsorted array

👉 Your task:

✔ Sort the array using Quick Sort (divide and conquer)

🔹 Example
Input:
[4, 2, 5, 1, 6, 7, 3]

Output:
[1, 2, 3, 4, 5, 6, 7]
🧠 2. Clear Analysis
🔹 What is Quick Sort?

👉 A divide and conquer sorting algorithm

🔹 Core Idea
Choose a pivot element
Partition the array:
Elements ≤ pivot go to the left
Elements > pivot go to the right
Recursively sort both sides
🔹 Key Step: Partitioning

👉 Partition ensures:

Pivot is placed in its correct sorted position
Left side → smaller elements
Right side → larger elements
🔹 Example Walkthrough

Array:

[4, 2, 5, 1, 6, 7, 3]

👉 Pivot = 3

After partition:

[2, 1, 3, 5, 6, 7, 4]
        ↑
     pivot fixed

Then recursively sort:

Left: [2, 1]
Right: [5, 6, 7, 4]
🔹 Why Quick Sort is Fast

✔ Works in-place (low memory)
✔ Good cache performance
✔ Very efficient in practice

🔹 Worst Case

👉 Happens when:

Pivot is always smallest or largest

Then:

O(n²)
🔹 Pivot Choices
First element
Last element (common)
Middle element
Random element (best in practice)
💡 3. Solution Approach
🔹 Algorithm
If left < right:
Partition the array
Get pivot index m
Recursively:
Sort left part → left → m-1
Sort right part → m+1 → right
🔹 Partition Logic

👉 Use last element as pivot

👉 Maintain pointer m:

Tracks correct position of smaller elements

👉 Loop through array:

If element ≤ pivot:
Swap with element at m
Increment m

👉 Finally:

Swap pivot into correct position
💻 4. Implementation
✅ Quick Sort Code
public class QuickSort {

    public static void sort(int[] arr, int left, int right) {

        if (left < right) {

            int pivotIndex = partition(arr, left, right);

            // Recursively sort left and right parts
            sort(arr, left, pivotIndex - 1);
            sort(arr, pivotIndex + 1, right);
        }
    }

    private static int partition(int[] arr, int left, int right) {

        int pivot = arr[right]; // choose last element as pivot
        int m = left;           // boundary for smaller elements

        for (int i = left; i < right; i++) {

            if (arr[i] <= pivot) {
                swap(arr, i, m);
                m++;
            }
        }

        // Place pivot in correct position
        swap(arr, m, right);

        return m;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {

        int[] arr = {4, 2, 5, 1, 6, 7, 3};

        sort(arr, 0, arr.length - 1);

        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
⚡ 5. Time & Space Complexity
Case	Complexity
Best	O(n log n)
Average	O(n log n)
Worst	O(n²)
Space	O(log n) (recursion)
🔍 6. Intuition (Very Important)

👉 Think like this:

Pick a pivot (like a reference point)
Split the array into:
smaller values
larger values
Then recursively sort both sides
🚀 7. Key Interview Points

✔ Why Quick Sort is fast in practice
✔ Why worst case is O(n²)
✔ Importance of pivot selection
✔ Difference from Merge Sort:

Quick Sort → in-place
Merge Sort → extra space

✔ Why Quick Sort is not stable

🧾 Final Summary
Question: Sort an array using Quick Sort
Core idea:
Choose pivot
Partition array
Recursively sort subarrays
Time complexity: O(n log n) (avg)
Space complexity: O(log n)

If you want next, I can:

✅ Show a step-by-step dry run (very important for interviews)
✅ Compare QuickSort vs MergeSort vs HeapSort
✅ Explain different partition techniques (Lomuto vs Hoare)
✅ Give tricky interview variations
 */
    public static void main(String[] args) {

        Comparator<Melon> byType = Comparator.comparing(Melon::getType);

        // initialize an array integers        
        int[] integers = {4, 2, 5, 1, 6, 7, 3};

        // initialize an array of Melons
        Melon[] melons = {new Melon("Watermelon", 3300), new Melon("Cantaloupe", 4500),
            new Melon("Cantaloupe", 2500), new Melon("Canary", 4300), new Melon("Crenshaw", 6300)};

        System.out.println("\n\nSort via Quick sort:");
        System.out.println("------------------------");

        System.out.println("\nSorting numbers ...");
        QuickSort.sort(integers, 0, integers.length - 1);
        System.out.println("Sorted: " + Arrays.toString(integers));

        System.out.println("\nSorting melons by type ...");
        QuickSort.sortWithComparator(melons, 0, melons.length - 1, byType);
        System.out.println("Sorted: " + Arrays.toString(melons));
    }
}
