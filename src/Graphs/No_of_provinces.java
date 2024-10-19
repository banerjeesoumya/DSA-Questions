package Graphs;

import java.util.ArrayList;

public class No_of_provinces {
    public static void main(String[] args) {
        Graph graph = new Graph(4);
        graph.addEdge(1, 0);
//        graph.addEdge(2, 1);
        graph.addEdge(3, 0);
        graph.addEdge(2, 0);

        No_of_provinces ob = new No_of_provinces();
        System.out.println(graph.adj.size());
        System.out.println(ob.findNoOfProvinces(graph.adj, graph));
    }

    public int findNoOfProvinces(ArrayList<ArrayList<Integer>> adj, Graph graph) {
        boolean[] vis = new boolean[adj.size()];
        int count = 0;
        for (int i = 0; i < adj.size(); i++) {
            if (!vis[i]) {
                count ++;
                graph.dfs_recur1(i, adj, vis);
            }
        }
        return count;
    }
}
