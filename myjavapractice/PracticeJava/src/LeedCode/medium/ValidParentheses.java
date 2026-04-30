/*
========================================
[PROBLEM] Valid Parentheses
[DIFFICULTY] EASY
[TOPIC] String, Stack
========================================

PROBLEM EXPLANATION:
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', 
determine if the input string is valid.

An input string is valid if:
1. Open brackets must be closed by the same type of brackets.
2. Open brackets must be closed in the correct order.
3. Every close bracket has a corresponding open bracket of the same type.

Example 1:
Input: s = "()"
Output: true

Example 2:
Input: s = "()[]{}"
Output: true

Example 3:
Input: s = "(]"
Output: false

KEY OBSERVATIONS / INTUITION:
- Use stack to track opening brackets
- When closing bracket found, check if matches top of stack
- Stack should be empty at end for valid string

APPROACH (Step-by-Step):
   Step 1: Create stack for tracking
   Step 2: Iterate through each character
   Step 3: If opening bracket, push to stack
   Step 4: If closing bracket, check stack top for match
   Step 5: At end, stack should be empty

TIME & SPACE COMPLEXITY ANALYSIS:
   Time Complexity:  O(n) - Single pass
   Space Complexity: O(n) - Stack in worst case

DRY RUN EXAMPLE:
Input: s = "([)]"
Process:
  i=0: '(' push to stack
  i=1: '[' push to stack
  i=2: ')' - stack top='[' != ')', invalid
Output: false

ONE-LINE MEMORY TRICK:
"Stack - push opening, pop and match closing"

MENTAL VISUALIZATION:
Think of parentheses as nested boxes. Each opening must be closed by its matching closing in the correct order.

IMPORTANT EDGE CASES:
* Empty string -> true
* Single character -> false
* Unmatched closing -> false

SOLUTION STRATEGY:
1. Use stack to track opening brackets
2. For each closing bracket, check top of stack
3. Return true if stack is empty at end

========================================
*/

package medium;

import java.util.*;

public class ValidParentheses {
    
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                
                char top = stack.pop();
                if ((c == ')' && top != '(') ||
                    (c == ']' && top != '[') ||
                    (c == '}' && top != '{')) {
                    return false;
                }
            }
        }
        
        return stack.isEmpty();
    }
    
    public static void main(String[] args) {
        // Test Case 1
        String s1 = "()";
        System.out.println("Input: \"" + s1 + "\"");
        System.out.println("Output: " + isValid(s1));
        System.out.println("Expected: true\n");
        
        // Test Case 2
        String s2 = "()[]{}";
        System.out.println("Input: \"" + s2 + "\"");
        System.out.println("Output: " + isValid(s2));
        System.out.println("Expected: true\n");
        
        // Test Case 3
        String s3 = "(]";
        System.out.println("Input: \"" + s3 + "\"");
        System.out.println("Output: " + isValid(s3));
        System.out.println("Expected: false\n");
        
        // Test Case 4
        String s4 = "([)]";
        System.out.println("Input: \"" + s4 + "\"");
        System.out.println("Output: " + isValid(s4));
        System.out.println("Expected: false\n");
        
        // Test Case 5
        String s5 = "{[]}";
        System.out.println("Input: \"" + s5 + "\"");
        System.out.println("Output: " + isValid(s5));
        System.out.println("Expected: true");
    }
}
