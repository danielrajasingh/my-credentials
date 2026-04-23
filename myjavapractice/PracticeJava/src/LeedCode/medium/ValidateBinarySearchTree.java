package medium;

public class ValidateBinarySearchTree {
    /*
    Problem: Validate Binary Search Tree | Link: https://leetcode.com/problems/validate-binary-search-tree
    Difficulty: Medium | Topic: Tree, DFS, Binary Search Tree
    
    Validate if tree is valid BST. Each node's left < node < right (recursively).
    Example: [2,1,3] → true; [5,1,4,null,null,3,6] → false (4 not < 5)
    
    APPROACH: DFS with min/max bounds. Track valid range for each node.
    */

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static boolean isValidBST(TreeNode root) {
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private static boolean validate(TreeNode node, long min, long max) {
        if (node == null) {
            return true;
        }

        if (node.val <= min || node.val >= max) {
            return false;
        }

        return validate(node.left, min, node.val) && validate(node.right, node.val, max);
    }

    public static void main(String[] args) {
        // Test case 1: Valid BST
        TreeNode root1 = new TreeNode(2);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(3);
        System.out.println("Test [2,1,3]: " + isValidBST(root1));
        System.out.println("Expected: true\n");

        // Test case 2: Invalid BST
        TreeNode root2 = new TreeNode(5);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(4);
        root2.right.left = new TreeNode(3);
        root2.right.right = new TreeNode(6);
        System.out.println("Test [5,1,4,null,null,3,6]: " + isValidBST(root2));
        System.out.println("Expected: false\n");

        // Test case 3: Single node
        TreeNode root3 = new TreeNode(1);
        System.out.println("Test [1]: " + isValidBST(root3));
        System.out.println("Expected: true\n");
    }
}
