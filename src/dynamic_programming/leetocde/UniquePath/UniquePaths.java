package dynamic_programming.leetocde.UniquePath;


/**
 * https://leetcode.com/problems/unique-paths/description/
 */
public class UniquePaths {

    public static void main(String[] args) {
        int m = 3 ,n = 7 ; //28
        System.out.println(uniquePaths(3,7));
    }

    public static int uniquePaths(int m, int n) {
        return uniquePaths(0,0,m , n,new Integer[m][n]);
    }

    public static int uniquePaths(int row, int col,int m, int n , Integer [][] memo) {
        if(!isValid(row, col, m, n)) return 0;
        if(row == m-1 && col == n-1) return 1;
        if(memo[row][col] != null) return memo[row][col];
        return memo[row][col] = uniquePaths(row+1, col, m, n,memo) + uniquePaths(row, col+1, m, n,memo);
    }

    private static boolean isValid(int row, int col, int m, int n) {
        return row < m && col < n;
    }


}
