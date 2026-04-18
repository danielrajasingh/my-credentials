package Chapter11.LinkedListRemoveDuplicates.src.main.java.coding.challenge04;
 
public class Main {
/*
Here’s your complete interview-ready breakdown for
Coding Challenge 4 – Remove Duplicates (Linked List) 👇

✅ 1. What is the Question?

👉 Given:
An unsorted singly linked list

👉 Task:
Remove duplicate values
Keep only the first occurrence

🔍 2. Clear Analysis
    Key challenges:
    No indexing (unlike arrays)
    Only next pointer available
    Need to track previous node for deletion
    Two Approaches:
    Approach	Time	Space	Idea
    HashSet	O(n)	O(n)	Track seen values
    Runner	O(n²)	O(1)	Compare each node with others
💡 3. Solution Idea
✅ Approach 1: Using HashSet (Optimal Time)
    👉 Steps:
    Traverse list
    Store seen values in Set
    If duplicate → remove node
    Else → add to set
✅ Approach 2: Runner Technique (No Extra Space)
    👉 Steps:
    Fix one node (current)
    Compare with all next nodes (runner)
    Remove duplicates
    Move current forward

⚙️ 4. Solution Implementation
✅ Approach 1: HashSet (O(n))
public void removeDuplicates() {
    Set<Integer> set = new HashSet<>();

    Node current = head;
    Node prev = null;

    while (current != null) {

        if (set.contains(current.data)) {
            prev.next = current.next;

            if (current == tail) {
                tail = prev;
            }

            size--;
        } else {
            set.add(current.data);
            prev = current;
        }

        current = current.next;
    }
}
✅ Approach 2: Runner (O(n²), O(1) space)
public void removeDuplicates() {
    Node current = head;

    while (current != null) {

        Node runner = current;

        while (runner.next != null) {

            if (runner.next.data == current.data) {
                if (runner.next == tail) {
                    tail = runner;
                }

                runner.next = runner.next.next;
                size--;

            } else {
                runner = runner.next;
            }
        }

        current = current.next;
    }
}
🧠 5. One-Line Memory Trick

👉 “Seen before? Remove it. Else store it.”

(OR)

👉 “Fix one node → scan rest → delete duplicates”

🧪 6. Dry Run Example
Input Linked List:
1 → 2 → 3 → 2 → 4 → 3 → 5
✅ Using HashSet
Step	Node	Set	Action
1	1	{1}	keep
2	2	{1,2}	keep
3	3	{1,2,3}	keep
4	2	exists	❌ remove
5	4	{1,2,3,4}	keep
6	3	exists	❌ remove
7	5	{1,2,3,4,5}	keep
✅ Final Output:
1 → 2 → 3 → 4 → 5

🎨 7. Mental Visualization
🔹 Duplicate Removal Concept
Before:
1 → 2 → 3 → 2 → 4 → 3 → 5
            ↑       ↑
         duplicate duplicate
🔹 Removal Process
Step:
prev → current → next

If duplicate:
prev.next = current.next

🔹 Pointer Movement
prev      current
 ↓          ↓
1 → 2 → 3 → 2 → 4
Remove duplicate 2:
1 → 2 → 3 ─────→ 4

🔹 Final Clean List
1 → 2 → 3 → 4 → 5
⚡ Visual Summary
        Linked List
   1 → 2 → 3 → 2 → 4 → 3 → 5
            ↓       ↓
        duplicates found
            ↓
        removed using:
   ✔ HashSet OR Runner
            ↓
   1 → 2 → 3 → 4 → 5


🎯 Interview Gold Insight
Say this:
👉 “If space is allowed, I’ll use HashSet for O(n).
If not, I’ll use runner technique with O(n²) time.”

🚀 Final Summary
HashSet → fast (O(n)), extra space
Runner → no space, slower (O(n²))
Key trick → track previous node carefully

If you want next level 🔥
I can show:
✅
Doubly Linked List version
✅
Recursive approach
✅
Edge cases (head duplicate, all duplicates)
✅
Interview tricky follow-ups

Just tell me 👍
 */
    public static void main(String[] args) {

       SinglyLinkedList sll = new SinglyLinkedList();              
       
       sll.insertFirst(5);
       sll.insertFirst(2);             
       sll.insertFirst(12);
       sll.insertFirst(2);
       sll.insertFirst(12);
       sll.insertFirst(5);
       sll.insertFirst(5);
       sll.insertFirst(12);
       sll.insertFirst(1);
       sll.insertFirst(4);
       sll.insertFirst(12);
       
       System.out.println("\nLinked list before removing duplicates:");
       sll.print();
       sll.removeDuplicates1();
       // sll.removeDuplicates2();
       System.out.println("\nLinked list after removing duplicates:");
       sll.print();
     
       System.out.println("\nSize: " + sll.size());
       
    }

}
