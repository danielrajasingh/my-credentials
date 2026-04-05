package Chapter14.HeapSort.src.main.java.coding.challenge;

import java.util.Arrays;
import java.util.Comparator;

public class Main {
/*
et’s break this down clearly into Question → Analysis → Solution → Implementation

✅ 1. What is the Question?

👉 You are given an unsorted array

👉 Your task is to:

✔ Sort the array using Heap Sort

🔹 Example
Input:
[4, 5, 2, 7, 1]

Output:
[1, 2, 4, 5, 7]
🧠 2. Clear Analysis
🔹 What is a Heap?

A binary heap is a complete binary tree stored in an array:

Two types:
Max Heap → Parent ≥ Children
Min Heap → Parent ≤ Children
🔹 Heap Sort Idea

👉 To sort in ascending order, we use a Max Heap

🔹 Key Observations
The largest element is always at the root (index 0)
We:
Swap root with last element
Remove last element (now sorted)
Heapify again
🔹 Why It Works

👉 Each time:

We place the largest remaining element at the end
So the array becomes sorted from right to left
🔹 Main Steps
Step 1: Build Max Heap

Convert array into a max heap

Step 2: Extract Elements
Swap root with last element
Reduce heap size
Heapify root again
Step 3: Repeat

Until only one element remains

💡 3. Solution Approach
🔹 Core Operations
buildHeap() → creates max heap
heapify() → restores heap property
swap() → swaps elements
🔹 Algorithm
Build max heap from array
For each element from end:
Swap root with last element
Reduce heap size
Heapify root
💻 4. Implementation
✅ Heap Sort Code
public class HeapSort {

    public static void sort(int[] arr) {

        int n = arr.length;

        // Step 1: Build Max Heap
        buildHeap(arr, n);

        // Step 2: Extract elements one by one
        for (int i = n - 1; i > 0; i--) {

            // Move current root (largest) to end
            swap(arr, 0, i);

            // Heapify reduced heap
            heapify(arr, i, 0);
        }
    }

    // Build max heap
    private static void buildHeap(int[] arr, int n) {
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }
    }

    // Heapify subtree rooted at index i
    private static void heapify(int[] arr, int n, int i) {

        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        if (largest != i) {
            swap(arr, i, largest);
            heapify(arr, n, largest);
        }
    }

    // Swap helper
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {

        int[] arr = {4, 5, 2, 7, 1};

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
Space	O(1)
🔍 6. Intuition (Important)

👉 Think like this:

A heap always gives you the largest element easily
So:
Extract largest → put at end
Repeat → array becomes sorted
🚀 7. Key Interview Points

✔ Why Heap Sort is O(n log n) always
✔ Difference from QuickSort / MergeSort
✔ Why Heap Sort is in-place (O(1) space)
✔ Why it is not stable
✔ Max Heap vs Min Heap usage

🧾 Final Summary
Question: Sort an array using Heap Sort
Core idea: Build a Max Heap and repeatedly extract the maximum
Approach:
Heapify array
Swap root with last element
Reduce heap and repeat
Time complexity: O(n log n)
Space complexity: O(1)

If you want next, I can:
✅ Show a step-by-step dry run (very important for exams)
✅ Explain heapify visually
✅ Compare Heap Sort vs QuickSort vs MergeSort
✅ Give tricky interview questions on heaps
 */
    public static void main(String[] args) {

        Comparator<Melon> byType = Comparator.comparing(Melon::getType);

        // initialize an array integers        
        int[] integers = {4, 5, 2, 7, 1};

        // initialize an array of Melons
        Melon[] melons = {new Melon("Watermelon", 3300), new Melon("Cantaloupe", 4500), 
            new Melon("Cantaloupe", 2500), new Melon("Canary", 4300), new Melon("Crenshaw", 6300)};

        System.out.println("\n\nSort via Heap sort:");
        System.out.println("----------------------");

        System.out.println("\nSorting numbers ...");
        HeapSort.sort(integers);
        System.out.println("Sorted: " + Arrays.toString(integers));

        System.out.println("\nSorting melons by type ...");       
        HeapSort.sortWithComparator(melons, byType);
        System.out.println("Sorted: " + Arrays.toString(melons));
    }
}
