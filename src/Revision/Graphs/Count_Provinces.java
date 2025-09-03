package Revision.Graphs;

import java.util.ArrayList;

public class Count_Provinces {
    public static void main(String[] args) {

    }
    public int findCircleNum(int[][] grid) {
        int n = grid.length;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1 && i != j) {
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }
        int count = 0;
        boolean[] vis = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                count ++;
                dfs(i, vis, adj);
            }
        }
        return count;
    }
    private void dfs(int node, boolean[] vis, ArrayList<ArrayList<Integer>> adj) {
        vis[node] = true;
        for (Integer adjNode : adj.get(node)) {
            if (!vis[adjNode]) {
                dfs(adjNode, vis, adj);
            }
        }
    }
}
