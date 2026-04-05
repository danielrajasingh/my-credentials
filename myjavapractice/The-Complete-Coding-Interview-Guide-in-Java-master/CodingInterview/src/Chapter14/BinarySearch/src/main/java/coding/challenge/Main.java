package Chapter14.BinarySearch.src.main.java.coding.challenge;

public class Main {

    public static void main(String[] args) {
/*
You’ve shared text from a book, but there is no actual question asked in it. So let’s structure what you should understand and what interviewers typically expect from this content.

✅ 1. What is the Question Here?

There is no direct question in your text.

However, based on the topic, the implied interview question is usually:

“Explain Binary Search and implement it (iterative or recursive). What is its time and space complexity?”

Sometimes also:

“Search an element in a sorted array efficiently.”

✅ 2. Clear Analysis
🔍 Key Idea

Binary Search works only on a sorted array and uses divide and conquer.

⚙️ How it works:
Start with two pointers:
left = 0
right = n - 1
Find middle:
mid = (left + right) / 2
Compare:
If arr[mid] == target → return index
If target < arr[mid] → search left half
If target > arr[mid] → search right half
Repeat until:
element is found OR
search space becomes empty
📊 Complexity
Time Complexity:
Best: O(1)
Average/Worst: O(log n)
(because we halve the search space every time)
Space Complexity:
Iterative: O(1)
Recursive: O(log n) (due to recursion stack)
✅ 3. Solution Approach

You need to:

Ensure the array is sorted
Apply binary search logic
Return index if found, otherwise return -1
✅ 4. Solution Implementation
✅ Iterative Binary Search (Most common in interviews)
public class BinarySearchExample {

    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (target < arr[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1; // not found
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 5, 7, 10, 16, 17, 18, 20};
        int target = 17;

        int result = binarySearch(arr, target);

        System.out.println("Index: " + result);
    }
}
✅ Recursive Binary Search
public class BinarySearchRecursive {

    public static int binarySearch(int[] arr, int left, int right, int target) {
        if (left > right) {
            return -1;
        }

        int mid = left + (right - left) / 2;

        if (arr[mid] == target) {
            return mid;
        }

        if (target < arr[mid]) {
            return binarySearch(arr, left, mid - 1, target);
        }

        return binarySearch(arr, mid + 1, right, target);
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 5, 7, 10, 16, 17, 18, 20};
        int target = 17;

        int result = binarySearch(arr, 0, arr.length - 1, target);

        System.out.println("Index: " + result);
    }
}
✅ 5. Interview Tips
Always mention:
“Array must be sorted”
“Time complexity is O(log n)”
Use:
left + (right - left) / 2 (to avoid overflow)
Be ready for:
First/last occurrence problems
Search in rotated sorted array
Infinite array search
Binary search on answer
🔥 Quick Summary
Binary Search = Divide & Conquer
Works only on sorted arrays
Cuts search space in half every step
Very efficient: O(log n)

If you want, I can next:
✅ Give interview trick questions on Binary Search
✅ Show visual step-by-step dry run
✅ Explain Binary Search variations (very important for Google/Amazon)
 */
        // initialize an array integers        
        int[] integers = {1, 4, 5, 7, 10, 16, 17, 18, 20, 23, 24, 25, 26, 30, 31, 33};
        int p = 17;

        int resultIterative = BinarySearch.runIterative(integers, p);
        int resultRecursive = BinarySearch.runRecursive(integers, 0, integers.length - 1, p);

        System.out.println("Iterative approach - found at index: " + resultIterative);
        System.out.println("Recursive approach - found at index: " + resultRecursive);
    }
}
