package Arrays;

import java.util.Arrays;

public class MoveZeroes {
    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 3, 12};
        System.out.println(arr.length);
        removeZeroes(arr);
    }

//    private static void removeZeroes(int[] arr) {
////        TWO POINTER APPROACH :-
//        int k;
//        for (int i = 0; i < arr.length; i++) {
//            if (arr[i] == 0) {
//                k = i;
//                for (int j = i + 1; j < arr.length; j++) {
//                    if (arr[j] != 0) {
//                        int temp = arr[k];
//                        arr[k] = arr[j];
//                        arr[j] = temp;
//                        k = k + 1;
//                    }
//                }
//            }
//        }
//        System.out.println(Arrays.toString(arr));



    /*
        int k = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                k = i;
                break;
            }
        }

        for (int i = k + 1; i < arr.length; i ++) {
            if (arr[i] != 0) {
                int temp = arr[i];
                arr[i] = arr[k];
                arr[k] = temp;
                k = k + 1;
            }
        }
        System.out.println(Arrays.toString(arr));

     */
//    }

    public static void removeZeroes(int[] arr) {
        int k = -1;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == 0) {
                k = i;
                break;
            }
        }
        if (k == -1) {
            System.exit(0);
        }
        for (int i = k + 1; i < arr.length; i++) {
            if (arr[i] != 0) {
                int temp = arr[i];
                arr[i] = arr[k];
                arr[k] = temp;
                k ++;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
