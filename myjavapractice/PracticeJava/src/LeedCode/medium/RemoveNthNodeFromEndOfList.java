package medium;

public class RemoveNthNodeFromEndOfList {
    /* Problem: Remove Nth Node From End of List | Link: https://leetcode.com/problems/remove-nth-node-from-end-of-list
    Difficulty: Medium | Topic: Linked List, Two Pointers
    APPROACH: Two pointers with gap of n, move until first reaches end. O(n). */

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy, second = dummy;
        for (int i = 0; i <= n; i++) first = first.next;
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }

    public static void main(String[] args) {
        System.out.println("Remove 2nd from end: [1,2,3,4,5] → [1,2,3,5]");
    }
}
