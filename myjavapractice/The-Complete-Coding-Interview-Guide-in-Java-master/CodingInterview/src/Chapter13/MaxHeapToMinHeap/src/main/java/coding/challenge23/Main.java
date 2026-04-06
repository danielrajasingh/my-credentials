package Chapter13.MaxHeapToMinHeap.src.main.java.coding.challenge23;
 
import java.util.Arrays;

public class Main {
/*
Here’s a clean, interview-ready breakdown of your problem:

🟢 1. What is the Question?

You are given an array representing a Max Heap.

👉 Task:
Convert it into a Min Heap

🔍 Important Clarification

The text you shared has a mistake:

It says “convert Min Heap to Max Heap” in one place
But the code and logic actually show Max Heap → Min Heap

👉 The actual question is:

Convert a Max Heap into a Min Heap in O(n) time and without extra space

🧠 2. Clear Analysis
🔑 Key Observation

Heap structure:

Stored as an array
Parent-child relationship:
Left child → 2*i + 1
Right child → 2*i + 2
🧩 Core Idea

Instead of rebuilding from scratch:

👉 We use bottom-up heapify

⚙️ Strategy
Start from the last non-leaf node
Move up to the root
At each node:
Apply Min Heapify
Ensure parent ≤ children
🧠 Why This Works?
Leaf nodes are already valid heaps
We fix violations from bottom → up
This ensures global correctness efficiently
📌 Key Insight

A heap can be built in O(n) using bottom-up heapify
(Not O(n log n), which is a common misconception)

🎯 Goal

Transform:

Max Heap → Min Heap

By enforcing:

Parent ≤ children
🚀 3. Solution Approach
🪜 Steps

Find last non-leaf node:

(n - 2) / 2
Loop from this index down to 0:
Apply min heapify
Heapify ensures:
Smallest element moves upward
Structure becomes valid Min Heap
⏱ Complexity
Time → O(n)
Space → O(1) (in-place)
💻 4. Java Implementation
public class HeapConversion {

    public static void convertMaxHeapToMinHeap(int[] heap) {
        int n = heap.length;

        // Start from last non-leaf node
        for (int i = (n - 2) / 2; i >= 0; i--) {
            heapifyMin(heap, i, n);
        }
    }

    // Min Heapify
    private static void heapifyMin(int[] heap, int i, int size) {
        int smallest = i;

        int left = 2 * i + 1;
        int right = 2 * i + 2;

        // Check left child
        if (left < size && heap[left] < heap[smallest]) {
            smallest = left;
        }

        // Check right child
        if (right < size && heap[right] < heap[smallest]) {
            smallest = right;
        }

        // Swap and continue heapifying
        if (smallest != i) {
            swap(heap, i, smallest);
            heapifyMin(heap, smallest, size);
        }
    }

    private static void swap(int[] heap, int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    // Test
    public static void main(String[] args) {
        int[] maxHeap = {50, 30, 40, 10, 5, 20, 30};

        convertMaxHeapToMinHeap(maxHeap);

        for (int val : maxHeap) {
            System.out.print(val + " ");
        }
    }
}
🧾 Final Summary
❓ Problem: Convert Max Heap → Min Heap
🧠 Key Idea: Use bottom-up heapify
⚙️ Method: Start from last non-leaf node → heapify upward
⏱ Complexity:
Time: O(n)
Space: O(1)
💡 Important: This is not a sorting problem, it’s a heap restructuring problem
🔥 Interview Tip

If asked:

👉 “Why O(n) and not O(n log n)?”

Answer:

Because heapify is applied bottom-up, and most nodes are near the leaves with small work, resulting in an overall linear time complexity.

If you want next:
✅ Visual step-by-step heap transformation
✅ Common mistakes interviewers test here
✅ Difference between heap build vs heap sort
✅ Similar heap problems (very important for Amazon/Google)
 */
    public static void main(String[] args) {

        /*        
              40
            /    \
          37      25
         /  \    /  \   
        33  34  20   22         
         */
        
        // max heap
        int arrMaxHeap[] = {40, 37, 25, 33, 34, 20, 22};
        int arrMinHeap[] = {20, 33, 22, 37, 34, 25, 40};
        
        System.out.println("Max heap: " + Arrays.toString(arrMaxHeap));        
        Heaps.convertToMinHeap(arrMaxHeap);
        System.out.println("Min heap: " + Arrays.toString(arrMaxHeap));        
        
        System.out.println("\n\nMin heap: " + Arrays.toString(arrMinHeap));        
        Heaps.convertToMaxHeap(arrMinHeap);
        System.out.println("Max heap: " + Arrays.toString(arrMinHeap));        
    }
}
