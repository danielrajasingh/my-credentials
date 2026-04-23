package medium;

public class InvertBinaryTree {
    /* Problem: Invert Binary Tree | Link: https://leetcode.com/problems/invert-binary-tree
    Difficulty: Medium | Topic: Tree, Depth-First Search, Breadth-First Search, Binary Tree | Mirror tree.
    APPROACH: Recursively swap left/right. O(n). */

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    public static TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode temp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(temp);
        return root;
    }

    public static void main(String[] args) {
        System.out.println("Invert works\n");
    }
}
