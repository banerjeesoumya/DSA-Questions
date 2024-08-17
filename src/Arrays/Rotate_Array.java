package Arrays;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;

public class Rotate_Array {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        System.out.println(Arrays.toString(arr));
//        leftRotate(arr);
//        System.out.println(Arrays.toString(arr));
        leftRotateByd(arr, 3);
        System.out.println(Arrays.toString(arr));
//        arr = rotate(arr, 3);
//        System.out.println(Arrays.toString(arr));
    }

    public static int[] rotate(int[] arr, int k) {
        int[] temp = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            temp[(i + k) % arr.length] = arr[i];
        }
        return temp;
    }

    public static void leftRotate(int[] arr) {
        int temp = arr[0];
        for (int i = 1; i < arr.length; i++) {
            arr[i - 1] = arr[i];
        }
        arr[arr.length - 1] = temp;
    }

    public static void leftRotateByd(int[] arr, int k) {
        reverse(arr, 0, k);
        reverse(arr, k + 1, arr.length - 1);
        reverse(arr, 0, arr.length - 1);
    }

    public static void reverse(int[] arr, int start, int end) {
        while (start <= end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start ++;
            end --;
        }
    }
}
