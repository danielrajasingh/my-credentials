package Chapter11.LinkedListsIntersection.src.main.java.coding.challenge10;
 
public class Main {

    /*
    Here’s your complete interview-style breakdown for Linked List Intersection (by reference) 👇

✅ 1. What is the Question?

👉 Given:
Two singly linked lists
👉 Task:
Check if they intersect (same node in memory, not same value)
Return the value of the intersection node
📌 Important:
❗ Intersection is based on reference, not value
Wrong:  8 == 8 (value match ❌)
Correct: same node in memory ✔
📌 Example:
List1: 2 → 1 → 8 → 9 → 4
                     ↑
List2:      3 → 8 → 9 → 4
👉 Both lists share node 8 onwards
👉 Answer = 8

🔍 2. Clear Analysis
🧠 Problem Challenge:
Lists may have different lengths
Need to compare nodes (addresses), not values
💡 Key Insight:

👉 If lists intersect:

They share the same tail
After intersection point → everything is same
❗ Main issue:

Lists are unequal length

So:
👉 We must align them first

💡 3. Solution Idea
Step-by-step:
Find lengths of both lists → s1, s2
Move pointer of longer list forward by |s1 - s2|
Now both pointers are equal distance from end
Move both pointers together
First match (same reference) → intersection
⚙️ 4. Solution Implementation
public int intersection() {

    Node p1 = head1;
    Node p2 = head2;

    int s1 = size(p1);
    int s2 = size(p2);

    // Step 1: align starting point
    if (s1 > s2) {
        for (int i = 0; i < s1 - s2; i++) {
            p1 = p1.next;
        }
    } else {
        for (int i = 0; i < s2 - s1; i++) {
            p2 = p2.next;
        }
    }

    // Step 2: move together
    while (p1 != null && p2 != null) {
        if (p1 == p2) {
            return p1.data;
        }
        p1 = p1.next;
        p2 = p2.next;
    }

    return -1; // no intersection
}
🧠 5. One-Line Memory Trick

👉 “Align lengths → move together → match reference.”

🧪 6. Dry Run Example
Input:
List1: 2 → 1 → 8 → 9 → 4   (size = 5)
List2: 3 → 8 → 9 → 4       (size = 4)
🔹 Step 1: Align
Difference = 1

Move List1 by 1:

List1 → 1 → 8 → 9 → 4
List2 → 3 → 8 → 9 → 4
🔹 Step 2: Move together
Step	p1	p2
1	1	3
2	8	8

👉 MATCH FOUND ✅

✅ Result:
Intersection node = 8
🎨 7. Mental Visualization
🔹 Before alignment:
List1: 2 → 1 → 8 → 9 → 4
List2:     3 → 8 → 9 → 4
🔹 After alignment:
List1:    1 → 8 → 9 → 4
List2:    3 → 8 → 9 → 4
🔹 Move together:
Step 1: 1 vs 3 ❌
Step 2: 8 vs 8 ✔ (same node)
🔹 Final view:
        8 → 9 → 4
       ↑
List1 →
List2 →
⚡ 8. Key Insight

👉 We are not comparing values
👉 We are comparing memory references

🎯 Interview Gold Explanation

Say this:

👉 “I first align both lists by length, then traverse them together. Since intersection means shared nodes, I compare references, not values. The first matching node is the intersection.”

🚀 Final Summary
Time → O(n + m)
Space → O(1)
Technique → Length alignment + two pointers

If you want next level 🔥
I can show:

🔥
Alternative solution (two pointer switching trick)
🔥
How to detect if intersection exists without size
🔥
Real memory visualization (heap-level thinking)

Just tell me 👍
     */
    public static void main(String[] args) {        

        SinglyLinkedList sll = new SinglyLinkedList();

        int intersection = sll.intersection();
        
        System.out.println("\nIntersection node has the value (-1 means no intersection): " + intersection);
    }

}
