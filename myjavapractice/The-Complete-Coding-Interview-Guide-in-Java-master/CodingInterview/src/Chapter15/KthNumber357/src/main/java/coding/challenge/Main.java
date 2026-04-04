package Chapter15.KthNumber357.src.main.java.coding.challenge;
import java.util.*;
public class Main {
/*
Great—this is a classic interview problem (similar to Ugly Numbers). Let’s break it down clearly 👇

🧩 1. Problem Statement (What is the question?)

You are given an integer k.

👉 Find the k-th number such that:

Its only prime factors are 3, 5, and 7
The sequence starts from 1
📌 Example Sequence
1, 3, 5, 7, 9, 15, 21, 25, 27, 35, ...

👉 Example:

k = 1 → 1
k = 2 → 3
k = 7 → 21
🧠 2. Clear Analysis
🔍 Key Insight

Every number in the sequence can be written as:

3^a × 5^b × 7^c
❌ Brute Force (Not Recommended)
Check every number and verify prime factors
Very slow → O(n log n) or worse
💡 Efficient Idea

We build the sequence in order using previously computed values.

👉 Similar to merging 3 sorted lists:

Multiply existing numbers by:
3
5
7
🧠 Core Idea

Start with:

1

Generate:

1×3 = 3
1×5 = 5
1×7 = 7

Then:

3×3 = 9
3×5 = 15
3×7 = 21
...
⚙️ 3. Solution Approach
✅ Approach 1: Dynamic Programming (Best)

Use:

A list to store results
3 pointers:
for multiples of 3
for multiples of 5
for multiples of 7
Steps:
Start with list = [1]
Maintain 3 indices:
i3, i5, i7
At each step:

Compute:

next = min(
    list[i3] * 3,
    list[i5] * 5,
    list[i7] * 7
)
Add next to list
Move corresponding pointer(s)
⚠️ Important

Avoid duplicates like:

3×5 = 15
5×3 = 15

👉 Move all matching pointers
 */
    public static void main(String[] args) {

        // sample of the array:
        // 1, 3, 5, 7, 3 * 3, 3 * 5, 3 * 7, 5 * 5, 3 * 3 * 3, 5 * 7, 3 * 3 * 5, 7 * 7 ...
        int result1 = Numbers.kth1(7);
        int result2 = Numbers.kth2(7);

        System.out.println("Result: " + result1 + "  |  " + result2);

    // ✅ Approach 1: Optimal (Recommended)
        System.out.println(findKth(7)); // Output: 21

        // Approach 2: Queue-Based (Your Given Logic)
        System.out.println(findKth1(7)); // Output: 21
    }



    public static int findKth(int k) {

        if (k <= 0) return 0;

        List<Integer> list = new ArrayList<>();
        list.add(1);

        int i3 = 0, i5 = 0, i7 = 0;

        while (list.size() < k) {

            int next3 = list.get(i3) * 3;
            int next5 = list.get(i5) * 5;
            int next7 = list.get(i7) * 7;

            int next = Math.min(next3, Math.min(next5, next7));

            list.add(next);

            if (next == next3) i3++;
            if (next == next5) i5++;
            if (next == next7) i7++;
        }

        return list.get(k - 1);
    }


    public static int findKth1(int k) {

        if (k <= 0) return 0;

        int min = 1;

        Queue<Integer> q3 = new ArrayDeque<>();
        Queue<Integer> q5 = new ArrayDeque<>();
        Queue<Integer> q7 = new ArrayDeque<>();

        for (int i = 1; i < k; i++) {

            q3.add(min * 3);
            q5.add(min * 5);
            q7.add(min * 7);

            min = Math.min(q3.peek(), Math.min(q5.peek(), q7.peek()));

            if (min == q3.peek()) q3.poll();
            if (min == q5.peek()) q5.poll();
            if (min == q7.peek()) q7.poll();
        }

        return min;
    }
}
