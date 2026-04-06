package Chapter12.StackViaQueue.src.main.java.coding.challenge07;
 
public class Main {
/*
Let’s go step-by-step and make this very clear + interview-ready.

🟡 1. What is the question?

👉 You are asked to:

Implement a Stack using two Queues

Required operations:
push(x) → insert element
pop() → remove top element
peek() → return top element
🟡 2. Core Difference
Data Structure	Behavior
Stack	LIFO (Last In First Out)
Queue	FIFO (First In First Out)
🟡 3. Challenge

👉 Queue removes from front
👉 Stack removes from top (last inserted)

🟡 4. Key Idea

To simulate LIFO using FIFO:

When popping/peeking →
move all elements except the last one

🟡 5. Approach (Two Queues)

Use:

queue1
queue2
🟡 6. How it works
🔹 push(x)

👉 Simply add to the non-empty queue

Push is easy → O(1)
🔹 pop()

👉 Steps:

Move all elements except last → other queue
Remove last element → this is stack top
Swap roles of queues
🔹 peek()

👉 Same as pop, but:

Don’t delete last element
Store it temporarily
🟡 7. Important Optimization

👉 Instead of moving elements back and forth:

Always use:

One queue = active
One queue = helper
🟡 8. Simple & Clean Implementation (Recommended)

👉 This is the clean interview version (easier than book version)

import java.util.*;

public class StackViaQueues {

    private Queue<Integer> q1 = new LinkedList<>();
    private Queue<Integer> q2 = new LinkedList<>();

    // PUSH
    public void push(int x) {
        q1.add(x);
    }

    // POP
    public int pop() {
        if (q1.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }

        // Move all except last
        while (q1.size() > 1) {
            q2.add(q1.poll());
        }

        int top = q1.poll(); // last element

        // swap queues
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;

        return top;
    }

    // PEEK
    public int peek() {
        if (q1.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }

        while (q1.size() > 1) {
            q2.add(q1.poll());
        }

        int top = q1.poll();
        q2.add(top); // put it back

        // swap queues
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;

        return top;
    }

    public boolean isEmpty() {
        return q1.isEmpty();
    }
}
🟡 9. Complexity Analysis
⏱ Time:
push → O(1)
pop → O(n)
peek → O(n)
🧠 Space:
O(n)
🟡 10. Alternative Approach (Push Costly)

👉 Instead:

Make push() costly → O(n)
pop() becomes O(1)
Idea:
During push:
Insert into empty queue
Move all previous elements behind it
🟡 11. Key Insight

👉 To simulate stack:

We must always access the last inserted element

Since queues don’t support that:
👉 We reorder elements manually

🟡 12. Common Mistakes

❌ Forgetting to swap queues
❌ Losing elements during transfer
❌ Incorrect peek logic
❌ Not handling empty case

🟡 13. Interview Tip

This problem tests:

Deep understanding of DS behavior
Ability to simulate one structure using another
Trade-offs (push costly vs pop costly)
🟡 14. Summary

👉 Problem:

Build stack using queues

👉 Trick:

Move elements to expose last inserted

👉 Best approach:

Two queues + transfer logic
🟡 15. Comparison (Very Important)
Problem	Trick
Queue via stacks	Reverse once
Stack via queues	Move all except last

If you want next, I can:

Show dry run step-by-step
Compare all stack/queue conversions
Give tricky interview variations
 */
    public static void main(String[] args) {

        MyStackViaQueue<Integer> stack = new MyStackViaQueue();

        stack.push(25);
        stack.push(35);
        stack.push(15);

        System.out.println("Size: " + stack.size());
        System.out.println("Peek: " + stack.peek());
        System.out.println("Size: " + stack.size());
        System.out.println("Pop: " + stack.pop());
        System.out.println("Size: " + stack.size());
        System.out.println("Peek: " + stack.peek());
        System.out.println("Peek: " + stack.peek());
        System.out.println("Size: " + stack.size());
        System.out.println("Push 17");
        stack.push(17);
        System.out.println("Push 12");
        stack.push(12);
        System.out.println("Peek: " + stack.peek());
        System.out.println("Peek: " + stack.peek());
        System.out.println("Size: " + stack.size());
        System.out.println("Pop: " + stack.pop());
        System.out.println("Size: " + stack.size());
        System.out.println("Pop: " + stack.pop());
        System.out.println("Size: " + stack.size());
        System.out.println("Push 55");
        stack.push(55);
        System.out.println("Size: " + stack.size());
        System.out.println("Peek: " + stack.peek());
        System.out.println("Peek: " + stack.peek());
        System.out.println("Size: " + stack.size());
        System.out.println("Pop: " + stack.pop());
        System.out.println("Size: " + stack.size());
        System.out.println("Pop: " + stack.pop());
        System.out.println("Size: " + stack.size());
        System.out.println("Peek: " + stack.peek());
        System.out.println("Pop: " + stack.pop());
        System.out.println("Size: " + stack.size());
    }
}
