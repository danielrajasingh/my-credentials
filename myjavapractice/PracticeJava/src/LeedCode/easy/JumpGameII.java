package easy;

public class JumpGameII {
    /* Problem: Jump Game II | Link: https://leetcode.com/problems/jump-game-ii
    Difficulty: Easy | Topic: Array, Dynamic Programming, Greedy | Min jumps to last.
    APPROACH: Greedy tracking farthest reach. O(n). */

    public static int jump(int[] nums) {
        int jumps = 0, currEnd = 0, farthest = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);
            if (i == currEnd) {
                jumps++;
                currEnd = farthest;
            }
        }
        return jumps;
    }

    public static void main(String[] args) {
        System.out.println("Jumps: " + jump(new int[]{2, 3, 1, 1, 4}));
        System.out.println("Expected: 2\n");
    }
}
