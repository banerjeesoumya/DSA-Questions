package Graphs;

import java.util.ArrayList;

public class Cycle_Detection_Directed {
    public static void main(String[] args) {
        int V = 4;  // Number of vertices
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(0).add(1);
        adj.get(1).add(2);
        adj.get(2).add(3);
        adj.get(3).add(1);

        if (isCyclic(V, adj)) {
            System.out.println("The graph contains a cycle.");
        } else {
            System.out.println("The graph does not contain a cycle.");
        }
    }

    public static boolean isCyclic (int V, ArrayList<ArrayList<Integer>> adj) {
        int[] visited = new int[V];
        int[] pathVisited = new int[V];

        for (int i = 0; i < V; i++) {
            if (visited[i] == 0) {
                if (dfs(i, visited, pathVisited, adj)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean dfs (int node, int[] vis, int[] pathVis, ArrayList<ArrayList<Integer>> adj) {
        vis[node] = 1;
        pathVis[node] = 1;
        for (int item : adj.get(node)) {
            if (vis[item] == 0) {
                if (dfs(item, vis, pathVis, adj)) {
                    return true;
                }
            }
            else if (pathVis[item] == 1) {
                return true;
            }
        }
        pathVis[node] = 0;
        return false;
    }
}
