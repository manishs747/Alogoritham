package dynamic_programming.struckty;


/**
 * https://www.youtube.com/watch?v=oFkDldu3C_4
 * https://www.structy.net/problems/fib/problem-index
 */
public class Fibonacci {

    public static int fib(int n) {
        return fib(n,new int [n+1]);
    }

    private static int fib(int n, int[] memo) {
        if(n < 2) return n;
        if(memo[n] == 0){
            memo[n] = fib(n-1,memo)+fib(n-2,memo);
        }
        return memo[n];
    }
}
