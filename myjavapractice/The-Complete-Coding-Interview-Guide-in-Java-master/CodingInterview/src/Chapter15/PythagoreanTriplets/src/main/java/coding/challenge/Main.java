package Chapter15.PythagoreanTriplets.src.main.java.coding.challenge;
import java.util.Arrays;
public class Main {
/*
        🧩 1. Problem Statement (What is the question?)

        You are given an array of positive integers.

        👉 Find and print all Pythagorean triplets:

        a² = b² + c²

        👉 Where:

        a, b, c are elements from the array
        All values must exist in the array
        📌 Example
        Input: [3, 6, 8, 5, 10, 4, 12, 14]

        👉 Output:

        (3, 4, 5)
        (6, 8, 10)
        🧠 2. Clear Analysis
        🔍 Brute Force (Not Good)
        Try all combinations of (a, b, c)
        Time: O(n³) ❌
        💡 Optimized Idea

        We use:

        👉 Sorting + Two Pointers

        🧠 Key Transformation

        Instead of:

        a² = b² + c²

        We:

        Square all numbers
        Sort the array

        Now problem becomes:

        a = b + c

        👉 Where a is the largest element

        🎯 Strategy
        Square all elements
        Sort array
        Fix a (largest value)
        Use two pointers:
        b → start (left)
        c → just before a (right)
        🔁 Two Pointer Logic

        For each a:

        If b + c == a → found triplet ✅
        If b + c < a → move b++
        If b + c > a → move c--
        📊 Example Walkthrough
        Original: [3, 4, 5]
        Squared:  [9, 16, 25]

        Check:

        9 + 16 = 25 → ✔️ triplet
        ⚙️ 3. Solution Approach
        Steps:
        Square array
        Sort array
        Loop from largest → smallest
        Apply two-pointer technique

        📊 5. Complexity Analysis
Step	Complexity
Squaring	O(n)
Sorting	O(n log n)
Two-pointer	O(n²)
Total	O(n²)
🎯 6. Interview Key Points
✅ You should say:
“Brute force is O(n³), but I can optimize to O(n²)”
“I use sorting + two pointers”
“Fix largest element and find pair sum”
⚠️ Common Mistakes
Not squaring first ❌
Forgetting to sort ❌
Using 3 loops ❌
Printing wrong values (squared instead of original) ❌
🚀 7. Pro Insight

👉 This problem is similar to:

2-sum problem
3-sum variation

👉 Pattern:

Sort + fix one + two-pointer
🧠 Bonus

If interviewer asks:

👉 “Can you avoid square root?”

You can:

Store original values
Or print squared triplets directly
 */
    public static void main(String[] args) {

        int[] arr = {3, 6, 8, 5, 10, 4, 12, 14};

        Pythagoreans.triplet(arr);




        // ✅ Optimal Solution (O(n²))
        int[] arr1 = {3, 6, 8, 5, 10, 4, 12, 14};

        findTriplets(arr1);
    }




    public static void findTriplets(int[] arr) {

        int n = arr.length;

        // Step 1: Square all elements
        int[] squared = new int[n];
        for (int i = 0; i < n; i++) {
            squared[i] = arr[i] * arr[i];
        }

        // Step 2: Sort
        Arrays.sort(squared);

        // Step 3: Fix 'a'
        for (int i = n - 1; i >= 2; i--) {

            int left = 0;
            int right = i - 1;

            // Step 4: Two pointer search
            while (left < right) {

                if (squared[left] + squared[right] == squared[i]) {

                    // Print original values (sqrt)
                    int a = (int) Math.sqrt(squared[i]);
                    int b = (int) Math.sqrt(squared[left]);
                    int c = (int) Math.sqrt(squared[right]);

                    System.out.println("(" + b + ", " + c + ", " + a + ")");

                    left++;
                    right--;
                }
                else if (squared[left] + squared[right] < squared[i]) {
                    left++;
                }
                else {
                    right--;
                }
            }
        }
    }

}
