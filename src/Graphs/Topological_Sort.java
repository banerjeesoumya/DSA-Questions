package Graphs;

import java.util.ArrayList;
import java.util.Stack;

public class Topological_Sort {
    public static void main(String[] args) {
        // Define the number of vertices
        int V = 6;

        // Initialize the adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Define the edges (directed graph)
        adj.get(5).add(2);
        adj.get(5).add(0);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(2).add(3);
        adj.get(3).add(1);

        // Perform topological sort
        ArrayList<Integer> result = topologicalSort(adj);

        // Print the result
        System.out.println("Topological Sort of the graph:");
        for (int node : result) {
            System.out.print(node + " ");
        }
    }

    public static ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> adj) {
        int[] vis = new int[adj.size()];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < adj.size(); i++) {
            if (vis[i] == 0) {
                dfs(i, vis, stack, adj);
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();
        while (!stack.isEmpty()) {
            ans.add(stack.pop());
        }
        return ans;
    }

    public static void dfs(int node, int[] vis, Stack<Integer> st, ArrayList<ArrayList<Integer>> adj) {
        vis[node] = 1;
        for (int item : adj.get(node)) {
            if (vis[item] == 0) {
                dfs(item, vis, st, adj);
            }
        }
        st.push(node);
    }
}
