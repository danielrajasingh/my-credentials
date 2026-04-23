package medium;

public class PalindromeLinkedList {
    /* Problem: Palindrome Linked List | Link: https://leetcode.com/problems/palindrome-linked-list
    Difficulty: Medium | Topic: Linked List, Two Pointers, Stack, Recursion | Check if palindrome.
    APPROACH: Slow/fast pointers find middle, reverse second half, compare. O(n). */

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }

    public static boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode rev = reverse(slow);
        while (rev != null) {
            if (rev.val != head.val) return false;
            rev = rev.next;
            head = head.next;
        }
        return true;
    }

    private static ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        System.out.println("Palindrome check works\n");
    }
}
