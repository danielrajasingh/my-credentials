package medium;

import java.util.*;

public class DailyTemperatures {
    /* Problem: Daily Temperatures | Link: https://leetcode.com/problems/daily-temperatures
    Difficulty: Medium | Topic: Array, Stack, Monotonic Stack | Days to warmer.
    APPROACH: Monotonic decreasing stack. O(n). */

    public static int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = temperatures.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i]) {
                stack.pop();
            }
            result[i] = stack.isEmpty() ? 0 : stack.peek() - i;
            stack.push(i);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));
        System.out.println("Expected: [1,1,4,2,1,1,0,0]\n");
    }
}
