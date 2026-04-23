package medium;

import java.util.*;

public class BinaryTreeInorderTraversal {
    /* Problem: Binary Tree Inorder Traversal | Link: https://leetcode.com/problems/binary-tree-inorder-traversal
    Difficulty: Medium | Topic: Stack, Tree, Depth-First Search, Binary Tree | Inorder DFS.
    APPROACH: Recursive or stack. O(n). */

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            result.add(curr.val);
            curr = curr.right;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("Inorder works\n");
    }
}
