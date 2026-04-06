package Chapter13.BinaryTreeCommonAncestor.src.main.java.coding.challenge10;
 
public class Main {
/*
Here’s a clear and structured breakdown of Coding Challenge 10 – First Common Ancestor (Binary Tree).

✅ What is the Question?

You are given a binary tree (not necessarily a BST) and two nodes:

👉 Find the first common ancestor (LCA - Lowest Common Ancestor) of these two nodes.

❗ Important Constraints
You cannot use extra data structures (like HashSet, maps, etc.)
You must work directly on the tree
The tree is a general binary tree, not necessarily ordered
✅ What is “Common Ancestor”?

A node A is a common ancestor of nodes n1 and n2 if:

Both n1 and n2 are in the subtree of A
Among all such nodes, we want the lowest (deepest) one
✅ Analysis
🔹 Key Insight

At any node, there are 3 possibilities:

Both nodes are in left subtree
Both nodes are in right subtree
One is in left, one is in right → current node is the ancestor
🔹 Recursive Idea

We traverse the tree using DFS (post-order):

For each node:

Check left subtree
Check right subtree
Decide based on results
🔹 Return Values (Important)

Each recursive call returns:

n1 → if only n1 is found
n2 → if only n2 is found
null → if neither found
ancestor node → if both found in different subtrees
🔹 Key Conditions
If left != null AND right != null
👉 Current node is common ancestor
If one side is null
👉 Return the other side
🔹 Time & Space Complexity
Time: O(n) (visit all nodes once)
Space: O(h) (recursion stack, h = height)
✅ Solution (Concept)
Traverse the tree using DFS
Check:
If current node matches either target
Recurse into left and right subtrees
If both sides return non-null → current node is LCA
Otherwise return non-null side
✅ Implementation (Java)
public Node lowestCommonAncestor(Node root, Node n1, Node n2) {
    if (root == null) return null;

    // If current node matches one of the nodes
    if (root == n1 || root == n2) {
        return root;
    }

    // Search in left and right subtrees
    Node left = lowestCommonAncestor(root.left, n1, n2);
    Node right = lowestCommonAncestor(root.right, n1, n2);

    // If both sides return non-null → this is LCA
    if (left != null && right != null) {
        return root;
    }

    // Return the non-null side
    return (left != null) ? left : right;
}
✅ Important Note (Simplified Version)

The code you saw in the book is more complex because it:

Explicitly distinguishes:
when nodes are found
when ancestor is found

👉 But in interviews, the simplified version above is preferred.

✅ Key Takeaways
This is a DFS (Post-order) problem
No extra storage is needed
The logic depends on:
Left subtree result
Right subtree result
If both sides return nodes → current node is ancestor
✅ Simple Intuition

“If one node is found on the left side and the other is found on the right side, then the current node is their lowest common ancestor.”

If you want next, I can:

Show a step-by-step dry run
Explain difference between LCA in BST vs Binary Tree
Provide interview tricky variations (very commonly asked) 🚀
 */
    public static void main(String[] args) {

    /*        
              40
            /    \
          47      45
         /  \    /  \
        11   3  44   4
       /  \
      12  55  
    */

        BinaryTree<Integer> bt = new BinaryTree<>();
        
        bt.insert(40);
        bt.insert(47);
        bt.insert(45);
        bt.insert(11);
        bt.insert(3);
        bt.insert(44);
        bt.insert(4);
        bt.insert(12);
        bt.insert(55);
          
        int ancestor = bt.commonAncestor(12, 3);
        
        System.out.println("Common ancestor: " + ancestor);
    }
}
