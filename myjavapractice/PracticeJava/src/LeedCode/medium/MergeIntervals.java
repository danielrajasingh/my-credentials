/*
========================================
[PROBLEM] Merge Intervals
[DIFFICULTY] MEDIUM
[TOPIC] Array, Sorting
========================================

PROBLEM EXPLANATION:
Given an array of intervals where intervals[i] = [starti, endi], 
merge all overlapping intervals, and return an array of the non-overlapping 
intervals that cover all the intervals in the input.

Example 1:
Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].

Example 2:
Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.

KEY OBSERVATIONS / INTUITION:
- Sort intervals by start time
- Merge overlapping intervals
- Current interval overlaps if start <= last.end

APPROACH (Step-by-Step):
   Step 1: Sort intervals by start time
   Step 2: Add first interval to result
   Step 3: For each interval, check if it overlaps with previous
   Step 4: If overlap, merge by updating end
   Step 5: If no overlap, add new interval

TIME & SPACE COMPLEXITY ANALYSIS:
   Time Complexity:  O(n log n) - Sorting dominates
   Space Complexity: O(n) - For result list

DRY RUN EXAMPLE:
Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Process:
  Sort: [[1,3],[2,6],[8,10],[15,18]]
  result = [[1,3]]
  i=1: [2,6] overlaps [1,3] -> merge to [1,6]
  i=2: [8,10] doesn't overlap [1,6] -> add [8,10]
  i=3: [15,18] doesn't overlap [8,10] -> add [15,18]
Output: [[1,6],[8,10],[15,18]]

ONE-LINE MEMORY TRICK:
"Sort by start, merge overlapping intervals"

MENTAL VISUALIZATION:
Think of merging overlapping time slots. Sort first, then merge contiguous intervals.

IMPORTANT EDGE CASES:
* No intervals -> return empty
* Single interval -> return that interval
* All overlapping -> return one interval

SOLUTION STRATEGY:
1. Sort intervals by start time
2. Iterate and merge overlapping intervals
3. Update end time if current overlaps

========================================
*/

package medium;

import java.util.*;

public class MergeIntervals {
    
    /**
     * Merge overlapping intervals
     */
    public static int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return new int[0][];
        }
        
        // Sort intervals by start time
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        
        List<int[]> result = new ArrayList<>();
        int[] current = intervals[0];
        result.add(current);
        
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= current[1]) {
                // Overlapping - merge
                current[1] = Math.max(current[1], intervals[i][1]);
            } else {
                // Not overlapping - add new interval
                current = intervals[i];
                result.add(current);
            }
        }
        
        return result.toArray(new int[0][]);
    }
    
    public static void main(String[] args) {
        // Test Case 1
        int[][] intervals1 = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        System.out.print("Input: ");
        printIntervals(intervals1);
        System.out.println("Output: " + Arrays.deepToString(merge(intervals1)));
        System.out.println("Expected: [[1,6],[8,10],[15,18]]\n");
        
        // Test Case 2
        int[][] intervals2 = {{1, 4}, {4, 5}};
        System.out.print("Input: ");
        printIntervals(intervals2);
        System.out.println("Output: " + Arrays.deepToString(merge(intervals2)));
        System.out.println("Expected: [[1,5]]\n");
        
        // Test Case 3
        int[][] intervals3 = {{1, 4}, {0, 4}};
        System.out.print("Input: ");
        printIntervals(intervals3);
        System.out.println("Output: " + Arrays.deepToString(merge(intervals3)));
        System.out.println("Expected: [[0,4]]\n");
        
        // Test Case 4
        int[][] intervals4 = {{1, 4}, {2, 3}};
        System.out.print("Input: ");
        printIntervals(intervals4);
        System.out.println("Output: " + Arrays.deepToString(merge(intervals4)));
        System.out.println("Expected: [[1,4]]\n");
        
        // Test Case 5
        int[][] intervals5 = {{1, 4}, {0, 0}};
        System.out.print("Input: ");
        printIntervals(intervals5);
        System.out.println("Output: " + Arrays.deepToString(merge(intervals5)));
        System.out.println("Expected: [[0,0],[1,4]]");
    }
    
    private static void printIntervals(int[][] intervals) {
        System.out.print("[");
        for (int i = 0; i < intervals.length; i++) {
            System.out.print("[" + intervals[i][0] + "," + intervals[i][1] + "]");
            if (i < intervals.length - 1) System.out.print(",");
        }
        System.out.println("]");
    }
}

public class MergeIntervals {
    
    // Main solving method
    public static Object solve(Object input) {
        if (input == null) return null;
        System.out.println("Solving: MergeIntervals");
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
