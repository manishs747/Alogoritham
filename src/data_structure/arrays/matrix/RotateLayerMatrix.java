package data_structure.arrays.matrix;

import utils.ArrayUtils;

public class RotateLayerMatrix {


    public static void main(String[] args) {
        int matrix[][] = {{1, 2, 3,4},
                {5,6, 7, 8},
                {9, 10, 11,12},
                {13, 14, 15,16}};
        matrix = rotateGrid(matrix,2);
        ArrayUtils.print(matrix);
    }

    public  static int[][] rotateGrid(int[][] grid, int k) {
        int temp[]=new int[grid.length];
        k = k % grid.length;
        for (int i = 0; i < grid[0].length; i++) {
            for (int t = 0; t < grid.length - k; t++)
                temp[t] = grid[i][t];
            for (int j = grid.length - k; j < grid.length; j++)
                grid[i][j - grid.length + k] = grid[i][j];
            for (int j = k; j < grid.length; j++)
                grid[i][j] = temp[j - k];
        }
            return grid;

    }
}
