package Chapter14.PositionOfFirstOne.src.main.java.coding.challenge;
 
public class Main {
/*
            Let’s break this down step by step in a clean interview-style way.

        ✅ 1. What is the question?

        You are given a sorted array containing only:

        0s followed by 1s
        At least one 0 and one 1

        👉 You need to find the index of the first occurrence of 1.

        Example:
        arr = [0, 0, 0, 1, 1, 1]
        Output = 3
        ✅ 2. Clear Analysis
        Key Observations:
        The array is sorted (all 0s come before 1s)
        Once 1 appears, everything after it is also 1
        We are looking for the first 1, not any 1
        Why not simple linear search?
        Linear search → O(n)
        We can do better using Binary Search because the array is sorted
        Binary Search Insight:

        At any mid:

        If arr[mid] == 0
        → First 1 must be on the right side
        If arr[mid] == 1
        → First 1 could be at mid or to the left
        Goal:

        Reduce the search space by half each time → O(log n)

        ✅ 3. Solution Approach
        Binary Search Strategy:

        Initialize:

        left = 0
        right = n - 1
        While left <= right:
        Find mid
        If arr[mid] == 1:
        Store it as a possible answer
        Move left → right = mid - 1
        Else:
        Move right → left = mid + 1
        Return the stored index
        ⚠️ Important Fix in Provided Code

        Your given code has a bug:

        int middle = 1 + (right - left) / 2;

        👉 Correct formula:

        int middle = left + (right - left) / 2;

        Also:

        if (arr[left] == 1)

        This check is unsafe (can go out of bounds).

        ✅ 4. Correct Implementation (Java)
        public static int firstOneIndex(int[] arr) {
            if (arr == null || arr.length == 0) {
                return -1;
            }

            int left = 0;
            int right = arr.length - 1;
            int result = -1;

            while (left <= right) {
                int mid = left + (right - left) / 2;

                if (arr[mid] == 1) {
                    result = mid;      // possible answer
                    right = mid - 1;   // search left side
                } else {
                    left = mid + 1;    // move right
                }
            }

            return result;
        }
        ✅ 5. Complexity
        Approach	Time Complexity	Space Complexity
        Linear Search	O(n)	O(1)
        Binary Search	O(log n)	O(1)
        ✅ 6. Interview Tip

        Whenever you see:

        Sorted array
        Finding a boundary (first/last occurrence)

        👉 Think immediately:

        “Binary Search with modification”

        If you want, I can also show:
        ✅ Visualization of how binary search works here
        ✅ Similar problems (first 1, last 1, first bad version, etc.)
        ✅ Pattern recognition tricks for interviews
 */
    public static void main(String[] args) {

        int[] zerosAndOnes = {0, 0, 1, 1, 1, 1, 1};

        int index = Arrays.firstOneIndex(zerosAndOnes);
        System.out.println("Index: " + index);
    }
}
