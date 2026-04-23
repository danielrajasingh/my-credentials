package hard;

import java.util.*;

public class LongestSubstringWithAtMostKDistinctCharacters {
    /* Problem: Longest Substring with At Most K Distinct Characters | Link: https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters
    Difficulty: Hard | Topic: Sliding Window, String | Find longest with ≤k distinct.
    APPROACH: Sliding window with HashMap. O(n). */

    public static int lengthOfLongestSubstringKDistinct(String s, int k) {
        Map<Character, Integer> window = new HashMap<>();
        int left = 0, max = 0;
        for (int right = 0; right < s.length(); right++) {
            window.put(s.charAt(right), window.getOrDefault(s.charAt(right), 0) + 1);
            while (window.size() > k) {
                char c = s.charAt(left);
                window.put(c, window.get(c) - 1);
                if (window.get(c) == 0) window.remove(c);
                left++;
            }
            max = Math.max(max, right - left + 1);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println("Max length: " + lengthOfLongestSubstringKDistinct("eceba", 2));
        System.out.println("Expected: 3\n");
    }
}
