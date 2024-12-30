package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Shortest_Path_UG {
    public static void main(String[] args) {

    }

    public int[] shortestPath(ArrayList<ArrayList<Integer>> adj, int src) {
        Queue<Integer> queue = new LinkedList<>();
        int[] dist = new int[adj.size()];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        queue.add(src);
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int item : adj.get(node)) {
                if (dist[node] + 1 < dist[item]) {
                    dist[item] = dist[node] + 1;
                    queue.add(item);
                }
            }
        }
        for (int i = 0; i < adj.size(); i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                dist[i] = -1;
            }
        }
        return dist;
    }
}
