package Chapter14.RankInStream.src.main.java.coding.challenge14;

public class Main {
/*
            Let’s break this Stream Ranking problem clearly and simply 👇

            ✅ 1. What is the Question?

            You are given a stream of integers (numbers arriving one by one).

            👉 You must build a system that supports:

            ✔️ Operation:

            Find the rank of a number p

            🔍 What is “Rank”?

            Rank = number of elements ≤ p (less than or equal to p)

            📌 Example

            Stream:

            40, 30, 45, 15, 33, 42, 56, 5, 17, 41, 67

            Now:

            Rank(45) = 8
            Rank(5)  = 0
            Rank(17) = 2

            👉 Count how many numbers are ≤ given number

            ❌ 2. Naive Approach
            Idea:
            Store all numbers in a sorted array
            Insert in sorted order
            Count elements ≤ p
            Problem:
            Insertion requires shifting elements
            Complexity:
            Insert → O(n)
            Rank → O(n)

            👉 Not efficient for streaming data

            ✅ 3. Optimal Idea (Binary Search Tree 🔥)

            👉 Use a Binary Search Tree (BST) with extra information

            ✅ 4. Key Insight

            Each node stores:

            leftTreeSize = number of nodes in left subtree
            ✅ 5. Why This Works?

            Because:

            All values in the left subtree are ≤ current node

            So:

            leftTreeSize = count of elements ≤ current node (in left side)
            ✅ 6. Algorithm
            🔹 Step 1: Insert elements

            While inserting:

            If going left → increment leftTreeSize
            If going right → do nothing
            🔹 Step 2: Get Rank

            For a number p:

            Case 1: p == node.value
            return node.leftTreeSize
            Case 2: p < node.value

            Go left

            Case 3: p > node.value
            return node.leftTreeSize + 1 + rank(right subtree)
            ✅ 7. Intuition

            When moving right:

            All left subtree nodes → smaller
            Current node → smaller
            So:
            rank = leftTreeSize + 1 + right subtree rank
            ✅ 8. Java Implementation
            public class StreamRanking {

                private Node root;

                class Node {
                    int value;
                    int leftTreeSize;
                    Node left, right;

                    Node(int value) {
                        this.value = value;
                        this.leftTreeSize = 0;
                    }
                }

                // Insert element into BST
                public void insert(int value) {
                    root = insert(root, value);
                }

                private Node insert(Node node, int value) {

                    if (node == null) {
                        return new Node(value);
                    }

                    if (value <= node.value) {
                        node.leftTreeSize++;
                        node.left = insert(node.left, value);
                    } else {
                        node.right = insert(node.right, value);
                    }

                    return node;
                }

                // Get rank of element
                public int getRank(int value) {
                    return getRank(root, value);
                }

                private int getRank(Node node, int value) {

                    if (node == null) {
                        return -1;
                    }

                    if (value == node.value) {
                        return node.leftTreeSize;
                    }
                    else if (value < node.value) {
                        return getRank(node.left, value);
                    }
                    else {
                        int rightRank = getRank(node.right, value);

                        if (rightRank == -1) return -1;

                        return node.leftTreeSize + 1 + rightRank;
                    }
                }

                public static void main(String[] args) {

                    StreamRanking sr = new StreamRanking();

                    int[] stream = {40, 30, 45, 15, 33, 42, 56, 5, 17, 41, 67};

                    for (int num : stream) {
                        sr.insert(num);
                    }

                    System.out.println(sr.getRank(45)); // 8
                    System.out.println(sr.getRank(5));  // 0
                    System.out.println(sr.getRank(17)); // 2
                }
            }
            ✅ 9. Complexity Analysis
            Operation	Complexity
            Insert	O(log n) (average)
            Rank	O(log n) (average)

            👉 Worst case (unbalanced tree): O(n)

            ⚠️ 10. Problem with BST

            👉 If data is sorted → BST becomes skewed

            🚀 11. Better Solution (Follow-up)

            Use:

            ✔️ Balanced BST
            AVL Tree
            Red-Black Tree

            OR

            ✔️ Order Statistics Tree (OS Tree)

            OR

            ✔️ Fenwick Tree / Segment Tree (if range known)
            ❌ Common Mistakes
            ❌ Not updating leftTreeSize
            ❌ Confusing < vs ≤
            ❌ Ignoring duplicates
            ❌ Not handling missing elements
            ✅ 12. Short Interview Answer

            Use a BST where each node tracks the size of its left subtree. While inserting, update this value. To get rank, traverse the tree and accumulate counts based on left subtree sizes.

            🔥 13. Key Insight to Remember

            👉 Rank = count of elements ≤ p

            👉 leftTreeSize is the secret to O(log n) queries

            If you want next level:

            I can show Fenwick Tree solution (very important for FAANG)
            Or give Order Statistics Tree (advanced C++)
            Or draw a step-by-step tree visualization 🚀
 */
    public static void main(String[] args) {

      /*        
              40
            /    \
          30      45
         /  \    /  \
        15  33  42  56
       / \       \    \    
      5  17       43  67        
      */
        Stream stream = new Stream();

        stream.generate(40);
        stream.generate(30);
        stream.generate(45);
        stream.generate(15);
        stream.generate(33);
        stream.generate(42);
        stream.generate(56);
        stream.generate(5);
        stream.generate(17);
        stream.generate(43);
        stream.generate(67);

        System.out.println("Rank of 40: " + stream.getRank(40));
        System.out.println("Rank of 30: " + stream.getRank(30));
        System.out.println("Rank of 45: " + stream.getRank(45));
        System.out.println("Rank of 15: " + stream.getRank(15));
        System.out.println("Rank of 33: " + stream.getRank(33));
        System.out.println("Rank of 42: " + stream.getRank(42));
        System.out.println("Rank of 56: " + stream.getRank(56));
        System.out.println("Rank of 5: " + stream.getRank(5));
        System.out.println("Rank of 17: " + stream.getRank(17));
        System.out.println("Rank of 43: " + stream.getRank(43));
        System.out.println("Rank of 67: " + stream.getRank(67));
        System.out.println("Rank of 6: " + stream.getRank(6));
    }
}
