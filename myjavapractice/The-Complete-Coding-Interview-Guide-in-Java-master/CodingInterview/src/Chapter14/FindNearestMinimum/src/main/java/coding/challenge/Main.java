package Chapter14.FindNearestMinimum.src.main.java.coding.challenge;
 
public class Main {
    /*
        This is a very important stack-based problem (also called Nearest Smaller to Left). Let’s break it down clearly 👇

✅ 1. What is the Question?

You are given an array:

arr = [4, 1, 8, 3, 8, 2, 6, 7, 4, 9]

👉 For each element, you must find:

The nearest smaller element on its left side

✔️ If no such element exists:

Return _ or -1

🔍 Example Output
Input:  [4, 1, 8, 3, 8, 2, 6, 7, 4, 9]
Output: [_, _, 1, 1, 3, 1, 2, 6, 2, 4]
✅ 2. Understanding the Problem

Let’s take one example:

Element: 8 (index 2)
Left side: [4, 1]
Nearest smaller: 1 ✅

👉 We need the closest smaller, NOT just any smaller.

❌ Brute Force Approach
Idea:
For each element, scan left until you find a smaller number
Complexity:
O(n²) ❌ (too slow)
✅ 3. Optimized Approach (Stack 🔥)

👉 Use a monotonic stack

✅ 4. Key Idea

Maintain a stack such that:

Stack always contains elements smaller than current element

✅ 5. Algorithm (Step-by-Step)

For each element arr[i]:

🔹 Step 1: Remove useless elements
While stack not empty AND stack.top >= arr[i]
    pop()

👉 Because they cannot be "nearest smaller"

🔹 Step 2: Check answer
If stack is empty → no smaller → print _
Else → top of stack is answer
🔹 Step 3: Push current element
stack.push(arr[i])
✅ 6. Dry Run
arr = [4, 1, 8, 3]

i=0 → 4 → stack empty → _
stack: [4]

i=1 → 1 → pop 4 → empty → _
stack: [1]

i=2 → 8 → top=1 → answer=1
stack: [1,8]

i=3 → 3 → pop 8 → top=1 → answer=1
stack: [1,3]
✅ 7. Java Implementation
import java.util.Stack;

public class NearestLeftSmaller {

    public static void findLeftSmaller(int[] arr) {

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < arr.length; i++) {

            // Step 1: Remove elements >= current
            while (!stack.isEmpty() && stack.peek() >= arr[i]) {
                stack.pop();
            }

            // Step 2: Print result
            if (stack.isEmpty()) {
                System.out.print("_ ");
            } else {
                System.out.print(stack.peek() + " ");
            }

            // Step 3: Push current element
            stack.push(arr[i]);
        }
    }

    public static void main(String[] args) {

        int[] arr = {4, 1, 8, 3, 8, 2, 6, 7, 4, 9};

        findLeftSmaller(arr);
        // Output: _ _ 1 1 3 1 2 6 2 4
    }
}
✅ 8. Complexity Analysis
Type	Complexity
Time	O(n)
Space	O(n)

👉 Each element is pushed and popped at most once

✅ 9. Why Stack Works? (Important Insight 🔥)
Stack keeps useful candidates only
Removes elements that:
Are bigger
Can never be answers in future

👉 This makes it efficient

✅ 10. Edge Cases 🚨
Case	Output
Increasing array	many valid answers
Decreasing array	mostly _
All same elements	all _
Single element	_
❌ Common Mistakes
❌ Not popping elements ≥ current
❌ Using queue instead of stack
❌ Returning first smaller instead of nearest
❌ Forgetting stack empty case
✅ 11. Short Interview Answer (Perfect Summary)

Use a stack to keep track of smaller elements. For each element, pop larger elements, then the top of the stack gives the nearest smaller element.

🚀 Bonus (Follow-ups)

They may ask:

👉 Nearest smaller to right
👉 Nearest greater element
👉 Stock span problem (variation 🔥)
👉 Largest rectangle in histogram (advanced)

If you want next level:

I can show visual stack animation
Or solve Next Greater Element
Or give a hard stack-based interview problem 🚀
     */
    public static void main(String[] args) {

        // Output: _, _, 1, 1, 3, 1, 2, 6, 2, 4, 
        int[] integers = {4, 1, 8, 3, 8, 2, 6, 7, 4, 9};
        
        Finds.leftSmaller(integers);
    }
}
