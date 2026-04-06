package Chapter14.SortStackInPlace.src.main.java.coding.challenge09;
 
import java.util.Stack;

public class Main {
/*
            Let’s structure this like a strong interview answer.

            ✅ 1. What is the question?

            You are given an unsorted stack.

            👉 Your task is to sort the stack in place (no extra stack allowed in the main logic), so that:

            The smallest elements end up on top (or largest, depending on requirement — here it’s ascending order in stack)
            Example:
            Input (top → bottom):
            4 → 5 → 3 → 8 → 2 → 1

            Output:
            1 → 2 → 3 → 4 → 5 → 8
            ✅ 2. Clear Analysis
            Constraints:
            You cannot use a second stack
            You cannot use iterative sorting (no for/while for sorting logic)
            Must rely on recursion + stack operations
            Key Insight:

            A stack follows LIFO (Last In First Out)

            To sort it:

            Remove elements one by one (recursively)
            Sort the remaining stack
            Insert the removed element back into the correct position
            Core Idea:

            👉 Break the problem into 2 parts:

            Sort smaller stack recursively
            Insert element in sorted position
            Why recursion?
            Recursion naturally behaves like a temporary stack
            It helps us simulate sorting without explicitly using another data structure
            Strategy:
            Step 1: sort(stack)
            Pop the top element
            Recursively sort the remaining stack
            Step 2: sortedInsert(stack, element)
            Insert element into the correct position in the already sorted stack
            If:
            Stack empty OR element > top → push directly
            Else:
            Pop top
            Recursively insert
            Push top back
            ✅ 3. Solution Approach
            Algorithm:
            sort(stack):
            If stack is empty → return
            Pop top element
            Recursively call sort on remaining stack
            Insert popped element using sortedInsert
            sortedInsert(stack, element):
            If stack empty OR element is larger than top:
            → push element
            Else:
            Pop top
            Recursively call sortedInsert
            Push back the popped element
            ✅ 4. Implementation (Java)
            import java.util.Stack;

            public class SortStack {

                public static void sort(Stack<Integer> stack) {
                    if (stack.isEmpty()) {
                        return;
                    }

                    int top = stack.pop();

                    // Sort remaining stack
                    sort(stack);

                    // Insert element in sorted order
                    sortedInsert(stack, top);
                }

                private static void sortedInsert(Stack<Integer> stack, int element) {
                    // Base case: stack empty or correct position found
                    if (stack.isEmpty() || element > stack.peek()) {
                        stack.push(element);
                        return;
                    }

                    // Remove top and recurse
                    int top = stack.pop();
                    sortedInsert(stack, element);

                    // Push the removed element back
                    stack.push(top);
                }

                // Utility to print stack
                public static void printStack(Stack<Integer> stack) {
                    System.out.println(stack);
                }

                public static void main(String[] args) {
                    Stack<Integer> stack = new Stack<>();
                    stack.push(1);
                    stack.push(2);
                    stack.push(8);
                    stack.push(3);
                    stack.push(5);
                    stack.push(4);

                    sort(stack);

                    printStack(stack);
                }
            }
            ✅ 5. Complexity
            Type	Complexity
            Time	O(n²)
            Space	O(n) (recursion stack)
            ✅ 6. Key Interview Insight

            👉 This is a classic recursion + stack manipulation problem

            Pattern to remember:
            “Remove → Recursively solve → Insert back correctly”
            🔥 Important Concept

            This problem is similar to:

            Insertion sort logic
            But applied using recursion instead of loops
            🚀 Quick Intuition

            “Take one element out, sort the rest, and put it back in the right place”

            If you want next:

            🔥 Visual step-by-step dry run
            🧠 Iterative solution using extra stack (comparison)
            📊 Similar recursion problems (very important for interviews)
 */
    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();
        
        stack.push(1);
        stack.push(2);
        stack.push(8);
        stack.push(3);
        stack.push(5);
        stack.push(4);
        
        System.out.println("Before sorting: " + stack);
        
        Stacks.sort(stack);
        
        System.out.println("After sorting: " + stack);
    }
}
