package easy;

public class NextPermutation {
    /* Problem: Next Permutation | Link: https://leetcode.com/problems/next-permutation
    Difficulty: Easy | Topic: Array, Two Pointers | Find next lexicographic permutation.
    APPROACH: Find rightmost i where nums[i]<nums[i+1], swap with smallest larger element, reverse after. O(n). */

    public static void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) i--;
        if (i >= 0) {
            int j = nums.length - 1;
            while (j > i && nums[j] <= nums[i]) j--;
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private static void reverse(int[] nums, int start) {
        int end = nums.length - 1;
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        nextPermutation(nums);
        System.out.println("[1,2,3] → " + java.util.Arrays.toString(nums));
        System.out.println("Expected: [1,3,2]\n");
    }
}
