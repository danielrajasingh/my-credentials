package Chapter14.RadixSort.src.main.java.coding.challenge;

import java.util.Arrays;

public class Main {

    /*
    Let’s go step by step again: Question → Analysis → Solution → Implementation

✅ 1. What is the Question?

👉 You are given:

✔ An array of integers

👉 Your task:

✔ Sort the array using Radix Sort

🔹 Example
Input:
[323, 2, 3, 123, 45, 6, 788]

Output:
[2, 3, 6, 45, 123, 323, 788]
🧠 2. Clear Analysis
🔹 What is Radix Sort?

👉 A non-comparative sorting algorithm

Instead of comparing numbers directly:

✔ It sorts numbers digit by digit

🔹 Key Idea

👉 Sort based on:

Units place (1s digit)
Tens place
Hundreds place
Thousands place, etc.
🔹 Important Requirement

👉 Radix Sort works correctly only if the sorting of digits is:

✔ Stable (relative order of equal elements is preserved)

🔹 Example Step-by-Step

Array:

[323, 2, 3, 123, 45, 6, 788]
Step 1: Sort by Units (1s digit)
[2, 3, 123, 323, 45, 6, 788]
Step 2: Sort by Tens digit
[2, 3, 6, 123, 323, 45, 788]
Step 3: Sort by Hundreds digit
[2, 3, 6, 45, 123, 323, 788]
🔹 Core Mechanism

👉 Radix Sort uses:

A stable sorting algorithm at each digit level
Typically Counting Sort
🔹 Important Formula

Digit extraction:

digit = (number / exp) % radix

Where:

exp = 1, 10, 100, 1000...
radix = base (usually 10)
💡 3. Solution Approach
🔹 Steps
Find minimum and maximum
Start from least significant digit (exp = 1)
For each digit:
Perform Counting Sort
Move to next digit (exp *= radix)
Stop when all digits are processed
🔹 Key Insight

👉 Radix Sort = Repeated stable sorting on digits

🔹 Time Complexity
Case	Complexity
Time	O(d × (n + b))
Space	O(n + b)

Where:

d = number of digits
n = number of elements
b = radix (base, usually 10)
💻 4. Implementation
✅ Radix Sort Code (Java)
public class RadixSort {

    public static void sort(int[] arr, int radix) {

        int max = getMax(arr);

        // exp = 1, 10, 100, ...
        for (int exp = 1; max / exp > 0; exp *= radix) {
            countingSortByDigit(arr, radix, exp);
        }
    }

    private static void countingSortByDigit(int[] arr, int radix, int exp) {

        int n = arr.length;
        int[] output = new int[n];
        int[] count = new int[radix];

        // Count occurrences
        for (int i = 0; i < n; i++) {
            int digit = (arr[i] / exp) % radix;
            count[digit]++;
        }

        // Prefix sum (cumulative count)
        for (int i = 1; i < radix; i++) {
            count[i] += count[i - 1];
        }

        // Build output array (stable sort)
        for (int i = n - 1; i >= 0; i--) {
            int digit = (arr[i] / exp) % radix;
            output[--count[digit]] = arr[i];
        }

        // Copy back to original array
        System.arraycopy(output, 0, arr, 0, n);
    }

    private static int getMax(int[] arr) {
        int max = arr[0];
        for (int num : arr) {
            if (num > max) max = num;
        }
        return max;
    }

    public static void main(String[] args) {

        int[] arr = {323, 2, 3, 123, 45, 6, 788};

        sort(arr, 10);

        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
⚡ 5. Time & Space Complexity
Case	Complexity
Time	O(d × (n + b))
Space	O(n + b)
🔍 6. Intuition (Very Important)

👉 Think like this:

Instead of comparing numbers directly
Break numbers into digits
Sort each digit from right to left
Combine results step by step
🚀 7. Key Interview Points

✔ Radix Sort is non-comparative
✔ Uses Counting Sort internally
✔ Requires stable sorting
✔ Works best for:

integers
fixed-length keys

✔ Faster than comparison sorts in some cases

🧾 Final Summary
Question: Sort array using Radix Sort
Core idea:
Sort by digits (LSD → MSD)
Approach:
Apply stable sorting per digit
Time complexity: O(d(n + b))
Space complexity: O(n + b)

If you want next, I can:

✅ Compare Radix Sort vs Counting Sort vs Bucket Sort
✅ Show step-by-step visual dry run (digit by digit)
✅ Give tricky interview questions on Radix Sort
✅ Explain LSD vs MSD Radix Sort
     */
    public static void main(String[] args) {

        // initialize an array integers        
        int[] integers = {323, 2, 33, 123, 45, 6, 788};

        System.out.println("\n\nSort via Radi sort:");
        System.out.println("-----------------------");

        RadixSort.sort(integers, 10);
        System.out.println("Sorted: " + Arrays.toString(integers));
    }
}
