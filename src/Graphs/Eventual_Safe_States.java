package Graphs;

import java.util.ArrayList;
import java.util.List;

public class Eventual_Safe_States {
    public static void main(String[] args) {
        int[][] graph = {{1, 2, 3, 4}, {1, 2}, {3, 4}, {0, 4}, {}};
        Eventual_Safe_States obj = new Eventual_Safe_States();
        List<Integer> result = obj.eventualSafeNodes(graph);
        System.out.println(result);
    }

    public List<Integer> eventualSafeNodes(int[][] graph) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < graph.length; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < graph.length; i++) {
            for (int neighbor : graph[i]) {
                adj.get(i).add(neighbor);
            }
        }
        int[] vis = new int[graph.length];
        int[] pathVis = new int[graph.length];
        int[] check = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (vis[i] == 0) {
                dfs(i, vis, pathVis, check, adj);
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < graph.length; i++) {
            if (check[i] == 1) {
                res.add(i);
            }
        }
        return res;
    }

    public boolean dfs(int node, int[] vis, int[] pathVis, int[] check, List<ArrayList<Integer>> adj) {
        vis[node] = 1;
        pathVis[node] = 1;
        check[node] = 0;
        for (int item : adj.get(node)) {
            if (vis[item] == 0) {
                if (dfs(item, vis, pathVis, check, adj)) {
                    check[node] = 0;
                    return true;
                }
            } else if (pathVis[item] == 1) {
                check[node] = 0;
                return true;

            }
        }
        pathVis[node] = 0;
        check[node] = 1;
        return false;
    }
}

