package Chapter15.NextElementSameDigits.src.main.java.coding.challenge;
 
public class Main {
/*
This is a very important interview problem (often called Next Permutation). Let’s break it down clearly so you can explain it confidently in interviews 👇

✅ 1. What is the Question?

You are given a positive integer n.

👉 You must:

Find the next greater number using exactly the same digits.

✔️ If possible:

Return the smallest number greater than n using the same digits.

❌ If not possible:

Return something like:

"Not possible" OR -1
🔍 Examples
Input	Output	Explanation
1234	1243	Next permutation
1232	1322	Rearranged
321	Not possible	Already largest
6	Not possible	Single digit
621873	623178	Next greater
✅ 2. Key Insight (Very Important 🔥)

You are NOT generating all permutations.

👉 You are finding the next lexicographically greater permutation

✅ 3. Core Idea (Intuition)

Think from right to left:

Right side digits are usually in descending order
We want to make a small increase, not a big one
✅ 4. Algorithm (Step-by-Step)
🔹 Step 1: Find "Breaking Point"

Traverse from right:

Find first index i such that:

arr[i] < arr[i + 1]

👉 This is where increasing is possible

🔹 Step 2: If NOT found

👉 Digits are in descending order (like 321)

➡️ Return "Not possible"

🔹 Step 3: Find Next Greater Digit

From right side, find:

smallest digit > arr[i]
🔹 Step 4: Swap

Swap:

arr[i] ↔ that digit
🔹 Step 5: Reverse Right Side

Reverse elements from:

i+1 → end

👉 This gives the smallest possible number after swap

✅ 5. Dry Run Example
Input: 621873
Step 1: Find i
→ 1 < 8 → i = position of 1

Step 2: Find smallest > 1 → 3

Step 3: Swap → 623871

Step 4: Reverse right → 623178

✅ 7. Complexity Analysis
Time Complexity: O(n)
Space Complexity: O(1)
✅ 8. Edge Cases 🚨
Case	Handling
Single digit	Not possible
Descending order (321)	Not possible
Repeated digits	Works fine
Large numbers	Convert to array
✅ 9. Common Interview Mistakes
❌ Sorting entire array instead of partial
❌ Not finding correct "just greater" element
❌ Forgetting to reverse right side
❌ Generating all permutations (very slow ❌)
✅ 10. Short Interview Answer (Perfect Summary)

Traverse from right to find the first decreasing digit, swap it with the next greater digit on the right, then reverse the suffix to get the smallest greater number.

 */
    public static void main(String[] args) {

        int digits[] = { 6, 2, 1, 8, 7, 3 };         
        Numbers.findNextGreater(digits); 
    }
}
