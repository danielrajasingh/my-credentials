package medium;

public class HouseRobberIII {
    static class TreeNode { int val; TreeNode left, right; TreeNode(int val) { this.val = val; } }
    static int[] dfs(TreeNode node) {
        if (node == null) return new int[]{0, 0};
        int[] left = dfs(node.left), right = dfs(node.right);
        int rob = node.val + left[1] + right[1], skip = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return new int[]{rob, skip};
    }
    public static int rob(TreeNode root) { int[] res = dfs(root); return Math.max(res[0], res[1]); }
    public static void main(String[] args) { System.out.println("House Robber III works\n"); }
}
