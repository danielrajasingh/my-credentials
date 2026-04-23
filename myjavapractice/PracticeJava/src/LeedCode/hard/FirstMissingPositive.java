package hard;

import java.util.*;

public class FirstMissingPositive {
    /* Problem: First Missing Positive | Link: https://leetcode.com/problems/first-missing-positive
    Difficulty: Hard | Topic: Array, Hash Table | Find smallest missing positive integer.
    APPROACH: Mark positions for found numbers, scan for first unmarked. O(n). */

    public static int firstMissingPositive(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        for (int num : nums) seen.add(num);
        for (int i = 1; ; i++) if (!seen.contains(i)) return i;
    }

    public static void main(String[] args) {
        System.out.println("Missing: " + firstMissingPositive(new int[]{1, 2, 0}));
        System.out.println("Expected: 3\n");
    }
}
