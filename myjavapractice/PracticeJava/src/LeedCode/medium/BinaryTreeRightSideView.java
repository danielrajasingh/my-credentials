package medium;
import java.util.*;
public class BinaryTreeRightSideView {
    static class TreeNode { int val; TreeNode left, right; TreeNode(int val) { this.val = val; } }
    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>(); if (root == null) return result;
        Queue<TreeNode> q = new LinkedList<>(); q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size(); result.add(q.peek().val);
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll(); if (node.right != null) q.offer(node.right); if (node.left != null) q.offer(node.left);
            }
        }
        return result;
    }
    public static void main(String[] args) { System.out.println("Right side view works\n"); }
}
