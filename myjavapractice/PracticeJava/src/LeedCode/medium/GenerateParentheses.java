package medium;

import java.util.*;

public class GenerateParentheses {
    /*
    ========================================
    Problem: Generate Parentheses
    Link: https://leetcode.com/problems/generate-parentheses
    Difficulty: Medium
    Topic: String, Dynamic Programming, Backtracking
    ========================================
    
    PROBLEM EXPLANATION:
    Given n pairs of parentheses, generate all combinations of valid
    parentheses strings.
    
    Example: n=3
    Output: ["((()))","(()())","(())()","()(()" ,"()()()"]
    
    KEY OBSERVATIONS:
    - Valid parentheses: at each position, open count >= close count
    - Never exceed n open or n close parentheses
    - Use backtracking to generate all valid combinations
    - At each step, decide whether to add '(' or ')'
    - Prune invalid branches early
    
    APPROACH (Backtracking):
    1. Create recursive function with current string, open count, close count
    2. Base case: if open == n && close == n, add string to result
    3. Recursive cases:
       - If open < n, add '(' and recurse
       - If close < open, add ')' and recurse
    4. Return result
    
    TIME COMPLEXITY: O(4^n / sqrt(n)) - Catalan number
    SPACE COMPLEXITY: O(n) - recursion depth and temporary strings
    
    DRY RUN:
    n=2
    backtrack("", 0, 0):
      Add '(': backtrack("(", 1, 0)
        Add '(': backtrack("((", 2, 0)
          Add ')': backtrack("(()", 2, 1)
            Add ')': backtrack("(())", 2, 2) → add to result
        Add ')': backtrack("()", 1, 1)
          Add '(': backtrack("()(", 2, 1)
            Add ')': backtrack("()()", 2, 2) → add to result
    Result: ["(())","()()"] ✓
    
    MEMORY TRICK:
    "Backtrack: add '(' if open < n, add ')' if close < open"
    
    VISUALIZATION:
    n=2:
    Level 0: ""
    Level 1: "("
    Level 2: "((", "()"
    Level 3: "(()", "()(", "()("
    Level 4: "(())", "()()", "())"
    Valid: "(())", "()()"
    */

    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, "", 0, 0, n);
        return result;
    }

    private static void backtrack(List<String> result, String current, int open, int close, int n) {
        // Base case: complete valid combination
        if (open == n && close == n) {
            result.add(current);
            return;
        }

        // Add '(' if we haven't used n open parentheses
        if (open < n) {
            backtrack(result, current + "(", open + 1, close, n);
        }

        // Add ')' if close count < open count
        if (close < open) {
            backtrack(result, current + ")", open, close + 1, n);
        }
    }

    public static void main(String[] args) {
        // Test case 1
        System.out.println("Input: n=3");
        List<String> result1 = generateParenthesis(3);
        System.out.println("Output: " + result1);
        System.out.println("Expected: 5 combinations\n");

        // Test case 2
        System.out.println("Input: n=1");
        List<String> result2 = generateParenthesis(1);
        System.out.println("Output: " + result2);
        System.out.println("Expected: [\"()\"]\n");

        // Test case 3
        System.out.println("Input: n=2");
        List<String> result3 = generateParenthesis(2);
        System.out.println("Output: " + result3);
        System.out.println("Expected: [\"(())\",\"()()\"]\n");

        // Test case 4
        System.out.println("Input: n=4");
        List<String> result4 = generateParenthesis(4);
        System.out.println("Output count: " + result4.size());
        System.out.println("Expected count: 14\n");
    }
}
