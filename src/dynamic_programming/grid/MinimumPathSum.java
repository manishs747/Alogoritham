package dynamic_programming.grid;


/**
 * https://leetcode.com/problems/minimum-path-sum/
 */
public class MinimumPathSum {

    public static void main(String[] args) {
        int grid [][] = {{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(minPathSum(grid));
    }



/***************************************************Top Down Solution************************************************/


    public static int minPathSum(int[][] grid) {
        return minPathSum(grid,0,0,new int [grid.length][grid[0].length]);
    }

    public static int minPathSum(int[][] grid , int row, int col,int [][] memo) {
        if(row == grid.length-1 && col == grid[0].length-1){
            return grid[row][col];
        }
        if(row >= grid.length || col >= grid[0].length){
            return Integer.MAX_VALUE;
        }
       // if(!isValid(row,col,grid.length,grid[0].length)) return Integer.MAX_VALUE;
       // if(isAtEnd(row,col,grid.length,grid[0].length)) return grid[row][col];
        if(memo[row][col] != 0){
          return memo[row][col];
        }
        return memo[row][col] =   grid[row][col] + Math.min(minPathSum(grid,row+1,col,memo), minPathSum(grid,row,col+1,memo));
    }

    private static boolean isAtEnd( int row, int col,int m ,int n ) {
        return row == m-1 && col == n-1 ;
    }

    private static boolean isValid( int row, int col,int m ,int n) {
        return row < m && col < n ;
    }

/***************************************************Bottom Up Solution Fast Solution************************************************/


    public static int minPathSumBottomUp(int[][] grid) {
        int R = grid.length;
        int C = grid[0].length;
        // Filling the values for the first column
        for (int i = 1; i < R; i++) {
            grid[i][0] = grid[i - 1][0] + grid[i][0];
        }
        // Filling the values for the first row
        for (int i = 1; i < C; i++) {
            grid[0][i] = grid[0][i - 1] + grid[0][i];
        }
        for (int i = 1; i < R; i++) {
            for (int j = 1; j < C; j++) {
                grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
            }
        }
        return grid[R - 1][C - 1];
    }

}
