package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Shortest_Path_Binary_Matrix {
    public static void main(String[] args) {
        int[][] grid = {
                {0}
        };

        Shortest_Path_Binary_Matrix solver = new Shortest_Path_Binary_Matrix();
        int result = solver.shortestPathBinaryMatrix(grid);
        System.out.println("Shortest path length: " + result);
    }

    public int shortestPathBinaryMatrix(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;
        if (grid[0][0] == 1 || grid[n-1][m-1] == 1) {
            return -1;
        }

        if (n == 1 && m == 1 && grid[0][0] == 0) {
            return 1;
        }

        int[][] dist = new int[n][m];
        Queue<Tuple> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
        dist[0][0] = 1;
        q.add(new Tuple(1, 0, 0));
        int[] dr = {-1, -1, -1, 0, 1, 1, 1, 0};
        int[] dc = {-1, 0, 1, 1, 1, 0, -1, -1};
        while (!q.isEmpty()) {
            Tuple t = q.poll();
            int dis = t.dist;
            int row = t.row;
            int col = t.col;
            for (int i = 0; i < 8; i ++) {
                int newRow = row + dr[i];
                int newCol = col + dc[i];
                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && grid[newRow][newCol] == 0 && dis + 1 < dist[newRow][newCol]) {
                    dist[newRow][newCol] = dis + 1;
                    if (newRow == n - 1 && newCol == m - 1) {
                        return dis + 1;
                    }
                    q.add(new Tuple(dist[newRow][newCol], newRow, newCol));
                }
            }
        }
        return -1;
    }
}

class Tuple {
    int dist, row, col;
    public Tuple(int dist, int row, int col) {
        this.dist = dist;
        this.row = row;
        this.col = col;
    }
}