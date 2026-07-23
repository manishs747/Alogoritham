package company.google;


import java.util.Arrays;

/**
 * https://leetcode.com/problems/maximal-square/description/
 * https://www.youtube.com/watch?v=Ti5vfu9arXQ
 *
 */
public class MaximumSquare {

    public static void main(String[] args) {
        char [][] matrix = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        System.out.println(maximalSquare(matrix));
    }

    public static int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int rows = matrix.length , cols = matrix[0].length;
        int [][] memo = new int[rows][cols];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        int maxSide = 0;
        // Compute DP for every cell
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                maxSide = Math.max(maxSide, maximalSquareUtil(matrix, i, j, memo));
            }
        }
        return maxSide * maxSide;
    }



    public static int maximalSquareUtil(char[][] matrix, int i, int j, int [][] memo) {
        if (i >= matrix.length || j >= matrix[0].length) return 0;
        if (memo[i][j] != -1) return memo[i][j];
        int right = maximalSquareUtil(matrix, i, j + 1, memo);
        int down = maximalSquareUtil(matrix, i + 1, j, memo);
        int diagonal = maximalSquareUtil(matrix, i + 1, j + 1, memo);
        int maxSqr = 0;
        if (matrix[i][j] == '1') {
            maxSqr = 1 + Math.min(right, Math.min(down, diagonal));
        }
        return memo[i][j] = maxSqr;
    }
}
