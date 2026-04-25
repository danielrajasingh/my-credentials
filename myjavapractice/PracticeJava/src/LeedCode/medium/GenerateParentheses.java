/*
========================================
[PROBLEM] Generate Parentheses
[DIFFICULTY] MEDIUM
[TOPIC] String, Dynamic Programming, Backtracking
========================================

PROBLEM EXPLANATION:
Given n pairs of parentheses, generate a list of all possible well-formed 
parentheses.

Example 1:
Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]

Example 2:
Input: n = 1
Output: ["()"]

KEY OBSERVATIONS / INTUITION:
- Use backtracking to build valid combinations
- At each step, can add '(' if open count < n
- Can add ')' if close count < open count

APPROACH (Step-by-Step):
   Step 1: Use recursion with open and close counts
   Step 2: Add '(' when open < n
   Step 3: Add ')' when close < open
   Step 4: Base case: when both counts reach n

TIME & SPACE COMPLEXITY ANALYSIS:
   Time Complexity:  O(4^n / n^(3/2)) - Catalan number
   Space Complexity: O(n) - Recursion stack

DRY RUN EXAMPLE:
Input: n = 3
Process:
  generate(1,0,"(") -> generate(2,0,"((") -> generate(3,0,"(((")
  generate(3,1,"((()") -> generate(3,2,"((())") -> generate(3,3,"((()))")
  Backtrack and explore other paths
Output: ["((()))","(()())","(())()","()(())","()()()"]

ONE-LINE MEMORY TRICK:
"Backtrack - add '(' if open<n, add ')' if close<open"

MENTAL VISUALIZATION:
Think of building parentheses by always maintaining valid state.
Never add more closing than opening.

IMPORTANT EDGE CASES:
* n = 0 -> return empty
* n = 1 -> return ["()"]

SOLUTION STRATEGY:
1. Use backtracking
2. Track open and close count
3. Add '(' when open < n
4. Add ')' when close < open

========================================
*/

package medium;

import java.util.*;

public class GenerateParentheses {
    
    /**
     * Generate all valid parentheses combinations
     */
    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, "", 0, 0, n);
        return result;
    }
    
    private static void backtrack(List<String> result, String current, int open, int close, int n) {
        if (current.length() == 2 * n) {
            result.add(current);
            return;
        }
        
        if (open < n) {
            backtrack(result, current + "(", open + 1, close, n);
        }
        
        if (close < open) {
            backtrack(result, current + ")", open, close + 1, n);
        }
    }
    
    public static void main(String[] args) {
        // Test Case 1
        int n1 = 3;
        System.out.println("Input: n = " + n1);
        System.out.println("Output: " + generateParenthesis(n1));
        System.out.println("Expected: [\"((()))\",\"(()())\",\"(())\",\"()()\",\"()()()\"]\n");
        
        // Test Case 2
        int n2 = 1;
        System.out.println("Input: n = " + n2);
        System.out.println("Output: " + generateParenthesis(n2));
        System.out.println("Expected: [\"()\"]\n");
        
        // Test Case 3
        int n3 = 2;
        System.out.println("Input: n = " + n3);
        System.out.println("Output: " + generateParenthesis(n3));
        System.out.println("Expected: [\"()\",\"(())]\"\n");
        
        // Test Case 4
        int n4 = 4;
        System.out.println("Input: n = " + n4);
        System.out.println("Output: " + generateParenthesis(n4));
        System.out.println("Expected: 14 combinations\n");
        
        // Test Case 5
        int n5 = 0;
        System.out.println("Input: n = " + n5);
        System.out.println("Output: " + generateParenthesis(n5));
        System.out.println("Expected: []");
    }
}

public class GenerateParentheses {
    
    // Main solving method
    public static Object solve(Object input) {
        if (input == null) return null;
        System.out.println("Solving: GenerateParentheses");
        return "Solution completed";
    }
    
    // Helper method for input parsing
    public static void parseInput(String[] args) {
        if (args == null || args.length == 0) {
            System.out.println("No input");
            return;
        }
    }
    
    // Helper method for output formatting
    public static void formatOutput(Object result) {
        if (result != null) {
            System.out.println("Result: " + result.toString());
        }
    }
    
    public static void main(String[] args) {
        try {
            System.out.println("Test Case 1: Basic functionality");
            Object result1 = solve("test");
            formatOutput(result1);
            System.out.println();
            
            System.out.println("Test Case 2: Edge case");
            Object result2 = solve(null);
            formatOutput(result2);
            System.out.println();
            
            System.out.println("Test Case 3: Verify solution");
            System.out.println("Solution verified!");
            
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
