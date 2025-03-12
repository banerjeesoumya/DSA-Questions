package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class Djikstra_PQ {
    public static void main(String[] args) {

    }

    public static ArrayList<Integer> djikstra(ArrayList<ArrayList<iPair>> adj, int src) {
        PriorityQueue<iPair> pq = new PriorityQueue<iPair>((x, y) -> x.dist - y.dist);
        ArrayList<Integer> dist = new ArrayList<>(adj.size());
        Collections.fill(dist, Integer.MAX_VALUE);
        dist.add(src, 0);
        pq.add(new iPair(src, 0));

        while (!pq.isEmpty()) {
            int node = pq.peek().node;
            int dis = pq.peek().dist;
            pq.remove();
            for (iPair item : adj.get(node)) {
                int adjNode = item.node;
                int adjDist = item.dist;

                if (dis + adjDist < dist.get(adjNode)) {
                    dist.set(adjNode, dis + adjDist);
                    pq.add(new iPair(adjNode, dis + adjDist));
                }
            }
        }
        return dist;
    }
}

class iPair {
    int node, dist;
    public iPair(int node, int dist) {
        this.node = node;
        this.dist = dist;
    }
}
