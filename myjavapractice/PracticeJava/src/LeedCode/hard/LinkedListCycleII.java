package hard;

public class LinkedListCycleII {
    static class ListNode { int val; ListNode next; ListNode(int val) { this.val = val; } }
    public static ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next; fast = fast.next.next;
            if (slow == fast) {
                ListNode p = head;
                while (p != slow) { p = p.next; slow = slow.next; }
                return p;
            }
        }
        return null;
    }
    public static void main(String[] args) { System.out.println("Cycle II works\n"); }
}
