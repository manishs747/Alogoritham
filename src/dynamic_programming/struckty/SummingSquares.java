package dynamic_programming.struckty;


import java.util.ArrayList;
import java.util.List;

/**
 * https://www.structy.net/problems/summing-squares
 * https://leetcode.com/problems/perfect-squares/description/
 *
 */
public class SummingSquares {
    public static void main(String[] args) {
        System.out.println(summingSquares(12)); // 3
    }

    public static int summingSquares(int n) {
        return summingSquares(n, new Integer[n + 1]);
    }

    public static int summingSquares(int n, Integer[] memo) {
        if (n == 0) return 0;
        if (memo[n] != null) return memo[n];
        int minSum = Integer.MAX_VALUE;
        for (int i = 1; i * i <= n; i++) {
            int subCount = summingSquares(n - i * i, memo);
            minSum = Math.min(minSum, 1 + subCount);
        }
        return memo[n] = minSum;
    }


}
