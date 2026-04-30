/*
========================================
[PROBLEM] Subarray Sum Equals K
[DIFFICULTY] MEDIUM
[TOPIC] Array, Hash Table, Prefix Sum
========================================

PROBLEM EXPLANATION:
Given an array of integers nums and an integer k, return the total number of 
continuous subarrays whose sum equals to k.

Example 1:
Input: nums = [1,1,1], k = 2
Output: 2
Explanation: The subarrays are [1,1] and [1,1]

Example 2:
Input: nums = [1,2,3], k = 3
Output: 2
Explanation: [1,2] and [3]

KEY OBSERVATIONS / INTUITION:
- Use prefix sum and hashmap
- If prefixSum - k exists in map, there's a subarray with sum k
- Count frequency of each prefix sum

APPROACH (Step-by-Step):
   Step 1: Calculate prefix sum at each position
   Step 2: Use hashmap to count prefix sum frequencies
   Step 3: For each prefix sum, check if prefixSum - k exists
   Step 4: Add count to result

TIME & SPACE COMPLEXITY ANALYSIS:
   Time Complexity:  O(n) - Single pass
   Space Complexity: O(n) - Hashmap for prefix sums

DRY RUN EXAMPLE:
Input: nums = [1,1,1], k = 2
Process:
  prefix=1: map={0:1,1:1}, prefix-k=-1 not found
  prefix=2: map={0:1,1:1,2:1}, prefix-k=0 found, count+=1
  prefix=3: map={0:1,1:1,2:1,3:1}, prefix-k=1 found, count+=1
Output: 2

ONE-LINE MEMORY TRICK:
"Prefix sum - k exists in map = subarray with sum k"

MENTAL VISUALIZATION:
Think of prefix sums as cumulative totals. If we need sum k from index i to j, then prefix[j] - prefix[i-1] = k, so prefix[i-1] = prefix[j] - k.

IMPORTANT EDGE CASES:
* Empty array -> return 0
* Single element equals k -> return 1
* No subarray found -> return 0

SOLUTION STRATEGY:
1. Use hashmap to store prefix sum frequencies
2. Include initial prefix sum of 0 with count 1
3. For each element, check if prefixSum - k exists

========================================
*/

package easy;

import java.util.*;

public class SubarraySumEqualsK {
    
    public static int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        
        int count = 0;
        int prefix = 0;
        
        for (int num : nums) {
            prefix += num;
            count += map.getOrDefault(prefix - k, 0);
            map.put(prefix, map.getOrDefault(prefix, 0) + 1);
        }
        
        return count;
    }
    
    public static void main(String[] args) {
        // Test Case 1
        int[] nums1 = {1, 1, 1};
        int k1 = 2;
        System.out.print("Input: nums=");
        printArray(nums1);
        System.out.println(", k=" + k1);
        System.out.println("Output: " + subarraySum(nums1, k1));
        System.out.println("Expected: 2\n");
        
        // Test Case 2
        int[] nums2 = {1, 2, 3};
        int k2 = 3;
        System.out.print("Input: nums=");
        printArray(nums2);
        System.out.println(", k=" + k2);
        System.out.println("Output: " + subarraySum(nums2, k2));
        System.out.println("Expected: 2\n");
        
        // Test Case 3
        int[] nums3 = {1, 2, 3};
        int k3 = 0;
        System.out.print("Input: nums=");
        printArray(nums3);
        System.out.println(", k=" + k3);
        System.out.println("Output: " + subarraySum(nums3, k3));
        System.out.println("Expected: 0\n");
        
        // Test Case 4
        int[] nums4 = {1, -1, 0};
        int k4 = 0;
        System.out.print("Input: nums=");
        printArray(nums4);
        System.out.println(", k=" + k4);
        System.out.println("Output: " + subarraySum(nums4, k4));
        System.out.println("Expected: 3\n");
        
        // Test Case 5
        int[] nums5 = {1};
        int k5 = 1;
        System.out.print("Input: nums=");
        printArray(nums5);
        System.out.println(", k=" + k5);
        System.out.println("Output: " + subarraySum(nums5, k5));
        System.out.println("Expected: 1");
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
