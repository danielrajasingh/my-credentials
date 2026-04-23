package medium;

import java.util.*;

public class SlidingWindowMaximum {
    /* Problem: Sliding Window Maximum | Link: https://leetcode.com/problems/sliding-window-maximum
    Difficulty: Medium | Topic: Array, Queue, Sliding Window
    
    Maintain max in sliding window of size k. Example: nums=[1,3,-1,-3,5,3,6,7], k=3 → [3,3,5,5,6,7]
    APPROACH: Monotonic deque stores indices in decreasing order. O(n). */

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        Deque<Integer> dq = new LinkedList<>();

        for (int i = 0; i < nums.length; i++) {
            if (!dq.isEmpty() && dq.peekFirst() < i - k + 1) dq.pollFirst();
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) dq.pollLast();
            dq.offerLast(i);
            if (i >= k - 1) result[i - k + 1] = nums[dq.peekFirst()];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        System.out.println("Input: [1,3,-1,-3,5,3,6,7], k=3");
        System.out.println("Output: " + Arrays.toString(maxSlidingWindow(nums, 3)));
        System.out.println("Expected: [3,3,5,5,6,7]\n");
    }
}
