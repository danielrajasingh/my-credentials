package Chapter11.LinkedListSum.src.main.java.coding.challenge09;
 
public class Main {
/*
Here’s your complete interview-style breakdown for Sum Two Linked Lists 👇

✅ 1. What is the Question?

👉 Given:

Two linked lists
Each list represents a number (digit by digit)

👉 Task:

Add the two numbers
Return the result as a linked list
📌 Example:
List1: 7 → 3 → 8 → 9 → 4 → 1 → 2
List2: 7 → 9 → 8 → 4

👉 These represent numbers (in reverse order addition style):

21389737 + 4897 (conceptually)

👉 Output:

4 → 3 → 7 → 4 → 5 → 1 → 2
🔍 2. Clear Analysis
Core challenges:
Lists may be different lengths
Need to handle carry (like normal addition)
Must process node by node
🧠 Key Insight:

👉 This is just like school addition:

  7 + 7 = 14 → write 4, carry 1
  3 + 9 + 1 = 13 → write 3, carry 1
💡 3. Solution Idea
Use recursion:

At each step:

Add current digits + carry
Store last digit (value % 10)
Pass carry (value / 10) to next
⚙️ 4. Solution Implementation (Recursive)
private Node sum(Node node1, Node node2, int carry) {

    // base case
    if (node1 == null && node2 == null && carry == 0) {
        return null;
    }

    Node resultNode = new Node();

    int value = carry;

    if (node1 != null) {
        value += node1.data;
    }

    if (node2 != null) {
        value += node2.data;
    }

    resultNode.data = value % 10;

    if (node1 != null || node2 != null) {
        Node more = sum(
            node1 == null ? null : node1.next,
            node2 == null ? null : node2.next,
            value >= 10 ? 1 : 0
        );
        resultNode.next = more;
    }

    return resultNode;
}
🧠 5. One-Line Memory Trick

👉 “Add digits + carry → store last digit → pass carry forward.”

🧪 6. Dry Run Example
Input:
List1: 7 → 3 → 8 → 9
List2: 7 → 9 → 8 → 4
Step-by-step:
🔹 Step 1:
7 + 7 = 14 → write 4, carry 1
Result: 4
🔹 Step 2:
3 + 9 + 1 = 13 → write 3, carry 1
Result: 4 → 3
🔹 Step 3:
8 + 8 + 1 = 17 → write 7, carry 1
Result: 4 → 3 → 7
🔹 Step 4:
9 + 4 + 1 = 14 → write 4, carry 1
Result: 4 → 3 → 7 → 4
🔹 Step 5:
0 + 0 + 1 = 1 → write 1
Result: 4 → 3 → 7 → 4 → 1
✅ Final Result:
4 → 3 → 7 → 4 → 1
🎨 7. Mental Visualization
🔹 Think like column addition:
   7 → 3 → 8 → 9
 + 7 → 9 → 8 → 4
------------------
   4 → 3 → 7 → 4 → 1
🔹 Carry flow:
7+7=14 → carry 1
3+9+1=13 → carry 1
8+8+1=17 → carry 1
🔹 Recursive flow:
Node1 → Node2 → carry
 ↓        ↓       ↓
 add → create node → call next
⚡ 8. Key Insight

👉 Recursion handles:

Moving to next nodes
Carry propagation automatically
🎯 Interview Gold Explanation

Say this:

👉 “This problem mimics digit-by-digit addition. I use recursion to process
both lists simultaneously, carry forward overflow, and build the result list node by node.”

🚀 Final Summary
Time → O(max(n, m))
Space → O(n) (due to recursion stack)
Technique → Recursion + Carry handling

If you want next level 🔥
I can show:

🔥
Iterative solution (no recursion)
🔥
Forward order version (harder problem)
🔥
Reverse linked list before/after trick

Just tell me 👍
 */
    public static void main(String[] args) {        

        SinglyLinkedList sll1 = new SinglyLinkedList();      
        sll1.insertFirst(2);
        sll1.insertFirst(1);
        sll1.insertFirst(4);
        sll1.insertFirst(9);
        sll1.insertFirst(8);
        sll1.insertFirst(3);
        sll1.insertFirst(7);
        
        SinglyLinkedList sll2 = new SinglyLinkedList();      
        sll2.insertFirst(4);
        sll2.insertFirst(8);
        sll2.insertFirst(9);
        sll2.insertFirst(7);
        
        sll1.sum(sll2);
    }
}
