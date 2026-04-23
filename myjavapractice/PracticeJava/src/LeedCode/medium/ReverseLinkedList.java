package medium;

public class ReverseLinkedList {
    /*
    ========================================
    Problem: Reverse Linked List
    Link: https://leetcode.com/problems/reverse-linked-list
    Difficulty: Medium
    Topic: Linked List, Recursion
    ========================================
    
    PROBLEM EXPLANATION:
    Given head of singly linked list, reverse it. Return reversed list head.
    
    Example: 1→2→3→4→5 becomes 5→4→3→2→1
    
    KEY OBSERVATIONS:
    - Iterative: use three pointers (prev, current, next)
    - Recursive: reverse rest, connect back
    - Time: O(n), Space: O(1) iterative, O(n) recursive
    
    APPROACH (Iterative):
    1. Initialize prev=null, current=head
    2. While current != null:
       - Save next = current.next
       - Reverse link: current.next = prev
       - Move prev, current forward
    3. Return prev (new head)
    
    TIME COMPLEXITY: O(n) - visit each node once
    SPACE COMPLEXITY: O(1) - only using pointers
    
    DRY RUN:
    1→2→3→null
    prev=null, curr=1, next=2
    1→null, prev=1, curr=2
    1→null←2, prev=2, curr=3
    1←2←3, prev=3, curr=null
    Result: 3→2→1 ✓
    
    MEMORY TRICK:
    "Three pointers: save next, reverse link, move forward"
    
    VISUALIZATION:
    Before: 1→2→3
    Step 1: null←1  2→3
    Step 2: null←1←2  3
    Step 3: null←1←2←3
    Result: 3→2→1
    */

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;

        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }

    static ListNode createList(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        ListNode head = new ListNode(arr[0]);
        ListNode current = head;
        for (int i = 1; i < arr.length; i++) {
            current.next = new ListNode(arr[i]);
            current = current.next;
        }
        return head;
    }

    static void printList(ListNode head) {
        System.out.print("[");
        while (head != null) {
            System.out.print(head.val);
            head = head.next;
            if (head != null) System.out.print(",");
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        // Test case 1
        ListNode head1 = createList(new int[]{1, 2, 3, 4, 5});
        System.out.println("Input: [1,2,3,4,5]");
        System.out.print("Output: ");
        printList(reverseList(head1));
        System.out.println("Expected: [5,4,3,2,1]\n");

        // Test case 2
        ListNode head2 = createList(new int[]{1, 2});
        System.out.println("Input: [1,2]");
        System.out.print("Output: ");
        printList(reverseList(head2));
        System.out.println("Expected: [2,1]\n");

        // Test case 3
        ListNode head3 = createList(new int[]{});
        System.out.println("Input: []");
        System.out.print("Output: ");
        printList(reverseList(head3));
        System.out.println("Expected: []\n");
    }
}
