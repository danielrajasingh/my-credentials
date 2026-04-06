package Chapter14.UnknownSizeList.src.main.java.coding.challenge03;

public class Main {
/*
Let’s go step by step: Question → Analysis → Solution → Implementation

✅ 1. What is the Question?

You are given:

👉 A sorted list of unknown size
👉 You cannot access its size directly
👉 You can only access elements using:

peekAt(index)
🔹 Important Behavior of peekAt
Returns element at index → if valid
Returns -1 → if index is out of bounds
🔹 Task

👉 Find the index of a given element p

🔹 Example
List: [2, 5, 8, 10, 15, 20, 30]
Target: 10

Output: 3
🧠 2. Clear Analysis of the Problem
🔹 Why this is tricky?
We don’t know the size
Binary search needs:
left
right

👉 But we don’t know right!

🔹 Key Insight

👉 Even though size is unknown:

The list is sorted
We can still access elements randomly (O(1))
🔹 Strategy Overview

We solve this in 2 phases:

🔹 Phase 1: Find a Search Boundary (Exponential Search)

Instead of checking:

0, 1, 2, 3, 4, 5...

👉 We check:

1, 2, 4, 8, 16...
Why?
Quickly jump beyond the target
Reduce time complexity to O(log n)
🔹 Phase 2: Binary Search

Once we find a range:

[previousIndex, currentIndex]

👉 Apply binary search in this range

💡 3. Solution Approach
Step-by-step:
🔹 Step 1: Find range
Start with index = 1
Double index until:
peekAt(index) == -1 OR
peekAt(index) >= target
🔹 Step 2: Apply Binary Search

Search between:

left = index / 2
right = index
💻 4. Implementation (Java)
public class UnknownSizeSearch {

    public static int search(SizelessList sl, int element) {

        int index = 1;

        // Step 1: Exponential search to find bounds
        while (sl.peekAt(index) != -1 && sl.peekAt(index) < element) {
            index *= 2;
        }

        // Step 2: Binary search in the found range
        return binarySearch(sl, element, index / 2, index);
    }

    private static int binarySearch(SizelessList sl, int element, int left, int right) {

        while (left <= right) {

            int mid = (left + right) / 2;
            int value = sl.peekAt(mid);

            if (value == -1 || value > element) {
                right = mid - 1;
            }
            else if (value < element) {
                left = mid + 1;
            }
            else {
                return mid; // found
            }
        }

        return -1; // not found
    }
}
🔍 5. Intuition (Very Important)

👉 Think of it as:

First find where the element could be
Then search inside that region
🔹 Why exponential search?

Because:

We don’t know size
Doubling gives:
Fast boundary detection
O(log n) complexity
⚡ 6. Time Complexity
Phase	Complexity
Exponential search	O(log n)
Binary search	O(log n)
Total	O(log n)
🚀 7. Key Interview Points

✔ This is a modified binary search problem
✔ Uses exponential search to find bounds
✔ Handles unknown size gracefully
✔ Time complexity remains O(log n)

🚀 Final Summary
Question: Search in a sorted list with unknown size
Challenge: No size() method
Solution:
Exponential search → find bounds
Binary search → find index
Time Complexity: O(log n)

If you want next, I can:
✅ Draw a step-by-step visual trace
✅ Give tricky variations (like infinite array)
✅ Compare with standard binary search
✅ Provide interview-level edge cases
 */
    public static void main(String[] args) {

        int[] slArr = {-2, 3, 12, 14, 16, 22, 23, 27};
        SizelessList sl = new SizelessList(slArr);               
        
        System.out.println("Search 2: " + UnknownSizeList.search(sl, 3));
        System.out.println("Search 23: " +UnknownSizeList.search(sl, 23));
        System.out.println("Search 1: " +UnknownSizeList.search(sl, 1));
    }
}
