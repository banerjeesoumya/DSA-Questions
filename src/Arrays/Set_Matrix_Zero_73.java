package Arrays;

public class Set_Matrix_Zero_73 {
    public static void main(String[] args) {
        int [][] arr = {{0,1,2,0}, {3,4,5,2}, {1,3,1,5}};
        System.out.println("Original Matrix : ");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
        int [][] ans = setZeroes(arr);
        System.out.println("Modified matrix : ");
        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[i].length; j++) {
                System.out.print(ans[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static int[][] setZeroes(int[][] matrix ) {
        int rowCount = matrix.length;
        int [] row = new int[rowCount];
        int colCount = matrix[0].length;
        int [] col = new int[colCount];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (row[i] == 1 || col[j] == 1) {
                    matrix[i][j] = 0;
                }
            }
        }
        return matrix;
    }
}
