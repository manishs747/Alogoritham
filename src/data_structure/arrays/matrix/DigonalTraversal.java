package data_structure.arrays.matrix;

import data_structure.arrays.Utility;

public class DigonalTraversal {


    public static void main(String[] args) {


        int arr[][] = { {1, 2, 3},
                {4, 5, 6},
                { 7, 8, 9}
        };
        Utility.print(arr);
        findDiagonalOrder(arr);


    }


    /**
     * [
     *  [ 1, 2, 3 ],
     *  [ 4, 5, 6 ],
     *  [ 7, 8, 9 ]
     * ]
     *
     * Output:  [1,2,4,7,5,3,6,8,9]
     */


    public static int[] findDiagonalOrder(int[][] matrix) {
        int R = matrix.length;
        int C = matrix[0].length;

        int r = 0;
        int c = 0;
        while(c < C   & r < R){
            System.out.print(matrix[r][c]+" ");
            r++;
        }
        return null;
    }
}
