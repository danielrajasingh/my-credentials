package easy;

import java.util.*;

public class TopKFrequentElements {
    /* Problem: Top K Frequent Elements | Link: https://leetcode.com/problems/top-k-frequent-elements
    Difficulty: Easy | Topic: Array, Hash Table, Divide and Conquer, Sorting, Heap, Bucket Sort, Counting, Quickselect | Get top k.
    APPROACH: HashMap + min-heap. O(n log k). */

    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) map.put(num, map.getOrDefault(num, 0) + 1);
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));
        for (int num : map.keySet()) {
            heap.offer(num);
            if (heap.size() > k) heap.poll();
        }
        int[] result = new int[k];
        for (int i = k - 1; i >= 0; i--) result[i] = heap.poll();
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2)));
        System.out.println("Expected: [1,2]\n");
    }
}
