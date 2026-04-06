package Chapter12.StackBraces.src.main.java.coding.challenge02;
 
public class Main {
/*
Let’s break this down clearly step-by-step.

🟡 1. What is the question?

You are given:

A string containing only curly braces { and }

👉 Your task:

Return true if:
All braces are properly matched
Return false otherwise
🟡 2. What does “matching braces” mean?

A string is valid if:

Every { has a corresponding }
Order is correct (LIFO order)
✅ Valid examples:
{{{}}}
{}{}
{{}}
❌ Invalid examples:
{{}
}}{
{}}{
🟡 3. Key Concept

👉 This problem uses:

Stack (LIFO – Last In First Out)

Why stack?

Because:

Last opened { must be closed first
Stack perfectly models this behavior
🟡 4. Clear Analysis

We process the string left to right:

Case 1: {

👉 Push into stack

Case 2: }

👉 Check:

If stack is empty → ❌ invalid
Else → pop one {
Final Check:
If stack is empty → ✅ valid
Else → ❌ invalid
🟡 5. Algorithm
Create an empty stack
Loop through each character:
If { → push
If }:
If stack empty → return false
Else → pop
After loop:
If stack empty → return true
Else → return false
🟡 6. Solution (Java Implementation)
import java.util.Stack;

public class StackBraces {

    public static boolean bracesMatching(String str) {
        Stack<Character> stack = new Stack<>();

        for (char ch : str.toCharArray()) {

            if (ch == '{') {
                stack.push(ch);
            }
            else if (ch == '}') {
                if (stack.isEmpty()) {
                    return false; // no matching opening brace
                }
                stack.pop();
            }
            else {
                return false; // invalid character
            }
        }

        // If stack is empty → all matched
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(bracesMatching("{{{}}}{}{{}}")); // true
        System.out.println(bracesMatching("{{}"));          // false
    }
}
🟡 7. Complexity Analysis
⏱ Time Complexity:
O(n)
One pass through string
🧠 Space Complexity:
O(n)
Stack stores braces
🟡 8. Key Insights
🔑 Stack ensures correct order of matching
🔑 Push for {, pop for }
🔑 Final stack must be empty
🟡 9. Common Mistakes

❌ Not checking empty stack before pop
❌ Ignoring invalid characters
❌ Only counting braces (order matters!)
❌ Forgetting final stack check

🟡 10. Interview Follow-up (Very Important)

👉 Often extended to:

Multiple brackets:
()  {}  []
Advanced solution idea:

Use a map

Map<Character, Character> map = Map.of(
    ')', '(',
    '}', '{',
    ']', '['
);
🟡 11. Final Summary

👉 Problem:

Validate matching curly braces

👉 Approach:

Use stack

👉 Logic:

{ → push
} → pop
End → stack must be empty

If you want next, I can:

Solve multiple brackets problem
Show step-by-step dry run
Give real interview tricky cases
 */
    public static void main(String[] args) {

        String goodBracesStr = "{}{{{}}}{{}}{}";
        String wrongBracesStr = "{}{{{}}}{{}{{}";

        System.out.println("Good (should return true): " 
                + StackBraces.bracesMatching(goodBracesStr));
        
        System.out.println("Wrong (should return false): " 
                + StackBraces.bracesMatching(wrongBracesStr));
    }
}
