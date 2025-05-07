package Graphs;

import java.util.HashSet;

public class Large_Island {
    public static void main(String[] args) {
        int[][] grid = {
                {1, 1},
                {1, 1}
        };

        // Create an instance and call the function
        Large_Island li = new Large_Island();
        int result = li.largestIsland(grid);

        // Print the result
        System.out.println("Largest possible island size: " + result);
    }

    private static boolean isValid(int n, int c, int s) {
        return ((n >= 0) && (n < s) && (c >= 0) && (c < s));
    }

    public int largestIsland(int[][] grid) {
         int n = grid.length;
         DisjointSet set = new DisjointSet(n * n);
         for (int row = 0; row < n; row++) {
             for (int col = 0; col < n; col++) {
                 if (grid[row][col] == 0) {
                     continue;
                 }
                 int[] dr = {-1, 0, 1, 0};
                 int[] dc = {0, -1, 0, 1};
                 for (int i = 0; i < 4; i ++) {
                     int newRow = row + dr[i];
                     int newCol = col + dc[i];
                     if (isValid(newRow, newCol, n) && grid[newRow][newCol] == 1) {
                         int node = row * n + col;
                         int adjNode = newRow * n + newCol;
                         set.unionBySize(node, adjNode);
                     }
                 }
             }
         }
         int max = 0;
         for (int row = 0; row < n; row++) {
             for (int col = 0; col < n; col++) {
                 if (grid[row][col] == 1) {
                     continue;
                 }
                 int[] dr = {-1, 0, 1, 0};
                 int[] dc = {0, -1, 0, 1};
                 HashSet<Integer> s = new HashSet<>();
                 for (int i = 0; i < 4; i ++) {
                     int newRow = row + dr[i];
                     int newCol = col + dc[i];
                     if (isValid(newRow, newCol, n)) {
                         if (grid[newRow][newCol] == 1) {
                             s.add(set.findParent(newRow * n + newCol));
                         }
                     }
                 }
                 int tot = 0;
                 for (Integer i : s) {
                     tot = tot + set.size.get(i);
                 }
                 max = Math.max(max, tot + 1);
             }
         }
        for (int c = 0; c < n * n; c ++) {
            max = Math.max(max, set.size.get(set.findParent(c)));
        }
        return max;
    }
}
