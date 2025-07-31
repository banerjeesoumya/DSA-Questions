//package Graphs;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Stack;
//
//public class DAG_Shortest_Path {
//    public static void main(String[] args) {
//
//    }
//    public int[] shortestPath(int V, int E, int[][] edges) {
//        ArrayList<ArrayList<Pair>> adj = new ArrayList<ArrayList<Pair>>();
//        for (int i = 0; i < V; i++) {
//            adj.add(new ArrayList<>());
//        }
//        for (int i = 0; i < E; i++) {
//            int u = edges[i][0];
//            int v = edges[i][1];
//            int w = edges[i][2];
//            adj.get(u).add(new Pair1(v, w));
//        }
//        int[] vis = new int[V];
//        Stack<Integer> stack = new Stack<>();
//        for (int i = 0; i < V; i++) {
//            if (vis[i] == 0) {
//                dfs(i, vis, adj, stack);
//            }
//        }
//        int[] dist = new int[V];
//        Arrays.fill(dist, Integer.MAX_VALUE);
//        dist[0] = 0;
//        while (!stack.isEmpty()) {
//            int node = stack.pop();
//            for (Pair item : adj.get(node)) {
//                int a = item.node;
//                int b = item.weight;
//                if (dist[node] > dist[a] + b) {
//                    dist[a] = dist[node] + b;
//                }
//            }
//        }
//        return dist;
//    }
//
//    public void dfs(int node, int[] vis, ArrayList<ArrayList<Pair>> adj, Stack<Integer> stack) {
//        vis[node] = 1;
//        for (Pair item : adj.get(node)) {
//            if (vis[item.node] == 0) {
//                dfs(item.node, vis, adj, stack);
//            }
//        }
//        stack.push(node);
//    }
//}
//
//class Pair1{
//    int node, weight;
//    public Pair1(int node, int weight) {
//        this.node = node;
//        this.weight = weight;
//    }
//}
