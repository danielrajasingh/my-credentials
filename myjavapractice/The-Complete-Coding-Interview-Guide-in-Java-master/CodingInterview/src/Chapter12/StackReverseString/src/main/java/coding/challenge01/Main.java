package Chapter12.StackReverseString.src.main.java.coding.challenge01;

public class Main {
    /*
    Let’s go step-by-step and make this very clear.

    🟡 1. What is the question?

    You are given:

    A string

    👉 Your task:

    Reverse the string using a stack
    🟡 2. What is being tested?

    This problem is testing:

    Understanding of stack (LIFO)
    Ability to apply data structures to simple problems
    🟡 3. Key Concept

    👉 Stack follows:

    LIFO (Last In, First Out)

    So:

    Last character pushed → first character popped
    Example:
    Input:  "HELLO"

    Push → H E L L O
    Stack top → O

    Pop → O L L E H

    Output: "OLLEH"
    🟡 4. Clear Analysis

    We cannot directly reverse using stack unless we:

    Step 1:

    Push all characters into the stack

    Step 2:

    Pop characters from the stack

    👉 This automatically reverses the order

    🟡 5. Algorithm
    Convert string → char array
    Create a stack
    Push all characters into stack
    Pop characters one by one
    Store them back into array
    Convert array → string
    🟡 6. Solution (Approach Summary)

    👉 Use stack to reverse order:

    Push → original order
    Pop → reversed order
    🟡 7. Implementation (Java Code)
    import java.util.Stack;

    public class StackReverseString {

        public static String reverse(String str) {
            Stack<Character> stack = new Stack<>();

            // Step 1: Push all characters into stack
            char[] chars = str.toCharArray();
            for (char c : chars) {
                stack.push(c);
            }

            // Step 2: Pop characters and overwrite array
            for (int i = 0; i < chars.length; i++) {
                chars[i] = stack.pop();
            }

            // Step 3: Return reversed string
            return new String(chars);
        }

        public static void main(String[] args) {
            String input = "HELLO";
            System.out.println(reverse(input)); // Output: OLLEH
        }
    }
    🟡 8. Complexity Analysis
    ⏱ Time Complexity:
    O(n)
    One pass to push + one pass to pop
    🧠 Space Complexity:
    O(n)
    Stack stores all characters
    🟡 9. Key Insights
    🔑 Stack naturally reverses order
    🔑 LIFO = reverse logic
    🔑 Very common beginner interview question
    🟡 10. Common Mistakes

    ❌ Not popping all elements
    ❌ Using wrong loop length
    ❌ Forgetting to convert back to string
    ❌ Not handling empty string

    🟡 11. Interview Follow-up (Important)

    Interviewer may ask:

    👉 “Can you do it without extra space?”

    Better solution:
    public static String reverse(String str) {
        char[] arr = str.toCharArray();
        int left = 0, right = arr.length - 1;

        while (left < right) {
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }

        return new String(arr);
    }
    🟡 12. Final Summary

    👉 Problem:

    Reverse string using stack

    👉 Approach:

    Push → Pop

    👉 Complexity:

    Time: O(n)
    Space: O(n)

    If you want, I can next:

    Show step-by-step dry run
    Explain stack vs recursion reversal
    Give advanced variations (reverse words, etc.)
     */
    public static void main(String[] args) {

        String str = "dlrow olleh";

        String result = Stacks.reverse(str);
        System.out.println("Result: " + result);
    }
}
