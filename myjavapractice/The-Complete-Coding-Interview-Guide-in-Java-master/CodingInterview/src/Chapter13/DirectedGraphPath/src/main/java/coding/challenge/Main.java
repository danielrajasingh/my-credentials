package Chapter13.DirectedGraphPath.src.main.java.coding.challenge;

public class Main {

    public static void main(String[] args) {
/*
Let’s break this down clearly and systematically.

🟡 1. What is the question?

You are given:

A directed graph (nodes + directed edges)

👉 Your task:

Determine whether there exists a path from node from to node to
Return:
true if a path exists
false otherwise
🟡 2. What is a “path”?

A path means:

A sequence of nodes where each step follows a directed edge

Example:
A → B → C → D

This means:

There is a path from A to D
But not necessarily from D to A (direction matters!)
🟡 3. Key Idea

👉 This is a graph traversal problem

We solve it using:

BFS (Breadth-First Search) OR
DFS (Depth-First Search)
Why traversal?

Because:

We explore all reachable nodes starting from from

If we reach to → ✅ return true
If not → ❌ return false

🟡 4. Important Considerations
🔹 Directed Graph
Edges are one-way only
🔹 Avoid infinite loops
Graph may contain cycles

👉 So we must use:

visited set
🟡 5. BFS Approach (Best for this problem)
Algorithm:
Start from from
Use a queue
Mark nodes as visited
While queue is not empty:
Remove node
Explore its neighbors
If neighbor == to → return true
If queue ends → return false
🟡 6. Solution (Code Implementation)
import java.util.*;

public class GraphPath {

    public boolean isPath(Map<String, List<String>> adjacencyList,
                          String from,
                          String to) {

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        // Start from 'from'
        queue.add(from);
        visited.add(from);

        while (!queue.isEmpty()) {
            String current = queue.poll();

            // Get neighbors
            List<String> neighbors = adjacencyList.get(current);

            if (neighbors != null) {
                for (String neighbor : neighbors) {

                    if (neighbor.equals(to)) {
                        return true; // path found
                    }

                    if (!visited.contains(neighbor)) {
                        visited.add(neighbor);
                        queue.add(neighbor);
                    }
                }
            }
        }

        return false; // no path found
    }
}
🟡 7. Complexity Analysis
⏱ Time Complexity:
O(V + E)
V = number of vertices
E = number of edges
🧠 Space Complexity:
O(V)
For visited set and queue
🟡 8. DFS Alternative (Concept)

You can also solve using recursion:

Explore deeply before backtracking
Still requires visited to avoid cycles
🟡 9. Key Insights
🔑 Graph traversal = BFS or DFS
🔑 Use visited set to prevent infinite loops
🔑 Directed graph → follow edges only in one direction
🔑 Stop immediately when to is found
🟡 10. Common Mistakes

❌ Not using visited set → infinite loop
❌ Ignoring direction of edges
❌ Not checking null adjacency list
❌ Traversing entire graph unnecessarily

🟡 11. Interview Tip

This problem tests:

Graph traversal
BFS vs DFS understanding
Cycle handling
Real-world reasoning
🟡 12. Quick Summary

👉 Problem:

Check if a path exists between two nodes

👉 Approach:

BFS / DFS traversal

👉 Key:

If reachable → return true
Else → return false

If you want next, I can:

Show DFS recursive solution
Provide step-by-step traversal example
Give bidirectional BFS (advanced optimization)
Explain real interview variations (very important)
 */
    Graph<String> graph = new Graph();

        // directed graph
        graph.addEdge("A", "C");
        graph.addEdge("C", "B");
        graph.addEdge("C", "E");
        graph.addEdge("B", "E");
        graph.addEdge("D", "A");
        graph.addEdge("D", "B");
       
        boolean isPathAE = graph.isPath("A", "E");
        System.out.println("Is path from A to E: " + isPathAE);
        
        boolean isPathEA = graph.isPath("E", "A");
        System.out.println("Is path from E to A: " + isPathEA);
        
        boolean isPathCD = graph.isPath("C", "D");
        System.out.println("Is path from C to D: " + isPathCD);
        
        boolean isPathDC = graph.isPath("D", "C");
        System.out.println("Is path from D to C: " + isPathDC);
        
        boolean isPathDE = graph.isPath("D", "E");
        System.out.println("Is path from D to E: " + isPathDE);
        
        boolean isPathED = graph.isPath("E", "D");
        System.out.println("Is path from E to D: " + isPathED);
    }
}
