package Graphs;

public class FloodFill {
    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int[][] ans = image;
        int initialColor = image[sr][sc];
        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, -1, 0, 1};
        dfs(sr, sc, ans, image, initialColor, drow, dcol, newColor);
        return ans;
    }

    public static void dfs (int sr, int sc, int[][] ans, int[][] image, int initialColor, int[] drow, int[] dcol, int newColor) {
        ans[sr][sc] = newColor;
        int n = image.length;
        int m = image[0].length;
        for (int i = 0; i < 4; i ++) {
            int nrow = sr + drow[i];
            int ncol = sc + dcol[i];
            if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && image[nrow][ncol] == initialColor && ans[nrow][ncol] != newColor) {
                dfs(nrow, ncol, ans, image, initialColor, drow, dcol, newColor);
            }
        }
    }
}
