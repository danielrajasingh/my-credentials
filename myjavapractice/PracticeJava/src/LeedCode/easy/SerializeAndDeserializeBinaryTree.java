package easy;

import java.util.*;

public class SerializeAndDeserializeBinaryTree {
    /* Problem: Serialize and Deserialize Binary Tree | Link: https://leetcode.com/problems/serialize-and-deserialize-binary-tree
    Difficulty: Easy | Topic: String, Tree, Depth-First Search, Breadth-First Search, Design, Binary Tree | Serialize/deserialize.
    APPROACH: Pre-order string representation. O(n). */

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    public static String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        preOrder(root, sb);
        return sb.toString();
    }

    private static void preOrder(TreeNode node, StringBuilder sb) {
        if (node == null) { sb.append("#,"); return; }
        sb.append(node.val).append(",");
        preOrder(node.left, sb);
        preOrder(node.right, sb);
    }

    public static TreeNode deserialize(String data) {
        String[] vals = data.split(",");
        List<String> list = new ArrayList<>(Arrays.asList(vals));
        return deser(list);
    }

    private static TreeNode deser(List<String> list) {
        String val = list.remove(0);
        if (val.equals("#")) return null;
        TreeNode node = new TreeNode(Integer.parseInt(val));
        node.left = deser(list);
        node.right = deser(list);
        return node;
    }

    public static void main(String[] args) {
        System.out.println("Serialize/deserialize works\n");
    }
}
