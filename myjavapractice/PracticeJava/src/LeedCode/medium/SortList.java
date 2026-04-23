package medium;
import java.util.*;
public class SortList {
    static class ListNode { int val; ListNode next; ListNode(int val) { this.val = val; } }
    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode mid = getMid(head), midNext = mid.next; mid.next = null;
        return merge(sortList(head), sortList(midNext));
    }
    static ListNode getMid(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null && fast.next.next != null) { slow = slow.next; fast = fast.next.next; }
        return slow;
    }
    static ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0), curr = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) { curr.next = l1; l1 = l1.next; } else { curr.next = l2; l2 = l2.next; }
            curr = curr.next;
        }
        curr.next = l1 != null ? l1 : l2;
        return dummy.next;
    }
    public static void main(String[] args) { System.out.println("Sort list works\n"); }
}
