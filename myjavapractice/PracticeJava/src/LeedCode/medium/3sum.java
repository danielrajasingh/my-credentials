/*
========================================
[PROBLEM] 3sum
[DIFFICULTY] MEDIUM
[TOPIC] Array, Two Pointers, Sorting
========================================

PROBLEM EXPLANATION:
Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] 
such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.

Example 1:
Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Explanation: 
-1 + -1 + 2 = 0
-1 + 0 + 1 = 0
Distinct triplets: [[-1,-1,2],[-1,0,1]]

Example 2:
Input: nums = [0,1,1]
Output: []
Explanation: The only possible triplet does not sum to 0.

Example 3:
Input: nums = [0,0,0]
Output: [[0,0,0]]
Explanation: The only triplet sums to 0.

KEY OBSERVATIONS / INTUITION:
- Fix one element, find other two using two pointers
- Sort the array first to handle duplicates and use two pointers
- Skip duplicate elements to avoid duplicate triplets
- Use two pointers (left and right) to find pairs that sum to negative of fixed element

APPROACH (Step-by-Step):
   Step 1: Sort the array
   Step 2: Iterate through array, fixing one element at a time
   Step 3: Use two pointers to find pairs that sum to negative of fixed element
   Step 4: Skip duplicates to avoid duplicate triplets
   Step 5: Add valid triplets to result

TIME & SPACE COMPLEXITY ANALYSIS:
   Time Complexity:  O(n^2) - Two nested loops
   Space Complexity: O(log n) for sorting (excluding output)

DRY RUN EXAMPLE:
Input: nums = [-1,0,1,2,-1,-4]
After sorting: [-4,-1,-1,0,1,2]
Process:
  i=0: num=-4, find pair sum to 4 -> no pair found
  i=1: num=-1, find pair sum to 1 -> left=2,right=5: 0+2=2<1, left++
         left=3,right=5: 0+1=1==1 -> triplet [-1,0,1]
         left=4,right=5: 1+2=3>1, right--
  i=2: num=-1 (duplicate), skip
  i=3: num=0, find pair sum to 0 -> no pair found
Output: [[-1,-1,2],[-1,0,1]]

ONE-LINE MEMORY TRICK:
"SORT + FIX + TWO POINTERS: Skip duplicates, find pairs"

MENTAL VISUALIZATION:
Think of finding three numbers that add to zero. Sort the array first, then fix one number and use two pointers to find the other two that together sum to the negative of the fixed number.

IMPORTANT EDGE CASES:
* Less than 3 elements -> return empty
* All zeros -> return [[0,0,0]]
* All same elements -> return empty (no valid triplet)

SOLUTION STRATEGY:
1. Sort the array
2. For each element, use two pointers to find pairs
3. Skip duplicate elements
4. Add valid triplets to result

========================================
*/

package medium;

import java.util.*;

class ThreeSumProblem {
    
    /**
     * Find all unique triplets that sum to zero
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        
        if (nums == null || nums.length < 3) {
            return result;
        }
        
        // Sort the array
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length - 2; i++) {
            // Skip duplicates for the first element
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            
            // If smallest possible sum > 0, break
            if (nums[i] + nums[i + 1] + nums[i + 2] > 0) {
                break;
            }
            
            // If largest possible sum < 0, continue
            if (nums[i] + nums[nums.length - 1] + nums[nums.length - 2] < 0) {
                continue;
            }
            
            // Use two pointers to find pairs
            int left = i + 1;
            int right = nums.length - 1;
            
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                
                if (sum == 0) {
                    // Found valid triplet
                    List<Integer> triplet = new ArrayList<>();
                    triplet.add(nums[i]);
                    triplet.add(nums[left]);
                    triplet.add(nums[right]);
                    result.add(triplet);
                    
                    // Skip duplicates for left and right
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        // Test Case 1
        int[] nums1 = {-1, 0, 1, 2, -1, -4};
        System.out.print("Input: ");
        printArray(nums1);
        System.out.println("Output: " + threeSum(nums1));
        System.out.println("Expected: [[-1,-1,2],[-1,0,1]]\n");
        
        // Test Case 2
        int[] nums2 = {0, 1, 1};
        System.out.print("Input: ");
        printArray(nums2);
        System.out.println("Output: " + threeSum(nums2));
        System.out.println("Expected: []\n");
        
        // Test Case 3
        int[] nums3 = {0, 0, 0};
        System.out.print("Input: ");
        printArray(nums3);
        System.out.println("Output: " + threeSum(nums3));
        System.out.println("Expected: [[0,0,0]]\n");
        
        // Test Case 4
        int[] nums4 = {-2, 0, 1, 1, 2};
        System.out.print("Input: ");
        printArray(nums4);
        System.out.println("Output: " + threeSum(nums4));
        System.out.println("Expected: [[-2,0,2],[-2,1,1]]\n");
        
        // Test Case 5
        int[] nums5 = {-1, 0, 1, 2, -1, -4};
        System.out.print("Input: ");
        printArray(nums5);
        System.out.println("Output: " + threeSum(nums5));
        System.out.println("Expected: [[-1,-1,2],[-1,0,1]]");
    }
    
    private static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) System.out.print(",");
        }
        System.out.println("]");
    }
}
