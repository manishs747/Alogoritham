package data_structure.arrays.matrix;

import data_structure.arrays.Utility;

/**
 * https://www.geeksforgeeks.org/maximum-size-sub-matrix-with-all-1s-in-a-binary-matrix/
 */
public class LargestSubmatrix {


    public static void main(String[] args) {
        // [[0,0,1],[1,1,1],[1,0,1]]
        int arr[][] = {{0,0,1}, {1,1,1}, {1,0,1}};
        Utility.print(arr);
        System.out.println(largestSubmatrix(arr));
    }


    public  static int largestSubmatrix(int[][] matrix) {
        int i,j;
        int r = matrix.length;         //no of rows in M[][]
        int c = matrix[0].length;     //no of columns in M[][]
        int sample[][] = new int[r][c];

        int max_of_s, max_i, max_j;


        for(i = 0; i < r; i++)
            sample[i][0] = matrix[i][0];


        for(j = 0; j < c; j++)
            sample[0][j] = matrix[0][j];

        for(i = 1; i < r; i++)
        {
            for(j = 1; j < c; j++)
            {
                if(matrix[i][j] == 1)
                    sample[i][j] = Math.min(sample[i][j-1],
                            Math.min(sample[i-1][j], sample[i-1][j-1])) + 1;
                else
                    sample[i][j] = 0;
            }
        }

        max_of_s = sample[0][0]; max_i = 0; max_j = 0;
        for(i = 0; i < r; i++)
        {
            for(j = 0; j < c; j++)
            {
                if(max_of_s < sample[i][j])
                {
                    max_of_s = sample[i][j];
                    max_i = i;
                    max_j = j;
                }
            }
        }

        return  (max_i - max_of_s)*(max_j - max_of_s);
    }


}
