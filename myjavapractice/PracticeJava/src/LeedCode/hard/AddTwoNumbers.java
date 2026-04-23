package hard;

public class AddTwoNumbers {
    /*
    ========================================
    Problem: Add Two Numbers
    Link: https://leetcode.com/problems/add-two-numbers
    Difficulty: Hard
    Topic: Linked List, Math, Recursion
    ========================================
    
    PROBLEM EXPLANATION:
    Two non-negative integers are represented in reverse order as linked lists.
    Each node contains a single digit. Add the two numbers and return the sum
    as a linked list also in reverse order.
    
    Example: l1=[2,4,3], l2=[5,6,4]
    Represents: 342 + 465 = 807
    Output: [7,0,8] (representing 807)
    
    KEY OBSERVATIONS:
    - Numbers are stored in reverse order (least significant digit first)
    - This makes addition straightforward (no need to reverse initially)
    - Handle carry as we traverse both lists
    - If one list is shorter, treat missing digits as 0
    - Don't forget final carry if exists
    
    APPROACH:
    1. Create dummy node for easier list construction
    2. Iterate through both lists simultaneously:
       - Get values (0 if node is null)
       - Calculate sum + carry
       - Create new node with digit (sum % 10)
       - Update carry (sum / 10)
    3. If carry remains after lists end, create new node
    4. Return dummy.next (actual list head)
    
    TIME COMPLEXITY: O(max(m, n)) where m, n are list lengths
    SPACE COMPLEXITY: O(max(m, n)) for result list
    
    DRY RUN:
    l1=[2,4,3], l2=[5,6,4]
    Node 1: 2+5=7, carry=0 → digit=7
    Node 2: 4+6=10, carry=1 → digit=0
    Node 3: 3+4+1=8, carry=0 → digit=8
    Result: [7,0,8] ✓
    
    MEMORY TRICK:
    "Reverse order: add right-to-left, handle carry as you go"
    
    VISUALIZATION:
    l1: 2 → 4 → 3 → null      (represents 342)
    l2: 5 → 6 → 4 → null      (represents 465)
    Operation:
    2+5 = 7 (sum), carry 0
    4+6 = 10 (sum), carry 1
    3+4+1 = 8 (sum), carry 0
    Result: 7 → 0 → 8 → null  (represents 807)
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

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int val1 = (l1 != null) ? l1.val : 0;
            int val2 = (l2 != null) ? l2.val : 0;

            int sum = val1 + val2 + carry;
            int digit = sum % 10;
            carry = sum / 10;

            current.next = new ListNode(digit);
            current = current.next;

            l1 = (l1 != null) ? l1.next : null;
            l2 = (l2 != null) ? l2.next : null;
        }

        return dummy.next;
    }

    // Helper method to create linked list from array
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

    // Helper method to print linked list
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
        ListNode l1_1 = createList(new int[]{2, 4, 3});
        ListNode l2_1 = createList(new int[]{5, 6, 4});
        System.out.println("Input: l1=[2,4,3] (342), l2=[5,6,4] (465)");
        System.out.print("Output: ");
        printList(addTwoNumbers(l1_1, l2_1));
        System.out.println("Expected: [7,0,8] (807)\n");

        // Test case 2
        ListNode l1_2 = createList(new int[]{0});
        ListNode l2_2 = createList(new int[]{0});
        System.out.println("Input: l1=[0], l2=[0]");
        System.out.print("Output: ");
        printList(addTwoNumbers(l1_2, l2_2));
        System.out.println("Expected: [0]\n");

        // Test case 3
        ListNode l1_3 = createList(new int[]{9, 9, 9, 9, 9, 9, 9});
        ListNode l2_3 = createList(new int[]{9, 9, 9, 9});
        System.out.println("Input: l1=[9,9,9,9,9,9,9], l2=[9,9,9,9]");
        System.out.print("Output: ");
        printList(addTwoNumbers(l1_3, l2_3));
        System.out.println("Expected: [8,9,9,9,0,0,0,1]\n");
    }
}
