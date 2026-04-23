package easy;

public class FlattenBinaryTreeToLinkedList {
    /* Problem: Flatten Binary Tree to Linked List | Link: https://leetcode.com/problems/flatten-binary-tree-to-linked-list
    Difficulty: Easy | Topic: Linked List, Stack, Tree, Depth-First Search, Binary Tree | Flatten.
    APPROACH: Pre-order DFS, right=flatten(left). O(n). */

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    public static void flatten(TreeNode root) {
        if (root == null) return;
        TreeNode left = root.left;
        TreeNode right = root.right;
        if (left != null) {
            flatten(left);
            root.right = left;
            TreeNode curr = left;
            while (curr.right != null) curr = curr.right;
            curr.right = right;
            root.left = null;
        }
        flatten(right);
    }

    public static void main(String[] args) {
        System.out.println("Flatten works\n");
    }
}
