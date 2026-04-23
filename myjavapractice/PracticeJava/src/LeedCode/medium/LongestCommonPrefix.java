package medium;

import java.util.*;

public class LongestCommonPrefix {
    /* Problem: Longest Common Prefix | Link: https://leetcode.com/problems/longest-common-prefix
    Difficulty: Medium | Topic: String | Find LCP.
    APPROACH: Horizontal scanning or column-wise. O(min(len)*n). */

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        for (int i = 0; i < strs[0].length(); i++) {
            for (int j = 1; j < strs.length; j++) {
                if (i >= strs[j].length() || strs[j].charAt(i) != strs[0].charAt(i)) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }

    public static void main(String[] args) {
        System.out.println("LCP: " + longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
        System.out.println("Expected: fl\n");
    }
}
