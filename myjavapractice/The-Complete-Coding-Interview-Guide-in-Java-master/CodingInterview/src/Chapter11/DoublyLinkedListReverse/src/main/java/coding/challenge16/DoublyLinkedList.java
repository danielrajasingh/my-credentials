package Chapter11.DoublyLinkedListReverse.src.main.java.coding.challenge16;
 
public final class DoublyLinkedList {
/*
Let’s break Reverse a Doubly Linked List in a very simple + visual way.

🧩 1. What is the Question?

👉 You are given a doubly linked list, where each node has:

next → forward link
prev → backward link
🎯 Task:

👉 Reverse the entire list

Problem: Consider a doubly linked list. Write a snippet of code that reverses its nodes.

Example:
Forward:
1 ⇄ 2 ⇄ 3 ⇄ 4 ⇄ null
Output:
4 ⇄ 3 ⇄ 2 ⇄ 1 ⇄ null
🔍 2. Clear Analysis
🧠 Key Idea:

In a doubly linked list:

Each node has two pointers
So reversing is just swapping pointers
📌 Trick:

For every node:

swap(next, prev)
After swapping:
What was going forward becomes backward
What was backward becomes forward
⚙️ 3. Solution Idea

👉 Steps:

Go node by node
Swap next and prev
Move using updated prev (because pointers are swapped)
At end → update head
💻 4. Solution Implementation
public void reverse() {

    Node current = head;
    Node temp = null;

    while (current != null) {

        // Step 1: swap prev and next
        temp = current.prev;
        current.prev = current.next;
        current.next = temp;

        // Step 2: move to next node (which is prev after swap)
        current = current.prev;
    }

    // Step 3: fix head
    if (temp != null) {
        head = temp.prev;
    }
}
🧠 5. One-Line Memory Trick

👉 “Swap left and right pointers, then move backward.”

🧪 6. Dry Run Example
Input:
1 ⇄ 2 ⇄ 3 ⇄ 4
🔹 Step 1 (node 1)
swap(1): next ↔ prev
1 becomes reversed direction
🔹 Step 2 (node 2)
swap(2): next ↔ prev
🔹 Step 3 (node 3)
swap(3): next ↔ prev
🔹 Step 4 (node 4)
swap(4): next ↔ prev
✅ Final list:
4 ⇄ 3 ⇄ 2 ⇄ 1
🎨 7. Mental Visualization

Think like train wagons 🚆 with two hooks

Before:
1 ⇄ 2 ⇄ 3 ⇄ 4

Each wagon has:

front hook (next)
back hook (prev)
Action:

👉 Flip each wagon’s direction

swap hooks for all wagons
After:
4 ⇄ 3 ⇄ 2 ⇄ 1
⚡ Key Insight
Step	Meaning
swap pointers	reverse direction
move using prev	because links flipped
update head	last becomes first
🚨 Common Mistakes

❌ Forgetting to swap both pointers
❌ Moving using next after swap
❌ Not updating head at end

🧠 Super Simple Understanding

👉 You are NOT reversing data
👉 You are just flipping directions

🚀 Final Summary

👉 Doubly linked list reversal =

Swap next & prev for every node + update head

If you want next level understanding, I can show:

🎬
step-by-step animation of pointer movement
🧱
memory diagram (how prev/next change in heap)
🔥
comparison: singly vs doubly reversal (very interview important)

Just tell 👍
 */
    private final class Node {

        private int data;
        private Node next;
        private Node prev;

        @Override
        public String toString() {
            return " " + data + " ";
        }
    }

    private Node head;

    public void insertFirst(int data) {

        Node newNode = new Node();

        newNode.data = data;
        newNode.next = head;

        if (head != null) {
            head.prev = newNode;
        }

        head = newNode;
    }

    public void reverse() {

        Node currentNode = head;
        Node prevNode = null;

        while (currentNode != null) {

            // swap next and prev pointers of the current node
            Node prev = currentNode.prev;
            currentNode.prev = currentNode.next;
            currentNode.next = prev;

            // update the previous node before moving to the next node
            prevNode = currentNode;

            // move to the next node in the doubly linked list            
            currentNode = currentNode.prev;
        }

        // update the head to point to the last node
        if (prevNode != null) {
            head = prevNode;
        }
    }

    public void print() {

        System.out.println("\nHead (" + head + ") ----------> Last:");

        Node currentNode = head;
        while (currentNode != null) {

            System.out.print(currentNode);
            currentNode = currentNode.next;
        }

        System.out.println();
    }
}
