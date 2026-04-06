package Chapter13.BinaryTreeDistanceFromLeaf.src.main.java.coding.challenge21;
 
public class Main {
    /*
    Here’s a clear, structured breakdown of the problem and solution 👇

🟢 1. What is the Question?

You are given:

A binary tree
An integer k

👉 Task:
Print all nodes that are exactly at distance k from any leaf node

🔍 What does “distance k from a leaf” mean?
A leaf node = a node with no children
Distance = number of edges going upward (towards root)

👉 So:

Distance 1 → parent of a leaf
Distance 2 → grandparent of a leaf
etc.
🧩 Example

If k = 2:

For a leaf node, go 2 levels up
Print that ancestor node

⚠️ Important:

A node may be at distance k from multiple leaves
Avoid printing duplicates
🧠 2. Clear Analysis
🔑 Key Idea

To find nodes at distance k from any leaf, we need to:

👉 Track the path from root to current node

💡 Why?

Because:

When we reach a leaf, we can look back in the path
The node at index:
path.length - k - 1

is the ancestor at distance k

🧩 Strategy

Use:

👉 Preorder Traversal (DFS)
👉 Keep a path list

⚙️ Steps
Traverse the tree using DFS (Preorder)
Maintain:
path → nodes from root to current node
When you reach a leaf:
Check if path length ≥ k

Add the node at position:

path[size - k - 1]
Use a Set to avoid duplicates
⚠️ Important Observations
Each root-to-leaf path is processed
Nodes may appear multiple times → use a Set
Time complexity is linear
🚀 3. Solution Approach
✅ Algorithm
Start DFS from root
Maintain:
List<Node> path
Set<Node> result
For each node:
Add to path
If leaf:
If path size ≥ k:
Add ancestor at distance k to result
Recurse left & right
Backtrack (remove node)
⏱ Complexity
Time: O(n)
Space: O(n) (path + recursion stack)
💻 4. Java Implementation
✅ Solution Code
import java.util.*;

class Node {
    int val;
    Node left, right;

    Node(int val) {
        this.val = val;
    }
}

public class KDistanceFromLeaf {

    public void printNodes(Node root, int k) {
        Set<Integer> result = new HashSet<>();
        List<Node> path = new ArrayList<>();

        findNodes(root, path, result, k);

        for (int val : result) {
            System.out.print(val + " ");
        }
    }

    private void findNodes(Node node,
                          List<Node> path,
                          Set<Integer> result,
                          int k) {

        if (node == null) return;

        // Add current node to path
        path.add(node);

        // If leaf node
        if (node.left == null && node.right == null) {

            if (path.size() > k) {
                // Get ancestor at distance k
                Node target = path.get(path.size() - k - 1);
                result.add(target.val);
            }
        }

        // Recurse left and right
        findNodes(node.left, path, result, k);
        findNodes(node.right, path, result, k);

        // Backtrack
        path.remove(path.size() - 1);
    }

    public static void main(String[] args) {
        Node root = new Node(40);
        root.left = new Node(47);
        root.right = new Node(11);
        root.left.left = new Node(3);
        root.left.right = new Node(5);
        root.right.left = new Node(7);
        root.right.right = new Node(2);

        KDistanceFromLeaf obj = new KDistanceFromLeaf();
        obj.printNodes(root, 2);
    }
}
🧾 Final Summary (Interview Ready)
❓ Problem: Find all nodes at distance k from any leaf
🧠 Key Idea:
Track root-to-node path
When at a leaf → look back k steps
⚙️ Approach:
DFS (preorder) + path list + set
⏱ Complexity:
Time: O(n)
Space: O(n)
🔥 Interview Tip

If asked:

👉 “Why use a Set?”

Answer:

To avoid printing duplicate nodes that may appear as ancestors of multiple leaf nodes.

If you want next:
✅ Dry run with a diagram
✅ Iterative (stack-based) version
✅ Similar problems (print nodes k distance from root, leaf-to-leaf distance)
✅ Common interview variations
     */
    public static void main(String[] args) {
        
        BinaryTree<Integer> bt = new BinaryTree<>();
        
        bt.leafDistance(2);
    }
}
