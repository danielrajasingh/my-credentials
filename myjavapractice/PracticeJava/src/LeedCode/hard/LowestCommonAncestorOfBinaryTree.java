package hard;

public class LowestCommonAncestorOfBinaryTree {
    /* Problem: Lowest Common Ancestor of a Binary Tree | Link: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree
    Difficulty: Hard | Topic: Tree, DFS, Binary Tree | Find LCA of two nodes.
    APPROACH: DFS - if node is p or q, return it. Find in left/right. Return based on results. O(n). */

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) return root;
        return left != null ? left : right;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        
        TreeNode p = root.left;
        TreeNode q = root.left.right;
        System.out.println("LCA of 5 and 2: " + lowestCommonAncestor(root, p, q).val);
        System.out.println("Expected: 5\n");
    }
}
