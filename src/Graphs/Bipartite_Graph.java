package Graphs;

import java.util.ArrayList;
import java.util.Arrays;

public class Bipartite_Graph {
    public static void main(String[] args) {
        int[][] graph = {
                {1, 3},
                {0, 2},
                {1, 3},
                {0, 2}
        };

        Bipartite_Graph bg = new Bipartite_Graph();
        boolean result = bg.isBipartite(graph);

        if (result) {
            System.out.println("The graph is bipartite.");
        } else {
            System.out.println("The graph is not bipartite.");
        }
    }

    public boolean isBipartite(int[][] graph) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        // Build the adjacency list from the adjacency matrix
        for (int i = 0; i < graph.length; i++) {
            adj.add(new ArrayList<>());
            for (int j = 0; j < graph[i].length; j++) {
                if (graph[i][j] == 1) {
                    adj.get(i).add(j);  // Add the edge from i to j
                }
            }
        }

        // Array to store the color of each node
        int[] color = new int[graph.length];
        Arrays.fill(color, -1);  // Initialize all nodes with no color (-1)

        // Check each node to ensure it's bipartite
        for (int i = 0; i < graph.length; i++) {
            if (color[i] == -1) {
                if (!dfs(i, 0, color, adj)) {
                    return false;  // If a conflict is found, return false
                }
            }
        }
        return true;  // If no conflict, the graph is bipartite
    }

    // DFS function to check for bipartiteness
    public boolean dfs(int node, int col, int[] color, ArrayList<ArrayList<Integer>> adj) {
        color[node] = col;  // Assign color to the node

        // Explore all the neighbors
        for (int neighbor : adj.get(node)) {
            if (color[neighbor] == -1) {
                // If neighbor has no color, assign opposite color
                if (!dfs(neighbor, 1 - col, color, adj)) {
                    return false;
                }
            } else if (color[neighbor] == col) {
                // If neighbor has the same color, the graph is not bipartite
                return false;
            }
        }
        return true;  // If no conflict, continue
    }
}
