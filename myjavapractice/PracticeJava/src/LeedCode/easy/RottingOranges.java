package easy;
import java.util.*;
public class RottingOranges {
    public static int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>(); int fresh = 0;
        for (int i = 0; i < grid.length; i++) for (int j = 0; j < grid[0].length; j++) {
            if (grid[i][j] == 2) q.offer(new int[]{i, j}); else if (grid[i][j] == 1) fresh++;
        }
        int time = 0;
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while (!q.isEmpty() && fresh > 0) {
            int size = q.size(); time++;
            for (int i = 0; i < size; i++) {
                int[] pos = q.poll();
                for (int[] d : dirs) {
                    int nx = pos[0] + d[0], ny = pos[1] + d[1];
                    if (nx >= 0 && nx < grid.length && ny >= 0 && ny < grid[0].length && grid[nx][ny] == 1) {
                        grid[nx][ny] = 2; q.offer(new int[]{nx, ny}); fresh--;
                    }
                }
            }
        }
        return fresh == 0 ? time : -1;
    }
    public static void main(String[] args) { System.out.println("Rotting: " + orangesRotting(new int[][]{{2,1,1},{1,1,0},{0,1,1}})); }
}
