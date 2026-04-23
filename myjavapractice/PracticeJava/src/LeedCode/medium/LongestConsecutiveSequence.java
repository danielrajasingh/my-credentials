package medium;

import java.util.*;

public class LongestConsecutiveSequence {
    /* Problem: Longest Consecutive Sequence | Link: https://leetcode.com/problems/longest-consecutive-sequence
    Difficulty: Medium | Topic: Array, Hash Table, Union Find | Find longest consecutive elements.
    APPROACH: HashSet for O(1) lookup, check chains. O(n). */

    public static int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);
        int max = 0;
        for (int num : set) {
            if (!set.contains(num - 1)) {
                int len = 1;
                while (set.contains(num + len)) len++;
                max = Math.max(max, len);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println("Longest: " + longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
        System.out.println("Expected: 4\n");
    }
}
