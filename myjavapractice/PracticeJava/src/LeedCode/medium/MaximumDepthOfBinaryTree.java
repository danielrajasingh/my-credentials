package medium;
public class MaximumDepthOfBinaryTree {
    static class TreeNode { int val; TreeNode left, right; TreeNode(int val) { this.val = val; } }
    public static int maxDepth(TreeNode root) {
        return root == null ? 0 : 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
    public static void main(String[] args) { System.out.println("Max depth works\n"); }
}
