package medium;

import java.util.*;

public class PartitionLabels {
    /* Problem: Partition Labels | Link: https://leetcode.com/problems/partition-labels
    Difficulty: Medium | Topic: Hash Table, Two Pointers, String, Greedy | Partition no-overlap.
    APPROACH: Greedy with last occurrence map. O(n). */

    public static List<Integer> partitionLabels(String s) {
        Map<Character, Integer> last = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            last.put(s.charAt(i), i);
        }
        List<Integer> result = new ArrayList<>();
        int end = 0, start = 0;
        for (int i = 0; i < s.length(); i++) {
            end = Math.max(end, last.get(s.charAt(i)));
            if (i == end) {
                result.add(i - start + 1);
                start = i + 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("Partitions: " + partitionLabels("ababcbacaddefegdehijhklij"));
        System.out.println("Expected: [9,7,8]\n");
    }
}
