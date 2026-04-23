package easy;

public class MaximumProductSubarray {
    /*
    ========================================
    Problem: Maximum Product Subarray
    Link: https://leetcode.com/problems/maximum-product-subarray
    Difficulty: Easy (Medium in practice)
    Topic: Array, Dynamic Programming
    ========================================
    
    PROBLEM EXPLANATION:
    Given array nums, find contiguous subarray with largest product.
    Return the product.
    
    Example: nums=[2,3,-2,4] → [2,3] → product=6
    Example: nums=[-2] → -2
    
    KEY OBSERVATIONS:
    - Negative numbers can flip sign, turning min to max
    - Track both maximum and minimum at each position
    - maxCurrent could come from: current num, prev_max*current, prev_min*current
    - Same for minimum
    
    APPROACH (DP with two pointers):
    1. Initialize maxProd=nums[0], minProd=nums[0], result=nums[0]
    2. For each num from index 1:
       - temp_max = max(num, maxProd*num, minProd*num)
       - minProd = min(num, prev_maxProd*num, minProd*num)
       - maxProd = temp_max
       - result = max(result, maxProd)
    3. Return result
    
    TIME COMPLEXITY: O(n) - single pass
    SPACE COMPLEXITY: O(1) - tracking max/min
    
    DRY RUN:
    nums=[2,3,-2,4]
    maxProd=2, minProd=2, result=2
    num=3: temp=max(3,6,6)=6, min=min(3,6,6)=3, maxProd=6, result=6
    num=-2: temp=max(-2,-12,-6)=-2, min=min(-2,-12,-6)=-12, maxProd=-2, result=6
    num=4: temp=max(4,-8,-48)=4, min=min(4,-8,-48)=-48, maxProd=4, result=6
    Result: 6 ✓
    
    MEMORY TRICK:
    "Track both max and min: negative flips, use both possibilities"
    
    VISUALIZATION:
    Array: 2  3  -2  4
    Max:   2  6  -2  4  (result=6)
    Min:   2  3  -12 -48
    */

    public static int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int maxProd = nums[0];
        int minProd = nums[0];
        int result = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int tempMax = maxProd;
            maxProd = Math.max(nums[i], Math.max(maxProd * nums[i], minProd * nums[i]));
            minProd = Math.min(nums[i], Math.min(tempMax * nums[i], minProd * nums[i]));
            result = Math.max(result, maxProd);
        }

        return result;
    }

    public static void main(String[] args) {
        // Test case 1
        int[] nums1 = {2, 3, -2, 4};
        System.out.println("Input: [2, 3, -2, 4]");
        System.out.println("Output: " + maxProduct(nums1));
        System.out.println("Expected: 6 ([2,3])\n");

        // Test case 2
        int[] nums2 = {-2};
        System.out.println("Input: [-2]");
        System.out.println("Output: " + maxProduct(nums2));
        System.out.println("Expected: -2\n");

        // Test case 3
        int[] nums3 = {0, 2};
        System.out.println("Input: [0, 2]");
        System.out.println("Output: " + maxProduct(nums3));
        System.out.println("Expected: 2\n");

        // Test case 4
        int[] nums4 = {-2, 3, -4};
        System.out.println("Input: [-2, 3, -4]");
        System.out.println("Output: " + maxProduct(nums4));
        System.out.println("Expected: 24\n");
    }
}
