package Chapter13.TwoBinaryTreesAreIsomorphic.src.main.java.coding.challenge16;
 
public class Main {
/*
Here’s a clear, structured breakdown of the problem 👇

🟢 1. What is the Question?

You are given two binary trees.

👉 Task:
Determine whether the two trees are isomorphic.

🔍 What does “isomorphic” mean?

Two binary trees are isomorphic if:

👉 One tree can be transformed into the other by swapping left and right children at any number of nodes.

🧩 Important Points
Trees must have the same structure (or mirrored structure)
Node values must match
You are allowed to flip children (swap left ↔ right) any number of times
🧠 Example

Tree 1:

    1
   / \
  2   3

Tree 2:

    1
   / \
  3   2

👉 These are isomorphic (just a swap at root)

🧠 2. Clear Analysis
🔑 Key Idea

For two trees to be isomorphic:

At every node:

👉 We must check two possibilities:

No swap case:
left → left
right → right
Swap case:
left → right
right → left
⚙️ Recursive Thinking

For nodes t1 and t2:

✅ Base Cases
Both null → true
One null → false
Values not equal → false
🔁 Recursive Cases

Check:

(no swap) AND (swap)

Where:

🧩 Case 1: No Swap
left(t1) ↔ left(t2)
right(t1) ↔ right(t2)
🧩 Case 2: Swap
left(t1) ↔ right(t2)
right(t1) ↔ left(t2)

👉 If either case is true → trees are isomorphic

🚀 3. Solution Approach
✅ Algorithm
If both nodes are null → return true
If one is null → return false
If values differ → return false
Recursively check:
No swap
Swap
Return OR of both cases
⏱ Complexity
Time: O(n)
Space: O(h) (recursion stack)
💻 4. Java Implementation
✅ Recursive Solution
class Node {
    int val;
    Node left, right;

    Node(int val) {
        this.val = val;
    }
}

public class IsomorphicBinaryTrees {

    public boolean isIsomorphic(Node t1, Node t2) {

        // Case 1: both null
        if (t1 == null && t2 == null) return true;

        // Case 2: one is null
        if (t1 == null || t2 == null) return false;

        // Case 3: values not equal
        if (t1.val != t2.val) return false;

        // Case 4: check both possibilities

        // No swap case
        boolean noSwap = isIsomorphic(t1.left, t2.left) &&
                         isIsomorphic(t1.right, t2.right);

        // Swap case
        boolean swap = isIsomorphic(t1.left, t2.right) &&
                       isIsomorphic(t1.right, t2.left);

        return noSwap || swap;
    }
}
🧾 Final Summary (Interview Ready)
❓ Problem: Check if two binary trees are isomorphic
🧠 Key Idea:
Trees can be transformed using child swaps
⚙️ Approach:
Recursive comparison of:
no-swap case
swap case
⏱ Complexity:
Time: O(n)
Space: O(h)
🔥 Interview Tip

If asked:

👉 “Why check both swap and no-swap cases?”

Answer:

Because at each node, we don't know whether the structure was swapped or not. So we must check both possibilities to ensure all valid transformations are considered.

If you want next:
✅ Dry run with a tricky example
✅ Iterative solution (rare but impressive)
✅ Difference between isomorphic, identical, and mirror trees
✅ Common interview traps
 */
    public static void main(String[] args) {
  
        BinaryTree bt = new BinaryTree();
        
        boolean result = bt.isIsomorphic();
        System.out.println("Is isomorphic: " + result);
    }
}
