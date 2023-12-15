package dynamic_programming.struckty;

public class Tribonacci {
    public static int tribonacci(int n) {
        return tribonacci(n,new int [n+1]);
    }
    private static int tribonacci(int n, int[] memo) {
        if(n < 2) return 0;
        if(n == 2) return 1;
        if(memo[n] == 0)
            memo[n] = tribonacci(n-1,memo)+tribonacci(n-2,memo)+tribonacci(n-3,memo);
        return memo[n];
    }
}
