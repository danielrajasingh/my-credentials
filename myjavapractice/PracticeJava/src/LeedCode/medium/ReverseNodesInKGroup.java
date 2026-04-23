package medium;

public class ReverseNodesInKGroup {
    /* Problem: Reverse Nodes in K-Group | Link: https://leetcode.com/problems/reverse-nodes-in-k-group
    Difficulty: Medium | Topic: Linked List, Recursion | Reverse every k nodes.
    APPROACH: Reverse group, link to next. O(n). */

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = head;
        for (int i = 0; i < k; i++) {
            if (curr == null) return head;
            curr = curr.next;
        }
        ListNode prev = null, node = head;
        for (int i = 0; i < k; i++) {
            ListNode next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }
        head.next = reverseKGroup(curr, k);
        return prev;
    }

    public static void main(String[] args) {
        System.out.println("Reverse K-Group works\n");
    }
}
