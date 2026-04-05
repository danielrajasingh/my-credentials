package Chapter14.MergeSortDoublyLinkedList.src.main.java.coding.challenge;

public class Main {
/*
Let’s go step by step: Question → Analysis → Solution → Implementation

✅ 1. What is the Question?

You are given:

👉 A singly linked list

Your task:

👉 Sort the linked list using Merge Sort

🔹 Important Constraints
Use Merge Sort algorithm
You should work with a linked list (not arrays)
Output should be a sorted linked list
🔹 Example
Input:  2 → 1 → 4 → 9 → 8 → 3 → 7 → null

Output: 1 → 2 → 3 → 4 → 7 → 8 → 9 → null
🧠 2. Clear Analysis of the Problem
🔹 Why Merge Sort?

Merge Sort is ideal for linked lists because:

Linked lists don’t support random access
Merge Sort:
Works with divide and conquer
Does not require index-based access
Efficient for linked structures
🔹 Core Steps of Merge Sort
Divide
Split the linked list into two halves
Conquer
Recursively sort both halves
Merge
Merge two sorted linked lists
🔹 Key Techniques Used
1. Fast & Slow Pointer (to find middle)
Slow pointer → moves 1 step
Fast pointer → moves 2 steps
When fast reaches end → slow is at middle
2. Recursive Sorting
Base case:
0 or 1 node → already sorted
Otherwise:
Split → sort → merge
3. Merge Two Sorted Lists
Compare nodes
Attach smaller node
Continue recursively
🔹 Time Complexity
O(n log n)
💡 3. Solution Approach
Step-by-step:
If list has:
0 or 1 node → return it
Find the middle using fast/slow pointer
Split into:
Left half
Right half
Recursively sort both halves
Merge both sorted halves
💻 4. Implementation (Java)
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class MergeSortLinkedList {

    public Node sort(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        // Step 1: Split the list
        Node middle = getMiddle(head);
        Node nextOfMiddle = middle.next;
        middle.next = null;

        // Step 2: Recursively sort both halves
        Node left = sort(head);
        Node right = sort(nextOfMiddle);

        // Step 3: Merge sorted halves
        return merge(left, right);
    }

    // Find middle using slow and fast pointer
    private Node getMiddle(Node head) {
        if (head == null) return head;

        Node slow = head;
        Node fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    // Merge two sorted linked lists
    private Node merge(Node l1, Node l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        Node result;

        if (l1.data <= l2.data) {
            result = l1;
            result.next = merge(l1.next, l2);
        } else {
            result = l2;
            result.next = merge(l1, l2.next);
        }

        return result;
    }

    // Utility to print list
    public void print(Node head) {
        while (head != null) {
            System.out.print(head.data + " → ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        MergeSortLinkedList list = new MergeSortLinkedList();

        Node head = new Node(2);
        head.next = new Node(1);
        head.next.next = new Node(4);
        head.next.next.next = new Node(9);
        head.next.next.next.next = new Node(8);
        head.next.next.next.next.next = new Node(3);
        head.next.next.next.next.next.next = new Node(7);

        head = list.sort(head);

        list.print(head); // Sorted output
    }
}
🔍 5. Intuition (Very Important)
Think of this as:
👉 “Sort by breaking into smaller lists”
Instead of sorting directly:
Break → Sort → Merge
⚡ 6. Key Interview Points

✔ Why Merge Sort for linked list?
✔ How do you find the middle?
✔ How do you merge two sorted lists?
✔ Time complexity: O(n log n)

🚀 Final Summary
Question: Sort a linked list using Merge Sort
Core idea: Divide → Recursively sort → Merge
Technique used:
Fast/Slow pointer
Recursive sorting
Merge logic
Time complexity: O(n log n)

If you want next, I can:
✅ Draw a full step-by-step diagram
✅ Show iterative (bottom-up) merge sort
✅ Give tricky interview questions on this topic
✅ Compare with Quick Sort on linked list
 */
    public static void main(String[] args) {

        DoublyLinkedList dll = new DoublyLinkedList();

        dll.insertFirst(2);
        dll.insertFirst(12);
        dll.insertFirst(9);
        dll.insertFirst(10);
        dll.insertFirst(-9);
        dll.insertFirst(56);
        dll.insertFirst(1);
        dll.insertFirst(-2);
        dll.insertFirst(10);
        dll.insertFirst(0);
        dll.insertFirst(10);

        System.out.println("Initial list:");
        dll.print();

        dll.sort();

        System.out.println("\nSorted list:");
        dll.print();
    }

}
