package Chapter12.ShortestSafeRoute.src.main.java.coding.challenge11;
 
public class Main {
/*
Let’s break this down clearly and in the same structured way for all three challenges you asked about:

✅ 1. Reverse String Using Stack
🔹 What is the question?

You are given a string. You must reverse it using a stack (LIFO data structure), instead of using built-in reverse functions.

🔹 Analysis
A stack follows Last-In-First-Out (LIFO).
When you push all characters of a string into a stack:
The last character comes out first when popping.
So popping all characters gives the reversed string.
🔹 Solution Approach
Push all characters into a stack.
Pop all characters one by one.
Build the reversed string from popped elements.
🔹 Implementation (Java)
import java.util.Stack;

public class ReverseStringUsingStack {
    public static String reverse(String str) {
        Stack<Character> stack = new Stack<>();

        // Push all characters
        for (char c : str.toCharArray()) {
            stack.push(c);
        }

        // Pop and build result
        char[] result = new char[str.length()];
        for (int i = 0; i < str.length(); i++) {
            result[i] = stack.pop();
        }

        return new String(result);
    }

    public static void main(String[] args) {
        System.out.println(reverse("hello")); // olleh
    }
}
✅ 2. Smallest Number After Removing K Digits
🔹 What is the question?

Given:

A number (as a string)
An integer k

👉 Remove k digits to get the smallest possible number.

🔹 Analysis
We want the smallest number → keep smaller digits in front
If a bigger digit appears before a smaller digit → remove the bigger one
Use a monotonic increasing stack
🔹 Key Idea
Traverse digits from left to right
Maintain stack in increasing order
Remove larger previous digits when a smaller digit appears
🔹 Solution Approach
Loop through digits:
While:
stack not empty
k > 0
top > current digit
→ pop stack
Push current digit
After traversal:
If k still > 0 → remove from end
Remove leading zeros (important in real implementation)
🔹 Implementation (Java)
import java.util.Stack;

public class SmallestNumber {
    public static String smallestAfterRemove(String num, int k) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < num.length(); i++) {
            char current = num.charAt(i);

            while (!stack.isEmpty() && k > 0 && stack.peek() > current) {
                stack.pop();
                k--;
            }

            stack.push(current);
        }

        // If k still remains
        while (k > 0 && !stack.isEmpty()) {
            stack.pop();
            k--;
        }

        // Build result
        StringBuilder result = new StringBuilder();
        for (char c : stack) {
            result.append(c);
        }

        // Remove leading zeros
        while (result.length() > 0 && result.charAt(0) == '0') {
            result.deleteCharAt(0);
        }

        return result.length() == 0 ? "0" : result.toString();
    }

    public static void main(String[] args) {
        System.out.println(smallestAfterRemove("4514327", 4)); // 127
    }
}
✅ 3. Path Between Two Nodes in Directed Graph
🔹 What is the question?

Given a directed graph, determine if there exists a path from node A → B.

🔹 Analysis
This is a graph traversal problem
We need to check if we can reach destination node
Two common approaches:
BFS (Breadth-First Search)
DFS (Depth-First Search)

👉 BFS is used in your example.

🔹 Key Idea
Start from from node
Explore all reachable nodes
If we reach to → return true
If traversal ends → return false
🔹 Solution Approach (BFS)
Use a queue
Use a visited set to avoid cycles
Start from source node
Traverse neighbors
Stop when destination is found
🔹 Implementation (Java)
import java.util.*;

public class DirectedGraphPath {
    private Map<Integer, List<Integer>> adjacencyList = new HashMap<>();

    public void addEdge(int from, int to) {
        adjacencyList.computeIfAbsent(from, k -> new ArrayList<>()).add(to);
    }

    public boolean isPath(int from, int to) {
        Queue<Integer> queue = new ArrayDeque<>();
        Set<Integer> visited = new HashSet<>();

        queue.add(from);
        visited.add(from);

        while (!queue.isEmpty()) {
            int node = queue.poll();

            List<Integer> neighbors = adjacencyList.get(node);
            if (neighbors != null) {
                for (int next : neighbors) {
                    if (!visited.contains(next)) {
                        if (next == to) {
                            return true;
                        }
                        visited.add(next);
                        queue.add(next);
                    }
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        DirectedGraphPath graph = new DirectedGraphPath();

        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);

        System.out.println(graph.isPath(1, 4)); // true
        System.out.println(graph.isPath(4, 1)); // false
    }
}
🎯 Summary
Problem	Core Idea	Data Structure
Reverse String	LIFO order reverses characters	Stack
Smallest Number	Remove larger digits greedily	Monotonic Stack
Path in Graph	Traverse nodes until destination	BFS / DFS

If you want next level understanding, I can:

Show dry run step-by-step
Give interview tricks & patterns
Provide similar Google/Amazon questions
 */
    public static void main(String[] args) {

        int[][] board
                = {
                    {0, 1, 1, 1, 0, 1, 1, 1, 1, 1},
                    {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                    {1, 1, 0, 1, 1, 1, 1, 1, 1, 1},
                    {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                    {1, 1, 1, 1, 1, 0, 1, 1, 0, 1},
                    {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                    {1, 0, 1, 1, 1, 1, 1, 1, 1, 1},
                    {1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                    {1, 1, 1, 1, 1, 0, 1, 1, 1, 1},
                    {1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
                };

        int dist = Sensors.shortestPath(board);

        if (dist != -1) {
            System.out.print("\n\nThe shortest safe path has length of " + dist);
        } else {
            System.out.print("\n\nNo route is safe to reach the destination");
        }
    }
}
