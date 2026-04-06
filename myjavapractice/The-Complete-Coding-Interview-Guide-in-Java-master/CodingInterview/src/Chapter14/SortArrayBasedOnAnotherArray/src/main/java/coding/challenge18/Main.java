package Chapter14.SortArrayBasedOnAnotherArray.src.main.java.coding.challenge18;

import java.util.Arrays;

public class Main {

        /*
                Great—this is a classic “custom sort / relative sort” problem used in interviews. Let’s break it down clearly 👇

                ✅ 1. What is the Question?

                You are given two arrays:

                int[] firstArr  = {4, 1, 8, 1, 3, 8, 6, 7, 4, 9, 8, 2, 5, 3};
                int[] secondArr = {7, 4, 8, 11, 2};

                👉 You must:
                Reorder firstArr so that its elements follow the order defined in secondArr.

                ✔️ Rules
                Elements present in secondArr:
                Should appear first
                In the same order as in secondArr
                With same frequency as in firstArr
                Elements NOT in secondArr:
                Should appear at the end
                In sorted order
                🔍 Expected Output
                {7, 4, 4, 8, 8, 8, 2, 1, 1, 3, 3, 5, 6, 9}

                ✅ 2. Key Idea (Core Insight 🔥)
                👉 Use frequency counting (HashMap / TreeMap)
                Why?
                We need:
                Count occurrences
                Maintain order
                Efficient lookup

                ✅ 3. Algorithm (Step-by-Step)
                🔹 Step 1: Count frequencies
                Store frequency of each element from firstArr:
                4 → 2
                1 → 2
                8 → 3
                ...
                🔹 Step 2: Fill based on secondArr
                For each element in secondArr:
                If present in map:
                Add it frequency times to result
                Remove from map
                🔹 Step 3: Add remaining elements
                These are elements not in secondArr
                Add them in sorted order
                👉 Use TreeMap to keep them sorted automatically

                ✅ 4. Dry Run
                secondArr = {7, 4, 8, 11, 2}

                → Add:
                7 → 1 time
                4 → 2 times
                8 → 3 times
                11 → skip (not present)
                2 → 1 time

                Remaining:
                {1, 3, 5, 6, 9} → sorted
                ✅ 5. Java Implementation
                import java.util.*;

                public class CustomSort {

                    public static void customSort(int[] firstArr, int[] secondArr) {

                        // Step 1: Frequency map (sorted)
                        Map<Integer, Integer> map = new TreeMap<>();

                        for (int num : firstArr) {
                            map.put(num, map.getOrDefault(num, 0) + 1);
                        }

                        int index = 0;

                        // Step 2: Place elements as per secondArr
                        for (int num : secondArr) {
                            if (map.containsKey(num)) {
                                int count = map.get(num);

                                while (count-- > 0) {
                                    firstArr[index++] = num;
                                }

                                map.remove(num);
                            }
                        }

                        // Step 3: Add remaining elements (sorted)
                        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                            int num = entry.getKey();
                            int count = entry.getValue();

                            while (count-- > 0) {
                                firstArr[index++] = num;
                            }
                        }
                    }

                    public static void main(String[] args) {
                        int[] firstArr = {4, 1, 8, 1, 3, 8, 6, 7, 4, 9, 8, 2, 5, 3};
                        int[] secondArr = {7, 4, 8, 11, 2};

                        customSort(firstArr, secondArr);

                        System.out.println(Arrays.toString(firstArr));
                    }
                }
                ✅ 6. Complexity Analysis
                Type	Complexity
                Time	O(m log m + n)
                Space	O(m)

                Where:
                m = size of firstArr
                n = size of secondArr
                ✅ 7. Optimized Alternative (Better Approach 🚀)
                👉 Use:
                HashMap for frequency
                List + Collections.sort() for leftovers

                This can reduce overhead vs TreeMap.

                ✅ 8. Edge Cases 🚨
                Case	Behavior
                Element in secondArr not in firstArr	Ignore
                Duplicate elements	Preserve frequency
                Empty arrays	Handle safely
                All elements missing in secondArr	Just sort
                ✅ 9. Common Interview Mistakes ❌
                ❌ Forgetting duplicates
                ❌ Not removing processed elements from map
                ❌ Sorting entire array (wrong)
                ❌ Ignoring order of secondArr
                ✅ 10. Short Interview Answer (Perfect Summary)

                Count frequencies of the first array,
                place elements according to the order in the second array,
                and append remaining elements in sorted order.
                🚀 Bonus (Follow-up Questions)
                They may ask:
                👉 What if secondArr has duplicates?
                👉 Can you do it in-place without extra space?
                👉 What if arrays are very large?
                👉 Can you use counting sort if range is small?
         */
    public static void main(String[] args) {

        int[] firstArr = {4, 1, 8, 1, 3, 8, 6, 7, 4, 9, 8, 2, 5, 3};
        int[] secondArr = {7, 4, 8, 11, 2};

        System.out.println("Before: " + Arrays.toString(firstArr));
        Sorts.custom(firstArr, secondArr);
        System.out.println("After: " + Arrays.toString(firstArr));
    }
}
