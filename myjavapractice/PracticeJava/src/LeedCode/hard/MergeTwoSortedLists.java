package hard;

public class MergeTwoSortedLists {
    /*
    ========================================
    Problem: Merge Two Sorted Lists
    Link: https://leetcode.com/problems/merge-two-sorted-lists
    Difficulty: Hard (Usually Easy/Medium)
    Topic: Linked List, Recursion
    ========================================
    
    PROBLEM EXPLANATION:
    Merge two sorted linked lists into one sorted list.
    
    Example: l1=[1,2,4], l2=[1,3,4]
    Output: [1,1,2,3,4,4]
    
    KEY OBSERVATIONS:
    - Two-pointer approach at list level
    - Compare heads, add smaller to result, move that pointer
    - Append remaining list when one ends
    - O(n+m) time, O(1) space (excluding output)
    
    APPROACH (Two Pointers):
    1. Create dummy node for easier construction
    2. Initialize pointers at heads of both lists
    3. While both have nodes:
       - Compare values, add smaller to result
       - Move that pointer forward
    4. Append remaining nodes from non-empty list
    5. Return dummy.next
    
    TIME COMPLEXITY: O(n + m) - visit each node once
    SPACE COMPLEXITY: O(1) - only pointers (excluding result)
    
    DRY RUN:
    l1=[1,2,4], l2=[1,3,4]
    Compare 1,1: take 1 from l1, result=[1]
    Compare 2,1: take 1 from l2, result=[1,1]
    Compare 2,3: take 2 from l1, result=[1,1,2]
    Compare 4,3: take 3 from l2, result=[1,1,2,3]
    l1 has 4: append l1, result=[1,1,2,3,4,4]
    Result: [1,1,2,3,4,4] ✓
    
    MEMORY TRICK:
    "Compare heads, take smaller, append remaining"
    
    VISUALIZATION:
    l1: 1→2→4
    l2: 1→3→4
    
    Result: 1←─(from l2)
            1←─(from l1)
            2←─(from l1)
            3←─(from l2)
            4←─(from l1)
            4←─(from l2)
    
    Final: 1→1→2→3→4→4
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

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }

        // Append remaining
        if (list1 != null) {
            current.next = list1;
        } else {
            current.next = list2;
        }

        return dummy.next;
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
        ListNode list1_1 = createList(new int[]{1, 2, 4});
        ListNode list2_1 = createList(new int[]{1, 3, 4});
        System.out.println("Input: l1=[1,2,4], l2=[1,3,4]");
        System.out.print("Output: ");
        printList(mergeTwoLists(list1_1, list2_1));
        System.out.println("Expected: [1,1,2,3,4,4]\n");

        // Test case 2
        ListNode list1_2 = createList(new int[]{});
        ListNode list2_2 = createList(new int[]{});
        System.out.println("Input: l1=[], l2=[]");
        System.out.print("Output: ");
        printList(mergeTwoLists(list1_2, list2_2));
        System.out.println("Expected: []\n");

        // Test case 3
        ListNode list1_3 = createList(new int[]{});
        ListNode list2_3 = createList(new int[]{0});
        System.out.println("Input: l1=[], l2=[0]");
        System.out.print("Output: ");
        printList(mergeTwoLists(list1_3, list2_3));
        System.out.println("Expected: [0]\n");
    }
}
