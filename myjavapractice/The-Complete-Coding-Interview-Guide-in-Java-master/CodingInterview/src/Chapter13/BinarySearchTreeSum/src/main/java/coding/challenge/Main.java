package Chapter13.BinarySearchTreeSum.src.main.java.coding.challenge;
 
public class Main {
/*
Here’s a clear, structured breakdown of this problem—perfect for interviews:

🟢 1. What is the Question?

You are given a Binary Search Tree (BST) and a target sum.

👉 Task:
Determine whether there exists any pair of nodes in the BST such that:

node1.value + node2.value = target sum
🔍 Key Point
You must return true if such a pair exists, otherwise false
Nodes can be from anywhere in the tree
You cannot reuse the same node twice
🧠 2. Clear Analysis
🔑 Important Property of BST

In a BST:

Left subtree → smaller values
Right subtree → larger values

👉 This property is crucial for optimization.

🧩 Core Idea (Hashing Approach)
Strategy:
Traverse the tree (DFS)
For each node:
Check if target - node.value exists in a set
If yes → pair found ✅
Else → add current value to set
💡 Why This Works?

If we have:

x + y = target

Then:

y = target - x

👉 So while traversing:

If target - current_node is already seen → pair exists
⚠️ Alternative Thinking (BST + Two Pointers)

Because BST is sorted via in-order traversal, we can treat it like a sorted array.

🔁 Two-pointer idea:
One pointer → smallest (forward in-order)
One pointer → largest (reverse in-order)

Then:

If sum < target → move forward pointer
If sum > target → move backward pointer
If equal → found pair
🚀 3. Solution Approach
✅ Approach 1: HashSet (Simplest & Most Common)
Steps:
Traverse tree (DFS)
Maintain a HashSet
For each node:
Check if (target - node.val) exists
If yes → return true
Else → add node value to set
⏱ Complexity:
Time: O(n)
Space: O(n)
✅ Approach 2: Two Pointers using Stacks (Advanced)
Idea:
Use:
Forward in-order (smallest first)
Reverse in-order (largest first)
Compare sum of both pointers
⏱ Complexity:
Time: O(n)
Space: O(h) (tree height)
💻 4. Java Implementation
✅ Approach 1: Using HashSet (Best for Interviews)
import java.util.HashSet;
import java.util.Set;

class Node {
    int val;
    Node left, right;

    Node(int val) {
        this.val = val;
    }
}

public class PairSumBST {

    public boolean findPair(Node root, int target) {
        Set<Integer> set = new HashSet<>();
        return dfs(root, target, set);
    }

    private boolean dfs(Node node, int target, Set<Integer> set) {
        if (node == null) return false;

        // Check left subtree
        if (dfs(node.left, target, set)) return true;

        // Check complement
        if (set.contains(target - node.val)) {
            System.out.println("Pair found: (" +
                    (target - node.val) + ", " + node.val + ")");
            return true;
        }

        // Add current node
        set.add(node.val);

        // Check right subtree
        return dfs(node.right, target, set);
    }
}
🔁 Approach 2: Two Stacks (Advanced)
import java.util.Stack;

public class PairSumBSTTwoStack {

    public boolean findPair(Node root, int target) {
        if (root == null) return false;

        Stack<Node> forward = new Stack<>();
        Stack<Node> backward = new Stack<>();

        Node left = root;
        Node right = root;

        while (true) {

            // Forward traversal (in-order)
            while (left != null) {
                forward.push(left);
                left = left.left;
            }

            // Reverse traversal
            while (right != null) {
                backward.push(right);
                right = right.right;
            }

            if (forward.isEmpty() || backward.isEmpty()) return false;

            Node lNode = forward.peek();
            Node rNode = backward.peek();

            // Stop if pointers meet
            if (lNode == rNode) return false;

            int sum = lNode.val + rNode.val;

            if (sum == target) {
                System.out.println("Pair found: (" +
                        lNode.val + ", " + rNode.val + ")");
                return true;
            }

            if (sum < target) {
                left = forward.pop().right;
            } else {
                right = backward.pop().left;
            }
        }
    }
}
🧾 Final Summary (Interview Ready)
❓ Problem: Find a pair in BST whose sum equals target
🧠 Key Insight:
Use complement (target - value)
Use BST property for optimization
⚙️ Approaches:
HashSet (simple & optimal)
Two-pointer using two stacks (advanced)
⏱ Complexity:
Time: O(n)
Space: O(n) (HashSet) or O(h) (stack approach)
🔥 Interview Tip

If asked:

👉 “Why HashSet?”

Answer:

Because it allows constant-time lookup, enabling us to check complements efficiently during traversal in O(n) time.

If you want next:
✅ Dry run of this algorithm
✅ BST traversal tricks (very important for interviews)
✅ Variations (3-sum in BST, closest pair, etc.)
✅ Coding patterns to recognize these problems
 */
    public static void main(String[] args) {
        
    /*        
              50
            /    \
          45      62
         /  \       \
        43  46      68
       /      \    /  \    
      6       49  65  71
        
    */

        BinarySearchTree bt = new BinarySearchTree();
        
        bt.insert(50);
        bt.insert(45);
        bt.insert(62);
        bt.insert(43);
        bt.insert(46);
        bt.insert(68);
        bt.insert(6);
        bt.insert(49);
        bt.insert(65);
        bt.insert(71);       
                  
        boolean found1 = bt.findPairSumHashing(133);
        boolean found2 = bt.findPairSumTwoStacks(133);
        System.out.println("\nPair found? " + found1 + "  |  " + found2);
    }

}
