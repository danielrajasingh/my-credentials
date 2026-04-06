package Chapter13.IsSymmetricBinaryTree.src.main.java.coding.challenge24;
 
public class Main {

    /*
    Here’s a clear, structured breakdown of the problem for you—perfect for interviews:

🟢 1. What is the Question?

You are given a binary tree.

👉 Task:
Determine whether the tree is symmetric (mirror image of itself).

🔍 What does “symmetric” mean?

A binary tree is symmetric if:

The left subtree is a mirror of the right subtree
Both structure and values match in a mirrored way
🧠 2. Clear Analysis
🔑 Key Observations

A tree is symmetric if:

The root is the same for both sides (implicitly)
The left subtree mirrors the right subtree
📌 Mirror Condition

To check symmetry, compare:

Left child of left subtree ↔ Right child of right subtree
Right child of left subtree ↔ Left child of right subtree
🧩 Recursive Insight

Think of it as:

Two trees are mirrors if:

Their roots are equal
Their children follow mirrored structure
⚠️ Base Cases
If both nodes are null → symmetric ✅
If one is null and the other is not → not symmetric ❌
If values are different → not symmetric ❌
🎯 Key Idea

👉 Compare pairs of nodes instead of traversing the whole tree normally.

🚀 3. Solution Approach

We can solve this using:

✅ A. Recursive Approach (DFS)
Logic:

Compare two nodes at a time:

left.left with right.right
left.right with right.left
Time Complexity:

👉 O(n) (visit each node once)

Space Complexity:

👉 O(h) (recursion stack, where h = height of tree)

🧠 Algorithm Steps
Start with root.left and root.right
Recursively check:
Values are equal
Left subtree of one == Right subtree of other
Right subtree of one == Left subtree of other
If all conditions pass → symmetric
🔁 B. Iterative Approach (BFS using Queue)
Logic:
Use a queue to compare nodes in pairs
Steps:
Add root.left and root.right to queue
While queue is not empty:
Remove two nodes at a time
Compare them
Add children in mirror order
Time Complexity:

👉 O(n)

Space Complexity:

👉 O(n) (queue storage)

💻 4. Java Implementation
✅ Recursive Solution
class Node {
    int val;
    Node left, right;

    Node(int val) {
        this.val = val;
    }
}

public class SymmetricTree {

    public boolean isSymmetric(Node root) {
        if (root == null) return true;
        return isMirror(root.left, root.right);
    }

    private boolean isMirror(Node left, Node right) {
        // Both null → symmetric
        if (left == null && right == null) return true;

        // One null → not symmetric
        if (left == null || right == null) return false;

        // Values must match + recursive checks
        return (left.val == right.val)
                && isMirror(left.left, right.right)
                && isMirror(left.right, right.left);
    }
}
🔁 Iterative Solution (Queue)
import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTreeIterative {

    public boolean isSymmetric(Node root) {
        if (root == null) return true;

        Queue<Node> queue = new LinkedList<>();

        queue.offer(root.left);
        queue.offer(root.right);

        while (!queue.isEmpty()) {
            Node left = queue.poll();
            Node right = queue.poll();

            // Both null → continue
            if (left == null && right == null) continue;

            // One null or values not equal → not symmetric
            if (left == null || right == null || left.val != right.val) {
                return false;
            }

            // Add mirror pairs
            queue.offer(left.left);
            queue.offer(right.right);

            queue.offer(left.right);
            queue.offer(right.left);
        }

        return true;
    }
}
🧾 Final Summary (Interview Ready)
❓ Problem: Check if a binary tree is symmetric
🧠 Key Idea: Compare mirror nodes
⚙️ Approaches:
Recursive (DFS)
Iterative (Queue / BFS)
⏱ Complexity:
Time: O(n)
Space:
Recursive: O(h)
Iterative: O(n)

If you want next level preparation, I can help you with:
✅ Dry run with example tree
✅ Common interview traps
✅ Edge cases (very important for Google/Amazon)
✅ Similar problems (tree mirroring, same tree, etc.)

     */
    public static void main(String[] args) {

        /*                          
              40    
            /    \   
          47      47
         /  \    /  \ 
        11   3  3   11
         */
        BinaryTree<Integer> bt = new BinaryTree<>();

        bt.insert(40);
        bt.insert(47);
        bt.insert(47);
        bt.insert(11);
        bt.insert(3);
        bt.insert(3);
        bt.insert(11);

        System.out.println("Symmetry check recursive: " + bt.isSymmetricRecursive());
        System.out.println("Symmetry check iterative: " + bt.isSymmetricIterative());
    }
}
