package easy;

import java.util.*;

public class MajorityElement {
    /* Problem: Majority Element | Link: https://leetcode.com/problems/majority-element
    Difficulty: Easy | Topic: Array, Hash Table, Divide and Conquer, Sorting, Counting | Find >n/2 element.
    APPROACH: HashMap count or Boyer-Moore voting. O(n). */

    public static int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (map.get(num) > nums.length / 2) return num;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println("Majority: " + majorityElement(new int[]{3, 2, 3}));
        System.out.println("Expected: 3\n");
    }
}
