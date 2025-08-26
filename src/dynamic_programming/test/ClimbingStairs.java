package dynamic_programming.test;

public class ClimbingStairs {

    public static void main(String[] args) {

    }






    private static int uniqueMethodHelper(int m, int n , Integer [][] memo) {
        if(m <= 0 || n <= 0) return 0;
        if(m == 1 && n == 1) return 1;
        if(memo[m-1][n-1] != null) return memo[m-1][n-1];
        return memo[m-1][n-1] = uniqueMethodHelper(m - 1, n,memo) + uniqueMethodHelper(m, n - 1,memo);
    }


}
