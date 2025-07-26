package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Network_Delay {
    public static void main(String[] args) {

    }

    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<Net_Pair>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i ++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < times.length; i ++) {
            adj.get(times[i][0]).add(new Net_Pair(times[i][1], times[i][2]));
        }
        PriorityQueue<Net_Pair> pq = new PriorityQueue<>((a, b) -> (a.time - b.time));
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;
        pq.add(new Net_Pair(k, 0));
        while (!pq.isEmpty()) {
            Net_Pair curr = pq.poll();
            int node  = curr.node;
            int time = curr.time;
            for (Net_Pair item : adj.get(node)) {
                int adj_node = item.node;
                int adj_time = item.time;
                if (time + adj_time < dist[adj_node]) {
                    dist[adj_node] = time + adj_time;
                    pq.add(new Net_Pair(adj_node, dist[adj_node]));
                }
            }
        }
        int max = 0;
        for (int i = 1; i <= n; i ++) {
            if (dist[i] == Integer.MAX_VALUE) {
                return -1;
            }
            max = Math.max(max, dist[i]);
        }
        return max;
    }
}

class Net_Pair {
    int node, time;
    public Net_Pair(int node, int time) {
        this.node = node;
        this.time = time;
    }
}
