package Arrays;

import java.util.ArrayList;
import java.util.Collections;

public class Leaders_In_An_Array {
    public static void main(String[] args) {
        int n = 6;
        int[] arr = {10, 22, 12, 3, 0, 6};
        ArrayList<Integer> ans = leaders(arr);
        for (int i = 0; i < ans.size(); i++) {
            System.out.println(ans.get(i) + " ");
        }
    }

    public static ArrayList<Integer> leaders (int[] arr) {
        ArrayList<Integer> ans = new ArrayList<>();
        int max = Integer.MIN_VALUE;
//        ans.add(arr[arr.length - 1]);
        for (int i = arr.length - 1; i >= 0; i --) {
            if (arr[i] > max) {
                max = arr[i];
                ans.add(max);
            }
        }
        return ans;
    }
}
