package Chapter13.BinarySearchTreeKthLargestElement.src.main.java.coding.challenge18;
 
public class Main {

    /*
    Here’s a clear, structured breakdown of the problem 👇

🟢 1. What is the Question?

You are given a Binary Search Tree (BST) and an integer k.

👉 Task:
Find and print the kth largest element in the BST without modifying the tree.

🔍 Important Clarification
Largest element = highest value in the BST
kth largest:
k = 1 → largest
k = 2 → second largest
etc.
🧩 Example

BST in sorted order (in-order traversal):

45, 47, 50, 52, 54, 55, 56

👉 Then:

k = 1 → 56
k = 2 → 55
k = 3 → 54
🧠 2. Clear Analysis
🔑 Key BST Property
In-order traversal (L → Root → R) gives sorted (ascending) order

👉 So:

in-order → smallest to largest
🔁 Reverse In-Order Traversal

👉 If we reverse it:

R → Root → L

Then we get:

👉 largest → smallest

💡 Why This Works

We want the kth largest, so:

👉 Just traverse in descending order
👉 Stop when we reach k nodes

⚙️ Strategy
Traverse using Reverse In-order (Right → Node → Left)
Maintain a counter
When counter == k → found the answer
⚠️ Key Optimization

👉 Stop traversal early once kth element is found

🚀 3. Solution Approach
✅ Optimal Approach (Reverse In-order)
Steps:
Traverse right subtree first
Visit node (increment count)
Check:
if count == k → print result
Traverse left subtree
Stop early when found
⏱ Complexity
Time: O(k + h)
(k nodes visited + tree height)
Space: O(h) (recursion stack)
💻 4. Java Implementation
✅ Recursive Solution (Best for Interviews)
class Node {
    int val;
    Node left, right;

    Node(int val) {
        this.val = val;
    }
}

public class KthLargestBST {

    private int count = 0;

    public void findKthLargest(Node root, int k) {
        reverseInOrder(root, k);
    }

    private void reverseInOrder(Node node, int k) {
        if (node == null || count >= k) return;

        // Traverse right (largest first)
        reverseInOrder(node.right, k);

        // Visit node
        count++;

        if (count == k) {
            System.out.println("Kth largest element: " + node.val);
            return;
        }

        // Traverse left
        reverseInOrder(node.left, k);
    }

    public static void main(String[] args) {
        Node root = new Node(50);
        root.left = new Node(30);
        root.right = new Node(70);
        root.left.left = new Node(20);
        root.left.right = new Node(40);
        root.right.left = new Node(60);
        root.right.right = new Node(80);

        KthLargestBST obj = new KthLargestBST();
        obj.findKthLargest(root, 3); // Example: 3rd largest
    }
}
🧾 Final Summary (Interview Ready)
❓ Problem: Find kth largest element in a BST
🧠 Key Insight:
Reverse in-order traversal gives descending order
⚙️ Approach:
Traverse: Right → Root → Left
Stop when k elements are visited
⏱ Complexity:
Time: O(k + h)
Space: O(h)
🔥 Interview Tip

If asked:

👉 “Why not in-order traversal?”

Answer:

In-order gives ascending order, so we would have to process all nodes. Reverse in-order allows us to stop early after visiting k nodes, making it more efficient.

If you want next:
✅ Iterative (stack-based) version
✅ Finding kth smallest (similar but different traversal)
✅ Dry run step-by-step
✅ Handling duplicates / edge cases
     */
    public static void main(String[] args) {

    /*        
              40
            /    \
          30      45
         /  \    /  \
        15  33  42  56
       / \      /     \    
      5  17    41      67
        
    */

        BinarySearchTree<Integer> bt = new BinarySearchTree<>();
        
        bt.insert(40);
        bt.insert(30);
        bt.insert(45);
        bt.insert(15);
        bt.insert(33);
        bt.insert(42);
        bt.insert(56);
        bt.insert(5);
        bt.insert(17);
        bt.insert(41);
        bt.insert(67);             

        bt.kthLargest(3);
    }
}


