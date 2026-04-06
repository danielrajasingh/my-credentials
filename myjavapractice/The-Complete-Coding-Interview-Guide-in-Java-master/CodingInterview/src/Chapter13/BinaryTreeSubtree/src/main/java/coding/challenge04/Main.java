package Chapter13.BinaryTreeSubtree.src.main.java.coding.challenge04;
 
public class Main {
/*
Let’s break this down clearly so you fully understand the question, logic, and solution.

🟡 1. What is the question?

You are given two binary trees:

Tree p (main tree)
Tree q (smaller tree)

👉 Your task:

Return true if q is a subtree of p
Return false otherwise
🟡 2. What does “subtree” mean?

Tree q is a subtree of p if:

There exists a node in p such that the subtree rooted at that node is exactly identical to q

Important:
Structure must match
Values must match
Entire subtree must match (not partial)
🟡 3. Example Understanding
✅ Valid case:
q matches a part of p exactly
❌ Invalid case:
Values match partially but structure differs
🟡 4. Key Idea

There are two checks we must perform:

🔹 Case 1: Trees match at current node

If:

p.element == q.element

👉 Then we check:

Left subtree of p == left subtree of q
Right subtree of p == right subtree of q
🔹 Case 2: Trees don’t match at current node

If:

p.element != q.element

👉 Then:

Search in left subtree of p
Search in right subtree of p
🟡 5. Algorithm
Step-by-step:
If p is null → return false
If trees match at current node → return true
Otherwise:
Check recursively:
left subtree of p
right subtree of p
Helper function (VERY IMPORTANT)

We need a function to check:

👉 Are two trees identical?

🟡 6. Solution (Code Implementation)
public class BinaryTreeSubtree {

    public boolean isSubtree(Node p, Node q) {
        if (q == null) return true;   // empty tree is always subtree
        if (p == null) return false;

        // If current trees match
        if (match(p, q)) {
            return true;
        }

        // Otherwise, check in left or right subtree
        return isSubtree(p.left, q) || isSubtree(p.right, q);
    }

    // Check if two trees are identical
    private boolean match(Node p, Node q) {
        // Both are null → match
        if (p == null && q == null) {
            return true;
        }

        // One is null → not match
        if (p == null || q == null) {
            return false;
        }

        // Check value + left + right
        return (p.element == q.element)
                && match(p.left, q.left)
                && match(p.right, q.right);
    }
}
🟡 7. Complexity Analysis
⏱ Time Complexity:
Worst case: O(n * m)
n = nodes in p
m = nodes in q

👉 Because for each node in p, we may compare entire q

🧠 Space Complexity:
O(h)
Recursion stack height of tree
🟡 8. Key Insights (Very Important for Interviews)
🔑 Two functions are required:
isSubtree() → traversal + search
match() → exact tree comparison
🔑 Always compare:
structure
values
🔑 If mismatch → continue searching in left & right subtree
🔑 Empty tree (q == null) is always a subtree
🟡 9. Common Mistakes

❌ Only checking values (ignoring structure)
❌ Not restarting comparison after mismatch
❌ Forgetting to compare full subtree
❌ Not handling null cases properly

🟡 10. Interview Tip

This problem tests:

Recursion
Tree traversal
Divide & conquer
Pattern matching in trees

If you want next, I can:

Show step-by-step dry run
Provide optimized solution using serialization (advanced)
Give LeetCode variations
Compare with tree equality problem
 */
    public static void main(String[] args) {

        /*    P:                     Q:   
              40                     30
            /    \                  /  \ 
          30      10               20   90 
         /  \    /  \             /
        20   90  70 80           6
       /
      6  
        */
        BinaryTree<Integer> p = new BinaryTree<>();

        p.insert(40);
        p.insert(30);
        p.insert(10);
        p.insert(20);
        p.insert(90);
        p.insert(70);
        p.insert(80);
        p.insert(6);
        
        BinaryTree<Integer> q = new BinaryTree<>();

        q.insert(30);
        q.insert(20);
        q.insert(90);
        q.insert(6);
        
        System.out.println("'p' subtree of 'q' ? " + p.isSubtree(q));
        System.out.println("'q' subtree of 'p' ? " + q.isSubtree(p));
    }
}
