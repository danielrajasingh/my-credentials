package medium;

public class MoveZeroes {
    /* Problem: Move Zeroes | Link: https://leetcode.com/problems/move-zeroes
    Difficulty: Medium | Topic: Array, Two Pointers | Move zeros to end, maintain order.
    APPROACH: Two pointers. O(n). */

    public static void moveZeroes(int[] nums) {
        int pos = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[pos] = nums[i];
                pos++;
            }
        }
        while (pos < nums.length) nums[pos++] = 0;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        moveZeroes(nums);
        System.out.println(java.util.Arrays.toString(nums));
        System.out.println("Expected: [1,3,12,0,0]\n");
    }
}
