package Chapter12.StackHistogramArea.src.main.java.coding.challenge08;
 
public class Main {

    /*
    This is a very important and slightly tricky stack problem. Let’s break it down step-by-step so you fully understand it.

🟡 1. What is the question?

You are given:

An array representing a histogram
Each value = height of a bar
Width of each bar = 1

👉 Your task:

Find the maximum rectangular area that can be formed inside the histogram

Example:
Heights = [4, 2, 8, 6, 5, 3]

👉 Output:

Max Area = 15
🟡 2. What does “largest rectangle” mean?

👉 You can pick:

Any continuous bars
Height = minimum height among them
Width = number of bars

👉 Area:

area = height × width
🟡 3. Brute Force (Not Good)

👉 For every bar:

Expand left
Expand right
Find min height

⛔ Complexity:

O(n²)
🟡 4. Key Insight (VERY IMPORTANT)

👉 For each bar:

Find how far it can extend left and right
while all bars are ≥ current height

🟡 5. Why Stack?

We need:

Efficient way to find previous smaller element

👉 Use:

Monotonic increasing stack (stores indices)
🟡 6. Core Idea
Keep indices of bars in increasing height order
When a smaller bar comes:
👉 we compute area for taller bars
🟡 7. Algorithm (Step-by-Step)

Loop through all bars:

Step 1:
If current height ≥ stack top → push index
Step 2:
If current height < stack top:
👉 Pop stack and calculate area
Step 3:

For popped index:

height = histogram[top]

right boundary = current index (i)
left boundary = stack.peek()

width = i - left - 1
area = height × width
Step 4:
Track maximum area
Step 5:
Add a dummy bar (height = 0) at end
👉 ensures all bars are processed
🟡 8. Solution (Code Implementation)
import java.util.Stack;

public class MaxHistogramArea {

    public static int maxArea(int[] histogram) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;

        for (int i = 0; i <= histogram.length; i++) {

            int currentHeight = (i == histogram.length) ? 0 : histogram[i];

            // Process stack when current bar is smaller
            while (!stack.isEmpty() && currentHeight < histogram[stack.peek()]) {

                int top = stack.pop();
                int height = histogram[top];

                // left boundary
                int left = stack.isEmpty() ? -1 : stack.peek();

                // width
                int width = i - left - 1;

                // area
                int area = height * width;

                maxArea = Math.max(maxArea, area);
            }

            stack.push(i);
        }

        return maxArea;
    }

    public static void main(String[] args) {
        int[] histogram = {4, 2, 8, 6, 5, 3};
        System.out.println(maxArea(histogram)); // Output: 15
    }
}
🟡 9. Complexity Analysis
⏱ Time:
O(n)

👉 Each element pushed & popped once

🧠 Space:
O(n)
🟡 10. Key Insights
🔑 Use monotonic increasing stack
🔑 Calculate area when height decreases
🔑 Use indices (not values)
🔑 Add dummy bar at end
🟡 11. Common Mistakes

❌ Forgetting dummy bar
❌ Wrong width calculation
❌ Using values instead of indices
❌ Not handling empty stack

🟡 12. Visual Intuition

👉 Each bar tries to:

Expand left until smaller bar
Expand right until smaller bar

👉 Stack helps find these boundaries efficiently

🟡 13. Interview Tip

This is a pattern problem used in:

Largest rectangle in histogram
Max rectangle in binary matrix
Stock span (similar idea)
🟡 14. Summary

👉 Problem:

Find largest rectangle in histogram

👉 Trick:

Use stack to find boundaries

👉 Formula:

area = height × width
width = right - left - 1

If you want next, I can:

Do a step-by-step dry run (VERY IMPORTANT)
Show visual diagram explanation
Extend this to matrix rectangle problem (Google-level)
     */
    public static void main(String[] args) {

        int[] histogram = {4, 2, 8, 6, 5, 3};
        
        int ma = Stacks.maxAreaUsingStack(histogram);
        
        System.out.println("Max area: " + ma);
    }
}
