package Chapter13.BinarySearchTreeDuplicates.src.main.java.coding.challenge15;

public class Main {

    /*
    Here’s a clear, structured breakdown of the problem 👇

🟢 1. What is the Question?

You are given a Binary Search Tree (BST).

👉 Task:
Modify the BST so that it supports duplicate values, and implement:

Insert operation
Delete operation
🔍 Important Clarification

In a normal BST:

left < node < right

👉 But here:

Duplicates are allowed
We must define how to handle them
🧩 Two Possible Approaches
✅ Approach 1: Count-based BST (Best)

Each node stores:

value
count (number of duplicates)

👉 Example:

Value	Count
10	3

Means: value 10 appears 3 times

✅ Approach 2: Insert duplicates into one side
Convention: insert duplicates into left subtree

👉 Simpler, but less efficient for counting

🧠 2. Clear Analysis
🔑 Key Idea

👉 Instead of storing duplicates as multiple nodes:

We store:

value + count
🧩 Insert Logic
Case 1: Node is null

👉 Create new node with:

count = 1
Case 2: Value == current node

👉 Duplicate found:

current.count++
Case 3: Value < current

👉 Go left

Case 4: Value > current

👉 Go right

🧩 Delete Logic
Case 1: Value not found

👉 Do nothing

Case 2: Duplicate exists (count > 1)

👉 Just decrement:

count--
Case 3: Single occurrence (count == 1)

👉 Remove node like normal BST:

Leaf → delete
One child → replace
Two children → replace with inorder successor
⚠️ Important Insight

Deleting duplicates does NOT always mean deleting the node.

🚀 3. Solution Approach
✅ Insert Algorithm
If node is null → create new node
If value equals node:
increment count
Else:
go left or right recursively
✅ Delete Algorithm
Search for node
If value found:
If count > 1 → decrement count
Else → delete node normally
Handle BST restructuring
⏱ Complexity
Insert: O(log n) (balanced tree)
Delete: O(log n)
Space: O(h) (recursion)
💻 4. Java Implementation
✅ Node Structure (With Count)
class Node {
    int val;
    int count;
    Node left, right;

    Node(int val) {
        this.val = val;
        this.count = 1;
    }
}
✅ Insert Operation
public Node insert(Node root, int val) {

    if (root == null) {
        return new Node(val);
    }

    if (val == root.val) {
        root.count++;  // handle duplicate
    }
    else if (val < root.val) {
        root.left = insert(root.left, val);
    }
    else {
        root.right = insert(root.right, val);
    }

    return root;
}
✅ Delete Operation
public Node delete(Node root, int val) {

    if (root == null) return null;

    if (val < root.val) {
        root.left = delete(root.left, val);
    }
    else if (val > root.val) {
        root.right = delete(root.right, val);
    }
    else {

        // Case 1: duplicate exists
        if (root.count > 1) {
            root.count--;
            return root;
        }

        // Case 2: node with 0 or 1 child
        if (root.left == null) return root.right;
        if (root.right == null) return root.left;

        // Case 3: node with 2 children
        Node successor = findMin(root.right);
        root.val = successor.val;
        root.count = successor.count;
        root.right = delete(root.right, successor.val);
    }

    return root;
}

private Node findMin(Node node) {
    while (node.left != null) {
        node = node.left;
    }
    return node;
}
🧾 Final Summary (Interview Ready)
❓ Problem: Handle duplicates in a BST
🧠 Key Idea:
Store duplicates using a count field
⚙️ Insert:
If duplicate → increment count
⚙️ Delete:
If count > 1 → decrement
Else → remove node normally
⏱ Complexity:
Insert/Delete: O(log n) (balanced BST)
🔥 Interview Tip

If asked:

👉 “Why use count instead of inserting duplicates as nodes?”

Answer:

Using a count avoids unnecessary tree growth, keeps the BST balanced, and simplifies operations like search, insert, and delete.

If you want next:
✅ Alternative (hash map + BST) approach
✅ Full delete step-by-step example
✅ Interview variations (e.g., duplicates on left vs right)
✅ Dry run with diagrams
     */
    public static void main(String[] args) {

    /*                        
              40(2)           D          40(1)
            /      \          E         /     \
          30(2)    45(4)      L       30(2)   45(2) 
         /    \      \        E       /
       17(2) 33(1)   56(1)    T     17(1)   
                              E
    */
        BinarySearchTree<Integer> bt = new BinarySearchTree<>();

        bt.insert(40);
        bt.insert(30);
        bt.insert(45);
        bt.insert(30);
        bt.insert(33);
        bt.insert(45);
        bt.insert(56);
        bt.insert(45);
        bt.insert(17);
        bt.insert(45);
        bt.insert(17);
        bt.insert(40);

        System.out.println("\n\nTraversal LEVEL: ");
        bt.print(BinarySearchTree.TraversalOrder.LEVEL);

        System.out.println("\n\nTraversal IN-ORDER: ");
        bt.print(BinarySearchTree.TraversalOrder.IN);

        System.out.println("\n\nTraversal PRE-ORDER: ");
        bt.print(BinarySearchTree.TraversalOrder.PRE);

        System.out.println("\n\nTraversal POST-ORDER: ");
        bt.print(BinarySearchTree.TraversalOrder.POST);

        System.out.println("\n\n\n\nDeleting... \n\n");
        bt.delete(33);
        bt.delete(45);
        bt.delete(45);
        bt.delete(40);
        bt.delete(17);
        bt.delete(56);

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
