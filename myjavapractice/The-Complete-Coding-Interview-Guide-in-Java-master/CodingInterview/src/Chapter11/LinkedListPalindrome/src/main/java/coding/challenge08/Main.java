package Chapter11.LinkedListPalindrome.src.main.java.coding.challenge08;
 
public class Main {
/*
Here’s your complete interview-style breakdown for Linked List Palindrome (Fast/Slow + Stack approach) 👇

✅ 1. What is the Question?

👉 Given a singly linked list of integers, determine:

✔ Is it a palindrome or not?

📌 Palindrome meaning:

A list is palindrome if:

Forward traversal == Reverse traversal

Example:

1 → 2 → 3 → 2 → 1   ✅ palindrome
1 → 2 → 3 → 4 → 5   ❌ not palindrome
🔍 2. Clear Analysis
❌ Simple idea (not optimal):
Reverse list → compare
OR use array → compare

👉 But:

Extra space OR modifies list
✅ Best Idea: Fast + Slow + Stack
Key insight:

👉 Slow pointer reaches middle
👉 Fast pointer reaches end

So:

First half stored in stack
Second half compared directly
💡 3. Solution Idea
Step 1: Find middle using 2 pointers
Slow → 1 step
Fast → 2 steps
Step 2: Push first half into stack
Stack stores reverse order automatically
Step 3: Handle odd length
Skip middle element
Step 4: Compare second half with stack
Pop stack and compare node values
⚙️ 4. Solution Implementation
public boolean isPalindrome() {

    Node slow = head;
    Node fast = head;
    Stack<Integer> stack = new Stack<>();

    // Step 1: push first half into stack
    while (fast != null && fast.next != null) {
        stack.push(slow.data);
        slow = slow.next;
        fast = fast.next.next;
    }

    // Step 2: skip middle element (odd length)
    if (fast != null) {
        slow = slow.next;
    }

    // Step 3: compare second half
    while (slow != null) {
        int top = stack.pop();

        if (top != slow.data) {
            return false;
        }

        slow = slow.next;
    }

    return true;
}
🧠 5. One-Line Memory Trick

👉 “Push first half → skip middle → compare second half.”

🧪 6. Dry Run Example
Input:
1 → 2 → 3 → 2 → 1
🔹 Step 1: Fast/Slow movement
Step	Slow	Fast
1	1	2
2	2	4
3	3	null

👉 Middle reached at 3

🔹 Stack build (first half)
Push: 1, 2

Stack = [1, 2]
🔹 Skip middle
slow moves from 3 → 2
🔹 Compare second half
Node	Stack Pop	Match
2	2	✔
1	1	✔
✅ Result:
TRUE (Palindrome)
🎨 7. Mental Visualization
🔹 Step 1: Split list
1 → 2 → 3 → 2 → 1

Left half   | Right half
1 → 2       | 2 → 1
🔹 Step 2: Stack stores left half
Stack:
Top → 2
      1
🔹 Step 3: Compare
Right side: 2 → 1
Stack pop:  2 → 1
🔹 Final match
✔✔✔✔✔
⚡ 8. Key Insight

👉 Why stack works:

Stack reverses order automatically
So first half becomes comparable with second half
🎯 Interview Gold Explanation

Say this:

👉 “I use fast and slow pointers to find the middle of the list. I push the first half into a stack so it is reversed automatically. Then I compare it with the second half. If all values match, the list is a palindrome.”

🚀 Final Summary
Time → O(n)
Space → O(n/2) ≈ O(n)
Technique → Fast/Slow + Stack

If you want next level 🔥
I can show:

🔥
O(1) space solution (reverse second half)
🔥
Recursive palindrome trick
🔥
Why fast/slow always finds middle exactly

Just tell me 👍
 */
    public static void main(String[] args) {

        SinglyLinkedList sll = new SinglyLinkedList();

        sll.insertFirst(11);
        sll.insertFirst(10);
        sll.insertFirst(9);
        sll.insertFirst(8);
        sll.insertFirst(9);
        sll.insertFirst(10);
        sll.insertFirst(11);        

        sll.print();

        boolean result = sll.isPalindrome();

        System.out.println("\nIs it palindrome? " + result);
    }

}
