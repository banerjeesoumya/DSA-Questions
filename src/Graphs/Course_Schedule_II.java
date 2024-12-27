package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Course_Schedule_II {
    public static void main(String[] args) {
        Course_Schedule_II obj = new Course_Schedule_II();

        int numCourses1 = 4;
        int[][] prerequisites1 = { {1, 0}, {2, 0}, {3, 1}, {3, 2} };
        int[] result1 = obj.findOrder(numCourses1, prerequisites1);
        System.out.println("Order of courses for Test Case 1: " + Arrays.toString(result1));

        int numCourses2 = 2;
        int[][] prerequisites2 = { {1, 0}, {0, 1} }; // Cycle in graph
        int[] result2 = obj.findOrder(numCourses2, prerequisites2);
        System.out.println("Order of courses for Test Case 2: " + Arrays.toString(result2));

        int numCourses3 = 6;
        int[][] prerequisites3 = { {1, 0}, {2, 1}, {3, 2}, {4, 2}, {5, 3} };
        int[] result3 = obj.findOrder(numCourses3, prerequisites3);
        System.out.println("Order of courses for Test Case 3: " + Arrays.toString(result3));

        int numCourses4 = 3;
        int[][] prerequisites4 = {};
        int[] result4 = obj.findOrder(numCourses4, prerequisites4);
        System.out.println("Order of courses for Test Case 4: " + Arrays.toString(result4));
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < numCourses; i ++) {
            adj.add(new ArrayList<>());
        }
        for (int[] pre : prerequisites) {
            adj.get(pre[1]).add(pre[0]);
        }
        int[] vis = new int[numCourses];
        int[] pathVis = new int[numCourses];
        Stack<Integer> st = new Stack<Integer>();
        for (int i = 0; i < numCourses; i ++) {
            if (vis[i] == 0) {
                if (dfs(i, vis, pathVis, st, adj)) {
                    return new int[0];
                }
            }
        }
        int[] ans = new int[numCourses];
        int k = 0;
        while (!st.isEmpty()) {
            ans[k++] = st.peek();
            st.pop();
        }
        return ans;
    }

    public static boolean dfs(int node, int[] vis, int[] pathVis, Stack<Integer> st, ArrayList<ArrayList<Integer>> adj) {
        vis[node] = 1;
        pathVis[node] = 1;
        for (int item : adj.get(node)) {
            if (vis[item] == 0) {
                if (dfs(item, vis, pathVis, st, adj)) {
                    return true;
                }
            }
            else if (pathVis[item] == 1) {
                return true;
            }
        }

        pathVis[node] = 0;
        st.push(node);
        return false;
    }
}
