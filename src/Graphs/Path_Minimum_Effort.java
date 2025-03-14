package Graphs;

import java.util.PriorityQueue;

public class Path_Minimum_Effort {
    public static void main(String[] args) {
        int[][] heights = {
                {1, 2, 3},
                {3, 8, 4},
                {5, 3, 5}
        };

        Path_Minimum_Effort solver = new Path_Minimum_Effort();
        int result = solver.minimumEffortPath(heights);
        System.out.println("Minimum Effort Path: " + result);
    }

    public int minimumEffortPath(int[][] height) {
        int n = height.length;
        int m = height[0].length;
        PriorityQueue<Data> pq = new PriorityQueue<>((x,y) -> x.diff - y.diff);
        int[][] dist = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
        dist[0][0] = 0;
        pq.add(new Data(0, 0, 0));
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};
        while (!pq.isEmpty()) {
            Data data = pq.poll();
            int diff = data.diff;
            int row = data.row;
            int col = data.col;
            if (row == n - 1 && col == m - 1) {
                return diff;
            }
            for (int i = 0; i < 4; i++) {
                int newRow = row + dr[i];
                int newCol = col + dc[i];
                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m) {
                    int newEff = Math.max(diff, Math.abs(height[row][col] - height[newRow][newCol]));
                    if (newEff < dist[newRow][newCol]) {
                        dist[newRow][newCol] = newEff;
                        pq.add(new Data(newEff, newRow, newCol));
                    }
                }
            }
        }
        return -1;
    }
}

class Data {
    int diff, row, col;
    public Data(int diff, int row, int col) {
        this.diff = diff;
        this.row = row;
        this.col = col;
    }
}
