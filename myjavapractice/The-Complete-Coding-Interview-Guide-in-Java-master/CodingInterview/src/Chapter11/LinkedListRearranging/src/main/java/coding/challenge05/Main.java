package Chapter11.LinkedListRearranging.src.main.java.coding.challenge05;
 
public class Main {
/*
Here’s your complete interview-style breakdown for this linked list partition problem 👇

✅ 1. What is the Question?

👉 Given:

A singly linked list
A value n (pivot)

👉 Task:

Rearrange the list such that:
All nodes < n come before
All nodes ≥ n come after

⚠️ Order does NOT need to be preserved

🔍 2. Clear Analysis
Key Idea:
We are partitioning the list around a pivot (like QuickSort concept)
Constraints:
Cannot use array indexing
Must manipulate pointers
Efficient solution → O(n)
Strategy:

👉 Traverse list once
👉 Build:

Left side → values < n
Right side → values ≥ n
💡 3. Solution Idea

👉 Use two pointers:

head → for smaller elements
tail → for larger elements
For each node:
If < n → move to head
Else → move to tail
⚙️ 4. Solution Implementation
public void rearrange(int n) {

    Node current = head;
    head = current;
    tail = current;

    while (current != null) {

        Node next = current.next;

        if (current.data < n) {
            // insert at head
            current.next = head;
            head = current;
        } else {
            // insert at tail
            tail.next = current;
            tail = current;
        }

        current = next;
    }

    tail.next = null; // important!
}
🧠 5. One-Line Memory Trick

👉 “< pivot → head, ≥ pivot → tail”

🧪 6. Dry Run Example
Input:
1 → 5 → 4 → 3 → 2 → 7 → null
pivot = 3
Step-by-Step:
Node	Action	List State
1	<3 → head	1
5	≥3 → tail	1 → 5
4	≥3 → tail	1 → 5 → 4
3	≥3 → tail	1 → 5 → 4 → 3
2	<3 → head	2 → 1 → 5 → 4 → 3
7	≥3 → tail	2 → 1 → 5 → 4 → 3 → 7
✅ Final Output:
2 → 1 → 5 → 4 → 3 → 7 → null

👉 Left side: < 3 → 2,1
👉 Right side: ≥ 3 → 5,4,3,7

🎨 7. Mental Visualization
🔹 Original List
1 → 5 → 4 → 3 → 2 → 7
            ↑ pivot = 3
🔹 Two Zones Concept
[ < pivot ]   |   [ ≥ pivot ]
🔹 Movement Flow
Traverse → Pick node → Decide:

if < 3 → move LEFT (head)
if ≥ 3 → move RIGHT (tail)
🔹 Final Partitioned List
2 → 1  |  5 → 4 → 3 → 7
⚡ Visual Summary
        Traverse List
              ↓
     Compare with pivot (n)
         ↙           ↘
    < n (HEAD)     ≥ n (TAIL)
         ↓           ↓
     Build new rearranged list
🎯 Interview Gold Insight

Say this:

👉 “This is a partition problem similar to QuickSort.
We can solve it in O(n) time by rearranging nodes using head and tail pointers.”

🚀 Final Summary
Single pass → O(n)
No extra space → O(1)
Key trick → pointer manipulation

If you want next level 🔥
I can show:
✅
Stable partition (preserve order)
✅
Using two separate lists (cleaner approach)
✅
Edge cases (all < n, all ≥ n, duplicates of pivot)

Just tell me 👍
 */
    public static void main(String[] args) {        

        SinglyLinkedList sll = new SinglyLinkedList();

        sll.insertFirst(11);
        sll.insertFirst(10);
        sll.insertFirst(9);
        sll.insertFirst(8);
        sll.insertFirst(8);
        sll.insertFirst(8);
        sll.insertFirst(7);
        sll.insertFirst(6);
        sll.insertFirst(5);
        sll.insertFirst(4);
        sll.insertFirst(-3);
        sll.insertFirst(2);
        sll.insertFirst(1);
        sll.insertFirst(11);
        sll.insertFirst(90);

        sll.print();    
        
        sll.rearrange(7);
        
        sll.print();
    }
    
}
