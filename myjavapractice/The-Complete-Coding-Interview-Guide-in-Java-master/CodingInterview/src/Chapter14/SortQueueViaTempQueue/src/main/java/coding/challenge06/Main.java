package Chapter14.SortQueueViaTempQueue.src.main.java.coding.challenge06;
  
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

    /*
    Let’s break this down clearly in the exact order you asked: Question → Analysis → Solution → Implementation idea

✅ 1. What is the Question?

You are given a queue of integers, and you need to:

👉 Sort the queue in ascending order

But with a constraint:

You are allowed to use only one additional (extra) queue
You cannot use arrays, stacks, or other data structures
You must use queue operations only:
enqueue (add)
dequeue (poll)
peek
🧠 2. Clear Analysis of the Problem
🔹 Key Observations
A queue is FIFO (First In First Out)
→ You cannot directly access random elements like in arrays.
Sorting requires:
Comparing elements
Moving elements repeatedly
Since we can use another queue, we can:
Store partially sorted elements
Use it as temporary storage
🔹 Important Idea Behind the Solution

👉 The approach is similar to insertion sort using queues

We:

Keep building a sorted sequence in the extra queue
Compare elements from the original queue
Place elements in the correct order
🔹 Step-by-step Logic
Create an extra queue
Process elements one by one from the original queue
Compare with elements already in the extra queue
Insert elements in the correct position
Repeat until all elements are sorted
Move elements back to the original queue
🔹 Complexity
Time Complexity: O(n²)
Space Complexity: O(n) (extra queue)
💡 3. Solution Approach (High-Level)

👉 Use two queues:

queue → original
extraQueue → helps in sorting
Strategy:
Keep transferring elements from queue to extraQueue
Maintain sorted order in extraQueue
Insert elements in correct position by comparing
Finally, copy back to original queue
💻 4. Implementation (Java Example)

Here is a clean and simplified version:

import java.util.*;

public class QueueSortUsingExtraQueue {

    public static void sort(Queue<Integer> queue) {
        if (queue == null || queue.size() < 2) {
            return;
        }

        Queue<Integer> extraQueue = new LinkedList<>();

        while (!queue.isEmpty()) {

            // Step 1: take one element from original queue
            int current = queue.poll();

            // Step 2: insert into extraQueue in sorted order
            while (!extraQueue.isEmpty() && extraQueue.peek() < current) {
                queue.add(extraQueue.poll());
            }

            extraQueue.add(current);
        }

        // Step 3: move back to original queue
        while (!extraQueue.isEmpty()) {
            queue.add(extraQueue.poll());
        }
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(3);
        queue.add(9);
        queue.add(1);
        queue.add(8);
        queue.add(5);
        queue.add(2);

        sort(queue);

        System.out.println(queue); // Output: [1, 2, 3, 5, 8, 9]
    }
}
🔍 5. How This Works (Intuition)
extraQueue always keeps elements in sorted order
For each new element:
Move smaller elements back to original queue
Insert the current element
Restore moved elements later
⚡ 6. Comparison with Your Provided Solution
Feature	Your Book Solution	This Simplified Approach
Approach	Complex simulation	Cleaner insertion sort
Extra space	O(n)	O(n)
Time complexity	O(n²)	O(n²)
Readability	Medium	Easy
🚀 Final Summary
Question: Sort a queue using only one extra queue
Key Idea: Use the extra queue to maintain sorted order
Technique: Insertion sort logic adapted for queues
Time Complexity: O(n²)

If you want, I can next:
✅ Visualize step-by-step with diagrams
✅ Give a dry run with your example (3 → 9 → 1 → …)
✅ Compare with “no extra space” solution (your previous problem)
     */
    public static void main(String[] args) {

        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(7);
        queue.add(1);
        queue.add(4);
        queue.add(0);
        queue.add(2);
        queue.add(-4);
        queue.add(-4);
        queue.add(1);
        queue.add(0);
        queue.add(14);
 
        System.out.println("Given queue: " + queue);

        Queues.sort(queue);

        System.out.println("Sorted queue: " + queue);
    }
}
