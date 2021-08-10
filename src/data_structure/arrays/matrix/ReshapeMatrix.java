package data_structure.arrays.matrix;


import data_structure.arrays.Utility;

/**
 * https://leetcode.com/problems/reshape-the-matrix/
 */
public class ReshapeMatrix {


    public static void main(String[] args) {
        int arr[][] = {{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}};

        Utility.print(matrixReshape(arr, 2, 8));
    }


    public static int[][] matrixReshape(int[][] mat, int r, int c) {
        if (mat.length * mat[0].length != r * c) {
            return mat;
        }
        int[][] result = new int[r][c];
        int count = 0;
        for (int[] arr : mat) {
            for (int num : arr) {
                result[count / c][count % c] = num;
                count++;
            }
        }
        return result;
    }
}
