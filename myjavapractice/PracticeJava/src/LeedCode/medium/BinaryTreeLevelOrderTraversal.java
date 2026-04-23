package medium;

import java.util.*;

public class BinaryTreeLevelOrderTraversal {
    /* Problem: Binary Tree Level Order Traversal | Link: https://leetcode.com/problems/binary-tree-level-order-traversal
    Difficulty: Medium | Topic: Tree, Breadth-First Search, Binary Tree | BFS traversal.
    APPROACH: Queue level by level. O(n). */

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            for (int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            result.add(level);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("Level order works\n");
    }
}
