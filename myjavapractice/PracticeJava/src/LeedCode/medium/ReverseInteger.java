package medium;

public class ReverseInteger {
    /* Problem: Reverse Integer | Link: https://leetcode.com/problems/reverse-integer
    Difficulty: Medium | Topic: Math | Reverse digits.
    APPROACH: Build new number with modulo. O(log n). */

    public static int reverse(int x) {
        long result = 0;
        while (x != 0) {
            int digit = x % 10;
            result = result * 10 + digit;
            x /= 10;
        }
        if (result < Integer.MIN_VALUE || result > Integer.MAX_VALUE) return 0;
        return (int) result;
    }

    public static void main(String[] args) {
        System.out.println("Reversed: " + reverse(123));
        System.out.println("Expected: 321\n");
    }
}
