package Chapter13.BinaryTreeMaxPathSum.src.main.java.coding.challenge13;
  
public class Main {
/*
Here’s a clear and structured breakdown of Coding Challenge 13 – Maximum Path Sum in a Binary Tree.

✅ What is the Question?

You are given a non-empty binary tree and asked to:

👉 Find the maximum path sum

Important constraints:
A path:
Can start and end at any node
Must follow parent-child connections
Must contain at least one node
The path:
Does NOT have to pass through the root
✅ What is a “Path” here?

A path is any connected sequence like:

Single node
Left → Root → Right
Any downward/upward combination (without branching back up)
✅ Key Insight

At any node, the maximum path can take 4 forms:

Node alone
Node + left subtree
Node + right subtree
Node + both left and right subtrees

👉 But:

When returning to the parent, you can only choose one side (left or right)
Because paths cannot “split” upward
✅ Analysis
🔹 Why Post-Order Traversal?

We need:

Left subtree result
Right subtree result

👉 So we use Post-order (Left → Right → Root)

🔹 Core Idea

For each node:

Step 1: Compute left and right contributions
Ignore negative values (use 0 instead)
Step 2: Update global max
max = max(max, left + right + node.value)
Step 3: Return to parent
return node.value + max(left, right)
🔹 Why ignore negative values?

Because:

Negative paths reduce the total sum
So we treat them as 0 (don’t include)
🔹 Time & Space Complexity
Time: O(n) → visit every node once
Space: O(h) → recursion stack (h = tree height)
✅ Solution (Clear Explanation)
Traverse tree using DFS (post-order)
For each node:
Get max path from left and right
Ignore negatives
Update global maximum
Return max contribution upward
✅ Implementation (Java)
public class BinaryTreeMaxPathSum {

    private int max = Integer.MIN_VALUE;

    public int maxPathSum(Node root) {
        maxGain(root);
        return max;
    }

    private int maxGain(Node node) {
        if (node == null) return 0;

        // Ignore negative paths
        int left = Math.max(0, maxGain(node.left));
        int right = Math.max(0, maxGain(node.right));

        // Case: path passes through this node
        int currentPath = node.element + left + right;

        // Update global max
        max = Math.max(max, currentPath);

        // Return max gain to parent (only one side allowed)
        return node.element + Math.max(left, right);
    }
}
✅ Key Takeaways
Use DFS + Post-order traversal
Consider 4 cases at each node
Use global variable to track max path
Ignore negative values using Math.max(0, value)
Only one path can be returned to parent
✅ Simple Intuition

Think of it like:

“At each node, I try to build the best path that passes through it,
but when I go up, I can only carry the best single branch.”

If you want next:

Step-by-step dry run with example
Common interview follow-up questions
Or visual diagram explanation
 */
    public static void main(String[] args) {
 
    /*  Max path sum is 30      
                -4
            /       \
           7         2
          / \       / \  
         1   -2    4   5
        / \    \       /
       6   5   10    12
    */

        BinaryTree bt = new BinaryTree();
        
        bt.insert(-4);
        bt.insert(7);
        bt.insert(2);
        bt.insert(1);
        bt.insert(-2);
        bt.insert(4);
        bt.insert(5);
        bt.insert(6);
        bt.insert(5);
        bt.insert(0);
        bt.insert(10);
        bt.insert(0);
        bt.insert(0);
        bt.insert(12);
          
        int max = bt.maxPathSum();
        
        System.out.println("Max: " + max);
    }
}
