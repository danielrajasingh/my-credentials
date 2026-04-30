/*
========================================
[PROBLEM] Product of Array Except Self
[DIFFICULTY] MEDIUM
[TOPIC] Array, Two Pointers, Binary Search, Bit Manipulation
========================================

PROBLEM EXPLANATION:
Given an integer array nums, return an array answer such that answer[i] is 
equal to the product of all the other elements of nums.

The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit 
integer.

You must write an algorithm that runs in O(n) time and without using the 
division operation.

Example 1:
Input: nums = [1,2,3,4]
Output: [24,12,8,6]

Example 2:
Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]

KEY OBSERVATIONS / INTUITION:
- Use prefix and suffix products
- For each element, product = prefix * suffix
- Can do in single pass with O(1) extra space

APPROACH (Step-by-Step):
   Step 1: Create result array initialized to 1
   Step 2: Calculate prefix products (left to right)
   Step 3: Calculate suffix products and multiply (right to left)
   Step 4: Return result

TIME & SPACE COMPLEXITY ANALYSIS:
   Time Complexity:  O(n) - Two passes
   Space Complexity: O(1) - Excluding output array

DRY RUN EXAMPLE:
Input: nums = [1,2,3,4]
Process:
  Prefix: [1,1,2,6]
  Suffix: [24,12,4,1]
  Result: [24,12,8,6]
Output: [24,12,8,6]

ONE-LINE MEMORY TRICK:
"Prefix * suffix - left to right then right to left"

MENTAL VISUALIZATION:
Think of each element's product as all elements to the left times all elements to the right.

IMPORTANT EDGE CASES:
* Contains zero -> product becomes 0
* Single element -> return [1]
* Negative numbers -> handle sign correctly

SOLUTION STRATEGY:
1. Calculate prefix products
2. Calculate suffix products in same array
3. Multiply prefix and suffix

========================================
*/

package medium;

public class ProductOfArrayExceptSelf {
    
    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        
        // Calculate prefix products
        result[0] = 1;
        for (int i = 1; i < n; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }
        
        // Calculate suffix products and multiply
        int suffix = 1;
        for (int i = n - 1; i >= 0; i--) {
            result[i] = result[i] * suffix;
            suffix *= nums[i];
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        // Test Case 1
        int[] nums1 = {1, 2, 3, 4};
        System.out.print("Input: ");
        printArray(nums1);
        System.out.println("Output: " + java.util.Arrays.toString(productExceptSelf(nums1)));
        System.out.println("Expected: [24,12,8,6]\n");
        
        // Test Case 2
        int[] nums2 = {-1, 1, 0, -3, 3};
        System.out.print("Input: ");
        printArray(nums2);
        System.out.println("Output: " + java.util.Arrays.toString(productExceptSelf(nums2)));
        System.out.println("Expected: [0,0,9,0,0]\n");
        
        // Test Case 3
        int[] nums3 = {2, 3};
        System.out.print("Input: ");
        printArray(nums3);
        System.out.println("Output: " + java.util.Arrays.toString(productExceptSelf(nums3)));
        System.out.println("Expected: [3,2]\n");
        
        // Test Case 4
        int[] nums4 = {1};
        System.out.print("Input: ");
        printArray(nums4);
        System.out.println("Output: " + java.util.Arrays.toString(productExceptSelf(nums4)));
        System.out.println("Expected: [1]\n");
        
        // Test Case 5
        int[] nums5 = {1, 2, 3};
        System.out.print("Input: ");
        printArray(nums5);
        System.out.println("Output: " + java.util.Arrays.toString(productExceptSelf(nums5)));
        System.out.println("Expected: [6,3,2]");
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
