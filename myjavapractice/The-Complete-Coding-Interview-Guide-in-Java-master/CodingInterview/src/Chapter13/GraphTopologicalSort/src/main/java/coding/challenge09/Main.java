package Chapter13.GraphTopologicalSort.src.main.java.coding.challenge09;
 
import java.util.Stack;

public class Main {
/*
Here’s a clear breakdown of Coding Challenge 9 – Topological Sort (DAG).

✅ What is the Question?

You are given a:

👉 Directed Acyclic Graph (DAG)

Your task is to:

👉 Return a linear ordering of vertices such that:

For every directed edge X → Y
X appears before Y in the ordering
❗ Important Constraints
The graph must be a DAG (no cycles)
A valid topological order is not unique
Multiple correct answers are possible
✅ What is Topological Sort?

It is an ordering of nodes such that:

👉 Dependencies come first

Example:

A → B → C

Valid orders:

A, B, C
A, C, B (NOT valid if A → C doesn’t exist)
✅ Analysis
🔹 Key Idea

Topological sort is based on:

👉 DFS (Depth First Search) + Stack

🔹 Why DFS?

Because:

We need to ensure:
👉 A node is processed only after all its dependencies
🔹 Core Logic
Visit a node
Recursively visit all its neighbors
After processing neighbors:
👉 Push node into a stack
🔹 Why Stack?

Because:

Nodes are pushed after their dependencies
When we pop:
👉 We get the correct order
🔹 Important Rule

👉 Post-order DFS

Process children first
Then process parent
🔹 Algorithm Steps
Create:
visited set
stack
For each unvisited node:
Run DFS
In DFS:
Mark node visited
Visit all neighbors
Push node into stack
Return stack (or reverse it)
🔹 Time & Space Complexity
Time: O(V + E)
(V = vertices, E = edges)
Space: O(V)
✅ Solution (Concept)
Use DFS traversal
Push nodes to stack after visiting children
Reverse stack to get order
✅ Implementation (Java)
public class TopologicalSort {

    private Map<Integer, List<Integer>> graph = new HashMap<>();

    public List<Integer> topologicalSort(int start, int totalNodes) {

        Set<Integer> visited = new HashSet<>();
        Stack<Integer> stack = new Stack<>();

        // Run DFS for all nodes (important for disconnected graphs)
        for (int i = 0; i < totalNodes; i++) {
            if (!visited.contains(i)) {
                dfs(i, visited, stack);
            }
        }

        // Convert stack to list
        List<Integer> result = new ArrayList<>();
        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }

        return result;
    }

    private void dfs(int node, Set<Integer> visited, Stack<Integer> stack) {
        visited.add(node);

        if (graph.containsKey(node)) {
            for (int neighbor : graph.get(node)) {
                if (!visited.contains(neighbor)) {
                    dfs(neighbor, visited, stack);
                }
            }
        }

        // Push after visiting all neighbors
        stack.push(node);
    }
}
✅ Key Takeaways
Works only for DAGs
Use DFS + Stack
Add node to stack after exploring neighbors
Final result = reverse of DFS finishing order
✅ Simple Intuition

“Process all dependencies first, then add the node.”

✅ Alternative Approach (Very Important)

👉 Kahn’s Algorithm (BFS-based)

Uses in-degree (incoming edges)
Starts with nodes having 0 in-degree
Removes nodes level by level

👉 This is also commonly asked in interviews.

If you want next, I can:

Explain Kahn’s Algorithm with code
Give a step-by-step dry run
Provide interview variations (very common!) 🚀
 */
    public static void main(String[] args) {

        Graph<String> graph = new Graph();

        graph.addEdge("D", "B");
        graph.addEdge("D", "A");
        graph.addEdge("B", "A");
        graph.addEdge("B", "C");
        graph.addEdge("B", "F");
        graph.addEdge("B", "E");
        graph.addEdge("E", "G");
        graph.addEdge("G", "H");
        graph.addEdge("A", "C");
        graph.addEdge("C", "F");
        graph.addEdge("F", "G");        
        
        Stack<String> ts = graph.topologicalSort("D");

        while (ts.empty() == false) {
            System.out.print(ts.pop() + " ");
        }
    }
}
