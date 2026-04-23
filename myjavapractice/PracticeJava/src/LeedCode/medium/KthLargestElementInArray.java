package medium;

import java.util.*;

public class KthLargestElementInArray {
    /* Problem: Kth Largest Element in an Array | Link: https://leetcode.com/problems/kth-largest-element-in-an-array
    Difficulty: Medium | Topic: Array, Heap, Quickselect | Find kth largest element.
    APPROACH: Min-heap of size k. O(n log k). */

    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : nums) {
            minHeap.offer(num);
            if (minHeap.size() > k) minHeap.poll();
        }
        return minHeap.peek();
    }

    public static void main(String[] args) {
        System.out.println("3rd largest: " + findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
        System.out.println("Expected: 5\n");
    }
}
