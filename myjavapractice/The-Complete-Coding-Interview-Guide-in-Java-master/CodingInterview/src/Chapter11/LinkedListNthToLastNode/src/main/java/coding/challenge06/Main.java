package Chapter11.LinkedListNthToLastNode.src.main.java.coding.challenge06;
 
public class Main {
/*
Here’s your complete interview-style breakdown for Nth to Last Node in Linked List 👇

✅ 1. What is the Question?

👉 Given:

A singly linked list
An integer n

👉 Task:

Return the nth node from the end (nth to last node)
📌 Example:
2 → 1 → 5 → 9 → 8 → 3 → 7 → null
n = 5

👉 5th from last = 5

🔍 2. Clear Analysis
❌ Brute Force Idea:
Count total nodes → then find (length - n)
Requires 2 passes
✅ Optimal Idea:

👉 Use two pointers (Runner technique)

Core Insight:
Move first pointer n steps ahead
Then move both pointers together
When first reaches null → second is answer
Why it works:

👉 Maintains a fixed gap of n nodes

💡 3. Solution Idea
Steps:
Initialize two pointers:
firstRunner
secondRunner
Move firstRunner ahead by n steps
Move both together until:
firstRunner == null
Return secondRunner
⚙️ 4. Solution Implementation
public int nthToLastIterative(int n) {

    Node firstRunner = head;
    Node secondRunner = head;

    // Step 1: move first pointer n steps ahead
    for (int i = 0; i < n; i++) {
        if (firstRunner == null) {
            throw new IllegalArgumentException("n is out of bounds");
        }
        firstRunner = firstRunner.next;
    }

    // Step 2: move both together
    while (firstRunner != null) {
        firstRunner = firstRunner.next;
        secondRunner = secondRunner.next;
    }

    return secondRunner.data;
}
🧠 5. One-Line Memory Trick

👉 “Move first n steps, then move both until end.”

🧪 6. Dry Run Example
Input:
List:
2 → 1 → 5 → 9 → 8 → 3 → 7

n = 5
🔹 Step 1: Move firstRunner 5 steps
Step	firstRunner
0	2
1	1
2	5
3	9
4	8

👉 Now:

firstRunner = 3
secondRunner = 2
🔹 Step 2: Move both together
Step	firstRunner	secondRunner
1	7	1
2	null	5
✅ Result:
secondRunner = 5
🎨 7. Mental Visualization
🔹 Step 1: Create a gap of n
2 → 1 → 5 → 9 → 8 → 3 → 7
↑            ↑
s            f   (gap = 5)
🔹 Step 2: Move both together
2 → 1 → 5 → 9 → 8 → 3 → 7
      s              f
🔹 Step 3: When first hits null
2 → 1 → 5 → 9 → 8 → 3 → 7
          s        (answer)
⚡ 8. Key Insight

👉 Instead of counting length:

You maintain a fixed distance of n between two pointers
🎯 Interview Gold Statement

Say this:

👉 “This is a two-pointer (runner) technique. One pointer is moved n steps ahead, then both pointers move together until the first reaches null, making the second pointer the nth from last.”

🚀 Final Summary
Time → O(n)
Space → O(1)
Technique → Two pointers (fast + slow gap)

If you want next level 🔥
I can show:

🔥
Recursive solution (interview favorite)
🔥
Find middle + kth from end combo trick
🔥
Edge cases (n=0, n > length)
🔥
Visual animation-style explanation

Just tell me 👍
 */
    public static void main(String[] args) {        

        SinglyLinkedList sll = new SinglyLinkedList();

        sll.insertFirst(11);
        sll.insertFirst(10);
        sll.insertFirst(9);
        sll.insertFirst(8);
        sll.insertFirst(7);
        sll.insertFirst(6);
        sll.insertFirst(5);
        sll.insertFirst(4);
        sll.insertFirst(3);
        sll.insertFirst(2);
        sll.insertFirst(1);

        sll.print();

        int n = 1;
        int resultIterative = sll.nthToLastIterative(n);
        int resultRecursive = sll.nthToLastRecursive(n);

        System.out.println("\nIterative: The " + n + "th to last node has the value: " + resultIterative);
        System.out.println("\nRecursive: The " + n + "th to last node has the value: " + resultRecursive);

    }

}
