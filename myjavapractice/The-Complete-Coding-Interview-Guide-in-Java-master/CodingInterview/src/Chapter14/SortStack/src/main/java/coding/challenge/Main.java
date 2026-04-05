package Chapter14.SortStack.src.main.java.coding.challenge;
 
import java.util.Stack;

public class Main {
 /*
 Let’s break it down clearly in an interview-style format.

✅ 1. What is the question?

You are given an unsorted stack.

👉 Your task is to:

Sort the stack in ascending or descending order
You are allowed to use only one additional stack (auxiliary stack)
Example:
Input (top → bottom):
1 → 4 → 5 → 3 → 1 → 2

Output (ascending):
1 → 1 → 2 → 3 → 4 → 5
✅ 2. Clear Analysis
Constraints:
Only one extra stack
Use only stack operations (push, pop, peek)
No arrays, no other data structures
Key Idea:

👉 Use the second stack (auxStack) as a temporary sorted container

Core Strategy (Very Important):

We process elements one by one from the original stack and insert them into the correct position in auxStack.

Step-by-step Logic:

For each element t popped from the original stack:

Compare with top of auxStack

While:

auxStack.peek() > t

→ Move elements back to original stack

Push t into auxStack
Why this works?

This is essentially:

Insertion Sort using stacks

We build a sorted stack gradually
Always maintain sorted order in auxStack
Final Step:

After processing:

auxStack contains sorted elements
Copy elements back to original stack
✅ 3. Solution Approach
Algorithm:
Step 1: Build sorted stack (auxStack)
While original stack is not empty:
Pop element t
Move larger elements from auxStack back to original stack
Push t into auxStack
Step 2: Restore to original stack
Move everything from auxStack back
Sorting Order:

auxStack keeps elements such that:

smallest at bottom → largest at top
After copying back → original stack becomes ascending
✅ 4. Implementation (Java)
import java.util.Stack;

public class SortStack {

    public static void sort(Stack<Integer> stack) {
        Stack<Integer> auxStack = new Stack<>();

        // Step 1: Sort into auxStack
        while (!stack.isEmpty()) {
            int t = stack.pop();

            while (!auxStack.isEmpty() && auxStack.peek() > t) {
                stack.push(auxStack.pop());
            }

            auxStack.push(t);
        }

        // Step 2: Move back to original stack
        while (!auxStack.isEmpty()) {
            stack.push(auxStack.pop());
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        stack.push(1);
        stack.push(4);
        stack.push(5);
        stack.push(3);
        stack.push(1);
        stack.push(2);

        sort(stack);

        System.out.println(stack); // [1, 1, 2, 3, 4, 5]
    }
}
✅ 5. Complexity
Type	Complexity
Time	O(n²)
Space	O(n) (aux stack)
✅ 6. Key Interview Insight

👉 This problem is:

“Sorting using only stack operations”

Pattern to Remember:
Concept	Insight
Sorting	Use auxiliary structure
Stack constraint	Use recursion or another stack
Approach	Insert elements in correct position
🚀 Quick Intuition

“Take one element → place it in correct sorted position → repeat”

🔥 Bonus Insight (Very Important for Interviews)
This is equivalent to Insertion Sort
The stack behavior makes it natural for:
recursion (Challenge 9)
auxiliary stack (Challenge 8)

If you want next:

🔥 Visual dry run (step-by-step stack states)
🧠 Difference between Challenge 8 vs 9 (very important)
📊 Pattern cheat sheet for stack problems
  */
    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();
        
        stack.push(1);
        stack.push(2);
        stack.push(1);
        stack.push(3);
        stack.push(5);
        stack.push(4);
        
        System.out.println("Before sorting: " + stack);
        
        Stacks.sort(stack);
        
        System.out.println("After sorting: " + stack);
    }
}
