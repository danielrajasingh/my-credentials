package medium;

public class JumpGame {
    /*
    ========================================
    Problem: Jump Game
    Link: https://leetcode.com/problems/jump-game
    Difficulty: Medium
    Topic: Array, Dynamic Programming, Greedy
    ========================================
    
    PROBLEM EXPLANATION:
    Given array where nums[i] is max jump length from index i,
    can you reach the last index starting from index 0?
    
    Example: nums=[2,3,1,1,4] → true (0→1→3 or 0→1→4)
    Example: nums=[3,2,1,0,4] → false (always arrive at 0)
    
    KEY OBSERVATIONS:
    - Greedy: track farthest reachable position
    - If current index > farthest, can't proceed
    - Update farthest as we iterate
    - If farthest >= last index, can reach end
    
    APPROACH (Greedy):
    1. Initialize maxReach = 0
    2. For each index i:
       - If i > maxReach, return false (unreachable)
       - Update maxReach = max(maxReach, i + nums[i])
       - If maxReach >= n-1, return true
    3. Return true
    
    TIME COMPLEXITY: O(n) - single pass
    SPACE COMPLEXITY: O(1) - only tracking maxReach
    
    DRY RUN:
    nums=[2,3,1,1,4]
    maxReach=0
    i=0: 0<=0, maxReach=max(0,0+2)=2
    i=1: 1<=2, maxReach=max(2,1+3)=4
    maxReach=4>=4, return true ✓
    
    nums=[3,2,1,0,4]
    maxReach=0
    i=0: 0<=0, maxReach=max(0,0+3)=3
    i=1: 1<=3, maxReach=max(3,1+2)=3
    i=2: 2<=3, maxReach=max(3,2+1)=3
    i=3: 3<=3, maxReach=max(3,3+0)=3
    i=4: 4>3, return false ✓
    
    MEMORY TRICK:
    "Track farthest reachable, if stuck before end, false"
    
    VISUALIZATION:
    nums=[2,3,1,1,4]
    Index: 0 1 2 3 4
    Reach: 2→(0,1,2)
           3→(1,2,3,4)
           Can reach 4 ✓
    */

    public static boolean canJump(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return true;
        }

        int maxReach = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i > maxReach) {
                return false;
            }

            maxReach = Math.max(maxReach, i + nums[i]);

            if (maxReach >= nums.length - 1) {
                return true;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        // Test case 1
        int[] nums1 = {2, 3, 1, 1, 4};
        System.out.println("Input: [2, 3, 1, 1, 4]");
        System.out.println("Output: " + canJump(nums1));
        System.out.println("Expected: true\n");

        // Test case 2
        int[] nums2 = {3, 2, 1, 0, 4};
        System.out.println("Input: [3, 2, 1, 0, 4]");
        System.out.println("Output: " + canJump(nums2));
        System.out.println("Expected: false\n");

        // Test case 3
        int[] nums3 = {0};
        System.out.println("Input: [0]");
        System.out.println("Output: " + canJump(nums3));
        System.out.println("Expected: true\n");

        // Test case 4
        int[] nums4 = {2, 0, 6, 9, 8, 4, 5, 0, 0, 9, 1, 2, 9, 9, 8, 4, 3, 0, 6, 5, 8, 0, 7, 9, 3, 4, 6, 6, 6, 4, 0, 0, 0, 0, 2, 2};
        System.out.println("Input: large array");
        System.out.println("Output: " + canJump(nums4));
        System.out.println("Expected: true\n");
    }
}
