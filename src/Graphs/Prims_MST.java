package Graphs;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Prims_MST {
    public static void main(String[] args) {
        int V = 5;
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();


        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        addEdge(adj, 0, 1, 2);
        addEdge(adj, 0, 3, 6);
        addEdge(adj, 1, 2, 3);
        addEdge(adj, 1, 3, 8);
        addEdge(adj, 1, 4, 5);
        addEdge(adj, 2, 4, 7);


        int mstWeight = spanningTree(V, adj);
        System.out.println("Weight of the Minimum Spanning Tree: " + mstWeight);
    }


    public static void addEdge(ArrayList<ArrayList<ArrayList<Integer>>> adj, int u, int v, int weight) {

        ArrayList<Integer> edge1 = new ArrayList<>();
        edge1.add(v);
        edge1.add(weight);
        adj.get(u).add(edge1);
        ArrayList<Integer> edge2 = new ArrayList<>();
        edge2.add(u);
        edge2.add(weight);
        adj.get(v).add(edge2);
    }



    public static int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj) {
        PriorityQueue<Prims_Pair> pq = new PriorityQueue<>((x, y) -> x.weight - y.weight);
        int[] vis = new int[V];
        pq.add(new Prims_Pair(0, 0));
        int sum = 0;
        while (!pq.isEmpty()) {
            Prims_Pair p = pq.poll();
            int wt = p.weight;
            int node = p.node;
            if (vis[node] == 1){
                continue;
            }
            vis[node] = 1;
            sum = sum + wt;

            for (ArrayList<Integer> it : adj.get(node)) {
                int adjNode = it.get(0);
                int edW = it.get(1);
                if (vis[adjNode] == 0){
                    pq.add(new Prims_Pair(adjNode, edW));
                }
            }
        }
        return sum;
    }
}

class Prims_Pair {
    int node, weight;
    public Prims_Pair(int node, int weight) {
        this.node = node;
        this.weight = weight;
    }
}
