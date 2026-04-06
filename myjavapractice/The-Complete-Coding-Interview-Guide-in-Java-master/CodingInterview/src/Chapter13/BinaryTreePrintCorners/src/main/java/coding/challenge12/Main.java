package Chapter13.BinaryTreePrintCorners.src.main.java.coding.challenge12;
 
public class Main {
/*
Here’s a clear breakdown of Coding Challenge 12 – Printing Binary Tree Corners.

✅ What is the Question?

You are given a binary tree and asked to:

👉 Print the “corner” nodes at each level

What are “corner nodes”?

For every level in the tree:

First node (leftmost)
Last node (rightmost)
✅ Example

Consider this tree:

        10
       /  \
      5    20
     / \     \
    3   7     25
Output:
Level 0: 10
Level 1: 5 20
Level 2: 3 25
✅ Analysis
🔹 Key Idea

We need to:

Traverse the tree level by level
Identify:
First node in level
Last node in level

👉 This is best done using BFS (Level Order Traversal)

🔹 Why BFS?

Because:

BFS processes nodes level by level
We can easily track:
Number of nodes in a level (size)
Position of nodes in that level
🔹 Logic to Detect Corners

For each level:

Let size = number of nodes in this level
Track position while iterating
Conditions:
First node → position == size - 1
Last node → position == 0
🔹 Time & Space Complexity
Time: O(n) → visit each node once
Space: O(n) → queue storage
✅ Solution (Concept)
Start with root in queue
While queue is not empty:
Get current level size
Traverse all nodes in that level
Print:
First node
Last node
Add children to queue
✅ Implementation (Java)
public void printCorners(Node root) {
    if (root == null) return;

    Queue<Node> queue = new LinkedList<>();
    queue.add(root);

    int level = 0;

    while (!queue.isEmpty()) {
        int size = queue.size();
        System.out.print("Level " + level + ": ");
        level++;

        for (int i = 0; i < size; i++) {
            Node node = queue.poll();

            // Print corner nodes
            if (i == 0 || i == size - 1) {
                System.out.print(node.element + " ");
            }

            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }

        System.out.println();
    }
}
✅ Key Takeaways
Use Level Order Traversal (BFS)
Track nodes using:
i == 0 → first node
i == size - 1 → last node
Works efficiently in O(n) time
✅ Simple Intuition

“At every level, I only care about the first and last nodes—everything in between can be ignored.”

If you want, I can:

Show a step-by-step dry run
Give edge cases interviewers ask
Or compare with printing boundary of tree (harder problem)
 */
    public static void main(String[] args) {

    /*        
             --40--
            /      \
           47       45
         /    \    /  \
        11     3  44   23
       /  \   / 
      2    4 1   
    */

        BinaryTree<Integer> bt = new BinaryTree<>();
        
        bt.insert(40);
        bt.insert(47);
        bt.insert(45);
        bt.insert(11);
        bt.insert(3);
        bt.insert(44);
        bt.insert(23);
        bt.insert(2);
        bt.insert(4);
        bt.insert(1);        
                          
        bt.printCorners();                        
    }
}
