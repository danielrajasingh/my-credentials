package Chapter13.BinaryTreeIsBST.src.main.java.coding.challenge07;
 
public class Main {
/*
Let’s break this down clearly in a structured way so you fully understand the problem and solution.

🟡 1. What is the question?

You are given a binary tree (not guaranteed to be a BST).

👉 Your task is to write a function that:

Returns true if the tree is a valid Binary Search Tree (BST)
Returns false otherwise
⚠️ Important detail:
The tree may contain duplicates
That makes a simple in-order traversal check unreliable
🟡 2. Key Concepts (BST rules)

A Binary Search Tree (BST) follows this rule:

For every node:

All values in the left subtree are ≤ node value
All values in the right subtree are > node value
🟡 3. Why simple methods fail
❌ Wrong approach:
Do an in-order traversal
Check if result is sorted

👉 Problem:

If duplicates exist, like [40, 40]
You cannot distinguish structure
Two different trees can give same traversal result
🟡 4. Correct Idea (Important)

Instead of checking only:

left ≤ node < right

We must check:

👉 Each node must satisfy a valid range (min, max)

Example:
Root: (min = -∞, max = +∞)
Left child: (min = -∞, max = root value)
Right child: (min = root value, max = +∞)
🟡 5. Algorithm

Start from root with:

min = null, max = null
For each node:
If node violates:
node <= min OR node > max → ❌ return false
Recursively:
Left subtree → update max = current node
Right subtree → update min = current node
If all nodes satisfy → ✅ return true
🟡 6. Solution (Code Implementation)

Here is the Java solution based on your explanation:

public class BinaryTreeIsBST {

    public boolean isBinarySearchTree(Node root) {
        return isBinarySearchTree(root, null, null);
    }

    private boolean isBinarySearchTree(Node node, Integer min, Integer max) {
        // Base case
        if (node == null) {
            return true;
        }

        // Check min constraint
        if (min != null && node.element <= min) {
            return false;
        }

        // Check max constraint
        if (max != null && node.element > max) {
            return false;
        }

        // Recursively check subtrees
        return isBinarySearchTree(node.left, min, node.element) &&
               isBinarySearchTree(node.right, node.element, max);
    }
}
🟡 7. Complexity Analysis
⏱ Time Complexity:
O(n)
Each node is visited once
🧠 Space Complexity:
O(h)
h = height of tree (recursion stack)
🟡 8. Key Takeaways
❌ In-order traversal alone is not reliable when duplicates exist
✅ Use range checking (min/max approach)
✅ Each node must respect its valid boundary
✅ This is the standard interview solution (Google, Amazon, etc.)

If you want, I can next:

Walk through a step-by-step example tree
Show common mistakes in interviews
Provide a DFS vs iterative solution
Or convert this into Python / C++ / pseudocode
 */
    public static void main(String[] args) {

    /* This tree is BST       
              40
            /    \
          35      45
         /  \    /  \  
        30   37 44   48   
       /
      20   
    */
        BinaryTree<Integer> bt = new BinaryTree<>();

        bt.insert(40);
        bt.insert(35);
        bt.insert(45);
        bt.insert(30);
        bt.insert(37);
        bt.insert(44);
        bt.insert(48);
        bt.insert(20);               

        System.out.println("\n\nTraversal LEVEL: ");
        bt.print();

        System.out.println("\n\nIs this binary tree BST: " + bt.isBinarySearchTree());       
    }
}
