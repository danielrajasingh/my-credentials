package Chapter11.ReverseLinkedListInGroups.src.main.java.coding.challenge15;
 
public class Main {
/*
Let’s break “Reverse Linked List in K Groups” in a very clear and visual way.

🧩 1. What is the Question?

👉 You are given:

A singly linked list
An integer k
🎯 Task:

👉 Reverse the list in groups of k nodes

Problem: Consider a singly linked list and an integer, k. Write a snippet of code that
reverses the linked list's nodes in k groups

Example:
Input:
7 → 4 → 3 → 1 → 8 → 2 → 9 → 0 → null
k = 3
Output:
3 → 4 → 7 → 2 → 8 → 1 → 0 → 9 → null
🔍 2. Clear Analysis (Simple Thinking)
🧠 Key Idea:

👉 We don’t reverse the whole list
👉 We reverse it chunk by chunk (k nodes at a time)

📌 Break it like this:
[7 → 4 → 3]   [1 → 8 → 2]   [9 → 0]
   reverse       reverse       reverse
After reversing each group:
[3 → 4 → 7] → [2 → 8 → 1] → [0 → 9]
⚙️ 3. Solution Idea

👉 For each group of k:

Reverse k nodes
Connect to next reversed group using recursion
💻 4. Solution Implementation
public Node reverseInKGroups(Node head, int k) {

    if (head == null) return null;

    Node current = head;
    Node prev = null;
    Node next = null;

    int count = 0;

    // Step 1: Reverse k nodes
    while (current != null && count < k) {
        next = current.next;   // store next
        current.next = prev;   // reverse link
        prev = current;        // move prev
        current = next;        // move current
        count++;
    }

    // Step 2: Recursively process remaining list
    if (next != null) {
        head.next = reverseInKGroups(next, k);
    }

    // Step 3: prev becomes new head of this group
    return prev;
}
🧠 5. One-Line Memory Trick

👉 “Reverse k nodes → connect → repeat.”

🧪 6. Dry Run Example
Input:
7 → 4 → 3 → 1 → 8 → 2 → 9 → 0
k = 3
🔹 Step 1: First group
7 → 4 → 3
↓ reverse
3 → 4 → 7
🔹 Step 2: Second group
1 → 8 → 2
↓ reverse
2 → 8 → 1
🔹 Step 3: Third group
9 → 0
↓ reverse
0 → 9
🔗 Final connection:
3 → 4 → 7 → 2 → 8 → 1 → 0 → 9
🎨 7. Mental Visualization

Think like train compartments 🚆

Before:
[7][4][3] [1][8][2] [9][0]
Step 1:
[3][4][7] [2][8][1] [0][9]
Then connect all:
3 → 4 → 7 → 2 → 8 → 1 → 0 → 9
🧠 Super Simple Intuition

👉 Imagine breaking a chain into small chunks
👉 Flip each chunk
👉 Rejoin them

🚨 Common Mistakes

❌ Reversing entire list at once
❌ Forgetting recursion step
❌ Not connecting last node of group to next group

⚡ Key Insight
Step	Meaning
Pick k nodes	form group
Reverse group	local reversal
Connect groups	recursion
🚀 Final Summary

👉 This problem = repeated mini-reversal + linking

If you want, I can next show:

🎬 Animation step-by-step pointer movement
🧱 Visual stack simulation (how recursion works)
🔥 Iterative version (no recursion, interview favorite)

Just tell 👍
 */
    public static void main(String[] args) {

       SinglyLinkedList sll = new SinglyLinkedList();              
       
       sll.insertFirst(0);       
       sll.insertFirst(9);       
       sll.insertFirst(2);       
       sll.insertFirst(8);       
       sll.insertFirst(1);
       sll.insertFirst(3);
       sll.insertFirst(4);
       sll.insertFirst(7);
              
       sll.print();
       
       sll.reverseInKGroups(3);
       
       sll.print();       
    }

}
