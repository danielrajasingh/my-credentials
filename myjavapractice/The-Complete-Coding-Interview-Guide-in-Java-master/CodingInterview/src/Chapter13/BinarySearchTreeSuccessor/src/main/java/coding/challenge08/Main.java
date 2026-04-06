package Chapter13.BinarySearchTreeSuccessor.src.main.java.coding.challenge08;
 
public class Main {
/*
✅ What is the question?

You are given:

A Binary Search Tree (BST)
A specific node n in that BST

👉 You need to find the in-order successor of node n.

🧠 What is “In-Order Successor”?

The in-order traversal of a BST visits nodes in this order:

Left → Root → Right

👉 So, the in-order successor of a node is:

The next node visited after n in an in-order traversal.

🔍 Key Insight (Important for interviews)

In a BST, the in-order successor depends on 2 main cases:

📌 Case 1: Node has a right subtree

If n.right != null:

The successor is the leftmost (smallest) node in the right subtree

👉 Why?
Because in in-order traversal, after visiting n, we go to the smallest value in the right subtree.

📌 Case 2: Node has NO right subtree

If n.right == null:

We move upwards using parent pointers until:

We find a node that is a left child of its parent

👉 That parent is the successor.

Sub-cases:
If n is a left child → successor is parent
If n is a right child → keep moving up until condition is met

👉 If we reach the root and still don’t find such a node:

The successor is null (no successor)
🧩 Example
        50
       /  \
     30    70
          /   \
         60    80
Successor of 50 → 60
Successor of 60 → 70
Successor of 80 → null
💡 Algorithm Summary
If right child exists:
Go to right subtree
Find leftmost node
Else:
Move up using parent pointer
Stop when current node is a left child
Return the parent
💻 Solution (Code)
Java Implementation
class Node {
    int data;
    Node left, right, parent;

    Node(int data) {
        this.data = data;
        left = right = parent = null;
    }
}

public class BSTSuccessor {

    // Main function
    public static Node inOrderSuccessor(Node node) {
        if (node == null) return null;

        // Case 1: Right subtree exists
        if (node.right != null) {
            return findLeftmost(node.right);
        }

        // Case 2: No right subtree
        Node parent = node.parent;

        while (parent != null && parent.right == node) {
            node = parent;
            parent = parent.parent;
        }

        return parent;
    }

    // Helper: Find leftmost node
    private static Node findLeftmost(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
}
⏱️ Time & Space Complexity
Time Complexity: O(h)
(h = height of the tree)
Space Complexity: O(1)
(no extra space used)
🚀 Interview Tip

If asked in Google/Microsoft interviews:

Always explain cases clearly
Mention:
Right subtree case
Parent traversal case
Draw a small BST diagram
Then write code

If you want, I can also:
✅ Give a recursive version
✅ Provide test cases
✅ Walk through a step-by-step dry run
✅ Extend this to successor without parent pointer (very common interview twist)
 */
    public static void main(String[] args) {

    /*        
              70
            /    \
          50      75
         /  \    /  \
        40  55  72  77
       /   /  \      
      35  54   60
              /
             58
              \
              59        
    */
        BinarySearchTree bt = new BinarySearchTree();

        bt.buildTreeSample();
        
        bt.inOrderSuccessor();
        bt.preOrderSuccessor();
        bt.postOrderSuccessor();
    }
}
