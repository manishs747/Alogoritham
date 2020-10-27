package data_structure.arrays.matrix;

public class MatrixDigonalSum {


    public static void main(String[] args) {
         /*
          {1,2,3},
                {4,5,6},
                {7,8,9},
          */

        int mat[][] = {
                {5},

        };
        System.out.println(diagonalSum(mat));

    }

    public static int diagonalSum(int[][] mat) {

        int n = mat.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
          sum = sum + mat[i][i] + mat[i][n-i-1];
        }
        if(n%2 != 0){
            sum = sum - mat[n/2][n/2];
        }
        return sum;
    }
}
