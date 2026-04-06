package Chapter13.MirrorBinaryTree.src.main.java.coding.challenge19;
 
public class Main {
/*
Here’s a clear, structured breakdown of the problem 👇

🟢 1. What is the Question?

You are given a binary tree.

👉 Task:
Create the mirror of the binary tree.

🔍 What does “mirror” mean?

A mirrored tree is a horizontal flip of the original tree.

👉 This means:

Left child ↔ Right child
Structure is reversed at every node
🧩 Example

Original tree:

      1
     / \
    2   3
   / \
  4   5

Mirrored tree:

      1
     / \
    3   2
       / \
      5   4
🧠 2. Clear Analysis
🔑 Key Idea

To mirror a tree:

👉 At every node, swap its left and right children

🧩 Two Possible Approaches
✅ 1. Create a New Tree
Do not modify the original tree
Build a new mirrored tree

👉 Use recursion:

Create a new node
Assign:
left = mirror of original right
right = mirror of original left
✅ 2. Mirror In-Place (Modify Original Tree)
Swap left and right pointers at each node
No extra tree is created

👉 Steps:

Mirror left subtree
Mirror right subtree
Swap left and right
⚙️ Traversal Type

👉 Post-order traversal

Why?

First process children
Then swap them
⚠️ Important Insight

The core operation is simply: swap(node.left, node.right)

🚀 3. Solution Approach
✅ Approach 1: Create New Mirrored Tree
Steps:
If node is null → return null
Create a new node
Recursively:
left = mirror of right subtree
right = mirror of left subtree
Return new node
⏱ Complexity
Time: O(n)
Space: O(n) (new tree + recursion)
✅ Approach 2: Mirror In-Place
Steps:
Traverse tree recursively
Swap left and right at each node
⏱ Complexity
Time: O(n)
Space: O(h) (recursion stack)
💻 4. Java Implementation
✅ Approach 1: Create New Tree
class Node {
    int val;
    Node left, right;

    Node(int val) {
        this.val = val;
    }
}

public class MirrorTree {

    public Node mirrorTree(Node root) {
        if (root == null) return null;

        Node newNode = new Node(root.val);

        // Swap recursively
        newNode.left = mirrorTree(root.right);
        newNode.right = mirrorTree(root.left);

        return newNode;
    }
}
✅ Approach 2: Mirror In-Place (Most Asked in Interviews)
public class MirrorTreeInPlace {

    public void mirror(Node node) {
        if (node == null) return;

        // Mirror left and right subtrees
        mirror(node.left);
        mirror(node.right);

        // Swap left and right
        Node temp = node.left;
        node.left = node.right;
        node.right = temp;
    }
}
🧾 Final Summary (Interview Ready)
❓ Problem: Create a mirror of a binary tree
🧠 Key Idea:
Swap left and right children at every node
⚙️ Approaches:
Build a new mirrored tree
Mirror in-place (modify original)
⏱ Complexity:
Time: O(n)
Space:
New tree → O(n)
In-place → O(h)
🔥 Interview Tip

If asked:

👉 “Which approach is better?”

Answer:

The in-place approach is more space-efficient (O(h)) and is usually preferred unless we need to preserve the original tree.

If you want next:
✅ Step-by-step dry run
✅ Iterative (non-recursive) version
✅ Difference between mirror, invert, and clone
✅ Common interview variations
 */
    public static void main(String[] args) {

    /*                          
              40                40
            /    \            /    \
          47      45         45    47
         /  \    /            \   /  \
        11   3  44            44 3    11
    */

        BinaryTree<Integer> bt = new BinaryTree<>();
        
        bt.insert(40);
        bt.insert(47);
        bt.insert(45);
        bt.insert(11);
        bt.insert(3);
        bt.insert(44);
                      
        System.out.println("Given tree");
        System.out.println("----------");
        
        System.out.println("\nTraversal LEVEL: ");
        bt.print(BinaryTree.TraversalOrder.LEVEL);
         
        System.out.println("\n\nTraversal IN-ORDER: ");
        bt.print(BinaryTree.TraversalOrder.IN);        
        
        System.out.println("\n\nTraversal PRE-ORDER: ");
        bt.print(BinaryTree.TraversalOrder.PRE);        
        
        System.out.println("\n\nMirorred tree in a new tree");
        System.out.println("---------------------------");
        
        BinaryTree<Integer> mirroredBt = bt.mirrorTreeInTree();
        
        System.out.println("\nTraversal LEVEL (mirror in new tree): ");
        mirroredBt.print(BinaryTree.TraversalOrder.LEVEL);
        
        System.out.println("\n\nTraversal IN-ORDER (mirror in new tree): ");
        mirroredBt.print(BinaryTree.TraversalOrder.IN);                        
        
        System.out.println("\n\nTraversal PRE-ORDER (mirror in new tree): ");
        mirroredBt.print(BinaryTree.TraversalOrder.PRE);        
        
        System.out.println("\n\nMirorred tree in place");
        System.out.println("----------------------");
        
        bt.mirrorTreeInPlace();
        
        System.out.println("\nTraversal LEVEL (mirror in place): ");
        bt.print(BinaryTree.TraversalOrder.LEVEL);
        
        System.out.println("\n\nTraversal IN-ORDER (mirror in place): ");
        bt.print(BinaryTree.TraversalOrder.IN);        
        
        System.out.println("\n\nTraversal PRE-ORDER (mirror in place): ");
        bt.print(BinaryTree.TraversalOrder.PRE);        
    }
}
