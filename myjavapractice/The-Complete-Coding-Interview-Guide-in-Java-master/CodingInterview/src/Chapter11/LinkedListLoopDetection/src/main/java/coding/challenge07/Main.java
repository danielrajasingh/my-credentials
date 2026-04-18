package Chapter11.LinkedListLoopDetection.src.main.java.coding.challenge07;
 
public class Main {
/*
Here’s your complete interview-ready breakdown for Loop Start Detection in Linked List 👇

✅ 1. What is the Question?

👉 Given a singly linked list, where:

A loop exists (tail connects back to some earlier node)

👉 Task:

Find the starting node of the loop
📌 Example:
1 → 2 → 3 → 4 → 5
          ↑       ↓
          ← ← ← ←

👉 Loop starts at node 3

🔍 2. Clear Analysis
❌ Naive ideas:
Use hash set → detect repetition (extra space O(n))
Count nodes → not reliable if loop exists
✅ Best Approach: Floyd’s Cycle Detection

👉 Also called:
Fast Runner / Slow Runner technique

Core Idea:

We use two pointers:

🐢 Slow → moves 1 step
🐇 Fast → moves 2 steps
Key insight:
If loop exists → they WILL meet
After meeting:
Move one pointer to head
Move both 1 step each
Where they meet again → loop start
💡 3. Solution Idea
Step 1: Detect cycle
Move slow (1 step)
Move fast (2 steps)
If they meet → cycle exists
Step 2: Find loop start
Move slow → back to head
Move both slow & fast 1 step
Meeting point = loop start
⚙️ 4. Solution Implementation
public Node findLoopStart(Node head) {

    Node slow = head;
    Node fast = head;

    // Step 1: detect cycle
    while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;

        if (slow == fast) {
            break;
        }
    }

    // no loop
    if (fast == null || fast.next == null) {
        return null;
    }

    // Step 2: find loop start
    slow = head;

    while (slow != fast) {
        slow = slow.next;
        fast = fast.next;
    }

    return slow; // loop start node
}
🧠 5. One-Line Memory Trick

👉 “Meet inside loop → reset one pointer → move both 1 step → meet at loop start.”

🧪 6. Dry Run Example
Input:
1 → 2 → 3 → 4 → 5
          ↑       ↓
          ← ← ← ←

Loop starts at 3

🔹 Step 1: Movement until meeting
Step	Slow	Fast
1	1	2
2	2	4
3	3	6(loop)
4	4	3
5	5	5

👉 They meet inside loop at node 5

🔹 Step 2: Reset slow to head
slow = 1
fast = 5
🔹 Step 3: Move both 1 step
Step	Slow	Fast
1	1 → 2	5 → 3
2	2 → 3	3 → 4

👉 They meet at 3

✅ Result:
Loop start = 3
🎨 7. Mental Visualization
🔹 Phase 1: Detect collision
1 → 2 → 3 → 4 → 5
          ↑       ↓
          ← ← ← ←

🐢 slow
        🐇 fast

👉 Fast catches slow inside loop

🔹 Phase 2: Reset slow
slow → head
fast → meeting point
🔹 Phase 3: Move together
slow → → →
fast → → →
🔹 Final meeting
        (loop start)
             3
⚡ 8. Key Insight

👉 Distance logic:

Fast moves 2x speed
They guarantee collision inside cycle
Reset trick converts cycle detection → cycle entry detection
🎯 Interview Gold Explanation

Say this:

👉 “Floyd’s cycle detection first finds a meeting point inside the loop. Then we reset one pointer to head and move both pointers one step at a time. They meet at the loop starting node because of equal distance properties inside the cycle.”

🚀 Final Summary
Detect cycle → O(n)
Find loop start → O(n)
Space → O(1)
Technique → Fast & Slow pointers

If you want next level 🔥
I can show:

🔥
Why mathematical proof works (distance equation)
🔥
Variations (find loop length, remove loop)
🔥
Interview trick questions they ask after this

Just tell me 👍
 */
    public static void main(String[] args) {

        SinglyLinkedList sll = new SinglyLinkedList();

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
        sll.insertFirst(0);

        sll.generateLoop();
        sll.print();
        
        sll.findLoopStartNode();
    }

}
