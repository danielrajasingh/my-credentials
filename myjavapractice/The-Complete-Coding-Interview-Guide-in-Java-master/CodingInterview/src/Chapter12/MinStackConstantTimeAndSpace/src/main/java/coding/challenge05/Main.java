package Chapter12.MinStackConstantTimeAndSpace.src.main.java.coding.challenge05;
 
public class Main {
/*
    Let’s break this down clearly and deeply—this is a very important interview problem.

    🟡 1. What is the question?

    You are asked to:

    👉 Design a stack that supports:

    push(x)
    pop()
    min()
    Constraint:

    All operations must run in O(1) time

    🟡 2. What is the challenge?

    Normally:

    Stack operations → O(1)
    But finding minimum → ❌ O(n) (scan entire stack)

    👉 That violates the constraint

    🟡 3. Key Idea

    We need:

    A way to track the minimum at all times

    🟡 4. Optimal Approach (Two Stacks)

    👉 Use:

    Main stack → stores all values
    Min stack → stores minimum values
    🟡 5. How it works
    🔹 push(value)
    Push value to main stack

    If:

    value ≤ current min

    → push into min stack

    🔹 pop()
    Pop from main stack
    If popped value == min → pop from min stack
    🔹 min()
    Return top of min stack
    🟡 6. Why this works?

    👉 Min stack always keeps:

    The current minimum at the top
    🟡 7. Solution (Code Implementation)
    import java.util.Stack;

    public class MinStack {

        private Stack<Integer> mainStack;
        private Stack<Integer> minStack;

        public MinStack() {
            mainStack = new Stack<>();
            minStack = new Stack<>();
        }

        // PUSH
        public void push(int value) {
            mainStack.push(value);

            if (minStack.isEmpty() || value <= minStack.peek()) {
                minStack.push(value);
            }
        }

        // POP
        public int pop() {
            int value = mainStack.pop();

            if (value == minStack.peek()) {
                minStack.pop();
            }

            return value;
        }

        // MIN
        public int min() {
            return minStack.peek();
        }
    }
    🟡 8. Complexity Analysis
    ⏱ Time:
    push → O(1)
    pop → O(1)
    min → O(1)
    🧠 Space:
    O(n) (extra stack)
    🟡 9. Key Insights
    🔑 Use auxiliary stack
    🔑 Track minimum dynamically
    🔑 Duplicate min values when needed
    🟡 10. Common Mistakes

    ❌ Not handling duplicate minimums
    ❌ Forgetting to update min stack
    ❌ Using only one stack (without trick)
    ❌ Returning wrong min after pop

    🟡 11. Advanced Version (No Extra Space)

    👉 Trick:

    Store encoded values
    Key idea:

    When pushing smaller value:

    encoded = 2 * value - currentMin
    Why?
    Encoded value helps recover previous min
    Pop logic:
    If top < min → special case
    Recover previous min:
    previousMin = 2 * currentMin - top
    🟡 12. Advanced Implementation
    import java.util.Stack;

    public class MinStackOptimized {

        private Stack<Integer> stack = new Stack<>();
        private int min;

        public void push(int value) {
            if (stack.isEmpty()) {
                stack.push(value);
                min = value;
            } else if (value >= min) {
                stack.push(value);
            } else {
                stack.push(2 * value - min);
                min = value;
            }
        }

        public void pop() {
            int top = stack.pop();

            if (top < min) {
                min = 2 * min - top;
            }
        }

        public int min() {
            return min;
        }
    }
    🟡 13. Complexity (Optimized)
    Time → O(1)
    Space → O(1) (no extra stack)
    🟡 14. Interview Tips

    This problem tests:

    Data structure design
    Optimization thinking
    Edge case handling
    🟡 15. Summary

    👉 Problem:

    Design stack with constant-time min()

    👉 Best solution:

    Use two stacks

    👉 Advanced:

    Use encoded values (no extra space)

    If you want next, I can:

    Show step-by-step dry run
    Compare both approaches clearly
    Give real interview variations (very important)
 */
    public static void main(String[] args) {

        MyStack stack = new MyStack();

        stack.push(5);
        stack.push(-25);
        stack.push(35);
        stack.push(15);
        System.out.println("Min: " + stack.min());

        stack.push(-1);
        stack.push(-30);
        stack.push(6);
        System.out.println("Min: " + stack.min());

        stack.push(-100);
        System.out.println("Min: " + stack.min());

        stack.pop();
        stack.pop();
        System.out.println("Min (after two pop): " + stack.min());

        stack.pop();
        stack.pop();
        System.out.println("Min (after two pop): " + stack.min());

        stack.pop();
        stack.pop();
        stack.pop();        
        System.out.println("Min (after three pop): " + stack.min());
        
        stack.pop();     
        System.out.println("Min (after two pop): " + stack.min());
    }

}
