package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class No_OfWays_Dest {
    public static void main(String[] args) {
        int n = 7;
        int[][] roads = {
                {0, 6, 7},
                {0, 1, 2},
                {1, 2, 3},
                {1, 3, 3},
                {6, 3, 3},
                {3, 5, 1},
                {6, 5, 1},
                {2, 5, 1},
                {0, 4, 5},
                {4, 6, 2}
        };

        No_OfWays_Dest obj = new No_OfWays_Dest();
        int result = obj.countPaths(n, roads);
        System.out.println("Number of ways to reach the destination: " + result);
    }

    public int countPaths(int n, int[][] roads) {
        ArrayList<ArrayList<Pair_Dest>> adj = new ArrayList<>();
        for (int i = 0; i < n; i ++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < roads.length; i ++) {
            adj.get(roads[i][0]).add(new Pair_Dest(roads[i][1], roads[i][2]));
            adj.get(roads[i][1]).add(new Pair_Dest(roads[i][0], roads[i][2]));
        }
        long[] dist = new long[n];
        int[] ways = new int[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        Arrays.fill(ways, 0);
        PriorityQueue<Pair_Dest> pq = new PriorityQueue<>((x, y) -> (Long.compare(x.dist, y.dist)));
        dist[0] = 0;
        ways[0] = 1;
        int mod = 1000000007;
        pq.add(new Pair_Dest(0, 0L));
        while (!pq.isEmpty()) {
            Pair_Dest curr = pq.poll();
            long currDist = curr.dist;
            int currNode = curr.node;
            for (Pair_Dest item : adj.get(currNode)) {
                int adjNode = item.node;
                long adjDist = item.dist;
                if (currDist + adjDist < dist[adjNode]) {
                    dist[adjNode] = currDist + adjDist;
                    ways[adjNode] = ways[currNode];
                    pq.add(new Pair_Dest(adjNode, dist[adjNode]));
                } else if (currDist + adjDist == dist[adjNode]) {
                    ways[adjNode] = (ways[adjNode] + ways[currNode]) % mod;
                }
            }
        }
        return ((ways[n - 1]) % mod);
    }
}

class Pair_Dest {
    int node;
    long dist;
    public Pair_Dest(int node, long dist) {
        this.node = node;
        this.dist = dist;
    }
}
