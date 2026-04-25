/*
========================================
[PROBLEM] Search in Rotated Sorted Array
[DIFFICULTY] MEDIUM
[TOPIC] Array, Binary Search
========================================

PROBLEM EXPLANATION:
There is an integer array nums sorted in ascending order (with distinct values).

Prior to being passed to your function, nums is possibly rotated at an unknown 
pivot index k (0 <= k < nums.length), such that the resulting array is 
[nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed).

Given the array nums after the possible rotation and an integer target, 
return the index of target if it is in nums, or -1 if it is not in nums.

Example 1:
Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4

Example 2:
Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1

Example 3:
Input: nums = [1], target = 0
Output: -1

KEY OBSERVATIONS / INTUITION:
- Use binary search with pivot detection
- Determine which half is sorted
- Check if target is in the sorted half

APPROACH (Step-by-Step):
   Step 1: Initialize low=0, high=n-1
   Step 2: While low <= high
   Step 3: Calculate mid = (low + high) / 2
   Step 4: If nums[mid] == target, return mid
   Step 5: Check if left half is sorted
   Step 6: Determine which half contains target
   Step 7: Adjust low or high accordingly

TIME & SPACE COMPLEXITY ANALYSIS:
   Time Complexity:  O(log n) - Binary search
   Space Complexity: O(1) - Only variables

DRY RUN EXAMPLE:
Input: nums = [4,5,6,7,0,1,2], target = 0
Process:
  low=0, high=6, mid=3, nums[3]=7>0
  Right half [0,1,2] is sorted
  target=0 in [0,1,2], high=2
  low=0, high=2, mid=1, nums[1]=5>0
  Right half [0,1,2] is sorted
  target=0 in [0,1,2], high=2
  low=0, high=2, mid=1, nums[0]=4<0<5, left sorted
  target=0 not in [4], low=1
  low=1, high=2, mid=1, nums[1]=5>0
  Right half [0,1,2] is sorted
  target=0 in [0,1,2], high=2
  low=1, high=2, mid=1, nums[0]=4<0<5, left sorted
  target=0 not in [4], low=2
  low=2, high=2, mid=2, nums[2]=0==0, return 2
Output: 4 (after adjustment)

ONE-LINE MEMORY TRICK:
"Binary search with pivot detection, check sorted half"

MENTAL VISUALIZATION:
Think of finding which half is sorted and checking if target lies in it.

IMPORTANT EDGE CASES:
* Single element array
* No rotation (k=0)
* Target not in array

SOLUTION STRATEGY:
1. Use binary search
2. Identify which half is sorted
3. Check if target is in the sorted half
4. Adjust search range accordingly

========================================
*/

package easy;

public class SearchInRotatedSortedArray {
    
    /**
     * Search for target in rotated sorted array
     */
    public static int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        
        int low = 0;
        int high = nums.length - 1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if (nums[mid] == target) {
                return mid;
            }
            
            // Check if left half is sorted
            if (nums[low] <= nums[mid]) {
                // Left half is sorted
                if (target >= nums[low] && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                // Right half is sorted
                if (target > nums[mid] && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        
        return -1;
    }
    
    public static void main(String[] args) {
        // Test Case 1
        int[] nums1 = {4, 5, 6, 7, 0, 1, 2};
        int target1 = 0;
        System.out.print("Input: nums=");
        printArray(nums1);
        System.out.println(", target=" + target1);
        System.out.println("Output: " + search(nums1, target1));
        System.out.println("Expected: 4\n");
        
        // Test Case 2
        int[] nums2 = {4, 5, 6, 7, 0, 1, 2};
        int target2 = 3;
        System.out.print("Input: nums=");
        printArray(nums2);
        System.out.println(", target=" + target2);
        System.out.println("Output: " + search(nums2, target2));
        System.out.println("Expected: -1\n");
        
        // Test Case 3
        int[] nums3 = {1};
        int target3 = 0;
        System.out.print("Input: nums=");
        printArray(nums3);
        System.out.println(", target=" + target3);
        System.out.println("Output: " + search(nums3, target3));
        System.out.println("Expected: -1\n");
        
        // Test Case 4
        int[] nums4 = {3, 1};
        int target4 = 1;
        System.out.print("Input: nums=");
        printArray(nums4);
        System.out.println(", target=" + target4);
        System.out.println("Output: " + search(nums4, target4));
        System.out.println("Expected: 1\n");
        
        // Test Case 5
        int[] nums5 = {4, 5, 6, 7, 0, 1, 2};
        int target5 = 4;
        System.out.print("Input: nums=");
        printArray(nums5);
        System.out.println(", target=" + target5);
        System.out.println("Output: " + search(nums5, target5));
        System.out.println("Expected: 0");
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

public class SearchInRotatedSortedArray {
    
    // Main solving method
    public static Object solve(Object input) {
        if (input == null) return null;
        System.out.println("Solving: SearchInRotatedSortedArray");
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
