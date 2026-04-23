package medium;

import java.util.Queue;
import java.util.LinkedList;

public class ImplementStackUsingQueues {
    /*
    ========================================
    Problem: Implement Stack using Queues
    Link: https://leetcode.com/problems/implement-stack-using-queues
    Difficulty: Medium
    Topic: Stack, Queue, Design
    ========================================
    
    PROBLEM EXPLANATION:
    Implement a Last-In-First-Out (LIFO) stack using only Queue data structure.
    Queue is FIFO (First-In-First-Out), opposite of Stack (LIFO).
    
    Need to implement:
    - push(int x): Add element to stack
    - pop(): Remove and return top element
    - top(): Return top element without removing
    - empty(): Check if stack is empty
    
    KEY OBSERVATIONS:
    - Queue: elements leave from front, enter from rear (FIFO)
    - Stack: elements leave from back/top (LIFO)
    - To simulate LIFO using FIFO, need clever repositioning
    - Two approaches: (1) Use one queue with rotation, (2) Use two queues
    
    APPROACH (One Queue):
    - Push: add element to queue (rear)
    - Pop: move all n-1 elements to rear (rotate), then poll front (this was top)
    - Top: find element that would be top (rotation logic)
    - Empty: check if queue is empty
    
    TIME COMPLEXITY:
    - Push: O(1)
    - Pop: O(n) - need to rotate n-1 elements
    - Top: O(n)
    - Empty: O(1)
    
    SPACE COMPLEXITY: O(n) - for queue elements
    
    DRY RUN:
    Push 1: queue = [1]
    Push 2: queue = [1, 2]
    Push 3: queue = [1, 2, 3]
    Pop:    rotate [1, 2] to end → queue = [2, 3, 1], poll → 3, queue = [2, 3]
    Top:    queue = [2, 3], top is 3 (last element after rotation)
    
    MEMORY TRICK:
    "Queue stores stack: for pop, rotate (n-1) then take front"
    
    VISUALIZATION:
    Push 1, 2, 3:  Queue front→[1, 2, 3]←rear
                   (rear is top of stack)
    Pop: Move 1,2 to rear: [2, 3, 1], remove front: [2, 3]
    Now rear (3) is new top
    */

    static class MyStack {
        private Queue<Integer> queue;

        public MyStack() {
            queue = new LinkedList<>();
        }

        public void push(int x) {
            queue.add(x);
        }

        public int pop() {
            // Rotate queue n-1 times to bring last element to front
            int size = queue.size();
            for (int i = 0; i < size - 1; i++) {
                queue.add(queue.poll());
            }
            return queue.poll();
        }

        public int top() {
            // Rotate queue n-1 times, peek front, then rotate back to restore
            int size = queue.size();
            for (int i = 0; i < size - 1; i++) {
                queue.add(queue.poll());
            }
            int topElement = queue.peek();
            queue.add(queue.poll()); // Rotate one more to restore position
            return topElement;
        }

        public boolean empty() {
            return queue.isEmpty();
        }
    }

    public static void main(String[] args) {
        MyStack stack = new MyStack();
        
        System.out.println("Creating stack and performing operations:");
        System.out.println("Push 1, 2, 3");
        stack.push(1);
        stack.push(2);
        stack.push(3);
        
        System.out.println("Top: " + stack.top() + " (expected: 3)");
        
        System.out.println("Pop: " + stack.pop() + " (expected: 3)");
        
        System.out.println("Empty: " + stack.empty() + " (expected: false)");
        
        System.out.println("\nPop: " + stack.pop() + " (expected: 2)");
        System.out.println("Top: " + stack.top() + " (expected: 1)");
        
        System.out.println("Pop: " + stack.pop() + " (expected: 1)");
        System.out.println("Empty: " + stack.empty() + " (expected: true)");
    }
}
