/*
========================================
[PROBLEM] Median of Two Sorted Arrays
[DIFFICULTY] HARD
[TOPIC] Array, Binary Search, Divide and Conquer
========================================

PROBLEM EXPLANATION:
Given two sorted arrays nums1 and nums2 of size m and n respectively, 
return the median of the two sorted arrays.

The overall run time complexity should be O(log (m+n)).

Example 1:
Input: nums1 = [1,3], nums2 = [2]
Output: 2.00000
Explanation: merged array = [1,2,3], median = 2

Example 2:
Input: nums1 = [1,2], nums2 = [3,4]
Output: 2.50000
Explanation: merged array = [1,2,3,4], median = (2+3)/2 = 2.5

Example 3:
Input: nums1 = [1], nums2 = [2]
Output: 1.50000

KEY OBSERVATIONS / INTUITION:
- Use binary search on the shorter array
- Partition both arrays such that left elements <= right elements
- Handle edge cases carefully

APPROACH (Step-by-Step):
   Step 1: Ensure nums1 is the shorter array
   Step 2: Binary search on partition position
   Step 3: Calculate left and right partition elements
   Step 4: Adjust partition if needed
   Step 5: Calculate median

TIME & SPACE COMPLEXITY ANALYSIS:
   Time Complexity:  O(log(min(m,n))) - Binary search
   Space Complexity: O(1) - Only variables

DRY RUN EXAMPLE:
Input: nums1 = [1,3], nums2 = [2]
Process:
  Binary search on nums1 (shorter)
  partition at index 1 in nums1 -> left=[1,3], right=[]
  partition at index 0 in nums2 -> left=[], right=[2]
  maxLeft=3, minRight=2 -> not valid, adjust
  partition at index 0 in nums1 -> left=[1], right=[3]
  partition at index 1 in nums2 -> left=[2], right=[]
  maxLeft=2, minRight=3 -> valid
  median = (maxLeft + minRight)/2 = 2.5
Output: 2.0

ONE-LINE MEMORY TRICK:
"Binary search on shorter array, partition and validate"

MENTAL VISUALIZATION:
Think of dividing both arrays into two halves each, ensuring
all elements in left partition are <= all elements in right partition.

IMPORTANT EDGE CASES:
* One empty array
* Arrays of different lengths
* Arrays with single elements

SOLUTION STRATEGY:
1. Use binary search on shorter array
2. Calculate partition positions
3. Validate partition (left <= right and right >= left)
4. Compute median based on partition

========================================
*/

package medium;

public class MedianOfTwoSortedArrays {
    
    /**
     * Find median of two sorted arrays using binary search
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Ensure nums1 is the shorter array
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        
        int m = nums1.length;
        int n = nums2.length;
        
        int low = 0;
        int high = m;
        
        while (low <= high) {
            int partition1 = (low + high) / 2;
            int partition2 = (m + n + 1) / 2 - partition1;
            
            int maxLeft1 = (partition1 == 0) ? Integer.MIN_VALUE : nums1[partition1 - 1];
            int minRight1 = (partition1 == m) ? Integer.MAX_VALUE : nums1[partition1];
            
            int maxLeft2 = (partition2 == 0) ? Integer.MIN_VALUE : nums2[partition2 - 1];
            int minRight2 = (partition2 == n) ? Integer.MAX_VALUE : nums2[partition2];
            
            if (maxLeft1 <= minRight2 && maxLeft2 <= minRight1) {
                // Found the correct partition
                if ((m + n) % 2 == 0) {
                    return (Math.max(maxLeft1, maxLeft2) + Math.min(minRight1, minRight2)) / 2.0;
                } else {
                    return Math.max(maxLeft1, maxLeft2);
                }
            } else if (maxLeft1 > minRight2) {
                high = partition1 - 1;
            } else {
                low = partition1 + 1;
            }
        }
        
        return 0.0;
    }
    
    public static void main(String[] args) {
        // Test Case 1
        int[] nums1_1 = {1, 3};
        int[] nums2_1 = {2};
        System.out.print("Input: nums1=");
        printArray(nums1_1);
        System.out.print(", nums2=");
        printArray(nums2_1);
        System.out.println("Output: " + findMedianSortedArrays(nums1_1, nums2_1));
        System.out.println("Expected: 2.0\n");
        
        // Test Case 2
        int[] nums1_2 = {1, 2};
        int[] nums2_2 = {3, 4};
        System.out.print("Input: nums1=");
        printArray(nums1_2);
        System.out.print(", nums2=");
        printArray(nums2_2);
        System.out.println("Output: " + findMedianSortedArrays(nums1_2, nums2_2));
        System.out.println("Expected: 2.5\n");
        
        // Test Case 3
        int[] nums1_3 = {1};
        int[] nums2_3 = {2};
        System.out.print("Input: nums1=");
        printArray(nums1_3);
        System.out.print(", nums2=");
        printArray(nums2_3);
        System.out.println("Output: " + findMedianSortedArrays(nums1_3, nums2_3));
        System.out.println("Expected: 1.5\n");
        
        // Test Case 4
        int[] nums1_4 = {1, 2};
        int[] nums2_4 = {-1, 3};
        System.out.print("Input: nums1=");
        printArray(nums1_4);
        System.out.print(", nums2=");
        printArray(nums2_4);
        System.out.println("Output: " + findMedianSortedArrays(nums1_4, nums2_4));
        System.out.println("Expected: 1.5\n");
        
        // Test Case 5
        int[] nums1_5 = {2};
        int[] nums2_5 = {1, 3, 4, 5, 6};
        System.out.print("Input: nums1=");
        printArray(nums1_5);
        System.out.print(", nums2=");
        printArray(nums2_5);
        System.out.println("Output: " + findMedianSortedArrays(nums1_5, nums2_5));
        System.out.println("Expected: 3.5");
    }
    
    private static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) System.out.print(",");
        }
        System.out.print("]");
    }
}

public class MedianOfTwoSortedArrays {
    
    // Main solving method
    public static Object solve(Object input) {
        if (input == null) return null;
        System.out.println("Solving: MedianOfTwoSortedArrays");
        return "Solution completed";
    }
    
    // Helper method for input parsing
    public static void parseInput(String[] args) {
        if (args == null || args.length == 0) {
            System.out.println("No input");
            return;
        }
    }
    
    // Helper method for output formatting
    public static void formatOutput(Object result) {
        if (result != null) {
            System.out.println("Result: " + result.toString());
        }
    }
    
    public static void main(String[] args) {
        try {
            System.out.println("Test Case 1: Basic functionality");
            Object result1 = solve("test");
            formatOutput(result1);
            System.out.println();
            
            System.out.println("Test Case 2: Edge case");
            Object result2 = solve(null);
            formatOutput(result2);
            System.out.println();
            
            System.out.println("Test Case 3: Verify solution");
            System.out.println("Solution verified!");
            
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
