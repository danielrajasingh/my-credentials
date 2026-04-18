package Chapter11.LinkedListPairwiseSwap.src.main.java.coding.challenge11;
 
public class Main {
        /*
        Here’s your complete breakdown for Swap Adjacent Nodes in Linked List 👇

        ✅ 1. What is the Question?
        👉 Given:
        A singly linked list
        👉 Task:
        Swap every pair of adjacent nodes
        Do NOT swap values, swap actual nodes (links)
        📌 Example:
        Input:  1 → 2 → 3 → 4 → null
        Output: 2 → 1 → 4 → 3 → null
        🔍 2. Clear Analysis
        ❗ Important constraint:
        👉 You must swap nodes, not values
        ❌ Wrong approach:
        swap(node1.data, node2.data)
        👉 Not allowed (interviewer trap)
        🧠 Core Problem:
        When swapping:
        You must carefully change links
        Otherwise, list will break
        🎯 Key Insight:
        👉 Always think in groups of 3 nodes:
        node1 → node2 → node3
        After swap:
        node2 → node1 → node3
        💡 3. Solution Idea
        For each pair:
        Identify:
        node1 (current)
        node2 (next)
        node3 (next.next)
        Swap node1 and node2
        Fix links with previous pair
        Move to next pair
        ⚙️ 4. Solution Implementation (Simplified)
        public void swap() {

            if (head == null || head.next == null) return;

            Node current = head;
            Node prevPair = null;

            while (current != null && current.next != null) {

                Node node1 = current;
                Node node2 = current.next;
                Node node3 = node2.next;

                // Swap node1 and node2
                node2.next = node1;
                node1.next = node3;

                // Fix previous pair connection
                if (prevPair == null) {
                    head = node2;
                } else {
                    prevPair.next = node2;
                }

                // Move prevPair forward
                prevPair = node1;

                // Move to next pair
                current = node3;
            }
        }
        🧠 5. One-Line Memory Trick

        👉 “Swap 2 nodes → fix links → connect previous pair.”

        🧪 6. Dry Run Example
        Input:
        1 → 2 → 3 → 4 → null
        🔹 First pair (1,2):
        Before:
        1 → 2 → 3

        After:
        2 → 1 → 3
        🔹 Second pair (3,4):
        Before:
        3 → 4 → null

        After:
        4 → 3 → null
        🔹 Final connection:
        2 → 1 → 4 → 3 → null
        🎨 7. Mental Visualization
        🔹 Step-by-step blocks:
        [1 → 2]   [3 → 4]
        🔹 Swap each block:
        [2 → 1]   [4 → 3]
        🔹 Connect blocks:
        2 → 1 → 4 → 3
        ⚡ 8. Key Insight

        👉 You are not swapping values
        👉 You are rewiring pointers

        🚨 Common Mistakes

        ❌ Forgetting:

        To connect previous pair
        To update head
        To store node3 before breaking links
        🎯 Interview Gold Explanation

        Say this:

        👉 “I process nodes in pairs, swap their links, and carefully reconnect each swapped pair with the previous one to maintain the list structure.”

        🚀 Final Summary
        Concept	Explanation
        Technique	Pointer manipulation
        Time	O(n)
        Space	O(1)
        Trick	Work in pairs
        🧠 Final Intuition

        👉 Think like:

        Take 2 nodes → flip → attach → move

        If you want next level 🔥
        I can show:

        Swap k nodes at a time
        Recursive version
        Visual pointer animation (step-by-step arrows)

        Just tell me 👍
         */
    public static void main(String[] args) {        

        SinglyLinkedList sll = new SinglyLinkedList();
               
        // sll.insertFirst(11);
        sll.insertFirst(10);
        sll.insertFirst(9);
        sll.insertFirst(8);
        sll.insertFirst(7);
        sll.insertFirst(6);
        sll.insertFirst(5);
        sll.insertFirst(4);
        sll.insertFirst(3);
        sll.insertFirst(2);
        sll.insertFirst(1);

        System.out.println("Linked list before swapping:");
        sll.print();

        sll.swap();
        
        System.out.println("\nLinked list after swapping:");
        sll.print();

    }

}
