package Graphs;

import java.util.HashMap;
import java.util.Map;

public class Max_Stone_Removed {
    public static void main(String[] args) {
        int[][] stones = {
                {0, 0}
        };
        int result = maxRemove(stones);
        System.out.println("Maximum stones that can be removed: " + result);

    }

    public static int maxRemove(int[][] stones) {
        int maxRow =0, maxCol=0;
        for (int[] stone : stones) {
            maxRow = Math.max(maxRow, stone[0]);
            maxCol = Math.max(maxCol, stone[1]);
        }
        DisjointSet ds =  new DisjointSet(maxRow + maxCol + 1);
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int[] stone : stones) {
            int nodeRow = stone[0];
            int nodeCol = stone[1] + maxRow + 1;
            ds.unionBySize(nodeRow, nodeCol);
            map.put(nodeRow, 1);
            map.put(nodeCol, 1);
        }
        int c = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (ds.findParent(entry.getKey()) == entry.getKey()) {
                c ++;
            }
        }
        return stones.length - c;
    }
}
