package easy;

public class SearchInRotatedSortedArray {
    /*
    ========================================
    Problem: Search in Rotated Sorted Array
    Link: https://leetcode.com/problems/search-in-rotated-sorted-array
    Difficulty: Easy (Medium in practice)
    Topic: Array, Binary Search
    ========================================
    
    PROBLEM EXPLANATION:
    Given a rotated sorted array nums and a target value, return the index of target.
    If not found, return -1. Array was originally sorted then rotated at pivot.
    
    Example: nums=[4,5,6,7,0,1,2], target=0 → index=4
    Example: nums=[4,5,6,7,0,1,2], target=3 → index=-1
    
    KEY OBSERVATIONS:
    - Binary search can still work: O(log n)
    - Array is partially sorted on both sides of rotation point
    - Determine which half is sorted, then determine if target is in that half
    - Adjust search boundaries accordingly
    - Find rotation point or use comparison with mid
    
    APPROACH (Binary Search):
    1. Initialize left=0, right=n-1
    2. While left <= right:
       - mid = (left + right) / 2
       - If nums[mid] == target, return mid
       - Determine which half is sorted (left or right)
       - Check if target is in sorted half
       - Adjust boundaries: move to half containing target
    3. Return -1 if not found
    
    TIME COMPLEXITY: O(log n) - binary search
    SPACE COMPLEXITY: O(1) - only using pointers
    
    DRY RUN:
    nums=[4,5,6,7,0,1,2], target=0
    left=0, right=6, mid=3 → nums[3]=7
    7 > 0, left side [4,5,6,7] is sorted
    0 not in [4,5,6,7], so search right side
    left=4, right=6, mid=5 → nums[5]=1
    1 > 0, right side [0,1,2] is sorted
    0 in [0,1,2], search here
    left=4, right=5, mid=4 → nums[4]=0 ✓
    Result: 4 ✓
    
    MEMORY TRICK:
    "Check which half is sorted, determine if target is in it"
    
    VISUALIZATION:
    nums: 4 5 6 7 | 0 1 2
                  └─ rotation point
    
    Left half sorted: [4,5,6,7]
    Right half sorted: [0,1,2]
    Find target by determining which sorted half contains it
    */

    public static int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            // Determine which half is sorted
            if (nums[left] <= nums[mid]) {
                // Left half is sorted
                if (nums[left] <= target && target < nums[mid]) {
                    // Target is in sorted left half
                    right = mid - 1;
                } else {
                    // Target is in right half
                    left = mid + 1;
                }
            } else {
                // Right half is sorted
                if (nums[mid] < target && target <= nums[right]) {
                    // Target is in sorted right half
                    left = mid + 1;
                } else {
                    // Target is in left half
                    right = mid - 1;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        // Test case 1
        int[] nums1 = {4, 5, 6, 7, 0, 1, 2};
        int target1 = 0;
        System.out.println("Input: nums=[4, 5, 6, 7, 0, 1, 2], target=0");
        System.out.println("Output: " + search(nums1, target1));
        System.out.println("Expected: 4\n");

        // Test case 2
        int[] nums2 = {4, 5, 6, 7, 0, 1, 2};
        int target2 = 3;
        System.out.println("Input: nums=[4, 5, 6, 7, 0, 1, 2], target=3");
        System.out.println("Output: " + search(nums2, target2));
        System.out.println("Expected: -1\n");

        // Test case 3
        int[] nums3 = {1};
        int target3 = 1;
        System.out.println("Input: nums=[1], target=1");
        System.out.println("Output: " + search(nums3, target3));
        System.out.println("Expected: 0\n");

        // Test case 4
        int[] nums4 = {1, 3};
        int target4 = 3;
        System.out.println("Input: nums=[1, 3], target=3");
        System.out.println("Output: " + search(nums4, target4));
        System.out.println("Expected: 1\n");
    }
}
