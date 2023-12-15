package dynamic_programming.leetocde;

public class ClimbingStairs {

    public static void main(String[] args) {
        System.out.println(climbStairs(3));
    }

    public static int climbStairs(int n) {
        return climbStairs(n,new int [n+1] );
    }

    public static int climbStairs(int n,int memo []) {
       if (n < 0) return 0;
       if (n == 0) return 1;
       if(memo[n] != 0) return memo[n];
       return memo[n] =climbStairs(n-1,memo)+climbStairs(n-2,memo);
    }

    public int climbStairsBottomUp(int n) {
        if(n < 0) return 0;
        int a = 1,b = 1;
        for (int i = 2; i <= n; i++) {
            int  path = a +  b;
            a = b;
            b = path;
        }
        return b;
    }


}
