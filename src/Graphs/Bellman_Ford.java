package Graphs;

import java.util.ArrayList;
import java.util.Arrays;

public class Bellman_Ford {
    public static void main(String[] args) {
        int V = 3; // Number of vertices
        int[][] edges = {
                {0, 1, 5},
                {1, 0, 3},
                {2, 0, 1}
        };
        int src = 2; // Source vertex

        int[] dist = bellmanFord(V, edges, src);
        System.out.println(Arrays.toString(dist));
    }
    public static int[] bellmanFord(int V, int[][] edges, int src) {
        // Write your code here
        int[] dist = new int[V];
        Arrays.fill(dist, 100000000);
        dist[src] = 0;
        for (int i = 0; i < V - 1; i ++) {
            for (int[] edge : edges) {
                int u = edge[0];
                int v = edge[1];
                int w = edge[2];
                if ((dist[u] != 100000000) && (dist[u] + w < dist[v])) {
                    dist[v] = dist[u] + w;
                }
            }
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            if ((dist[u] != 100000000) && (dist[u] + w < dist[v])) {
                int[] temp = new int[1];
                temp[0] = -1;
                return temp;
            }
        }
        return dist;
    }
}

