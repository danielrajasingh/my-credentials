package Chapter13.BinaryTreeLandingReservation.src.main.java.coding.challenge05;
 
import java.time.LocalTime;

public class Main {
/*
Let’s break this down step-by-step so you clearly understand the problem, the idea, and the solution.

🟡 1. What is the question?

You are given:

A single runway airport
Multiple landing requests

Each request contains:

Landing time (e.g., 9:50)
Duration (e.g., 6 minutes)

👉 Your task:

Accept a landing request only if it does NOT overlap with existing ones
Reject it if it overlaps any existing reservation
Use a Binary Search Tree (BST) to manage the requests
🟡 2. What is an “overlap”?

A request overlaps if:

Its landing time interval intersects with another request

Example:
Request A: 9:50 → 9:56 (6 mins)
Request B: 9:55 → 10:00

👉 These overlap between 9:55 and 9:56 ❌

🟡 3. Key Idea of the Problem

Each landing request is like an interval:

[start time, end time]

Where:

end time = start time + duration
🟡 4. Why use a BST?

We store requests in a BST ordered by landing time.

BST property:
Left subtree → earlier times
Right subtree → later times

👉 This helps us:

Search for conflicts in O(h) instead of scanning all requests
🟡 5. How to check overlap?

For a new request:

It overlaps with an existing request if:
(start1 < end2) AND (end1 > start2)
In terms of time logic:
Existing: [current.element, current.element + current.time]
New: [element, element + time]

Check:

existing_end > new_start  AND  new_end > existing_start

If true → ❌ overlap → reject

🟡 6. Algorithm
Start at root
Compare new request with current node:
If overlap → ❌ reject
If no overlap:
If new time < current time → go left
Else → go right
Repeat until inserted or rejected
🟡 7. Solution (Code Implementation)
import java.time.Duration;
import java.time.LocalTime;

public class LandingReservationBST {

    private Node root;

    private class Node {
        LocalTime start;
        int duration;
        Node left, right;

        Node(LocalTime start, int duration) {
            this.start = start;
            this.duration = duration;
        }
    }

    public boolean insert(LocalTime start, int duration) {
        if (root == null) {
            root = new Node(start, duration);
            return true;
        }
        return insert(root, start, duration);
    }

    private boolean insert(Node current, LocalTime start, int duration) {

        LocalTime currentEnd = current.start.plusMinutes(current.duration);
        LocalTime newEnd = start.plusMinutes(duration);

        // Check overlap
        if (!currentEnd.isBefore(start) && !newEnd.isBefore(current.start)) {
            System.out.println("❌ Cannot reserve runway at " + start);
            return false;
        }

        // Go left
        if (start.isBefore(current.start)) {
            if (current.left == null) {
                current.left = new Node(start, duration);
                return true;
            }
            return insert(current.left, start, duration);
        }
        // Go right
        else {
            if (current.right == null) {
                current.right = new Node(start, duration);
                return true;
            }
            return insert(current.right, start, duration);
        }
    }
}
🟡 8. Complexity Analysis
⏱ Time Complexity:
O(h) per insertion
h = height of BST
🧠 Space Complexity:
O(h) (recursion stack)
🟡 9. Key Takeaways
✈️ This is an interval scheduling problem
🌳 BST is used to:
Keep requests sorted by time
Quickly find conflicts
❌ Overlap detection is the most important part
✅ In-order traversal gives you sorted timeline
🟡 10. Interview Tip

This problem tests:

BST knowledge
Interval overlap logic
Time comparison reasoning
Real-world modeling skills

If you want next, I can:

Show step-by-step insertion example
Convert this to array / interval tree solution
Give LeetCode-style variations
Provide dry run with real times (very important for interviews)
 */
    public static void main(String[] args) {

        BinarySearchTree<LocalTime> bst = new BinarySearchTree<>();

        bst.insert(LocalTime.of(10, 10), 3);
        bst.insert(LocalTime.of(10, 14), 3);
        bst.insert(LocalTime.of(9, 55), 2);
        bst.insert(LocalTime.of(10, 18), 1);
        bst.insert(LocalTime.of(9, 58), 5);        
        bst.insert(LocalTime.of(9, 47), 2);        
        bst.insert(LocalTime.of(9, 41), 2);        
        bst.insert(LocalTime.of(10, 22), 1);
        bst.insert(LocalTime.of(9, 50), 6); // cannot do reservation
        bst.insert(LocalTime.of(10, 4), 4);         
        
        System.out.println("\nThe landing schedule is:");
        bst.printInOrder();
    }
}
