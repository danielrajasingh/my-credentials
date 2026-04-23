package medium;
import java.util.*;
public class PopulatingNextRightPointers {
    static class Node { int val; Node left, right, next; Node(int val) { this.val = val; } }
    public static Node connect(Node root) {
        if (root == null) return null;
        Queue<Node> q = new LinkedList<>(); q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Node node = q.poll(); if (i < size - 1) node.next = q.peek();
                if (node.left != null) q.offer(node.left); if (node.right != null) q.offer(node.right);
            }
        }
        return root;
    }
    public static void main(String[] args) { System.out.println("Next pointers connected\n"); }
}
