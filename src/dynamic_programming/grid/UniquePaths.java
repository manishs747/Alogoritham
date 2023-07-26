package dynamic_programming.grid;

import java.util.HashMap;
import java.util.Map;

public class UniquePaths {

    public static void main(String[] args) {
        System.out.println(uniquePaths1(3,7));//28
    }


    /*********************************2 D Array********************************************/
    public static int uniquePaths(int m, int n) {
        return uniquePaths(m, n,new int [m][n]);
    }

    private static int uniquePaths(int m, int n , int [][] memo) {
        if(m == 1 && n == 1) return 1;
        if(m < 1 || n < 1) return 0;
        if(memo[m-1][n-1] == 0){
            memo[m-1][n-1] = uniquePaths(m - 1, n,memo) + uniquePaths(m, n - 1,memo);
        }
       return memo[m-1][n-1];
    }

    /*********************************2 D Array 2********************************************/
    //The space complexity of the optimized solution is O(m * n) because we use a 2D array memo of size m * n to store the memoized results.
    private static int uniquePaths2(int m, int n) {
        return uniquePathsHelper(m, n, new int[m][n]);
    }

    private static int uniquePathsHelper(int m, int n, int[][] memo) {
        if (m == 1 || n == 1) return 1;  // base case
        if (memo[m-1][n-1] > 0) return memo[m-1][n-1];  // memo base case
        return  memo[m-1][n-1]  = uniquePathsHelper(m - 1, n, memo) + uniquePathsHelper(m, n - 1, memo);//setting memo
    }


    /********************************** Hash Map *******************************************/

    public static int uniquePaths1(int m, int n) {
        return uniquePaths1(m, n,new HashMap<String,Integer>());
    }

    private static int uniquePaths1(int m, int n , Map<String,Integer> memo) {
        if(m == 1 && n == 1) return 1;
        if(m < 1 || n < 1) return 0;
        String key = m +"-"+n;
        if(!memo.containsKey(key)){
           memo.put(key,uniquePaths1(m - 1, n,memo) + uniquePaths1(m, n - 1,memo));
        }
        return memo.get(key);
    }





}
