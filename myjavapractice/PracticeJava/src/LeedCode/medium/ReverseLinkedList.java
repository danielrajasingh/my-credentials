/*
========================================
[PROBLEM] Reverse Linked List
[DIFFICULTY] MEDIUM
[TOPIC] Linked List, Recursion
========================================

PROBLEM EXPLANATION:
Given the head of a singly linked list, reverse the list, and return the reversed list.

Example 1:
Input: head = [1,2,3,4,5]
Output: [5,4,3,2,1]

Example 2:
Input: head = [1,2]
Output: [2,1]

Example 3:
Input: head = []
Output: []

KEY OBSERVATIONS / INTUITION:
- Can be done iteratively or recursively
- Iterative: prev -> curr -> next, move all forward
- Recursive: reverse rest of list, adjust pointers

APPROACH (Step-by-Step):
   Step 1: Initialize prev = null, curr = head
   Step 2: While curr is not null, store next node
   Step 3: Reverse the pointer: curr.next = prev
   Step 4: Move prev and curr forward
   Step 5: Return prev (new head)

TIME & SPACE COMPLEXITY ANALYSIS:
   Time Complexity:  O(n) - Single pass
   Space Complexity: O(1) - Iterative approach

DRY RUN EXAMPLE:
Input: 1 -> 2 -> 3 -> 4 -> 5
Process:
  Iteration 1: prev=null, curr=1 -> reverse 1->null, prev=1, curr=2
  Iteration 2: prev=1, curr=2 -> reverse 2->1, prev=2, curr=3
  Iteration 3: prev=2, curr=3 -> reverse 3->2, prev=3, curr=4
  Iteration 4: prev=3, curr=4 -> reverse 4->3, prev=4, curr=5
  Iteration 5: prev=4, curr=5 -> reverse 5->4, prev=5, curr=null
Output: 5 -> 4 -> 3 -> 2 -> 1

ONE-LINE MEMORY TRICK:
"Prev, Curr, Next - slide through the list"

MENTAL VISUALIZATION:
Think of three pointers sliding through the list, reversing each link.

IMPORTANT EDGE CASES:
* Empty list -> return null
* Single node -> return same node
* Two nodes -> properly reverse

SOLUTION STRATEGY:
1. Use iterative approach with three pointers
2. Reverse each link by changing curr.next to prev
3. Move prev and curr forward
4. Return prev when curr becomes null

========================================
*/

package medium;

class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }
}

public class ReverseLinkedList {
    
    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        return prev;
    }
    
    public static void main(String[] args) {
        // Test Case 1
        ListNode head1 = createList(new int[]{1, 2, 3, 4, 5});
        System.out.print("Input: ");
        printList(head1);
        ListNode reversed1 = reverseList(head1);
        System.out.print("Output: ");
        printList(reversed1);
        System.out.println("Expected: 5->4->3->2->1\n");
        
        // Test Case 2
        ListNode head2 = createList(new int[]{1, 2});
        System.out.print("Input: ");
        printList(head2);
        ListNode reversed2 = reverseList(head2);
        System.out.print("Output: ");
        printList(reversed2);
        System.out.println("Expected: 2->1\n");
        
        // Test Case 3
        ListNode head3 = null;
        System.out.print("Input: null\n");
        ListNode reversed3 = reverseList(head3);
        System.out.println("Output: null");
        System.out.println("Expected: null\n");
        
        // Test Case 4
        ListNode head4 = createList(new int[]{1});
        System.out.print("Input: ");
        printList(head4);
        ListNode reversed4 = reverseList(head4);
        System.out.print("Output: ");
        printList(reversed4);
        System.out.println("Expected: 1");
    }
    
    private static ListNode createList(int[] arr) {
        if (arr == null || arr.length == 0) return null;
        ListNode head = new ListNode(arr[0]);
        ListNode curr = head;
        for (int i = 1; i < arr.length; i++) {
            curr.next = new ListNode(arr[i]);
            curr = curr.next;
        }
        return head;
    }
    
    private static void printList(ListNode head) {
        if (head == null) {
            System.out.println("null");
            return;
        }
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val);
            if (curr.next != null) System.out.print("->");
            curr = curr.next;
        }
        System.out.println();
    }
}
