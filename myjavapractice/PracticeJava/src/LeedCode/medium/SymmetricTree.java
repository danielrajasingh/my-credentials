package medium;

public class SymmetricTree {
    /* Problem: Symmetric Tree | Link: https://leetcode.com/problems/symmetric-tree
    Difficulty: Medium | Topic: Tree, DFS, Binary Tree | Check if tree is mirror of itself.
    APPROACH: Compare left and right subtrees recursively. O(n). */

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    public static boolean isSymmetric(TreeNode root) {
        return root == null || isMirror(root.left, root.right);
    }

    private static boolean isMirror(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        return left.val == right.val && isMirror(left.left, right.right) && isMirror(left.right, right.left);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        System.out.println("Symmetric [1,2,2]: " + isSymmetric(root));
        System.out.println("Expected: true\n");
    }
}
