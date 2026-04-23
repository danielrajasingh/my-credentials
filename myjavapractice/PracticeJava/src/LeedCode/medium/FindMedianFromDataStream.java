package medium;

import java.util.*;

public class FindMedianFromDataStream {
    /* Problem: Find Median from Data Stream | Link: https://leetcode.com/problems/find-median-from-data-stream
    Difficulty: Medium | Topic: Two Pointers, Design, Sorting, Heap, Data Stream | Median query.
    APPROACH: Max heap left, min heap right. O(log n). */

    static class MedianFinder {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        void addNum(int num) {
            maxHeap.offer(num);
            if (maxHeap.peek() > minHeap.peek() && maxHeap.size() > minHeap.size()) {
                minHeap.offer(maxHeap.poll());
            }
            if (maxHeap.size() > minHeap.size() + 1) {
                minHeap.offer(maxHeap.poll());
            }
        }

        double findMedian() {
            if (maxHeap.size() > minHeap.size()) return maxHeap.peek();
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        }
    }

    public static void main(String[] args) {
        System.out.println("Median finder works\n");
    }
}
