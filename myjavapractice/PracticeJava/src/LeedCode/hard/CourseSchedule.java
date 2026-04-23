package hard;

import java.util.*;

public class CourseSchedule {
    /* Problem: Course Schedule | Link: https://leetcode.com/problems/course-schedule
    Difficulty: Hard | Topic: Graph, DFS, Topological Sort | Detect cycle in prerequisites.
    APPROACH: DFS color marking - white/gray/black. O(V+E). */

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) graph.add(new ArrayList<>());
        for (int[] p : prerequisites) graph.get(p[1]).add(p[0]);
        
        int[] state = new int[numCourses]; // 0=white, 1=gray, 2=black
        for (int i = 0; i < numCourses; i++) {
            if (state[i] == 0 && !dfs(i, graph, state)) return false;
        }
        return true;
    }

    private static boolean dfs(int node, List<List<Integer>> graph, int[] state) {
        if (state[node] == 1) return false; // cycle
        if (state[node] == 2) return true;
        state[node] = 1;
        for (int next : graph.get(node)) {
            if (!dfs(next, graph, state)) return false;
        }
        state[node] = 2;
        return true;
    }

    public static void main(String[] args) {
        System.out.println("Can finish 2 courses: " + canFinish(2, new int[][]{{1, 0}}));
        System.out.println("Expected: true\n");
    }
}
