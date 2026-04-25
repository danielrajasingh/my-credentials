/*
========================================
[PROBLEM] AddTwoNumbers
[DIFFICULTY] HARD
[TOPIC] Linked List, Math, Recursion
========================================

PROBLEM EXPLANATION:
You are given two non-empty linked lists representing two non-negative integers. 
The digits are stored in reverse order, and each of their nodes contains a single digit.

Add the two numbers and return the sum as a linked list.

Example 1:
Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807

Example 2:
Input: l1 = [0], l2 = [0]
Output: [0]

Example 3:
Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
Output: [8,9,9,9,0,0,0,1]

KEY OBSERVATIONS / INTUITION:
- Numbers are stored in reverse order (least significant digit first)
- This makes addition straightforward - just like elementary math
- Handle carry as we traverse both lists
- If one list is shorter, treat missing digits as 0
- Don't forget final carry if exists

APPROACH (Step-by-Step):
   Step 1: Create dummy node for easier list construction
   Step 2: Iterate through both lists simultaneously
   Step 3: Get values (0 if node is null), calculate sum + carry
   Step 4: Create new node with digit (sum % 10), update carry (sum / 10)
   Step 5: If carry remains after lists end, create new node

TIME & SPACE COMPLEXITY ANALYSIS:
   Time Complexity:  O(max(m, n)) - Where m, n are list lengths
   Space Complexity: O(max(m, n)) - For result list

DRY RUN EXAMPLE:
Input: l1=[2,4,3], l2=[5,6,4] (represents 342 and 465)
Process:
  Node 1: 2+5=7, carry=0 -> digit=7
  Node 2: 4+6=10, carry=1 -> digit=0
  Node 3: 3+4+1=8, carry=0 -> digit=8
Output: [7,0,8] (represents 807)

ONE-LINE MEMORY TRICK:
"REVERSE: Add right-to-left, handle carry as you go"

MENTAL VISUALIZATION:
Think of adding two numbers column by column from right to left, just like you learned in elementary school. Each node is a digit, and you propagate any carry to the next position.

IMPORTANT EDGE CASES:
* One list is empty -> return the other list
* Both lists are empty -> return 0
* Final carry after all digits -> add extra node

SOLUTION STRATEGY:
1. Use dummy node to simplify list construction
2. Traverse both lists simultaneously
3. Handle carry propagation
4. Handle different length lists

========================================
*/

package hard;

public class AddTwoNumbers {
    
    // Definition for singly-linked list
    static class ListNode {
        int val;
        ListNode next;
        
        ListNode() {}
        
        ListNode(int val) {
            this.val = val;
        }
        
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    
    /**
     * Add two numbers represented as linked lists
     */
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
            
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        
        return dummy.next;
    }
    
    // Helper method to create linked list from array
    public static ListNode createList(int[] arr) {
        if (arr == null || arr.length == 0) return null;
        
        ListNode head = new ListNode(arr[0]);
        ListNode current = head;
        
        for (int i = 1; i < arr.length; i++) {
            current.next = new ListNode(arr[i]);
            current = current.next;
        }
        
        return head;
    }
    
    // Helper method to print linked list
    public static void printList(ListNode head) {
        System.out.print("[");
        while (head != null) {
            System.out.print(head.val);
            head = head.next;
            if (head != null) System.out.print(",");
        }
        System.out.println("]");
    }
    
    public static void main(String[] args) {
        // Test Case 1
        ListNode l1_1 = createList(new int[]{2, 4, 3});
        ListNode l2_1 = createList(new int[]{5, 6, 4});
        System.out.print("Input: l1=");
        printList(l1_1);
        System.out.print(", l2=");
        printList(l2_1);
        System.out.print("Output: ");
        printList(addTwoNumbers(l1_1, l2_1));
        System.out.println("Expected: [7,0,8]\n");
        
        // Test Case 2
        ListNode l1_2 = createList(new int[]{0});
        ListNode l2_2 = createList(new int[]{0});
        System.out.print("Input: l1=");
        printList(l1_2);
        System.out.print(", l2=");
        printList(l2_2);
        System.out.print("Output: ");
        printList(addTwoNumbers(l1_2, l2_2));
        System.out.println("Expected: [0]\n");
        
        // Test Case 3
        ListNode l1_3 = createList(new int[]{9, 9, 9, 9, 9, 9, 9});
        ListNode l2_3 = createList(new int[]{9, 9, 9, 9});
        System.out.print("Input: l1=");
        printList(l1_3);
        System.out.print(", l2=");
        printList(l2_3);
        System.out.print("Output: ");
        printList(addTwoNumbers(l1_3, l2_3));
        System.out.println("Expected: [8,9,9,9,0,0,0,1]");
    }
}
