package Graphs;

import java.util.Arrays;

public class City_With_Smallest_No_Of_Neighbours {
    public static void main(String[] args) {
        int n = 5;
        int[][] edges = {
                {0, 1, 2}, {0, 4, 8}, {1, 2, 3}, {1, 4, 2}, {2, 3, 1}, {3, 4, 1}
        };
        int distanceThreshold = 2;

        City_With_Smallest_No_Of_Neighbours obj = new City_With_Smallest_No_Of_Neighbours();
        int result = obj.findTheCity(n, edges, distanceThreshold);

        System.out.println("City with the smallest number of reachable neighbors: " + result);
    }

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] distance = new int[n][n];
        for (int[] row : distance) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];
            distance[u][v] = wt;
            distance[v][u] = wt;
        }
        for (int i = 0; i < n; i++) {
            distance[i][i] = 0;
        }
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (distance[i][k] == Integer.MAX_VALUE || distance[k][j] == Integer.MAX_VALUE) {
                        continue;
                    }
                    distance[i][j] = Math.min(distance[i][j], distance[i][k] + distance[k][j]);
                }
            }
        }
        int cntCity = n;
        int cityNo = -1;
        for (int i = 0; i < n; i++) {
            int c = 0;
            for (int j = 0; j < n; j++) {
                if (distance[i][j] <= distanceThreshold) {
                    c ++;
                }
            }
            if (c <= cntCity) {
                cntCity = c;
                cityNo = i;
            }
        }
        return cityNo;
    }
}
