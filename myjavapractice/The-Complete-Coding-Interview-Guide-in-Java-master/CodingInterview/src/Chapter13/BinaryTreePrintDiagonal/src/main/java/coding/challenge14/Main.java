package Chapter13.BinaryTreePrintDiagonal.src.main.java.coding.challenge14;

public class Main {
/*
Here’s a clear breakdown of Coding Challenge 14 – Diagonal Traversal of a Binary Tree.

✅ What is the Question?

You are given a non-empty binary tree and asked to:

👉 Print all nodes grouped by diagonals with a negative slope ()

Key idea:
Nodes lying on the same top-right → bottom-left diagonal should be printed together.
Each diagonal is printed as a group.
✅ What is a “Diagonal” in a Binary Tree?

A diagonal includes:

A node
Its right child (same diagonal)
Its left child (next diagonal)
Rule:
Move right → stay on same diagonal
Move left → move to next diagonal (diagonal + 1)
✅ Example
        50
       /  \
     45    70
    / \      \
   41  48     80
Diagonals:
Diagonal 0 → 50, 70, 80
Diagonal 1 → 45, 48
Diagonal 2 → 41
✅ Analysis
Approach 1: Recursive (HashMap)
Idea:
Use a map:
Map<DiagonalNumber, List<Node>>
Traverse tree using preorder
Assign:
left → diagonal + 1
right → same diagonal
Complexity:
Time: O(n log n) (due to map operations)
Space: O(n)
Approach 2: Iterative (Queue)
Idea:
Use a queue
Traverse nodes diagonally
When moving:
Go right → same diagonal
Store left children for next diagonal
Complexity:
Time: O(n)
Space: O(n)
✅ Solution (Clean Explanation)
🔹 Recursive Solution
Create a HashMap
Traverse tree (preorder)
Store nodes based on diagonal number
Print map values
🔹 Iterative Solution (Better)
Start with root
Push all right nodes of current diagonal
When moving to next diagonal:
Use left child
Then traverse its right chain
Repeat
✅ Implementation (Java)
🔹 Recursive Approach
public void printDiagonalRecursive(Node root) {
    Map<Integer, List<Integer>> map = new HashMap<>();
    traverse(root, 0, map);

    for (int i = 0; i < map.size(); i++) {
        System.out.println(map.get(i));
    }
}

private void traverse(Node node, int diagonal, Map<Integer, List<Integer>> map) {
    if (node == null) return;

    map.putIfAbsent(diagonal, new ArrayList<>());
    map.get(diagonal).add(node.element);

    // left → next diagonal
    traverse(node.left, diagonal + 1, map);

    // right → same diagonal
    traverse(node.right, diagonal, map);
}
🔹 Iterative Approach (Recommended)
public void printDiagonalIterative(Node root) {
    if (root == null) return;

    Queue<Node> queue = new LinkedList<>();
    queue.add(root);

    while (!queue.isEmpty()) {
        int size = queue.size();

        while (size-- > 0) {
            Node node = queue.poll();

            // Traverse all right nodes
            while (node != null) {
                System.out.print(node.element + " ");

                // enqueue left child for next diagonal
                if (node.left != null) {
                    queue.add(node.left);
                }

                node = node.right;
            }
        }

        System.out.println();
    }
}
✅ Key Takeaways
Right child → same diagonal
Left child → next diagonal
Recursive → uses HashMap
Iterative → uses Queue (more efficient)
Time complexity: O(n) (best solution)

If you want, I can next:

Draw a step-by-step dry run
Or give interview-level follow-up questions
Or convert this into Python / C++ 🚀
 */
    public static void main(String[] args) {

    /*        
             ------1------
            /             \
           47             45
         /    \         /    \
        11     31     44      52
       /  \   /  \   /  \    /  \ 
      12   9 5   45 2   `1  7    9
    */

        BinaryTree<Integer> bt = new BinaryTree<>();
        
        bt.insert(1);
        bt.insert(47);
        bt.insert(45);
        bt.insert(11);
        bt.insert(31);
        bt.insert(44);
        bt.insert(52);
        bt.insert(12);
        bt.insert(9);
        bt.insert(5);
        bt.insert(45);
        bt.insert(2);
        bt.insert(1);
        bt.insert(7);
        bt.insert(9);
          
        System.out.println("Recursive approach:");
        bt.printDiagonalRecursive();
        
        System.out.println();
        
        System.out.println("Iterative approach:");
        bt.printDiagonalIterative();
    }
}
