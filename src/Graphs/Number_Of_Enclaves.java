package Graphs;

public class Number_Of_Enclaves {
    public int numEnclaves(int[][] grid) {
        int mainCount = 0;
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < m; j ++) {
                if (i == 0 || j == 0 || i == (n - 1) || j == (m - 1)){
                    if (grid[i][j] == 1) {
                        dfs (i, j, vis, grid);
                    }
                }
            }
        }
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < m; j ++) {
                if (grid[i][j] == 1 && vis[i][j] == 0) {
                    mainCount ++;
                }
            }
        }
        return mainCount;
    }

    public static void dfs(int row, int col, int[][] vis, int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        // boolean[][] visited = new boolean[n][m];
        vis[row][col] = 1;
        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};
        for (int i = 0; i < 4; i ++) {
            int nrow = row + drow[i];
            int ncol = col + dcol[i];
            if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && vis[nrow][ncol] == 0 && grid[nrow][ncol] == 1) {
                dfs(nrow, ncol, vis, grid);
            }
        }
    }
}
