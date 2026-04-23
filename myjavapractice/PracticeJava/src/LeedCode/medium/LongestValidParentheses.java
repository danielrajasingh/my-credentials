package medium;

import java.util.*;

public class LongestValidParentheses {
    /* Problem: Longest Valid Parentheses | Link: https://leetcode.com/problems/longest-valid-parentheses
    Difficulty: Medium | Topic: String, Dynamic Programming, Stack | Find longest valid substring.
    APPROACH: Stack or DP. O(n). */

    public static int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') stack.push(i);
            else {
                stack.pop();
                if (stack.isEmpty()) stack.push(i);
                else max = Math.max(max, i - stack.peek());
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println("Longest: " + longestValidParentheses("(()"));
        System.out.println("Expected: 2\n");
    }
}
