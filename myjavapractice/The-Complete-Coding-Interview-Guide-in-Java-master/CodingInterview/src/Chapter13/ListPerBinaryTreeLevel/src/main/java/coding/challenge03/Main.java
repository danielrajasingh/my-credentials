package Chapter13.ListPerBinaryTreeLevel.src.main.java.coding.challenge03;

public class Main {
/*
Let’s go step by step so everything is crystal clear.

🟡 1. What is the question?

You are given a binary tree.

👉 Your task:

Create a list of elements for each level
Return a structure like:
[
  [level 0 elements],
  [level 1 elements],
  [level 2 elements],
  ...
]
🟡 2. What does “List per level” mean?

Each level of the tree becomes a separate list.

Example:
        40
       /  \
     47    45
    / \    / \
   11 13  44 88
  / \
 3   1
Output:
Level 0 → [40]
Level 1 → [47, 45]
Level 2 → [11, 13, 44, 88]
Level 3 → [3, 1]
🟡 3. Key Idea (Very Important)

👉 This problem is solved using:

BFS (Breadth-First Search) / Level Order Traversal

Why BFS?

Because:

BFS naturally processes level by level
We can easily group nodes per level
🟡 4. Algorithm
Use a queue
Start with the root
Repeat until queue is empty:
Count nodes at current level
Process all nodes in that level
Add their children to the queue
Store elements in a list
Add each level list to final result
🟡 5. Solution (Clean and Standard)
import java.util.*;

public class ListPerLevel {

    public List<List<Integer>> getLevels(Node root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) return result;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size(); // number of nodes in this level
            List<Integer> currentLevel = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                Node node = queue.poll();

                currentLevel.add(node.element);

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }

            result.add(currentLevel);
        }

        return result;
    }
}
🟡 6. Complexity Analysis
⏱ Time Complexity:
O(n)
Each node is visited once
🧠 Space Complexity:
O(n)
Queue + result storage
🟡 7. Key Insights
🔑 Use Queue (FIFO) for BFS
🔑 Process nodes level by level
🔑 Use queue.size() to separate levels
🔑 Each iteration = one level
🟡 8. Common Mistakes

❌ Mixing levels in one list
❌ Not using queue.size()
❌ Using DFS instead of BFS
❌ Forgetting to store each level separately

🟡 9. Interview Tip

This problem tests:

BFS understanding
Queue usage
Tree traversal
Ability to structure output per level
🟡 10. Alternative (Recursive DFS)

If interviewer asks for variation:

You can solve using DFS + level index

If you want next, I can:

Show DFS recursive version
Give step-by-step dry run
Provide zigzag level order (very common interview twist)
Compare BFS vs DFS for this problem
 */
    public static void main(String[] args) {

    // [[40], [47, 45], [11, 13, 44, 88], [3, 1]]
    /*        
              --40--
            /        \
          -47-       -45-
         /    \     /    \
        11     13  44    88
       /  \   
      3    1 
    */

        BinaryTree<Integer> bt = new BinaryTree<>();
        
        bt.insert(40);
        bt.insert(47);
        bt.insert(45);
        bt.insert(11);
        bt.insert(13);
        bt.insert(44);
        bt.insert(88);
        bt.insert(3);
        bt.insert(1);        
          
        System.out.println(bt.fetchAllLevels());
    }
}
