package medium;

public class MedianOfTwoSortedArrays {
    /*
    ========================================
    Problem: Median of Two Sorted Arrays
    Link: https://leetcode.com/problems/median-of-two-sorted-arrays
    Difficulty: Medium
    Topic: Array, Binary Search, Divide and Conquer
    ========================================
    
    PROBLEM EXPLANATION:
    Given two sorted arrays nums1 and nums2 of size m and n,
    return the median of the two sorted arrays.
    
    Example: nums1=[1,3], nums2=[2] → median=2.0
    Example: nums1=[1,2], nums2=[3,4] → median=2.5
    
    KEY OBSERVATIONS:
    - Brute force: merge and find median O(m+n) time, O(m+n) space
    - Optimal: use binary search O(log(min(m,n))) time, O(1) space
    - Partition arrays so left half has same elements as right half
    - Median = max(left) or (max(left) + min(right)) / 2
    
    APPROACH (Binary Search on Smaller Array):
    1. Ensure nums1 is the smaller array
    2. Binary search on nums1 partition
    3. For each partition, calculate corresponding nums2 partition
    4. Ensure partition validity: nums1Left <= nums2Right, nums2Left <= nums1Right
    5. Calculate median from partition boundaries
    
    TIME COMPLEXITY: O(log(min(m, n))) - binary search on smaller array
    SPACE COMPLEXITY: O(1) - only using pointers
    
    DRY RUN:
    nums1=[1,3], nums2=[2]
    Partition: [1 | 3] and [2 |]
    Left: max(1, 2) = 2
    Right: min(3, null) = 3
    Median = (2 + 3) / 2 = 2.5? No, wait...
    Actually [1,2 | 3]: left=[1,2], right=[3] → (2+3)/2 = 2.5 ✓
    
    MEMORY TRICK:
    "Binary search: partition so left count = right count, check boundaries"
    
    VISUALIZATION:
    nums1: 1 3
    nums2: 2
    
    Merge conceptually: 1 2 3
    Median position: between 2 and 3 = 2.5
    
    Or: 1 2 | 3
        └─ left half ─┘ ├─ right half ─┤
    Median = (max_left + min_right) / 2 = (2 + 3) / 2 = 2.5
    */

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;
        int low = 0, high = m;

        while (low <= high) {
            int partition1 = (low + high) / 2;
            int partition2 = (m + n + 1) / 2 - partition1;

            int left1 = (partition1 == 0) ? Integer.MIN_VALUE : nums1[partition1 - 1];
            int right1 = (partition1 == m) ? Integer.MAX_VALUE : nums1[partition1];
            int left2 = (partition2 == 0) ? Integer.MIN_VALUE : nums2[partition2 - 1];
            int right2 = (partition2 == n) ? Integer.MAX_VALUE : nums2[partition2];

            if (left1 <= right2 && left2 <= right1) {
                if ((m + n) % 2 == 0) {
                    return (Math.max(left1, left2) + Math.min(right1, right2)) / 2.0;
                } else {
                    return Math.max(left1, left2);
                }
            } else if (left1 > right2) {
                high = partition1 - 1;
            } else {
                low = partition1 + 1;
            }
        }

        return -1.0;
    }

    public static void main(String[] args) {
        // Test case 1
        int[] nums1_1 = {1, 3};
        int[] nums2_1 = {2};
        System.out.println("Input: nums1=[1,3], nums2=[2]");
        System.out.println("Output: " + findMedianSortedArrays(nums1_1, nums2_1));
        System.out.println("Expected: 2.0\n");

        // Test case 2
        int[] nums1_2 = {1, 2};
        int[] nums2_2 = {3, 4};
        System.out.println("Input: nums1=[1,2], nums2=[3,4]");
        System.out.println("Output: " + findMedianSortedArrays(nums1_2, nums2_2));
        System.out.println("Expected: 2.5\n");

        // Test case 3
        int[] nums1_3 = {0, 0};
        int[] nums2_3 = {0, 0};
        System.out.println("Input: nums1=[0,0], nums2=[0,0]");
        System.out.println("Output: " + findMedianSortedArrays(nums1_3, nums2_3));
        System.out.println("Expected: 0.0\n");

        // Test case 4
        int[] nums1_4 = {};
        int[] nums2_4 = {1};
        System.out.println("Input: nums1=[], nums2=[1]");
        System.out.println("Output: " + findMedianSortedArrays(nums1_4, nums2_4));
        System.out.println("Expected: 1.0\n");
    }
}
