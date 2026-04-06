package Chapter12.SmallestNumber.src.main.java.coding.challenge09;
 
public class Main {

    /*
    Let’s break this down step-by-step so it’s clear, intuitive, and interview-ready.

🟡 1. What is the question?

You are given:

A number as a string (e.g., "4514327")
An integer k (number of digits to remove)

👉 Your task:

Remove k digits so that the resulting number is the smallest possible

Example:
Input:  "4514327", k = 4
Output: "127"
Input:  "2222222", k = 4
Output: "222"
🟡 2. Key Observation

👉 To get the smallest number:

Remove larger digits that appear before smaller digits

Example:
"4514327"

4 > 1 → remove 4
5 > 1 → remove 5

👉 Always prefer:

Smaller digits earlier in the number

🟡 3. Brute Force (Not Good)
Try all combinations of removing k digits
Choose smallest

⛔ Complexity:

O(2^n)
🟡 4. Optimal Approach (Greedy + Stack)

👉 Use:

Monotonic increasing stack

🟡 5. Core Idea

👉 While traversing digits:

If current digit is smaller than stack top
→ remove (pop) bigger digits
🟡 6. Algorithm
Step 1: Traverse digits

For each digit:

While:
    k > 0
    AND stack not empty
    AND stack top > current digit

→ pop from stack
→ k--

👉 Then push current digit

Step 2: If k still remains

👉 Remove from end (largest remaining digits)

while k > 0:
    stack.pop()
    k--
Step 3: Build result
Convert stack → string
Remove leading zeros
🟡 7. Solution (Code Implementation)
import java.util.Stack;

public class SmallestNumber {

    public static String smallestAfterRemove(String num, int k) {
        Stack<Character> stack = new Stack<>();

        for (char digit : num.toCharArray()) {

            // Remove larger digits from stack
            while (k > 0 && !stack.isEmpty() && stack.peek() > digit) {
                stack.pop();
                k--;
            }

            stack.push(digit);
        }

        // Remove remaining digits from end
        while (k > 0 && !stack.isEmpty()) {
            stack.pop();
            k--;
        }

        // Build result
        StringBuilder result = new StringBuilder();
        for (char c : stack) {
            result.append(c);
        }

        // Remove leading zeros
        while (result.length() > 0 && result.charAt(0) == '0') {
            result.deleteCharAt(0);
        }

        return result.length() == 0 ? "0" : result.toString();
    }

    public static void main(String[] args) {
        System.out.println(smallestAfterRemove("4514327", 4)); // 127
        System.out.println(smallestAfterRemove("2222222", 4)); // 222
    }
}
🟡 8. Complexity Analysis
⏱ Time:
O(n)

👉 Each digit pushed & popped at most once

🧠 Space:
O(n)
🟡 9. Key Insights
🔑 Greedy decision: remove bigger digits early
🔑 Stack maintains increasing order
🔑 Remove leftover digits from end
🔑 Handle leading zeros
🟡 10. Common Mistakes

❌ Not removing remaining k digits
❌ Forgetting leading zeros
❌ Using integer instead of string (overflow risk)
❌ Wrong comparison logic

🟡 11. Pattern Recognition

👉 This is similar to:

Remove K digits (LeetCode)
Monotonic stack problems
Lexicographically smallest subsequence
🟡 12. Summary

👉 Problem:

Remove k digits → smallest number

👉 Trick:

Use monotonic increasing stack

👉 Key rule:

Remove bigger digits when smaller digit appears

If you want next, I can:

Do a step-by-step dry run (VERY IMPORTANT)
Show visual intuition
Give harder variations (Google-level)
     */
    public static void main(String[] args) {

        String nr = "4321";

        Numbers.smallestAfterRemove(nr, 2);
    }
}
