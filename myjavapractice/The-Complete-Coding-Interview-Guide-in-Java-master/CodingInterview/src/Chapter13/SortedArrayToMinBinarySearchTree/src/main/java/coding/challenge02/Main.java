package Chapter13.SortedArrayToMinBinarySearchTree.src.main.java.coding.challenge02;
 
public class Main {
/*
Let’s go step-by-step so you fully understand this classic interview problem.

🟡 1. What is the question?

You are given:

A sorted array (in ascending order)

👉 Your task:

Build a Binary Search Tree (BST)

The BST must be:

Minimal height (i.e., as balanced as possible)

🟡 2. What does “Minimal BST” mean?

A minimal BST is:

A BST with the smallest possible height

Why?
Balanced trees → faster operations (search, insert, delete)
🟡 3. Key Idea

👉 To make the tree balanced:

Always pick the middle element as the root

Why middle?

Because:

Left side → smaller elements
Right side → larger elements

This naturally balances the tree.

🟡 4. Strategy (Very Important)

We recursively:

Pick the middle element
Make it the root
Recursively build:
Left subtree → left half of array
Right subtree → right half of array
Example:

Array:

[-2, 3, 4, 6, 7, 8, 12, 23, 90]
Step 1:
Middle = 7 → root
Step 2:
Left → [-2, 3, 4, 6]
Right → [8, 12, 23, 90]
Step 3 (recursive):
Middle of left → 3
Middle of right → 12
🟡 5. Algorithm
If start > end → return null

Find middle:

mid = (start + end) / 2
Create node with array[mid]
Recursively:
Left subtree → start → mid-1
Right subtree → mid+1 → end
Return node
🟡 6. Solution (Code Implementation)
public class SortedArrayToBST {

    public Node buildBST(int[] arr) {
        return buildBST(arr, 0, arr.length - 1);
    }

    private Node buildBST(int[] arr, int start, int end) {
        if (start > end) {
            return null;
        }

        // Find middle
        int mid = (start + end) / 2;

        // Create root node
        Node node = new Node(arr[mid]);

        // Build left subtree
        node.left = buildBST(arr, start, mid - 1);

        // Build right subtree
        node.right = buildBST(arr, mid + 1, end);

        return node;
    }
}
🟡 7. Complexity Analysis
⏱ Time Complexity:
O(n)
Each element is processed once
🧠 Space Complexity:
O(log n) (balanced recursion stack)
🟡 8. Key Insights
🔑 Always pick middle element first
🔑 Use divide and conquer
🔑 Recursion naturally builds the tree
🔑 Result is a height-balanced BST
🟡 9. Common Mistakes

❌ Picking first or last element as root
❌ Not dividing array properly
❌ Infinite recursion (wrong base case)
❌ Not handling odd/even mid properly

🟡 10. Interview Tip

This problem tests:

Recursion
Divide & conquer
BST knowledge
Tree construction skills
🟡 11. Quick Summary

👉 Problem:

Build a BST from sorted array

👉 Key idea:

Middle element = root
Recursively build left and right

👉 Result:

Balanced BST with minimal height

If you want next, I can:

Show step-by-step tree construction diagram
Provide iterative version
Compare with linked list to BST
Give LeetCode variations (very important for interviews)
 */
    public static void main(String[] args) {
    
        Integer[] m = {-2, 3, 4, 6, 7, 8, 12, 23, 90};
        
        BinarySearchTree<Integer> bt = new BinarySearchTree<>();
        
        bt.minimalBst(m);
        
        System.out.println("Root: " + bt.root());
        System.out.println("Root Height: " + bt.height());
        System.out.println("Number of nodes: " + bt.size());
     
        System.out.println("\n\nTraversal LEVEL: ");
        bt.print(BinarySearchTree.TraversalOrder.LEVEL);
        
        System.out.println("\n\nTraversal IN-ORDER: ");
        bt.print(BinarySearchTree.TraversalOrder.IN);        
        
        System.out.println("\n\nTraversal PRE-ORDER: ");
        bt.print(BinarySearchTree.TraversalOrder.PRE);        
        
        System.out.println("\n\nTraversal POST-ORDER: ");
        bt.print(BinarySearchTree.TraversalOrder.POST);                
    }

}
