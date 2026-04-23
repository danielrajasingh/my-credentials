package medium;

import java.util.*;

public class MinStack {
    /* Problem: Min Stack | Link: https://leetcode.com/problems/min-stack
    Difficulty: Medium | Topic: Stack, Design | Stack with min query.
    APPROACH: Dual stack tracking values and mins. O(1). */

    static class MinStackImpl {
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> minStack = new Stack<>();

        void push(int val) {
            stack.push(val);
            minStack.push(Math.min(minStack.isEmpty() ? val : minStack.peek(), val));
        }

        void pop() {
            stack.pop();
            minStack.pop();
        }

        int top() { return stack.peek(); }
        int getMin() { return minStack.peek(); }
    }

    public static void main(String[] args) {
        MinStackImpl ms = new MinStackImpl();
        ms.push(-2);
        ms.push(0);
        ms.push(-3);
        System.out.println("Min: " + ms.getMin());
        System.out.println("Expected: -3\n");
    }
}
