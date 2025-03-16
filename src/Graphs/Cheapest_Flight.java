package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Cheapest_Flight {
    public static void main(String[] args) {
        int n = 4; // Number of cities
        int[][] flights = {
                {0, 1, 100},
                {1, 2, 100},
                {2, 0, 100},
                {1, 3, 600},
                {2, 3, 200}
        };
        int src = 0; // Source city
        int dst = 3; // Destination city
        int k = 1; // Maximum number of stops

        Cheapest_Flight cf = new Cheapest_Flight();
        int result = cf.findCheapestPrice(n, flights, src, dst, k);

        System.out.println("Cheapest Price: " + result);
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<Node>> adj = new ArrayList<>();
        for (int i = 0; i < n; i ++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < flights.length; i++) {
            adj.get(flights[i][0]).add(new Node(flights[i][1], flights[i][2]));
        }
        Queue<Tuple_CheapFlight> q = new LinkedList<>();
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        q.add(new Tuple_CheapFlight(0, src, 0));
        while (!q.isEmpty()) {
            Tuple_CheapFlight curr = q.poll();
            int stop = curr.stops;
            int node = curr.node;
            int dis = curr.dist;

            if (stop > k) {
                continue;
            }
            for (Node item : adj.get(node)) {
                int adjNode = item.node;
                int adjDist = item.dist;

                if (dis + adjDist < dist[adjNode] && stop <= k) {
                    dist[adjNode] = dis + adjDist;
                    q.add(new Tuple_CheapFlight(stop + 1, adjNode, dist[adjNode]));
                }
            }
        }
        if (dist[dst] == Integer.MAX_VALUE) {
            return -1;
        }
        return dist[dst];
    }
}

class Node {
    int node;
    int dist;
    public Node (int node, int dist) {
        this.node = node;
        this.dist = dist;
    }
}

class Tuple_CheapFlight {
    int stops, node, dist;
    public Tuple_CheapFlight(int stops, int node, int dist) {
        this.stops = stops;
        this.node = node;
        this.dist = dist;
    }
}
