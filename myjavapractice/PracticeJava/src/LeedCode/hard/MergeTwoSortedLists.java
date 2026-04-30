/*
========================================
[PROBLEM] Merge Two Sorted Lists
[DIFFICULTY] HARD
[TOPIC] Linked List, Recursion
========================================

PROBLEM EXPLANATION:
You are given the heads of two sorted linked lists list1 and list2.
Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.

Return the head of the merged linked list.

Example 1:
Input: list1 = [1,2,4], list2 = [1,3,4]
Output: [1,1,2,3,4,4]

Example 2:
Input: list1 = [], list2 = []
Output: []

Example 3:
Input: list1 = [], list2 = [0]
Output: [0]

KEY OBSERVATIONS / INTUITION:
- Simple merge like merging two sorted arrays
- Compare nodes from both lists, pick smaller
- Use dummy node to simplify

APPROACH (Step-by-Step):
   Step 1: Create dummy node for result
   Step 2: Compare heads of both lists
   Step 3: Attach smaller node to result
   Step 4: Move forward in that list
   Step 5: Attach remaining nodes when one list ends

TIME & SPACE COMPLEXITY ANALYSIS:
   Time Complexity:  O(n + m) - where n and m are lengths of lists
   Space Complexity: O(1) - excluding output

DRY RUN EXAMPLE:
Input: list1 = [1,2,4], list2 = [1,3,4]
Process:
  Compare 1 and 1 -> pick 1, move list1
  Compare 2 and 1 -> pick 1, move list2
  Compare 2 and 3 -> pick 2, move list1
  Compare 4 and 3 -> pick 3, move list2
  Compare 4 and 4 -> pick 4, move list1
  Attach remaining 4
Output: [1,1,2,3,4,4]

ONE-LINE MEMORY TRICK:
"Compare and pick - keep merging"

MENTAL VISUALIZATION:
Think of merging two sorted decks of cards by always picking the smaller top card.

IMPORTANT EDGE CASES:
* Both lists empty -> return null
* One list empty -> return other
* Lists of different lengths

SOLUTION STRATEGY:
1. Use dummy node to simplify
2. Compare and pick smaller node
3. Continue until one list ends
4. Attach remaining list

========================================
*/

package hard;

class ListNode24 {
    int val;
    ListNode24 next;
    ListNode24(int val) { this.val = val; }
}

public class MergeTwoSortedLists {
    
    public static ListNode24 mergeTwoLists(ListNode24 l1, ListNode24 l2) {
        ListNode24 dummy = new ListNode24(0);
        ListNode24 curr = dummy;
        
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        
        if (l1 != null) curr.next = l1;
        if (l2 != null) curr.next = l2;
        
        return dummy.next;
    }
    
    public static void main(String[] args) {
        // Test Case 1
        ListNode24 l1 = createList(new int[]{1, 2, 4});
        ListNode24 l2 = createList(new int[]{1, 3, 4});
        System.out.print("Input: l1=");
        printList(l1);
        System.out.print(" l2=");
        printList(l2);
        ListNode24 result1 = mergeTwoLists(l1, l2);
        System.out.print("Output: ");
        printList(result1);
        System.out.println("Expected: 1->1->2->3->4->4\n");
        
        // Test Case 2
        ListNode24 l3 = null;
        ListNode24 l4 = null;
        System.out.println("Input: l1=[], l2=[]");
        ListNode24 result2 = mergeTwoLists(l3, l4);
        System.out.println("Output: null");
        System.out.println("Expected: null\n");
        
        // Test Case 3
        ListNode24 l5 = null;
        ListNode24 l6 = createList(new int[]{0});
        System.out.println("Input: l1=[], l2=[0]");
        ListNode24 result3 = mergeTwoLists(l5, l6);
        System.out.print("Output: ");
        printList(result3);
        System.out.println("Expected: 0\n");
        
        // Test Case 4
        ListNode24 l7 = createList(new int[]{});
        ListNode24 l8 = createList(new int[]{1});
        System.out.println("Input: l1=[empty], l2=[1]");
        ListNode24 result4 = mergeTwoLists(l7, l8);
        System.out.print("Output: ");
        printList(result4);
        System.out.println("Expected: 1\n");
        
        // Test Case 5
        ListNode24 l9 = createList(new int[]{1});
        ListNode24 l10 = createList(new int[]{1});
        System.out.println("Input: l1=[1], l2=[1]");
        ListNode24 result5 = mergeTwoLists(l9, l10);
        System.out.print("Output: ");
        printList(result5);
        System.out.println("Expected: 1->1");
    }
    
    private static ListNode24 createList(int[] arr) {
        if (arr == null || arr.length == 0) return null;
        ListNode24 head = new ListNode24(arr[0]);
        ListNode24 curr = head;
        for (int i = 1; i < arr.length; i++) {
            curr.next = new ListNode24(arr[i]);
            curr = curr.next;
        }
        return head;
    }
    
    private static void printList(ListNode24 head) {
        if (head == null) {
            System.out.println("null");
            return;
        }
        ListNode24 curr = head;
        while (curr != null) {
            System.out.print(curr.val);
            if (curr.next != null) System.out.print("->");
            curr = curr.next;
        }
        System.out.println();
    }
}
