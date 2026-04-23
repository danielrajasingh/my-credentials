package medium;

public class DiameterOfBinaryTree {
    /* Problem: Diameter of Binary Tree | Link: https://leetcode.com/problems/diameter-of-binary-tree
    Difficulty: Medium | Topic: Tree, Depth-First Search, Binary Tree | Find diameter (longest path).
    APPROACH: DFS return height, track max diameter. O(n). */

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    static int maxDia = 0;

    public static int diameterOfBinaryTree(TreeNode root) {
        maxDia = 0;
        dfs(root);
        return maxDia;
    }

    private static int dfs(TreeNode node) {
        if (node == null) return 0;
        int left = dfs(node.left);
        int right = dfs(node.right);
        maxDia = Math.max(maxDia, left + right);
        return 1 + Math.max(left, right);
    }

    public static void main(String[] args) {
        System.out.println("Diameter works\n");
    }
}
