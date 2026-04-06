package Chapter14.InterspersedEmptyStrings.src.main.java.coding.challenge05;
 
public class Main {
/*
Let’s go step by step exactly as you asked: Question → Analysis → Solution → Implementation

✅ 1. What is the Question?

You are given:

👉 A sorted array of strings
👉 But it contains empty strings ("") mixed in

Your task:

👉 Find the index of a given non-empty string

🔹 Important Constraints
Array is sorted
Contains empty strings
You must return the index of the target string
If not found → return -1
🔹 Example
Input:
["cat", "", "", "", "dog", "", "", "fox", ""]

Target: "fox"

Output: 7
🧠 2. Clear Analysis of the Problem
🔹 Why normal Binary Search doesn’t work directly?

Binary search relies on:

Comparing middle element
Deciding left or right

👉 But here:

mid = ""

❌ Problem:
You cannot compare empty string properly

So:

You don’t know whether to go left or right
🔹 Key Insight

👉 We still use Binary Search, but with a twist:

👉 If mid is empty:
Move left and right pointers outward
Find the nearest non-empty string
Then continue binary search normally
🔹 Core Idea
Compute mid
If strings[mid] == "":
Find closest non-empty string (left or right)
Compare with target
Continue Binary Search
🔹 Time Complexity
Worst case: O(n)
(if many empty strings)
Best case: O(log n)
💡 3. Solution Approach
Strategy:
Use Binary Search
If middle is empty:
Expand outward to find non-empty string
Compare:
If match → return index
If smaller → search right
If bigger → search left
💻 4. Implementation (Java)
public class InterspersedSearch {

    public static int search(String[] arr, String target) {
        return search(arr, target, 0, arr.length - 1);
    }

    private static int search(String[] arr, String target, int left, int right) {

        if (left > right) {
            return -1;
        }

        int mid = (left + right) / 2;

        // If mid is empty, find nearest non-empty string
        if (arr[mid].isEmpty()) {

            int leftMid = mid - 1;
            int rightMid = mid + 1;

            while (true) {
                if (leftMid < left && rightMid > right) {
                    return -1; // no non-empty string found
                }

                if (rightMid <= right && !arr[rightMid].isEmpty()) {
                    mid = rightMid;
                    break;
                }

                if (leftMid >= left && !arr[leftMid].isEmpty()) {
                    mid = leftMid;
                    break;
                }

                rightMid++;
                leftMid--;
            }
        }

        // Compare with target
        if (arr[mid].equals(target)) {
            return mid;
        }
        else if (arr[mid].compareTo(target) < 0) {
            return search(arr, target, mid + 1, right);
        }
        else {
            return search(arr, target, left, mid - 1);
        }
    }

    public static void main(String[] args) {
        String[] arr = {"cat", "", "", "", "dog", "", "", "fox", ""};

        System.out.println(search(arr, "fox")); // Output: 7
        System.out.println(search(arr, "dog")); // Output: 4
        System.out.println(search(arr, "bat")); // Output: -1
    }
}
🔍 5. Intuition (Very Important)
Binary search still works
The only challenge is:
👉 Handling empty strings
So we:
Treat empty strings as “skip”
Find nearest valid string
Then continue normally
⚡ 6. Key Interview Points

✔ Always mention:

“This is a modified binary search”
“Empty strings are skipped by searching nearest valid element”
“Worst case becomes O(n)”
🚀 Final Summary
Problem: Search in a sorted array with empty strings
Main challenge: Empty strings break binary search
Solution: Modified binary search
Key trick: Skip empty strings by expanding outward
Time Complexity: O(n) worst case

If you want next, I can:
✅ Draw step-by-step visualization
✅ Show iterative (non-recursive) version
✅ Compare with standard binary search
✅ Give tricky interview variations
 */
    public static void main(String[] args) {

        String[] stringsArr = {"cat", "", "", "house", "", "", "", "", "laptop",
            "pen", "", "", "", "", "rear", "", "tower", "", ""};

        System.out.println("Search 'join':" + Strings.search(stringsArr, "join"));
        System.out.println("Search 'pen':" + Strings.search(stringsArr, "pen"));
        System.out.println("Search 'tower':" + Strings.search(stringsArr, "tower"));
        System.out.println("Search 'cat':" + Strings.search(stringsArr, "cat"));       
        System.out.println("Search 'laptop':" + Strings.search(stringsArr, "laptop"));
        System.out.println("Search '':" + Strings.search(stringsArr, ""));
    }
}
