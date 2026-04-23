package medium;

import java.util.*;

public class MergeKSortedLists {
    /*
    ========================================
    Problem: Merge K Sorted Lists
    Link: https://leetcode.com/problems/merge-k-sorted-lists
    Difficulty: Medium
    Topic: Linked List, Divide and Conquer, Heap, Merge Sort
    ========================================
    
    PROBLEM EXPLANATION:
    Given array of k linked lists, merge all into one sorted linked list.
    
    Example: lists=[[1,4,5],[1,3,4],[2,6]]
    Output: [1,1,2,1,3,4,4,5,6]
    
    KEY OBSERVATIONS:
    - Brute: merge pairwise O(nk log k) or with heap O(nk log k)
    - Better: use min-heap to track smallest element across all lists
    - Extract min from heap, add to result, add next element from that list
    
    APPROACH (Min-Heap):
    1. Create min-heap with all list heads
    2. Create dummy result node
    3. While heap not empty:
       - Extract min node from heap
       - Add to result
       - If min node has next, add next to heap
    4. Return dummy.next
    
    TIME COMPLEXITY: O(nk log k) - nk elements, log k heap operations
    SPACE COMPLEXITY: O(k) - heap size
    
    DRY RUN:
    lists=[[1,4,5],[1,3,4],[2,6]]
    Heap: [1(list0), 1(list1), 2(list2)]
    Extract 1: add 4 → Heap: [1(list1), 2(list2), 4(list0)]
    Extract 1: add 3 → Heap: [2(list2), 4(list0), 3(list1)]
    Continue...
    Result: 1→1→2→1→3→4→4→5→6 ✓
    
    MEMORY TRICK:
    "Min-heap tracks smallest across k lists, merge on-the-fly"
    
    VISUALIZATION:
    List 0: 1→4→5
    List 1: 1→3→4
    List 2: 2→6
    
    Heap always has k elements (or fewer when lists end)
    Extract min, add next from that list
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

    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);

        // Add all list heads to heap
        for (ListNode list : lists) {
            if (list != null) {
                minHeap.offer(list);
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while (!minHeap.isEmpty()) {
            ListNode minNode = minHeap.poll();
            current.next = minNode;
            current = current.next;

            if (minNode.next != null) {
                minHeap.offer(minNode.next);
            }
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
        ListNode[] lists1 = {
            createList(new int[]{1, 4, 5}),
            createList(new int[]{1, 3, 4}),
            createList(new int[]{2, 6})
        };
        System.out.println("Input: [[1,4,5],[1,3,4],[2,6]]");
        System.out.print("Output: ");
        printList(mergeKLists(lists1));
        System.out.println("Expected: [1,1,2,1,3,4,4,5,6]\n");

        // Test case 2
        ListNode[] lists2 = {};
        System.out.println("Input: []");
        System.out.print("Output: ");
        printList(mergeKLists(lists2));
        System.out.println("Expected: []\n");

        // Test case 3
        ListNode[] lists3 = {null};
        System.out.println("Input: [null]");
        System.out.print("Output: ");
        printList(mergeKLists(lists3));
        System.out.println("Expected: []\n");
    }
}
