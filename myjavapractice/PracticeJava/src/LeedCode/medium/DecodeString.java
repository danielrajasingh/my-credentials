package medium;

import java.util.*;

public class DecodeString {
    /* Problem: Decode String | Link: https://leetcode.com/problems/decode-string
    Difficulty: Medium | Topic: String, Stack, Recursion | Expand encoded string.
    APPROACH: Stack for numbers and strings. O(n). */

    public static String decodeString(String s) {
        Stack<Object> stack = new Stack<>();
        int num = 0;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) num = num * 10 + (c - '0');
            else if (c == '[') {
                stack.push(num);
                stack.push("[");
                num = 0;
            } else if (c == ']') {
                StringBuilder sb = new StringBuilder();
                while (!stack.peek().equals("[")) sb.insert(0, stack.pop());
                stack.pop();
                int cnt = (int) stack.pop();
                String str = sb.toString();
                for (int i = 0; i < cnt - 1; i++) sb.append(str);
                stack.push(sb.toString());
            } else {
                stack.push(String.valueOf(c));
            }
        }
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) result.insert(0, stack.pop());
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println("Decode: " + decodeString("3[a2[c]]"));
        System.out.println("Expected: accaccacc\n");
    }
}
