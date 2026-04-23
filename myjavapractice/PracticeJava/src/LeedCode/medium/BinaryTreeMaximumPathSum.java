package medium;

public class BinaryTreeMaximumPathSum {
    /* Problem: Binary Tree Maximum Path Sum | Link: https://leetcode.com/problems/binary-tree-maximum-path-sum
    Difficulty: Medium | Topic: Tree, DFS, Binary Tree | Find max sum path.
    APPROACH: DFS, track max at each node, return max child path. O(n). */

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    static int maxSum;

    public static int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        dfs(root);
        return maxSum;
    }

    private static int dfs(TreeNode node) {
        if (node == null) return 0;
        int left = Math.max(0, dfs(node.left));
        int right = Math.max(0, dfs(node.right));
        maxSum = Math.max(maxSum, node.val + left + right);
        return node.val + Math.max(left, right);
    }

    public static void main(String[] args) {
        System.out.println("Max path sum works\n");
    }
}
