package Chapter11.LinkedListMoveLastToFront.src.main.java.coding.challenge14;

public class Main {
/*
Let’s break this down in a very clear + visual + step-by-step way so you fully understand it.

🧩 1. What is the Question?

👉 Given a singly linked list, you must:

Take the last node
Move it to the front (head)

Problem: Consider a singly linked list. Write a snippet of code that moves the last node to
the front via two approaches. So, the last node of the linked list becomes its head.


Example:
Before:
1 → 2 → 3 → 4 → null

After:
4 → 1 → 2 → 3 → null
🔍 2. Clear Analysis (How to think)
🧠 Key idea:

We need to:

Find second last node
Detach last node
Move it to front
📌 Why second last node?

Because:

We need to break link before last node
So we must know who is before last
⚙️ 3. Solution Idea

We do 4 steps:

Step 1:

👉 Go to second last node

Step 2:

👉 Save last node

Step 3:

👉 Remove last node from end

Step 4:

👉 Attach last node at front

💻 4. Solution Implementation
Approach 1 (Simple)
public void moveLastToFront() {

    Node current = head;

    // Step 1: go to second last node
    while (current.next.next != null) {
        current = current.next;
    }

    // Step 2: last node
    Node last = current.next;

    // Step 3: detach last node
    current.next = null;

    // Step 4: move it to front
    last.next = head;
    head = last;
}
🧠 5. One-Line Memory Trick

👉 “Cut last → attach front.”

🧪 6. Dry Run Example
Input:
1 → 2 → 3 → 4 → null
🔹 Step 1: Find second last
1 → 2 → 3 → 4
          ↑
       current (3)
🔹 Step 2: Save last
last = 4
🔹 Step 3: Break link
1 → 2 → 3 → null
🔹 Step 4: Attach at front
4 → 1 → 2 → 3 → null
🎨 7. Mental Visualization

Think like train coaches 🚆

Before:
[1]—[2]—[3]—[4]
Action:

👉 Remove last coach (4)

[1]—[2]—[3]   +   [4]
Attach at front:
[4]—[1]—[2]—[3]
🔥 Second Approach (Concept)

Instead of breaking first:

👉 Make it circular temporarily

1 → 2 → 3 → 4 → back to 1

Then:

Move head to 4
Break link after 3
⚡ Key Insight
Step	Meaning
Find second last	locate break point
detach last	isolate node
attach front	rewire head
🚨 Common Mistakes

❌ Not handling 1 node list
❌ Not stopping at second last node
❌ Forgetting to set current.next = null

🧠 Final Simple Understanding

👉 You are just doing:

Take last node
Remove it
Put it in front

If you want next level understanding, I can also show:

🎬
animation of pointer movement step-by-step
🧱
memory diagram (heap view)
🔥
trick to do this in one traversal

Just tell 👍
 */
    public static void main(String[] args) {

        SinglyLinkedList sll = new SinglyLinkedList();

        sll.insertFirst(7);
        sll.insertFirst(10);
        sll.insertFirst(3);
        sll.insertFirst(9);
        sll.insertFirst(1);

        System.out.println("\nInitial:");
        sll.print();

        sll.moveLastToFront1();
        // sll.moveLastToFront2();

        System.out.println("\nResult:");
        sll.print();
    }

}
