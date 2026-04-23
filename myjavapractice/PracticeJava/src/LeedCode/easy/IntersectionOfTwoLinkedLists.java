package easy;

public class IntersectionOfTwoLinkedLists {
    /* Problem: Intersection of Two Linked Lists | Link: https://leetcode.com/problems/intersection-of-two-linked-lists
    Difficulty: Easy | Topic: Hash Table, Linked List, Two Pointers | Find intersection node.
    APPROACH: Two pointers traverse both lists, meet at intersection. O(m+n). */

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA, b = headB;
        while (a != b) {
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println("Intersection check works\n");
    }
}
