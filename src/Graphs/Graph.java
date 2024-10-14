package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {
    int V;
    ArrayList<ArrayList<Integer>> adj;

    public Graph(int V) {
        this.V = V;
        adj = new ArrayList<>();
        for (int v = 0; v < V; v++) {
            adj.add(new ArrayList<>());
        }
    }

    public void addEdge(int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    public ArrayList<Integer> bfs (int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        visited[0] = true;
        q.add(0);

        while (!q.isEmpty()) {
            int node = q.poll();
            ans.add(node);

            for (int i : adj.get(node)) {
                if (!visited[i]) {
                    visited[i] = true;
                    q.add(i);
                }
            }
        }
        return ans;
    }

    public ArrayList<Integer> dfs (int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];
        ArrayList<Integer> ans = new ArrayList<>();
        dfs_recur(0, adj, visited, ans);
        return ans;
    }

    public void dfs_recur(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited, ArrayList<Integer> ans) {
        visited[node] = true;
        ans.add(node);

        for (int i : adj.get(node)) {
            if (!visited[i]) {
                dfs_recur(i, adj, visited, ans);
            }
        }
    }
    public void dfs_recur1(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {
        visited[node] = true;
        for (int i : adj.get(node)) {
            if (!visited[i]) {
                dfs_recur1(i, adj, visited);
            }
        }
    }
}
