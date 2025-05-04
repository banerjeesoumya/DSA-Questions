package Graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Kruskal_MST {
    public static void main(String[] args) {
        int V = 3;
        int E = 3;

        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }


        addEdge(adj, 0, 1, 5);
        addEdge(adj, 1, 2, 3);
        addEdge(adj, 0, 2, 1);

        int mstWeight = spanningTree(V, adj);
        System.out.println("Weight of the Minimum Spanning Tree: " + mstWeight);
    }

    public static void addEdge(ArrayList<ArrayList<ArrayList<Integer>>> adj, int u, int v, int wt) {
        ArrayList<Integer> edge1 = new ArrayList<>();
        edge1.add(v);
        edge1.add(wt);
        adj.get(u).add(edge1);

        ArrayList<Integer> edge2 = new ArrayList<>();
        edge2.add(u);
        edge2.add(wt);
        adj.get(v).add(edge2);
    }


    public static int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj) {
        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            for (ArrayList<Integer> edge : adj.get(i)) {
                int u = i;
                int v = edge.get(0);
                int w = edge.get(1);
                edges.add(new Edge(u, v, w));
            }
        }
        DisjointSet set = new DisjointSet(V);
        Collections.sort(edges);
        int wt = 0;
        for (Edge edge : edges) {
            int w = edge.wt;
            int u = edge.src;
            int v = edge.dest;
            if (set.findParent(u) != set.findParent(v)) {
                wt = wt + w;
                set.unionBySize(u, v);
            }
        }
        return wt;
    }
}

class Edge implements Comparable<Edge> {
    int src, dest, wt;
    Edge(int src, int dest, int wt) {
        this.src = src;
        this.dest = dest;
        this.wt = wt;
    }
    public int compareTo(Edge e) {
        return this.wt - e.wt;
    }
}
