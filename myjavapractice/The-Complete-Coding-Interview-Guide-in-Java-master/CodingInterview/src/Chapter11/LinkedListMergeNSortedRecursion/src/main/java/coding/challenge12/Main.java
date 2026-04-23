package Chapter11.LinkedListMergeNSortedRecursion.src.main.java.coding.challenge12;
 
public class Main {
/*

    Here’s your full structured understanding of
👉 Merge Two Sorted Linked Lists (Without Extra Space)

✅ 1. What is the Question?

👉 Given:

Two sorted singly linked lists

👉 Task:

Merge them into one sorted list
❗ Do NOT create new nodes (in-place merge)
📌 Example:
List1: 4 → 7 → 8 → 10 → null
List2: 5 → 9 → 11 → null

👉 Output:

4 → 5 → 7 → 8 → 9 → 10 → 11 → null
🔍 2. Clear Analysis
❗ Constraints:
Already sorted lists
No extra space (reuse nodes)
🧠 Core Idea:

👉 You cannot create new nodes, so:

You must rearrange pointers
🎯 Key Insight:

👉 Always compare:

current node of list1  vs  current node of list2

👉 Insert smaller one into result

⚠️ Main Challenge:

When inserting from list2:

Don’t lose remaining part of list1
👉 So we use a swap trick
💡 3. Solution Idea
Steps:
Choose smaller head → becomes new head
Traverse list1
If next node in list1 is bigger than list2 node:
Insert list2 node in between
Swap pointers
Continue until one list ends
Attach remaining nodes
⚙️ 4. Solution Implementation (Clean Version)
public void merge(SinglyLinkedList sll) {

    Node list1 = head;
    Node list2 = sll.head;

    // Step 1: Decide new head
    if (list1.data > list2.data) {
        Node temp = list1;
        list1 = list2;
        list2 = temp;
    }

    head = list1;

    // Step 2: Merge
    while (list1 != null && list2 != null) {

        Node temp = null;

        // Move list1 while its values are smaller
        while (list1 != null && list1.data <= list2.data) {
            temp = list1;
            list1 = list1.next;
        }

        // Insert list2 node here
        temp.next = list2;

        // Swap list1 and list2
        Node swap = list1;
        list1 = list2;
        list2 = swap;
    }
}
🧠 5. One-Line Memory Trick

👉 “Compare → insert smaller → swap → continue.”

🧪 6. Dry Run Example
Input:
L1: 4 → 7 → 8 → 10
L2: 5 → 9 → 11
🔹 Step 1:
4 < 5 → head = 4
🔹 Step 2:

Compare 7 and 5

Insert 5 before 7

Result:

4 → 5 → 7 → 8 → 10
🔹 Step 3:

Compare 7 and 9

7 < 9 → move forward
🔹 Step 4:

Compare 10 and 9

Insert 9 before 10

Result:

4 → 5 → 7 → 8 → 9 → 10
🔹 Step 5:

Attach remaining:

→ 11
✅ Final Output:
4 → 5 → 7 → 8 → 9 → 10 → 11
🎨 7. Mental Visualization
🔹 Think like zipper merging:
L1: 4 → 7 → 8 → 10
L2: 5 → 9 → 11
🔹 Step-by-step merge:
4 → (5 inserted) → 7 → 8 → (9 inserted) → 10 → 11
🔹 Visual blocks:
[4] → [5] → [7,8] → [9] → [10] → [11]
⚡ 8. Key Insight

👉 You are NOT creating new nodes
👉 You are relinking existing nodes

🚨 Common Mistakes

❌ Losing reference to next nodes
❌ Not swapping pointers correctly
❌ Forgetting to attach remaining nodes

🎯 Interview Gold Explanation

👉 “I merge in-place by comparing nodes from both lists and inserting nodes from the second list into the first at correct positions using pointer manipulation.”

🚀 Final Summary
Concept	Value
Time	O(n + m)
Space	O(1)
Technique	Pointer manipulation
Trick	Swap references
🧠 Final Intuition

👉 Think like:

Take smaller → attach → move → repeat

If you want next level 🔥
I can show:

🔥
Recursive solution (very important for interviews)
🔥
Merge K sorted lists
🎬
Step-by-step animation like a movie

Just tell me 👍


 */
    public static void main(String[] args) {        
 
        SinglyLinkedList sll1 = new SinglyLinkedList();

        sll1.insertFirst(10);
        sll1.insertFirst(8);
        sll1.insertFirst(7);        
        sll1.insertFirst(4);
        
        SinglyLinkedList sll2 = new SinglyLinkedList();
        
        sll2.insertFirst(11);
        sll2.insertFirst(9);        
        sll2.insertFirst(5);
        
        SinglyLinkedList sll3 = new SinglyLinkedList();
        
        sll3.insertFirst(15);
        sll3.insertFirst(14);
        sll3.insertFirst(3);        
        sll3.insertFirst(1);
        
        sll1.print();
        sll2.print();
        sll3.print();
        
        sll1.merge(new SinglyLinkedList[]{sll1, sll2, sll3}, 3);
        
        System.out.println("\nAfter merging:");

        sll1.print();                       
    }

}
