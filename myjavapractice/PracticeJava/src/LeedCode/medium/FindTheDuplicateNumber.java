package medium;

public class FindTheDuplicateNumber {
    /*
    ========================================
    Problem: Find the Duplicate Number
    Link: https://leetcode.com/problems/find-the-duplicate-number
    Difficulty: Medium
    Topic: Array, Two Pointers, Binary Search, Bit Manipulation
    ========================================
    
    PROBLEM EXPLANATION:
    Given array of n+1 integers where each is between 1 and n (inclusive),
    there must be at least one duplicate. Assume only one duplicate exists
    (but may repeat more than once). Find the duplicate in O(1) space.
    
    Example: nums=[1,3,4,2,2] → 2
    Example: nums=[3,1,3,4,2] → 3
    
    KEY OBSERVATIONS:
    - Cannot use HashSet (violates O(1) space)
    - Treat as linked list cycle problem
    - If we follow nums[i] → nums[nums[i]], we get a cycle
    - Use Floyd's Cycle Detection (tortoise and hare)
    - The cycle start is the duplicate number
    
    APPROACH (Floyd's Cycle Detection):
    1. Treat array as linked list: node i points to node nums[i]
    2. Use slow and fast pointers starting at index 0
    3. Move slow by 1 step, fast by 2 steps
    4. When they meet, there's a cycle
    5. Move one pointer to start, move both by 1 step
    6. When they meet again, that's the cycle start = duplicate
    
    TIME COMPLEXITY: O(n) - detecting cycle and finding start
    SPACE COMPLEXITY: O(1) - only using pointers
    
    DRY RUN:
    nums=[1,3,4,2,2]
    Treat as linked list: 0→1→3→2→4→2→4→...
    slow=0, fast=0
    Step 1: slow=1, fast=3
    Step 2: slow=3, fast=4
    Step 3: slow=2, fast=2 → meet at index 2
    Reset slow=0, move both by 1 until meet
    slow=0, fast=2
    slow=1, fast=4
    slow=3, fast=2
    slow=2, fast=4
    slow=4, fast=2
    slow=2, fast=4 (they meet!) → nums[2]=4? No...
    Actually: need to recount. Let me trace properly:
    Index array: [1, 3, 4, 2, 2]
    Following: 0→1→3→2→4→2 (cycle: 2→4→2)
    Duplicate is 2 ✓
    
    MEMORY TRICK:
    "Array as linked list: Floyd's cycle detection finds duplicate"
    
    VISUALIZATION:
    nums = [1, 3, 4, 2, 2]
    Index:   0  1  2  3  4
    
    0 → 1 → 3 → 2 → 4 → 2 → 4 → ... (cycle)
                     └─────────┘
    Entry point to cycle is at index where duplicate value is
    */

    public static int findDuplicate(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return -1;
        }

        // Step 1: Find intersection point in cycle
        int slow = nums[0];
        int fast = nums[0];

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        // Step 2: Find entrance to cycle (duplicate number)
        int ptr1 = nums[0];
        int ptr2 = slow;

        while (ptr1 != ptr2) {
            ptr1 = nums[ptr1];
            ptr2 = nums[ptr2];
        }

        return ptr1;
    }

    public static void main(String[] args) {
        // Test case 1
        int[] nums1 = {1, 3, 4, 2, 2};
        System.out.println("Input: [1, 3, 4, 2, 2]");
        System.out.println("Output: " + findDuplicate(nums1));
        System.out.println("Expected: 2\n");

        // Test case 2
        int[] nums2 = {3, 1, 3, 4, 2};
        System.out.println("Input: [3, 1, 3, 4, 2]");
        System.out.println("Output: " + findDuplicate(nums2));
        System.out.println("Expected: 3\n");

        // Test case 3
        int[] nums3 = {1, 4, 4, 2, 4};
        System.out.println("Input: [1, 4, 4, 2, 4]");
        System.out.println("Output: " + findDuplicate(nums3));
        System.out.println("Expected: 4\n");

        // Test case 4
        int[] nums4 = {2, 5, 9, 6, 4, 3, 7, 8, 3, 1};
        System.out.println("Input: [2, 5, 9, 6, 4, 3, 7, 8, 3, 1]");
        System.out.println("Output: " + findDuplicate(nums4));
        System.out.println("Expected: 3\n");
    }
}
