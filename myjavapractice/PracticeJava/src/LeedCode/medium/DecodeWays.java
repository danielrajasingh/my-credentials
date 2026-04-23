package medium;

import java.util.*;

public class DecodeWays {
    /* Problem: Decode Ways | Link: https://leetcode.com/problems/decode-ways
    Difficulty: Medium | Topic: String, Dynamic Programming | Count decode options.
    APPROACH: DP tracking ways. O(n). */

    public static int numDecodings(String s) {
        if (s.charAt(0) == '0') return 0;
        int prev1 = 1, prev2 = 1;
        for (int i = 1; i < s.length(); i++) {
            int curr = 0;
            if (s.charAt(i) != '0') curr += prev1;
            int twoDigit = Integer.parseInt(s.substring(i - 1, i + 1));
            if (twoDigit >= 10 && twoDigit <= 26) curr += prev2;
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }

    public static void main(String[] args) {
        System.out.println("Decodings: " + numDecodings("226"));
        System.out.println("Expected: 3\n");
    }
}
