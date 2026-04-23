package hard;

import java.util.*;

public class TaskScheduler {
    /* Problem: Task Scheduler | Link: https://leetcode.com/problems/task-scheduler
    Difficulty: Hard | Topic: Array, Hash Table, Greedy, Sorting, Heap, Counting | Min time schedule.
    APPROACH: Max frequency formula. O(n). */

    public static int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for (char c : tasks) freq[c - 'A']++;
        int maxFreq = 0;
        for (int f : freq) maxFreq = Math.max(maxFreq, f);
        int countMax = 0;
        for (int f : freq) if (f == maxFreq) countMax++;
        return Math.max(tasks.length, (maxFreq - 1) * (n + 1) + countMax);
    }

    public static void main(String[] args) {
        System.out.println("Schedule: " + leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 2));
        System.out.println("Expected: 8\n");
    }
}
