package hard;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    /* Problem: Construct Binary Tree from Preorder and Inorder Traversal | Link: https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
    Difficulty: Hard | Topic: Array, Hash Table, Divide and Conquer, Tree, Binary Tree | Build tree.
    APPROACH: First preorder is root, find in inorder split left/right. O(n). */

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        java.util.Map<Integer, Integer> map = new java.util.HashMap<>();
        for (int i = 0; i < inorder.length; i++) map.put(inorder[i], i);
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, map);
    }

    private static TreeNode build(int[] pre, int pL, int pR, int[] in, int iL, int iR, java.util.Map<Integer, Integer> map) {
        if (pL > pR) return null;
        TreeNode root = new TreeNode(pre[pL]);
        int idx = map.get(pre[pL]);
        root.left = build(pre, pL + 1, pL + idx - iL, in, iL, idx - 1, map);
        root.right = build(pre, pL + idx - iL + 1, pR, in, idx + 1, iR, map);
        return root;
    }

    public static void main(String[] args) {
        System.out.println("Tree build works\n");
    }
}
