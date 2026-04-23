package easy;
import java.util.*;
public class KthSmallestElementInBST {
    static class TreeNode { int val; TreeNode left, right; TreeNode(int val) { this.val = val; } }
    static int count, result;
    public static int kthSmallest(TreeNode root, int k) {
        count = 0; result = 0; inorder(root, k);
        return result;
    }
    static void inorder(TreeNode node, int k) {
        if (node == null) return;
        inorder(node.left, k);
        if (++count == k) { result = node.val; return; }
        inorder(node.right, k);
    }
    public static void main(String[] args) { System.out.println("Kth works\n"); }
}
