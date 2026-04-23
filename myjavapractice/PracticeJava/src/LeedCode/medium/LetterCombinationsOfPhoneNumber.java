package medium;

import java.util.*;

public class LetterCombinationsOfPhoneNumber {
    /*
    Problem: Letter Combinations of a Phone Number | Link: https://leetcode.com/problems/letter-combinations-of-a-phone-number
    Difficulty: Medium | Topic: Hash Table, String, Backtracking
    
    Map digits to letters (like phone keypad). Generate all combinations.
    Example: "23" → ["ad","ae","af","bd","be","bf","cd","ce","cf"]
    
    APPROACH: Backtracking - for each digit, try each mapped letter.
    */

    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }

        String[] mapping = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        backtrack(result, "", digits, 0, mapping);
        return result;
    }

    private static void backtrack(List<String> result, String current, String digits, int index, String[] mapping) {
        if (index == digits.length()) {
            result.add(current);
            return;
        }

        String letters = mapping[digits.charAt(index) - '0'];
        for (char c : letters.toCharArray()) {
            backtrack(result, current + c, digits, index + 1, mapping);
        }
    }

    public static void main(String[] args) {
        System.out.println("Input: \"23\"");
        System.out.println("Output: " + letterCombinations("23"));
        System.out.println("Expected: 9 combinations\n");

        System.out.println("Input: \"\"");
        System.out.println("Output: " + letterCombinations(""));
        System.out.println("Expected: []\n");

        System.out.println("Input: \"2\"");
        System.out.println("Output: " + letterCombinations("2"));
        System.out.println("Expected: [a,b,c]\n");
    }
}
