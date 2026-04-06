package Chapter14.SortQueueWithoutExtraSpace.src.main.java.coding.challenge07;
 
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
/*
Let’s break this down in a clear, interview-ready way.

✅ 1. What is the question?

You are given a queue of integers.

👉 Your task is to:

Sort the queue
❗ Without using any extra data structure (no additional queue, stack, array)
Example:
Input (rear → front):
3 → 9 → 1 → 8 → 5 → 2

Output (front → rear):
1 → 2 → 3 → 5 → 8 → 9
✅ 2. Clear Analysis
Constraints:
Must use only the given queue
No extra queue/stack/array
Only operations:
enqueue (add)
dequeue (remove)
peek
Key Idea:

👉 Use a selection sort-like approach

Core Concept:
Repeatedly find the minimum element
Move it to the rear of the queue
Shrink the unsorted portion each time
Important Observation:

A queue is:

FIFO (First In First Out)

So we:

Scan entire queue
Find minimum
Rearrange elements
Place minimum at correct position (end of sorted part)
How it works:

We divide the queue into:

Unsorted part
Sorted part (at the rear)

Each iteration:

Find the minimum in the unsorted part
Move it to the rear
✅ 3. Solution Approach
Step-by-step:
Step 1: Repeat for each element
for i = 1 to n:
    find minimum in unsorted part
    move it to rear
Step 2: Find Minimum (moveMinToRear)

For each element in the queue:

Dequeue element
Compare with current minimum
If smaller:
Update minimum
Otherwise:
Put back into queue
Finally, add the minimum to the rear
Key Trick:

👉 Keep track of:

minElement
sortIndex → boundary between sorted & unsorted
⚠️ Important Note

Even though we say “no extra space”:

We still use:
a few variables (int, boolean)
But no extra data structure
✅ 4. Implementation (Java)
import java.util.Queue;
import java.util.LinkedList;

public class SortQueue {

    public static void sort(Queue<Integer> queue) {
        int n = queue.size();

        for (int i = 0; i < n; i++) {
            moveMinToRear(queue, n - i);
        }
    }

    private static void moveMinToRear(Queue<Integer> queue, int sortIndex) {
        int minElement = Integer.MAX_VALUE;
        int size = queue.size();

        // Step 1: Find minimum in unsorted part
        for (int i = 0; i < size; i++) {
            int current = queue.poll();

            if (current <= minElement && i < sortIndex) {
                minElement = current;
            }

            queue.add(current);
        }

        // Step 2: Remove one occurrence of minElement and push others back
        boolean minPlaced = false;

        for (int i = 0; i < size; i++) {
            int current = queue.poll();

            if (current == minElement && !minPlaced) {
                minPlaced = true;
                continue; // skip adding once (placing it at rear later)
            }

            queue.add(current);
        }

        // Step 3: Add minimum to rear
        queue.add(minElement);
    }
}
✅ 5. Complexity
Type	Complexity
Time	O(n²)
Space	O(1) (no extra DS)
✅ 6. Key Interview Insight

👉 This is:

“Selection sort adapted to a queue”

Pattern to Remember:
Concept	Insight
Queue sorting	Use repeated scanning
No extra space	Only use variables
Strategy	Find min → move to rear
🚀 Quick Intuition

“Find the smallest → send it to the back → repeat”

🔥 Important Comparison (Very Useful)
Problem	Data Structure	Technique
Stack sort (Challenge 8)	Stack	Auxiliary stack
Stack sort (Challenge 9)	Stack	Recursion
Queue sort (Challenge 7)	Queue	Selection sort style

If you want next:

🔥 Step-by-step visualization of queue operations
🧠 Pattern cheat sheet for stack & queue problems
📊 Difference between all sorting challenges (7, 8, 9)
 */
    public static void main(String[] args) {

        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(7);
        queue.add(1);
        queue.add(-7);
        queue.add(3);
        queue.add(9);
        queue.add(2);
        queue.add(1);
        queue.add(-1);
        queue.add(0);
        queue.add(0);
        queue.add(9);
        queue.add(2);
        queue.add(3);
        queue.add(1);

        System.out.println("Given queue: " + queue);

        Queues.sort(queue);

        System.out.println("Sorted queue: " + queue);
    }
}
