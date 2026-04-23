package medium;

import java.util.*;

public class MergeTwoBinaryTrees {
    /* Problem: Merge Two Binary Trees | Link: https://leetcode.com/problems/merge-two-binary-trees
    Difficulty: Medium | Topic: Tree, Depth-First Search, Breadth-First Search, Binary Tree | Merge trees.
    APPROACH: Recursive DFS. O(min(m,n)). */

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    public static TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) return root2;
        if (root2 == null) return root1;
        root1.val += root2.val;
        root1.left = mergeTrees(root1.left, root2.left);
        root1.right = mergeTrees(root1.right, root2.right);
        return root1;
    }

    public static void main(String[] args) {
        System.out.println("Merge works\n");
    }
}
