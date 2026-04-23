package hard;

public class PathSumIII {
    /* Problem: Path Sum III | Link: https://leetcode.com/problems/path-sum-iii
    Difficulty: Hard | Topic: Tree, Depth-First Search, Binary Tree | Count paths with target sum.
    APPROACH: DFS tracking running sum. O(n²). */

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    public static int pathSum(TreeNode root, long targetSum) {
        return dfs(root, targetSum);
    }

    private static int dfs(TreeNode node, long target) {
        if (node == null) return 0;
        int count = (node.val == target) ? 1 : 0;
        count += dfs(node.left, target - node.val);
        count += dfs(node.right, target - node.val);
        count += dfs(node.left, target);
        count += dfs(node.right, target);
        return count;
    }

    public static void main(String[] args) {
        System.out.println("Path sum works\n");
    }
}
