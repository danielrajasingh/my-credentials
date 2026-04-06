package Chapter13.HeapConnectRopes.src.main.java.coding.challenge25;
 
public class Main {
/*
Here’s a clean, interview-ready breakdown of your problem in 4 parts:

🟢 1. What is the Question?

You are given an array of rope lengths.

👉 Task:
Connect all ropes into one single rope.

👉 Rule:

Cost of connecting two ropes = sum of their lengths
You must minimize the total cost
🧠 2. Clear Analysis
🔍 Key Idea

When you connect two ropes:

Their combined length becomes part of future costs
So whatever you create early will be reused again and again
⚠️ Important Insight
If you combine large ropes early → future costs become bigger ❌
If you combine small ropes first → future costs stay small ✅

👉 This is a Greedy Problem

💡 Why Greedy Works?

Because:

Choosing the two smallest ropes at every step minimizes future accumulation of cost.

🧩 Example

Ropes: [1, 3, 4, 6]

✅ Optimal (smallest first)
1 + 3 = 4 → cost = 4
Ropes → [4, 4, 6]
4 + 4 = 8 → cost = 8
Ropes → [6, 8]
6 + 8 = 14 → cost = 14

👉 Total cost = 4 + 8 + 14 = 26

❌ Worst (largest first)
4 + 6 = 10
10 + 3 = 13
13 + 1 = 14

👉 Total cost = 37

🎯 Conclusion

👉 Always combine two smallest ropes first

🚀 3. Solution Approach
🔧 Use: Min Heap (Priority Queue)

Why?

Always gives the smallest element efficiently
Avoids repeated sorting
🪜 Steps
Insert all rope lengths into a Min Heap
While heap has more than 1 rope:
Extract two smallest ropes
Add their sum to total cost
Insert the combined rope back
Return total cost
⏱ Complexity
Building heap: O(n)
Each operation: O(log n)
Total: O(n log n)
💻 4. Java Implementation
import java.util.PriorityQueue;

public class MinimumCostRopes {

    public static int minimumCost(int[] ropes) {
        if (ropes == null || ropes.length == 0) {
            return 0;
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // Step 1: Add all ropes to heap
        for (int rope : ropes) {
            minHeap.add(rope);
        }

        int totalCost = 0;

        // Step 2: Combine ropes
        while (minHeap.size() > 1) {
            int first = minHeap.poll();   // smallest
            int second = minHeap.poll();  // second smallest

            int sum = first + second;

            totalCost += sum;

            // Put back the combined rope
            minHeap.add(sum);
        }

        return totalCost;
    }

    public static void main(String[] args) {
        int[] ropes = {1, 3, 4, 6};
        System.out.println("Minimum Cost = " + minimumCost(ropes));
    }
}
🧾 Final Summary (Interview Ready)
❓ Problem: Connect ropes with minimum total cost
🧠 Strategy: Always connect two smallest ropes first
⚙️ Data Structure: Min Heap
⏱ Time Complexity: O(n log n)
💡 Technique: Greedy Algorithm

If you want next level prep, I can help you with:
✅ Dry run using heap (step-by-step)
✅ How to explain this in interviews (very important)
✅ Variations of this problem (very commonly asked)
✅ Similar greedy + heap problems
 */
    public static void main(String[] args) {

        int[] ropesLength = {1, 4, 6, 3};
        MinHeap heap = new MinHeap();
        
        int result = heap.minimumCost(ropesLength);
                
        System.out.println("Result: " + result);
    }
}
