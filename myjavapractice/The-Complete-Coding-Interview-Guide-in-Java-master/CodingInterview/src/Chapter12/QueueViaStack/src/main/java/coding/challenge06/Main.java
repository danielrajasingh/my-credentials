package Chapter12.QueueViaStack.src.main.java.coding.challenge06;
 
public class Main {
/*
            Let’s break this down clearly and logically—this is a classic interview problem.

            🟡 1. What is the question?

            You are asked to:

            👉 Design a queue using two stacks

            Required operations:
            enqueue(x) → insert element
            dequeue() → remove element
            peek() → get front element
            🟡 2. Key Concept

            👉 Difference between data structures:

            Structure	Behavior
            Stack	LIFO (Last In First Out)
            Queue	FIFO (First In First Out)
            🟡 3. Challenge

            👉 Stack gives:

            Remove from top

            👉 Queue needs:

            Remove from front
            🟡 4. Key Idea

            👉 Use two stacks:

            stackEnqueue → for adding elements
            stackDequeue → for removing elements
            🟡 5. Core Logic
            🔹 Enqueue (add element)
            Just push into stackEnqueue
            🔹 Dequeue / Peek

            👉 If stackDequeue is empty:

            Move all elements from stackEnqueue → stackDequeue

            👉 This reverses order → gives FIFO behavior

            🟡 6. Why this works?
            Example:
            Enqueue: 1, 2, 3

            stackEnqueue: [1, 2, 3] (top = 3)

            Transfer → stackDequeue:
            [3, 2, 1] → top = 1

            Now dequeue → 1 (correct FIFO)
            🟡 7. Algorithm
            enqueue(x):
            Push to stackEnqueue
            dequeue():
            If stackDequeue is empty:
            Transfer all elements from stackEnqueue
            Pop from stackDequeue
            peek():
            Same as dequeue but return top without removing
            🟡 8. Solution (Code Implementation)
            import java.util.Stack;

            public class QueueViaStacks<E> {

                private Stack<E> stackEnqueue;
                private Stack<E> stackDequeue;

                public QueueViaStacks() {
                    stackEnqueue = new Stack<>();
                    stackDequeue = new Stack<>();
                }

                // ENQUEUE
                public void enqueue(E value) {
                    stackEnqueue.push(value);
                }

                // DEQUEUE
                public E dequeue() {
                    shiftStacks();
                    return stackDequeue.pop();
                }

                // PEEK
                public E peek() {
                    shiftStacks();
                    return stackDequeue.peek();
                }

                // SIZE
                public int size() {
                    return stackEnqueue.size() + stackDequeue.size();
                }

                // Helper function
                private void shiftStacks() {
                    if (stackDequeue.isEmpty()) {
                        while (!stackEnqueue.isEmpty()) {
                            stackDequeue.push(stackEnqueue.pop());
                        }
                    }
                }
            }
            🟡 9. Complexity Analysis
            ⏱ Time Complexity:
            enqueue → O(1)
            dequeue → amortized O(1)
            peek → amortized O(1)
            🧠 Space Complexity:
            O(n)
            🟡 10. Key Insight (VERY IMPORTANT)

            👉 We don’t reverse every time

            We reverse only:

            When stackDequeue is empty

            🟡 11. Common Mistakes

            ❌ Reversing on every dequeue → O(n²)
            ❌ Not checking if dequeue stack is empty
            ❌ Forgetting FIFO logic
            ❌ Mixing push/pop directions

            🟡 12. Interview Tip

            This problem tests:

            Understanding of stack vs queue
            Ability to simulate one DS using another
            Optimization thinking (amortized analysis)
            🟡 13. Follow-up Questions

            Interviewer may ask:

            Can you do this with one stack?
            What is amortized complexity?
            Can you implement queue using recursion?
            🟡 14. Summary

            👉 Problem:

            Implement queue using stacks

            👉 Solution:

            Use two stacks
            One for input
            One for output

            👉 Trick:

            Reverse only when needed

            If you want, I can next:

            Show step-by-step dry run
            Compare with stack via queues
            Give real interview variations
 */
    public static void main(String[] args) {

        MyQueueViaStack<Integer> stack = new MyQueueViaStack();

        stack.enqueue(25);
        stack.enqueue(35);
        stack.enqueue(15);

        System.out.println("Size: " + stack.size());
        System.out.println("Peek: " + stack.peek());
        System.out.println("Size: " + stack.size());
        System.out.println("Pop: " + stack.dequeue());
        System.out.println("Size: " + stack.size());
        System.out.println("Peek: " + stack.peek());
        System.out.println("Size: " + stack.size());
        System.out.println("Push 17");
        stack.enqueue(17);
        System.out.println("Peek: " + stack.peek());
        System.out.println("Size: " + stack.size());
        System.out.println("Pop: " + stack.dequeue());
        System.out.println("Size: " + stack.size());
        System.out.println("Pop: " + stack.dequeue());
        System.out.println("Size: " + stack.size());
        System.out.println("Push 55");
        stack.enqueue(55);
        System.out.println("Size: " + stack.size());
        System.out.println("Peek: " + stack.peek());
        System.out.println("Size: " + stack.size());
        System.out.println("Pop: " + stack.dequeue());
        System.out.println("Size: " + stack.size());
        System.out.println("Pop: " + stack.dequeue());
        System.out.println("Size: " + stack.size());             
    }
}
