package Chapter13.BinaryTreeSpiralTraversal.src.main.java.coding.challenge20;
 
public class Main {
/*
Here’s a clear, structured breakdown of the problem 👇

🟢 1. What is the Question?

You are given a binary tree.

👉 Task:
Print the nodes in spiral (zig-zag) level order traversal.

🔍 What is Spiral Traversal?

Traversal alternates direction at each level:

Level 1 → left → right
Level 2 → right → left
Level 3 → left → right
Level 4 → right → left
… and so on
🧩 Example
        1
      /   \
     2     3
    / \   / \
   4   5 6   7

👉 Output:

1 3 2 4 5 6 7   (if starting right→left)

or

1 2 3 7 6 5 4   (depending on direction convention)
🧠 2. Clear Analysis
🔑 Key Idea

This is a variation of:

👉 Level Order Traversal (BFS)

But with:

👉 Alternating direction at each level

🧩 Core Observations
Each level must be processed separately
Direction flips after every level
Need a way to:
control order of traversal
store nodes temporarily
⚙️ Why Two Stacks Work?

We need:

One stack for current level
One stack for next level

👉 Stacks help reverse order naturally

💡 Logic:
Current Level	Direction	Push Children Order
Left → Right	L→R	left first, then right
Right → Left	R→L	right first, then left
🔁 Flow
Start with root in stack
Process one stack completely
Push children into the other stack in correct order
Swap stacks
Repeat
🚀 3. Solution Approach
✅ Approach 1: Two Stacks (Best)
Steps:
Create:
stack1 (for current level)
stack2 (for next level)
Push root into stack1
While either stack is not empty:
Process stack1:
Print nodes
Push children into stack2 (right then left)
Process stack2:
Print nodes
Push children into stack1 (left then right)
⏱ Complexity
Time: O(n) (each node visited once)
Space: O(n) (stacks)
💻 4. Java Implementation
✅ Two-Stack Solution (Recommended)
import java.util.Stack;

class Node {
    int val;
    Node left, right;

    Node(int val) {
        this.val = val;
    }
}

public class SpiralTraversal {

    public void spiralOrder(Node root) {
        if (root == null) return;

        Stack<Node> stack1 = new Stack<>(); // left → right
        Stack<Node> stack2 = new Stack<>(); // right → left

        stack1.push(root);

        while (!stack1.isEmpty() || !stack2.isEmpty()) {

            // Process stack1 (left → right)
            while (!stack1.isEmpty()) {
                Node node = stack1.pop();
                System.out.print(node.val + " ");

                // Push children into stack2 (right first)
                if (node.right != null) stack2.push(node.right);
                if (node.left != null) stack2.push(node.left);
            }

            // Process stack2 (right → left)
            while (!stack2.isEmpty()) {
                Node node = stack2.pop();
                System.out.print(node.val + " ");

                // Push children into stack1 (left first)
                if (node.left != null) stack1.push(node.left);
                if (node.right != null) stack1.push(node.right);
            }
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        SpiralTraversal obj = new SpiralTraversal();
        obj.spiralOrder(root);
    }
}
🧾 Final Summary (Interview Ready)
❓ Problem: Print binary tree in zig-zag (spiral) level order
🧠 Key Idea:
Alternate traversal direction at each level
⚙️ Approach:
Use two stacks
Control order of child insertion
⏱ Complexity:
Time: O(n)
Space: O(n)
🔥 Interview Tip

If asked:

👉 “Why two stacks?”

Answer:

Because stacks naturally reverse order, allowing us to alternate traversal direction efficiently without reversing lists manually.

If you want next:
✅ Deque-based solution (very popular in interviews)
✅ BFS queue solution (with direction flag)
✅ Dry run step-by-step
✅ Common variations (zigzag level sum, diagonal traversal)
 */
    public static void main(String[] args) {

    /* Output: 40 45 47 11 3 44 5 87 77 6 2 1 4 23 21 1 5 8 
               40 47 45 5 44 3 11 21 23 4 1 2 6 77 87 8 5 1 
              ----40----
             /          \
            47          45
          /    \      /    \  
         11     3    44     5
       /   \   / \  /  \   / \
      21   23 4   1 2  6  77  87
      /\   /  
     1  5 8
    */

        BinaryTree<Integer> bt = new BinaryTree<>();
        
        bt.insert(40);
        
        bt.insert(47);
        bt.insert(45);
        
        bt.insert(11);
        bt.insert(3);
        bt.insert(44);
        bt.insert(5);
        
        bt.insert(21);
        bt.insert(23);
        bt.insert(4);
        bt.insert(1);
        bt.insert(2);
        bt.insert(6);
        bt.insert(77);
        bt.insert(87);
        
        bt.insert(1);
        bt.insert(5);
        bt.insert(8);
          
        bt.spiralOrderTraversalRecursive();
        System.out.println();
        bt.spiralOrderTraversalTwoStacks();
        System.out.println();
        bt.spiralOrderTraversalDeque();
    }
}
