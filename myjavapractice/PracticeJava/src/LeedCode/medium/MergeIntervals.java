package medium;

import java.util.*;

public class MergeIntervals {
    /*
    ========================================
    Problem: Merge Intervals
    Link: https://leetcode.com/problems/merge-intervals
    Difficulty: Medium
    Topic: Array, Sorting
    ========================================
    
    PROBLEM EXPLANATION:
    Given array of intervals, merge all overlapping intervals.
    Return array with merged intervals (in any order).
    
    Example: intervals=[[1,3],[2,6],[8,10],[15,18]]
    Output: [[1,6],[8,10],[15,18]]
    
    KEY OBSERVATIONS:
    - Sort by start time first
    - After sorting, overlapping intervals are adjacent
    - Merge if current.start <= previous.end
    - Use end = max(current.end, previous.end) to merge properly
    - O(n log n) due to sorting
    
    APPROACH:
    1. Sort intervals by start value
    2. Initialize result with first interval
    3. For each subsequent interval:
       - If overlaps with last in result, merge them
       - Otherwise, add as new interval
    4. Return result
    
    TIME COMPLEXITY: O(n log n) - dominated by sorting
    SPACE COMPLEXITY: O(1) or O(n) - for result (excluding output)
    
    DRY RUN:
    intervals=[[1,3],[2,6],[8,10],[15,18]]
    After sort: [[1,3],[2,6],[8,10],[15,18]]
    result=[[1,3]]
    [2,6]: 2 <= 3, merge → [[1,6]]
    [8,10]: 8 > 6, add → [[1,6],[8,10]]
    [15,18]: 15 > 10, add → [[1,6],[8,10],[15,18]]
    Result: [[1,6],[8,10],[15,18]] ✓
    
    MEMORY TRICK:
    "Sort by start, merge adjacent if overlapping"
    
    VISUALIZATION:
    Before: [1──3] [2────6] [8──10] [15──18]
    After:  [1────────6] [8──10] [15──18]
    (overlaps merged)
    */

    public static int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length <= 1) {
            return intervals;
        }

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> result = new ArrayList<>();
        int[] currentInterval = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            int[] nextInterval = intervals[i];

            // Check if overlapping
            if (nextInterval[0] <= currentInterval[1]) {
                // Merge intervals
                currentInterval[1] = Math.max(currentInterval[1], nextInterval[1]);
            } else {
                // No overlap, add current to result and move to next
                result.add(currentInterval);
                currentInterval = nextInterval;
            }
        }

        result.add(currentInterval);
        return result.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        // Test case 1
        int[][] intervals1 = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        System.out.println("Input: [[1,3],[2,6],[8,10],[15,18]]");
        System.out.print("Output: [");
        int[][] result1 = merge(intervals1);
        for (int i = 0; i < result1.length; i++) {
            System.out.print("[" + result1[i][0] + "," + result1[i][1] + "]");
            if (i < result1.length - 1) System.out.print(",");
        }
        System.out.println("]");
        System.out.println("Expected: [[1,6],[8,10],[15,18]]\n");

        // Test case 2
        int[][] intervals2 = {{1, 4}, {4, 5}};
        System.out.println("Input: [[1,4],[4,5]]");
        System.out.print("Output: [");
        int[][] result2 = merge(intervals2);
        for (int i = 0; i < result2.length; i++) {
            System.out.print("[" + result2[i][0] + "," + result2[i][1] + "]");
            if (i < result2.length - 1) System.out.print(",");
        }
        System.out.println("]");
        System.out.println("Expected: [[1,5]]\n");

        // Test case 3
        int[][] intervals3 = {{1, 5}};
        System.out.println("Input: [[1,5]]");
        System.out.print("Output: [");
        int[][] result3 = merge(intervals3);
        for (int i = 0; i < result3.length; i++) {
            System.out.print("[" + result3[i][0] + "," + result3[i][1] + "]");
            if (i < result3.length - 1) System.out.print(",");
        }
        System.out.println("]");
        System.out.println("Expected: [[1,5]]\n");
    }
}
