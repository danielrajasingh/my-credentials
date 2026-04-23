package easy;

import java.util.*;

public class SlidingWindowMedian {
    /*
    ========================================
    Problem: Sliding Window Median
    Link: https://leetcode.com/problems/sliding-window-median
    Difficulty: Medium (listed as Easy)
    Topic: Array, Sliding Window, Heap
    ========================================
    
    PROBLEM EXPLANATION:
    Given an array nums and window size k, return an array of medians
    for each sliding window of size k.
    
    Example: nums=[1,3,-1,-3,5,3,6,7], k=3
    Windows: [1,3,-1]→median=1, [3,-1,-3]→median=-1, etc.
    
    KEY OBSERVATIONS:
    - Need to maintain sorted order in each window
    - Median is middle element (or average of two middle for even size)
    - Window slides: remove left element, add right element
    - Brute force is O(n*k*logk), but can optimize with two heaps
    
    APPROACH (Two Heaps):
    1. Use maxHeap for left half (descending), minHeap for right half (ascending)
    2. Maintain balance: |maxHeap.size() - minHeap.size()| ≤ 1
    3. For each window:
       - Add element to appropriate heap
       - Balance heaps
       - Get median from top of heaps
       - Remove element leaving window
    
    TIME COMPLEXITY: O(n * log k) - n windows, log k for heap operations
    SPACE COMPLEXITY: O(k) - for storing window elements in heaps
    
    DRY RUN:
    nums=[1,3,-1,-3,5,3,6,7], k=3
    Window [1,3,-1]: sorted=[-1,1,3], median=1
    Window [3,-1,-3]: sorted=[-3,-1,3], median=-1
    Window [-1,-3,5]: sorted=[-3,-1,5], median=-1
    
    MEMORY TRICK:
    "Two heaps balance: maxHeap(left) ≤ minHeap(right), difference ≤ 1"
    
    VISUALIZATION:
    maxHeap [smaller] | minHeap [larger]
           3, 1      |    -1, -3
    Peek maxHeap for median
    */

    public static double[] medianSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return new double[0];
        }

        double[] result = new double[nums.length - k + 1];
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a); // max heap
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // min heap

        for (int i = 0; i < nums.length; i++) {
            // Add to appropriate heap
            if (maxHeap.isEmpty() || nums[i] <= maxHeap.peek()) {
                maxHeap.offer(nums[i]);
            } else {
                minHeap.offer(nums[i]);
            }

            // Balance heaps
            if (maxHeap.size() > minHeap.size() + 1) {
                minHeap.offer(maxHeap.poll());
            } else if (minHeap.size() > maxHeap.size()) {
                maxHeap.offer(minHeap.poll());
            }

            // When window is complete, calculate median
            if (i >= k - 1) {
                if (k % 2 == 1) {
                    result[i - k + 1] = maxHeap.peek();
                } else {
                    result[i - k + 1] = (maxHeap.peek() + minHeap.peek()) / 2.0;
                }

                // Remove element leaving window
                if (nums[i - k + 1] <= maxHeap.peek()) {
                    maxHeap.remove(nums[i - k + 1]);
                } else {
                    minHeap.remove(nums[i - k + 1]);
                }

                // Rebalance after removal
                if (maxHeap.size() > minHeap.size() + 1) {
                    minHeap.offer(maxHeap.poll());
                } else if (minHeap.size() > maxHeap.size()) {
                    maxHeap.offer(minHeap.poll());
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        // Test case 1
        int[] nums1 = {1, 3, -1, -3, 5, 3, 6, 7};
        int k1 = 3;
        double[] result1 = medianSlidingWindow(nums1, k1);
        System.out.println("Input: [1, 3, -1, -3, 5, 3, 6, 7], k=3");
        System.out.print("Output: [");
        for (int i = 0; i < result1.length; i++) {
            System.out.print(result1[i]);
            if (i < result1.length - 1) System.out.print(", ");
        }
        System.out.println("]");

        // Test case 2
        int[] nums2 = {1};
        int k2 = 1;
        double[] result2 = medianSlidingWindow(nums2, k2);
        System.out.println("\nInput: [1], k=1");
        System.out.print("Output: [");
        for (int i = 0; i < result2.length; i++) {
            System.out.print(result2[i]);
            if (i < result2.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }
}
