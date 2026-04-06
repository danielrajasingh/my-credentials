package Chapter12.StockSpan.src.main.java.coding.challenge04;
 
import java.util.Arrays;

public class Main {
/*
Let’s go step-by-step and make this very clear and interview-ready.

🟡 1. What is the question?

You are given:

An array of stock prices over consecutive days

👉 Your task:

For each day, compute the stock span
🟡 2. What is “Stock Span”?

For a given day i, stock span =

Number of consecutive previous days (including today) where
price ≤ current day’s price

Example:
Prices: [55, 34, 22, 23, 27, 88, 70, 42, 51, 100]
Span:   [ 1,  1,  1,  2,  3,  6,  1,  1,  2,  10]
Explanation:
Day 6 → price = 88
Previous smaller prices: 27, 23, 22, 34, 55
→ span = 6
🟡 3. Brute Force Approach (Not Good)

👉 For each day:

Go backward
Count until a bigger price appears
Complexity:
❌ O(n²)
🟡 4. Optimal Approach (Key Insight)

👉 We need:

The nearest previous greater price

Use:

Stack (monotonic decreasing stack)

🟡 5. Key Idea

We store:

indices of days in stack

👉 Why indices?

To compute span easily:
span = current_index - previous_greater_index
🟡 6. Algorithm
Create:
Stack (stores indices)
Result array
First day:
span = 1
push index 0
For each day i:

While:

current price > price at stack top

→ pop stack

If stack is empty:

span = i + 1

Else:

span = i - stack.peek()
Push current index
🟡 7. Solution (Code Implementation)
import java.util.Stack;

public class StockSpan {

    public static int[] stockSpan(int[] prices) {
        int n = prices.length;
        int[] span = new int[n];

        Stack<Integer> stack = new Stack<>();

        // First day
        span[0] = 1;
        stack.push(0);

        // Process remaining days
        for (int i = 1; i < n; i++) {

            // Pop smaller prices
            while (!stack.isEmpty() && prices[i] > prices[stack.peek()]) {
                stack.pop();
            }

            // Calculate span
            if (stack.isEmpty()) {
                span[i] = i + 1;
            } else {
                span[i] = i - stack.peek();
            }

            // Push current index
            stack.push(i);
        }

        return span;
    }

    public static void main(String[] args) {
        int[] prices = {55, 34, 22, 23, 27, 88, 70, 42, 51, 100};
        int[] result = stockSpan(prices);

        for (int s : result) {
            System.out.print(s + " ");
        }
    }
}
🟡 8. Complexity Analysis
⏱ Time Complexity:
O(n)
Each element pushed and popped once
🧠 Space Complexity:
O(n)
Stack + result array
🟡 9. Key Insights
🔑 Use monotonic stack
🔑 Remove smaller elements
🔑 Find nearest greater element to the left
🔑 Store indices, not values
🟡 10. Common Mistakes

❌ Using brute force
❌ Storing values instead of indices
❌ Not popping all smaller elements
❌ Wrong span formula

🟡 11. Interview Tip

This problem is a pattern problem:

👉 Same concept used in:

Next Greater Element
Histogram problems
Daily Temperatures
🟡 12. Quick Summary

👉 Problem:

Count consecutive smaller/equal prices

👉 Approach:

Use stack

👉 Formula:

span = i - previous greater index

If you want next, I can:

Show step-by-step dry run (very important)
Explain monotonic stack pattern deeply
Give similar interview questions
 */
    public static void main(String[] args) {

        int stockPrices[] = {55, 34, 22, 23, 27, 88, 70, 42, 51, 100};
        int[] spanResult = StockSpan.stockSpan(stockPrices);

        System.out.println("Stock prices: " + Arrays.toString(stockPrices));
        System.out.println("Span results: " + Arrays.toString(spanResult));
    }
}
