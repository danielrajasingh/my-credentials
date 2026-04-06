package Chapter12.StackOfPlates.src.main.java.coding.challenge03;
 
public class Main {
/*
Let’s break this down clearly—this is a classic system design + data structure problem.

🟡 1. What is the question?

You are given a scenario:

You have stacks of plates
Each stack has a fixed capacity (n)

👉 Your task:

When one stack exceeds capacity → create a new stack
But overall, the system should behave like one single stack
You must implement:
push(value) → push element
pop() → remove top element
popAt(stackIndex) → pop from a specific stack
🟡 2. Real-world intuition

Think of:

Plates stacked in piles in a kitchen

Each pile has a limit (e.g., 3 plates)
When full → start a new pile
But user thinks it's one big stack
🟡 3. Key Idea

👉 Use:

List of stacks (LinkedList or ArrayList)

Each node = one stack

🟡 4. Data Structure Design
[ Stack1 ] → [ Stack2 ] → [ Stack3 ]

Each stack has:

Max size = capacity
🟡 5. Operations Breakdown
🔹 push(value)
Logic:
If no stack OR last stack is full:
Create new stack
Else:
Push into last stack
🔹 pop()
Logic:
Pop from last stack
If empty → remove that stack
🔹 popAt(index)
Logic:
Pop from specific stack
Then shift elements left:
Take bottom of next stack → move to current
Repeat
🟡 6. Important Challenge

👉 After popAt, stacks become uneven

So we must:

Shift elements from next stacks

🟡 7. Solution (Code Implementation)
import java.util.*;

public class StackOfPlates {

    private static final int CAPACITY = 3;
    private List<Stack<Integer>> stacks = new ArrayList<>();

    // PUSH
    public void push(int value) {
        if (stacks.isEmpty() || stacks.get(stacks.size() - 1).size() == CAPACITY) {
            Stack<Integer> newStack = new Stack<>();
            newStack.push(value);
            stacks.add(newStack);
        } else {
            stacks.get(stacks.size() - 1).push(value);
        }
    }

    // POP
    public int pop() {
        if (stacks.isEmpty()) {
            throw new EmptyStackException();
        }

        Stack<Integer> last = stacks.get(stacks.size() - 1);
        int value = last.pop();

        if (last.isEmpty()) {
            stacks.remove(stacks.size() - 1);
        }

        return value;
    }

    // POP AT INDEX
    public int popAt(int index) {
        if (index < 0 || index >= stacks.size()) {
            throw new IndexOutOfBoundsException();
        }

        int value = stacks.get(index).pop();
        shiftLeft(index);

        return value;
    }

    // SHIFT ELEMENTS LEFT
    private void shiftLeft(int index) {
        for (int i = index; i < stacks.size() - 1; i++) {
            Stack<Integer> current = stacks.get(i);
            Stack<Integer> next = stacks.get(i + 1);

            // remove bottom element from next stack
            int bottom = next.remove(0);
            current.push(bottom);

            if (next.isEmpty()) {
                stacks.remove(i + 1);
                break;
            }
        }
    }
}
🟡 8. Complexity Analysis
⏱ push:
O(1)
⏱ pop:
O(1)
⏱ popAt:
O(n) (due to shifting)
🧠 Space:
O(n)
🟡 9. Key Insights
🔑 Use list of stacks
🔑 Treat last stack as main stack
🔑 Handle overflow by creating new stack
🔑 Handle popAt with shifting logic
🟡 10. Common Mistakes

❌ Not removing empty stacks
❌ Forgetting to shift elements after popAt
❌ Using wrong index handling
❌ Ignoring bottom element movement

🟡 11. Interview Tip

This problem tests:

System design thinking
Stack behavior understanding
Edge case handling
Clean abstraction
🟡 12. Follow-up Questions (Very Important)

Interviewer may ask:

Can you optimize shifting?
What if stacks are very large?
Can you use Deque instead of Stack?
🟡 13. Summary

👉 Problem:

Multiple stacks behaving as one

👉 Approach:

Use list of stacks

👉 Special case:

popAt() requires shifting

If you want, I can next:

Draw step-by-step example
Optimize using Deque (better design)
Give LeetCode version (SetOfStacks)
 */
    public static void main(String[] args) {

        MyStack stack = new MyStack();

        stack.push(25);
        stack.push(35);
        stack.push(15);
        stack.push(-1);
        stack.push(-3);
        stack.push(6);
        stack.push(2);
        stack.push(12);

        stack.printStacks();
        
        System.out.println("\n\nPop from stack 1: " + stack.popAt(1));
        
        stack.printStacks();
        
        System.out.println("\n\nPop from stack 0: " + stack.popAt(0));
        
        stack.printStacks();
    }

}
