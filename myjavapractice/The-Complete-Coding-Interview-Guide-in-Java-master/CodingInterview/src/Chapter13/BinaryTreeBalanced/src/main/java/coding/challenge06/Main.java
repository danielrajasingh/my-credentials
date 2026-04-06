package Chapter13.BinaryTreeBalanced.src.main.java.coding.challenge06;
 
public class Main {
/*
Let’s go step-by-step so everything is crystal clear.

🟡 1. What is the question?

You are given a binary tree.

👉 You must write a function that:

Returns true if the tree is balanced
Returns false if the tree is not balanced
🟡 2. What does “Balanced Binary Tree” mean?

A binary tree is balanced if:

For every node, the difference between the heights of the left and right subtrees is at most 1

In simple terms:

Height difference:

|left subtree height - right subtree height| ≤ 1

If this condition fails for any node, the tree is ❌ not balanced

🟡 3. Example Understanding
✅ Balanced Tree:
Each node has:
left height = right height OR differs by 1
❌ Unbalanced Tree:

Example:

root (40)
  ├── left height = 4
  └── right height = 2

Difference = 2 → ❌ Not balanced

🟡 4. Naive Approach (Simple but slow)
Idea:
For each node:
Compute height of left subtree
Compute height of right subtree
Check difference
Problem:
Height is computed repeatedly → inefficient

👉 Time Complexity: O(n log n)

🟡 5. Optimal Approach (Important)
Key Idea:

👉 Compute height + balance check in one traversal

Instead of:

First calculating height
Then checking balance

We:

Return height if balanced
Return a special value (error) if not balanced
💡 Trick:

Use:

Integer.MIN_VALUE  → indicates "NOT BALANCED"
🟡 6. Algorithm
Start from root
Recursively check:
Left subtree height
Right subtree height
If either subtree is unbalanced → propagate error
If difference > 1 → return error
Otherwise → return height
🟡 7. Solution (Code Implementation)
public class BinaryTreeBalanced {

    public boolean isBalanced(Node root) {
        return checkHeight(root) != Integer.MIN_VALUE;
    }

    private int checkHeight(Node root) {
        // Base case
        if (root == null) {
            return 0;
        }

        // Check left subtree
        int leftHeight = checkHeight(root.left);
        if (leftHeight == Integer.MIN_VALUE) {
            return Integer.MIN_VALUE; // not balanced
        }

        // Check right subtree
        int rightHeight = checkHeight(root.right);
        if (rightHeight == Integer.MIN_VALUE) {
            return Integer.MIN_VALUE; // not balanced
        }

        // Check balance condition
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return Integer.MIN_VALUE; // imbalance found
        }

        // Return height if balanced
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
🟡 8. Complexity Analysis
⏱ Time Complexity:
O(n)
Each node is visited only once
🧠 Space Complexity:
O(h)
h = height of tree (recursion stack)
🟡 9. Key Takeaways
❌ Naive approach → O(n log n)
✅ Optimal approach → O(n)
🔑 Combine:
Height calculation
Balance checking
🔑 Use sentinel value (error propagation) to stop early
🟡 10. Interview Tip

When interviewer asks:

“Is the tree balanced?”

They are testing:

Recursion skills
Optimization thinking
Ability to reduce time complexity

If you want, I can next:

Show step-by-step dry run
Compare with top-down vs bottom-up approaches
Give LeetCode-style variations
Convert this into Python / C++ / iterative solution
 */
    public static void main(String[] args) {

    /*  not balanced at root      
              40
            /    \
           30     49
          /  \   /  \  
         20  35 45   52
            /  \
           34  37
              /
             36
    */

        BinaryTree<Integer> bt = new BinaryTree<>();
        
        bt.insert(40);
        bt.insert(30);
        bt.insert(49);
        bt.insert(20);
        bt.insert(35);
        bt.insert(45);
        bt.insert(52);
        bt.insert(34);
        bt.insert(37);
        bt.insert(36); // if you comment this line the tree is balanced
                  
        System.out.println("Balanced (approach 1)? " + bt.isBalanced1());              
        System.out.println("Balanced (approach 2)? " + bt.isBalanced2());              
    }
}
