package Chapter14.BucketSort.src.main.java.coding.challenge;

import java.util.Arrays;

public class Main {
/*
Let’s go step by step: Question → Analysis → Solution → Implementation

✅ 1. What is the Question?

👉 You are given:

✔ An unsorted array of numbers

👉 Your task:

✔ Sort the array using Bucket Sort

🔹 Example
Input:
[4, 2, 11, 7, 18, 3, 14, 7, 4, 16]

Output:
[2, 3, 4, 4, 7, 7, 11, 14, 16, 18]
🧠 2. Clear Analysis
🔹 What is Bucket Sort?

👉 A sorting algorithm that:

✔ Divides elements into buckets (groups)
✔ Sorts each bucket
✔ Combines results

🔹 Key Idea

👉 Instead of sorting the whole array directly:

Distribute elements into buckets
Sort each bucket
Merge all buckets
🔹 When is Bucket Sort Useful?

✔ When data is:

Uniformly distributed
In a known range
🔹 Two Approaches
✅ 1. Scatter → Sort → Gather
Create buckets based on ranges
Put elements into appropriate buckets
Sort each bucket
Combine results
🚀 2. Scatter → Count → Gather (Counting Style)
Create buckets for each value
Store frequency (count) instead of values
Rebuild sorted array from counts
🔹 Example (Concept)
Array: [4, 2, 8, 7, 8, 2, 2, 7, 4, 9]

Bucket Index → Count
2 → 3 times
4 → 2 times
7 → 2 times
8 → 2 times
9 → 1 time

👉 Then reconstruct:

[2, 2, 2, 4, 4, 7, 7, 8, 8, 9]
🔹 Key Components
Scatter → distribute elements into buckets
Sort → sort each bucket
Gather → combine results
💡 3. Solution Approach
🔹 Approach 1 (General Bucket Sort)
Create buckets (e.g., ranges)
Distribute elements into buckets
Sort each bucket
Merge buckets
🔹 Approach 2 (Counting Bucket Sort - Faster)
Find maximum value
Create bucket array of size max + 1
Count occurrences
Rebuild sorted array
🔹 Complexity
Case	Time
Best	O(n + k)
Average	O(n + k)
Worst	O(n²)
💻 4. Implementation
✅ Approach 1: Bucket with Lists
import java.util.*;

public class BucketSort {

    public static void sort(int[] arr) {

        int max = getMax(arr);

        int bucketCount = 5; // number of buckets
        List<Integer>[] buckets = new List[bucketCount];

        for (int i = 0; i < bucketCount; i++) {
            buckets[i] = new ArrayList<>();
        }

        // Scatter
        for (int num : arr) {
            int bucketIndex = (num * bucketCount) / (max + 1);
            buckets[bucketIndex].add(num);
        }

        // Sort each bucket
        for (List<Integer> bucket : buckets) {
            Collections.sort(bucket);
        }

        // Gather
        int index = 0;
        for (List<Integer> bucket : buckets) {
            for (int num : bucket) {
                arr[index++] = num;
            }
        }
    }

    private static int getMax(int[] arr) {
        int max = arr[0];
        for (int num : arr) {
            if (num > max) max = num;
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {4, 2, 11, 7, 18, 3, 14, 7, 4, 16};

        sort(arr);

        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
🚀 Approach 2: Counting Bucket Sort
public class CountingBucketSort {

    public static void sort(int[] arr) {

        int max = findMax(arr);

        int[] bucket = new int[max + 1];

        // Scatter (count occurrences)
        for (int num : arr) {
            bucket[num]++;
        }

        // Gather (rebuild sorted array)
        int index = 0;
        for (int i = 0; i < bucket.length; i++) {
            while (bucket[i] > 0) {
                arr[index++] = i;
                bucket[i]--;
            }
        }
    }

    private static int findMax(int[] arr) {
        int max = arr[0];
        for (int num : arr) {
            if (num > max) max = num;
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {4, 2, 8, 7, 8, 2, 2, 7, 4, 9};

        sort(arr);

        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
⚡ 5. Time & Space Complexity
Approach	Time	Space
Bucket (lists)	O(n + k)	O(n + k)
Counting	O(n + k)	O(k)
🔍 6. Intuition (Very Important)

👉 Think like this:

Instead of sorting directly
Distribute elements into groups
Sort small groups instead of one big array
🚀 7. Key Interview Points

✔ When to use Bucket Sort
✔ Difference between:

Bucket Sort
Counting Sort

✔ Why it works best for uniform data
✔ Trade-off between space vs speed
✔ Why it is usually not stable

🧾 Final Summary
Question: Sort an array using Bucket Sort
Core idea:
Divide → Distribute → Sort → Combine
Approach:
Bucket with lists OR counting array
Time complexity: O(n + k)
Best use case: Uniformly distributed data

If you want next, I can:

✅ Compare Bucket Sort vs Counting Sort vs Radix Sort
✅ Give step-by-step visual dry run
✅ Provide interview trick questions
✅ Explain when NOT to use bucket sort
 */
    public static void main(String[] args) {

        // initialize an array integers        
        int[] integers = {4, 1, 8, 3, 8, 2, 6, 7, 4, 9};

        System.out.println("\n\nSort via Bucket sort:");
        System.out.println("-------------------------");

        int[] integersC1 = integers.clone();
        int[] integersC2 = integers.clone();
        
        BucketSort.sort1(integersC1);
        BucketSort.sort1(integersC2);
        System.out.println("Sorted C1: " + Arrays.toString(integersC1));
        System.out.println("Sorted C2: " + Arrays.toString(integersC2));
    }
}
