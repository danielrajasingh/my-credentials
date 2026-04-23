package medium;

public class LongestIncreasingSubsequence {
    /*
    ========================================
    Problem: Longest Increasing Subsequence
    Link: https://leetcode.com/problems/longest-increasing-subsequence
    Difficulty: Medium
    Topic: Array, Dynamic Programming, Binary Search
    ========================================
    
    PROBLEM EXPLANATION:
    Given array nums, return length of longest strictly increasing subsequence.
    Subsequence doesn't need to be contiguous.
    
    Example: nums=[10,9,2,5,3,7,101,18] → [2,3,7,101] → length=4
    Example: nums=[0,1,0,4,4,4,3,2,1] → [0,1,4] → length=3
    
    KEY OBSERVATIONS:
    - DP approach: dp[i] = length of LIS ending at index i
    - dp[i] = max(dp[j] + 1) for all j < i where nums[j] < nums[i]
    - Brute force: O(n²) DP or O(n log n) with binary search
    
    APPROACH (O(n log n) with Binary Search):
    1. Maintain array 'tails' where tails[i] = smallest tail element for LIS of length i+1
    2. For each num:
       - Use binary search to find position in tails
       - If num > tails[len-1], append it
       - Otherwise, replace element to keep tails sorted
    3. Return length of tails
    
    TIME COMPLEXITY: O(n log n) - binary search for each element
    SPACE COMPLEXITY: O(n) - tails array
    
    DRY RUN:
    nums=[10,9,2,5,3,7,101,18]
    tails=[]
    10: tails=[10]
    9: replace 10 → tails=[9]
    2: replace 9 → tails=[2]
    5: append → tails=[2,5]
    3: replace 5 → tails=[2,3]
    7: append → tails=[2,3,7]
    101: append → tails=[2,3,7,101]
    18: replace 101 → tails=[2,3,7,18]
    Length: 4 ✓
    
    MEMORY TRICK:
    "Maintain sorted tails array, binary search for position"
    
    VISUALIZATION:
    LIS: 2 < 3 < 7 < 101
    Another: 2 < 5 < 7 < 101
    Tails tracks smallest possible tail for each length
    */

    public static int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] tails = new int[nums.length];
        int len = 0;

        for (int num : nums) {
            int pos = binarySearch(tails, len, num);
            tails[pos] = num;
            if (pos == len) {
                len++;
            }
        }

        return len;
    }

    private static int binarySearch(int[] tails, int len, int target) {
        int left = 0, right = len;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (tails[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        // Test case 1
        int[] nums1 = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println("Input: [10, 9, 2, 5, 3, 7, 101, 18]");
        System.out.println("Output: " + lengthOfLIS(nums1));
        System.out.println("Expected: 4\n");

        // Test case 2
        int[] nums2 = {0, 1, 0, 4, 4, 4, 3, 2, 1};
        System.out.println("Input: [0, 1, 0, 4, 4, 4, 3, 2, 1]");
        System.out.println("Output: " + lengthOfLIS(nums2));
        System.out.println("Expected: 3\n");

        // Test case 3
        int[] nums3 = {3, 10, 2, 1, 20};
        System.out.println("Input: [3, 10, 2, 1, 20]");
        System.out.println("Output: " + lengthOfLIS(nums3));
        System.out.println("Expected: 3\n");
    }
}
