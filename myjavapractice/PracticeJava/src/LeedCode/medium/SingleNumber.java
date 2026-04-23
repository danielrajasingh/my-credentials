package medium;

public class SingleNumber {
    /* Problem: Single Number | Link: https://leetcode.com/problems/single-number
    Difficulty: Medium | Topic: Array, Bit Manipulation | Find element appearing once, others twice.
    APPROACH: XOR - a^a=0, a^0=a. XOR all, duplicates cancel. O(n). */

    public static int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) result ^= num;
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {4, 1, 2, 1, 2};
        System.out.println("Single: " + singleNumber(nums));
        System.out.println("Expected: 4\n");
    }
}
