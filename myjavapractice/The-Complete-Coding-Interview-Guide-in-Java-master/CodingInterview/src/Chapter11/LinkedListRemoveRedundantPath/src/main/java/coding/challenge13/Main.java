package Chapter11.LinkedListRemoveRedundantPath.src.main.java.coding.challenge13;

public class Main {
/*
Here’s your complete structured breakdown for
👉 Remove Redundant Path (Linked List of Coordinates)
✅ 1. What is the Question?
👉 Given:
A linked list where each node = (row, column) → (r, c)
This represents a path in a grid
👉 Task:
Remove redundant intermediate points
Keep only turning points + endpoints
Problem: Consider a singly linked list storing a path in a matrix. The data of a node is of
type (row, column) or, in short, (r, c). The path can only be either horizontal (by column)
or vertical (by row). The complete path is given by the end points of all of the horizontal
and vertical paths; therefore, the middle points (or points in between) are redundant.
Write a snippet of code that removes the redundant path.


📌 Example:
(0,0) → (0,1) → (0,2) → (1,2) → (2,2) → (3,2) → (3,3) → (3,4)
👉 Output:
(0,0) → (0,2) → (3,2) → (3,4)
🔍 2. Clear Analysis
🧠 Key Observation:
👉 Movement is only:
Horizontal → same row (r same)
Vertical → same column (c same)
🎯 Key Insight:
👉 If 3 consecutive nodes:
Have same row → middle is useless
Have same column → middle is useless
📌 Pattern:
A → B → C
If:
A.r == B.r == C.r  (horizontal)
OR
A.c == B.c == C.c  (vertical)
👉 Remove B (middle node)
💡 3. Solution Idea
👉 Traverse list using pointer:
Take 3 nodes:
current
next
next.next
Check:
same row OR same column
If yes:
remove middle node
Else:
move forward
⚙️ 4. Solution Implementation (Clean Version)
public void removeRedundantPath() {

    Node current = head;

    while (current != null && current.next != null && current.next.next != null) {

        Node next = current.next;
        Node nextNext = current.next.next;

        // Vertical line (same column)
        if (current.c == next.c && current.c == nextNext.c) {
            current.next = nextNext; // remove middle
        }

        // Horizontal line (same row)
        else if (current.r == next.r && current.r == nextNext.r) {
            current.next = nextNext; // remove middle
        }

        else {
            current = current.next; // move forward
        }
    }
}
🧠 5. One-Line Memory Trick
👉 “If 3 points lie in straight line → remove middle.”
🧪 6. Dry Run Example
Input:
(0,0) → (0,1) → (0,2) → (1,2) → (2,2) → (3,2) → (3,3) → (3,4)
🔹 Step 1:
(0,0), (0,1), (0,2)
Same row → remove (0,1)
🔹 Step 2:
(0,0), (0,2), (1,2)
Not same → move forward
🔹 Step 3:
(0,2), (1,2), (2,2)
Same column → remove (1,2)
🔹 Step 4:
(0,2), (2,2), (3,2)
Same column → remove (2,2)
🔹 Step 5:
(3,2), (3,3), (3,4)
Same row → remove (3,3)
✅ Final Output:
(0,0) → (0,2) → (3,2) → (3,4)
🎨 7. Mental Visualization
🔹 Think like path simplification:
→ → →   ↓ ↓ ↓   → →
🔹 Only keep turns:
Start → Turn → Turn → End
🔹 Visual idea:
(0,0) ───── (0,2)
              │
              │
           (3,2) ─── (3,4)
⚡ 8. Key Insight

👉 Middle nodes in straight line are redundant
👉 Only direction changes matter

🚨 Common Mistakes

❌ Not checking 3 nodes
❌ Moving pointer incorrectly after deletion
❌ Missing vertical/horizontal condition

🎯 Interview Gold Explanation

👉 “I scan the list in triplets and remove the middle node whenever three consecutive points lie in a straight horizontal or vertical line.”

🚀 Final Summary
Concept	Value
Time	O(n)
Space	O(1)
Technique	Pointer manipulation
Trick	Triplet comparison
🧠 Final Intuition

👉 Think like:

Straight line → compress it → keep endpoints only

If you want next level 🔥
I can show:

🎬 Step-by-step animation (like a moving path)
🧠 Convert this into matrix/grid visualization
🔥 Hard variation (diagonal movement included)

Just tell me 👍



(0,0) → (0,1) → (0,2)
                     ↓
                   (1,2)
                     ↓
                   (2,2)
                     ↓
                   (3,2) → (3,3) → (3,4)
 */
    public static void main(String[] args) {        

        SinglyLinkedList sll = new SinglyLinkedList();

        sll.insertFirst(3, 4);               
        sll.insertFirst(3, 3);
        sll.insertFirst(3, 2);
        sll.insertFirst(2, 2);
        sll.insertFirst(1, 2);
        sll.insertFirst(0, 2);
        sll.insertFirst(0, 1);
        sll.insertFirst(0, 0);       
        
        System.out.println("\nInitial");
        sll.print();

        sll.removeRedundantPath();
        System.out.println("\nAfter");
        sll.print();
        
    }

}
