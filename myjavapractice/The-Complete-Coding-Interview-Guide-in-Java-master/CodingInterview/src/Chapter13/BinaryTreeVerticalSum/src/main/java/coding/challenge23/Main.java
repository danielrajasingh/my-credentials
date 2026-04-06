package Chapter13.BinaryTreeVerticalSum.src.main.java.coding.challenge23;
 
public class Main {

    public static void main(String[] args) {   
/*
Here’s a clear, structured breakdown of the problem—perfect for interviews:

🟢 1. What is the Question?

You are given a binary tree.

👉 Task:
Compute the vertical sum of the tree.

🔍 What is “vertical sum”?
Imagine drawing vertical lines through the tree
Each node belongs to a vertical line (column)
You must sum all nodes in the same vertical column
📌 Horizontal Distance Concept
Root → distance = 0
Left child → distance = -1
Right child → distance = +1

👉 Every vertical line is identified by this distance

🧩 Example

If tree has columns:

-3  -2  -1   0   1   2   3
 5   7   16  35  54  44  6

👉 Output = [5, 7, 16, 35, 54, 44, 6]

🧠 2. Clear Analysis
🔑 Key Idea

Each node contributes to exactly one vertical line

👉 So we need to:

Track horizontal distance (HD) from root
Group nodes by HD
Sum values for each HD
⚙️ Strategy

Use:

👉 HashMap (distance → sum)

🧩 Traversal Approach
Use DFS (Preorder traversal):
Visit root
Traverse left
Traverse right

At each node:

Add value to its corresponding distance
🧠 Recurrence Logic
left child  → distance - 1
right child → distance + 1
⚠️ Important Insight

This is similar to grouping nodes based on their vertical alignment.

🚀 3. Solution Approach
🪜 Steps
Start with root at distance = 0
Create a Map<Integer, Integer>
key = horizontal distance
value = vertical sum
Traverse the tree recursively:
Add node value to map at current distance
Move:
Left → distance - 1
Right → distance + 1
Finally:
Sort keys and return sums (if order needed)
⏱ Complexity
Time:
O(n log n) (due to TreeMap / map operations)
Space:
O(n) (map + recursion stack)

👉 Can be improved to O(n) using HashMap + list

💻 4. Java Implementation
✅ Recursive Solution
import java.util.*;

class Node {
    int val;
    Node left, right;

    Node(int val) {
        this.val = val;
    }
}

public class VerticalSumBinaryTree {

    public static void verticalSum(Node root) {
        Map<Integer, Integer> map = new TreeMap<>();

        calculateVerticalSum(root, map, 0);

        // Print results
        for (int key : map.keySet()) {
            System.out.print(map.get(key) + " ");
        }
    }

    private static void calculateVerticalSum(Node node,
                                            Map<Integer, Integer> map,
                                            int dist) {
        if (node == null) return;

        // Add current node value
        map.put(dist, map.getOrDefault(dist, 0) + node.val);

        // Traverse left → distance -1
        calculateVerticalSum(node.left, map, dist - 1);

        // Traverse right → distance +1
        calculateVerticalSum(node.right, map, dist + 1);
    }

    public static void main(String[] args) {
        Node root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(22);
        root.left.left = new Node(5);
        root.left.right = new Node(3);
        root.right.right = new Node(25);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);

        verticalSum(root);
    }
}
🧾 Final Summary (Interview Ready)
❓ Problem: Find vertical sums in a binary tree
🧠 Key Idea:
Assign horizontal distance (HD) to each node
Group nodes with same HD
⚙️ Approach:
DFS traversal + HashMap
⏱ Complexity:
Time: O(n log n) (TreeMap)
Space: O(n)

💡 Core Concept:

“Nodes with same horizontal distance belong to same vertical line”

🔥 Bonus (Interview Tip)

If interviewer asks:

👉 “Can you optimize?”

Answer:

Yes, using a HashMap instead of TreeMap gives O(n) time, and we can track min and max horizontal distances to print in order.

If you want next:
✅ Step-by-step dry run
✅ Optimized O(n) solution explanation
✅ BFS (level order) variation
✅ Similar problems (top view, bottom view, vertical order traversal)
 */
        BinaryTree<Integer> bt = new BinaryTree<>();
        
        bt.verticalSum();
    }
}
