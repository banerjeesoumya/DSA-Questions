package Graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Minimum_Multiplications {
    public static void main(String[] args) {

    }

    public static int minimumMultiplications(int[] arr, int start, int end) {
        Queue<Multi_Pair> q = new LinkedList<>();
        int[] dist = new int[100000];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        q.add(new Multi_Pair(start, 0));
        int mod = 100000;
        while(!q.isEmpty()) {
            Multi_Pair pair = q.poll();
            int node = pair.node;
            int steps = pair.steps;
            for (int i = 0; i < arr.length; i ++) {
                int num = (arr[i] * node) % mod;
                if (steps + 1 < dist[num]) {
                    dist[num] = steps + 1;
                    if (num == end){
                        return steps + 1;
                    }
                    q.add(new Multi_Pair(num, steps + 1));
                }
            }
        }
        return -1;
    }
}

class Multi_Pair{
    int node, steps;
    public Multi_Pair(int node, int steps) {
        this.node = node;
        this.steps = steps;
    }
}
