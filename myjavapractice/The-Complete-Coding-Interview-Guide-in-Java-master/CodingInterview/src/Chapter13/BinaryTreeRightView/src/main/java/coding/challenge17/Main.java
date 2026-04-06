package Chapter13.BinaryTreeRightView.src.main.java.coding.challenge17;
 
public class Main {
/*
Here’s a clear, structured breakdown of the problem 👇

🟢 1. What is the Question?

You are given a binary tree.

👉 Task:
Print the right view of the binary tree.

🔍 What is “Right View”?

The right view consists of nodes you can see when looking at the tree from the right side.

👉 In simple terms:

For each level of the tree
Print the rightmost node
🧩 Example
        1
       / \
      2   3
       \    \
        5    4
         \
          6

👉 Right view:

1 3 4 6
🧠 2. Clear Analysis
🔑 Key Idea

👉 At each level, we only need the last node

⚙️ Two Main Approaches
✅ 1. BFS (Level Order Traversal)
Traverse level by level
At each level:
Keep track of the last node
Print it
✅ 2. DFS (Recursive)
Traverse tree right first
Track level depth
Print first node encountered at each level

👉 This ensures the rightmost node is visited first

🧩 Key Observations
Right view = last node of each level
Tree height = number of nodes in right view (max)
🚀 3. Solution Approach
✅ Approach 1: BFS (Most Common)
Steps:
Use a queue
Traverse level by level
For each level:
Loop through all nodes
Print the last node in that level
⏱ Complexity
Time: O(n)
Space: O(n)
✅ Approach 2: DFS (Recursive)
Steps:
Traverse right subtree first
Keep track of:
Current level
Max level visited
Print node when:
Level > max level seen so far
⏱ Complexity
Time: O(n)
Space: O(h) (recursion stack)
💻 4. Java Implementation
✅ BFS Approach (Iterative – Best for interviews)
import java.util.*;

class Node {
    int val;
    Node left, right;

    Node(int val) {
        this.val = val;
    }
}

public class RightViewBinaryTree {

    public void rightView(Node root) {
        if (root == null) return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Node current = queue.poll();

                // Print last node of this level
                if (i == size - 1) {
                    System.out.print(current.val + " ");
                }

                if (current.left != null) queue.add(current.left);
                if (current.right != null) queue.add(current.right);
            }
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.right = new Node(5);
        root.right.right = new Node(4);
        root.left.right.right = new Node(6);

        RightViewBinaryTree obj = new RightViewBinaryTree();
        obj.rightView(root);
    }
}
✅ DFS Approach (Recursive – Advanced)
import java.util.*;

public class RightViewDFS {

    private int maxLevel = 0;

    public void rightView(Node root) {
        rightViewHelper(root, 1);
    }

    private void rightViewHelper(Node node, int level) {
        if (node == null) return;

        // If first node at this level → print it
        if (level > maxLevel) {
            System.out.print(node.val + " ");
            maxLevel = level;
        }

        // Traverse right first, then left
        rightViewHelper(node.right, level + 1);
        rightViewHelper(node.left, level + 1);
    }
}
🧾 Final Summary (Interview Ready)
❓ Problem: Print the right view of a binary tree
🧠 Key Idea:
Right view = rightmost node at each level
⚙️ Approaches:
BFS → print last node of each level
DFS → traverse right first + track levels
⏱ Complexity:
Time: O(n)
Space:
BFS → O(n)
DFS → O(h)
🔥 Interview Tip

If asked:

👉 “Why traverse right first in DFS?”

Answer:

Because we want to ensure that the rightmost node is visited before any other nodes at the same level.

If you want next:
✅ Left view (mirror of this problem)
✅ Top view / bottom view (very common interview questions)
✅ Step-by-step dry run
✅ Differences between views (right, left, top, bottom)
 */
    public static void main(String[] args) {
    
        BinaryTree bt = new BinaryTree();
                      
        System.out.println("Iterative approach:");
        bt.printRightViewIterative();
        
        System.out.println("\n\nRecursive approach:");
        bt.printRightViewRecursive();
    }
}
