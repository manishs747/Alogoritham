package dynamic_programming.grid;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/out-of-boundary-paths/
 * <p>
 * There is an m x n grid with a ball. The ball is initially at the position [startRow, startColumn].
 * You are allowed to move the ball to one of the four adjacent four cells in the grid (possibly out of the grid crossing the grid boundary).
 * You can apply at most maxMove moves to the ball.
 * <p>
 * Given the five integers m, n, maxMove, startRow, startColumn,
 * return the number of paths to move the ball out of the grid boundary. Since the answer can be very large, return it modulo 109 + 7.
 */
public class OutOfBoundaryPath {
    static int MODULUS = 1000000007;
    public static void main(String[] args) {

        /**
         * Input: m = 2, n = 2, maxMove = 2, startRow = 0, startColumn = 0
         * Output: 6
         */
        int m = 8, n = 50, maxMove = 23, startRow = 5, startColumn = 26;
        // int m = 1, n = 3, maxMove = 3, startRow = 0, startColumn = 1;
        System.out.println(findPaths(m, n, maxMove, startRow, startColumn));
    }

    public int findPathsArr(int m, int n, int N, int i, int j) {
        int[][][] memo = new int[m][n][N + 1];
        for (int[][] l : memo) for (int[] sl : l) Arrays.fill(sl, -1);
        return findPathsArr(m, n, N, i, j, memo);
    }

    public int findPathsArr(int M, int N, int MAX, int i, int j, int[][][] memo) {
        if (i == M || j == N || i < 0 || j < 0) return 1;
        if (MAX == 0) return 0;
        if (memo[i][j][MAX] >= 0) return memo[i][j][MAX];
        memo[i][j][MAX] = (
                        (findPathsArr(M, N, MAX - 1, i - 1, j, memo) + findPathsArr(M, N, MAX - 1, i + 1, j, memo)) % MODULUS +
                        (findPathsArr(M, N, MAX - 1, i, j - 1, memo) + findPathsArr(M, N, MAX - 1, i, j + 1, memo)) % MODULUS
        ) % MODULUS;
        return memo[i][j][MAX];
    }


    /*******************************************************************************************************************/
    public static int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        return findPaths(m, n, maxMove, startRow, startColumn, new HashMap<>());
    }

    public static int findPaths(int m, int n, int maxMove, int startRow, int startColumn, Map<String, Integer> memo) {
        if (isOutSideBoundary(startRow, startColumn, m, n)) return 1;
        if (maxMove == 0) return 0;
        String key = startRow + "_" + startColumn + "_" + maxMove;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        int count = (
                (findPaths(m, n, maxMove - 1, startRow, startColumn + 1, memo) + findPaths(m, n, maxMove - 1, startRow + 1, startColumn, memo)) % MODULUS +
                        (findPaths(m, n, maxMove - 1, startRow, startColumn - 1, memo) + findPaths(m, n, maxMove - 1, startRow - 1, startColumn, memo)) % MODULUS
        ) % MODULUS;
        memo.put(key, count);
        return memo.get(key);
    }

    private static boolean isOutSideBoundary(int startRow, int startColumn, int m, int n) {
        if (startRow < 0 || startRow > m - 1 || startColumn < 0 || startColumn > n - 1) return true;
        return false;
    }


}
