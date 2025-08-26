package dynamic_programming.neetcode;

import java.util.HashMap;
import java.util.Map;

public class ClimbStairs {

    public static void main(String[] args) {
        int n = 3;
        System.out.println(climbStairs(n)); //3
    }


    public  static int climbStairs(int n) {
         return climbStairs(n,new int[n]);
    }


    public  static int climbStairs(int n, int [] memo) {
        if(n == 0) return 1;
        if(n < 0) return 0;
        if(memo[n-1] != 0) return memo[n-1];
        return memo[n-1] = climbStairs(n-1,memo)+climbStairs(n-2,memo);
    }


}
