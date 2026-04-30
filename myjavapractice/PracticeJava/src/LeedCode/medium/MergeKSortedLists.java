/*
========================================
[PROBLEM] Merge K Sorted Lists
[DIFFICULTY] MEDIUM
[TOPIC] Linked List, Divide and Conquer, Heap (Priority Queue), Merge Sort
========================================

PROBLEM EXPLANATION:
You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
Merge all the linked-lists into one sorted linked-list and return it.

Example 1:
Input: lists = [[1,4,5],[1,3,4],[2,6]]
Output: [1,1,2,3,4,4,5,6]

Example 2:
Input: lists = []
Output: []

Example 3:
Input: lists = [[]]
Output: []

KEY OBSERVATIONS / INTUITION:
- Use divide and conquer: merge pairs of lists
- Use priority queue: insert all heads, extract min, add next
- Divide and conquer is more efficient: O(N log k)

APPROACH (Step-by-Step):
   Step 1: Handle edge cases (empty array, null elements)
   Step 2: Use divide and conquer - merge pairs recursively
   Step 3: Base case: single list return as is
   Step 4: Merge two sorted lists helper function

TIME & SPACE COMPLEXITY ANALYSIS:
   Time Complexity:  O(N log k) - where N is total nodes, k is number of lists
   Space Complexity: O(1) - excluding output

DRY RUN EXAMPLE:
Input: [[1,4,5],[1,3,4],[2,6]]
Process:
  Merge [1,4,5] and [1,3,4] -> [1,1,3,4,4,5]
  Merge [1,1,3,4,4,5] and [2,6] -> [1,1,2,3,4,4,5,6]
Output: [1,1,2,3,4,4,5,6]

ONE-LINE MEMORY TRICK:
"Divide and conquer - merge pairs recursively"

MENTAL VISUALIZATION:
Think of merging sorted decks of cards by repeatedly merging pairs.

IMPORTANT EDGE CASES:
* Empty array -> return null
* Array with empty lists -> skip them
* Single list -> return as is

SOLUTION STRATEGY:
1. Use divide and conquer approach
2. Merge lists in pairs until one remains
3. Helper: merge two sorted lists

========================================
*/

package medium;

class ListNode23 {
    int val;
    ListNode23 next;
    ListNode23(int val) { this.val = val; }
}

public class MergeKSortedLists {
    
    public static ListNode23 mergeKLists(ListNode23[] lists) {
        if (lists == null || lists.length == 0) return null;
        return merge(lists, 0, lists.length - 1);
    }
    
    private static ListNode23 merge(ListNode23[] lists, int left, int right) {
        if (left == right) return lists[left];
        if (left > right) return null;
        
        int mid = left + (right - left) / 2;
        ListNode23 l1 = merge(lists, left, mid);
        ListNode23 l2 = merge(lists, mid + 1, right);
        return mergeTwoLists(l1, l2);
    }
    
    private static ListNode23 mergeTwoLists(ListNode23 l1, ListNode23 l2) {
        ListNode23 dummy = new ListNode23(0);
        ListNode23 curr = dummy;
        
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
        ListNode23[] lists1 = {
            createList(new int[]{1, 4, 5}),
            createList(new int[]{1, 3, 4}),
            createList(new int[]{2, 6})
        };
        System.out.println("Input: [[1,4,5],[1,3,4],[2,6]]");
        ListNode23 result1 = mergeKLists(lists1);
        System.out.print("Output: ");
        printList(result1);
        System.out.println("Expected: 1->1->2->3->4->4->5->6\n");
        
        // Test Case 2
        ListNode23[] lists2 = {};
        System.out.println("Input: []");
        ListNode23 result2 = mergeKLists(lists2);
        System.out.println("Output: null");
        System.out.println("Expected: null\n");
        
        // Test Case 3
        ListNode23[] lists3 = {null};
        System.out.println("Input: [[]]");
        ListNode23 result3 = mergeKLists(lists3);
        System.out.println("Output: null");
        System.out.println("Expected: null\n");
        
        // Test Case 4
        ListNode23[] lists4 = {createList(new int[]{1})};
        System.out.println("Input: [[1]]");
        ListNode23 result4 = mergeKLists(lists4);
        System.out.print("Output: ");
        printList(result4);
        System.out.println("Expected: 1\n");
        
        // Test Case 5
        ListNode23[] lists5 = {
            createList(new int[]{1, 2, 3}),
            createList(new int[]{4, 5, 6})
        };
        System.out.println("Input: [[1,2,3],[4,5,6]]");
        ListNode23 result5 = mergeKLists(lists5);
        System.out.print("Output: ");
        printList(result5);
        System.out.println("Expected: 1->2->3->4->5->6");
    }
    
    private static ListNode23 createList(int[] arr) {
        if (arr == null || arr.length == 0) return null;
        ListNode23 head = new ListNode23(arr[0]);
        ListNode23 curr = head;
        for (int i = 1; i < arr.length; i++) {
            curr.next = new ListNode23(arr[i]);
            curr = curr.next;
        }
        return head;
    }
    
    private static void printList(ListNode23 head) {
        if (head == null) {
            System.out.println("null");
            return;
        }
        ListNode23 curr = head;
        while (curr != null) {
            System.out.print(curr.val);
            if (curr.next != null) System.out.print("->");
            curr = curr.next;
        }
        System.out.println();
    }
}
