package Graphs;

public class Network_Connections {
    public static void main(String[] args) {
        int n = 6;
        int[][] connections = {
                {0, 1},
                {0, 2},
                {0, 3},
                {1, 2},
                {1, 3}
        };

        Network_Connections nc = new Network_Connections();
        int result = nc.makeConnected(n, connections);
        System.out.println("Minimum cables needed to connect all computers: " + result);
    }

    public int makeConnected(int n, int[][] connections) {
        DisjointSet ds = new DisjointSet(n);
        int cntExtras = 0;
        for (int[] connection : connections) {
            int u = connection[0];
            int v = connection[1];
            if (ds.findParent(u) == ds.findParent(v)) {
                cntExtras++;
            } else {
                ds.unionBySize(u, v);
            }
        }
        int C = 0;
        for (int i = 0; i < n; i ++) {
            if (ds.findParent(i) == i) {
                C ++;
            }
        }
        int ans = C - 1;
        return (cntExtras >= ans) ? ans : -1;
    }
}
