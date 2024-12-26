package Graphs;

import java.util.ArrayList;
import java.util.Arrays;

public class Course_Schedule_I {
    public static void main(String[] args) {
        int numCourses = 4;
        int[][] prerequisites = { {1, 0}, {2, 0}, {3, 1}, {3, 2} };
        Course_Schedule_I obj = new Course_Schedule_I();
        System.out.println(obj.canFinish(numCourses, prerequisites));
    }

    public static boolean dfs (int node, int[] vis, int[] pathVis, ArrayList<ArrayList<Integer>> adj) {
        vis[node] = 1;
        pathVis[node] = 1;

        for (int item : adj.get(node)) {
            if (vis[item] == 0) {
                if (dfs(item, vis, pathVis, adj)) {
                    return true;
                }
            }
            else if (pathVis[item] == 1) {
                return true;
            }
        }


        pathVis[node] = 0;
        return false;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] pre : prerequisites) {
            adj.get(pre[1]).add(pre[0]);
        }

        int[] visited = new int[numCourses];
        int[] pathVisited = new int[numCourses];
        Arrays.fill(visited, 0);
        Arrays.fill(pathVisited, 0);
        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 0) {
                if (dfs(i, visited, pathVisited, adj)) {
                    return false;
                }
            }
        }
        return true;
    }
}
