package dynamic_programming.leetocde.UniquePath;

public class UniquePaths2 {

    public static void main(String[] args) {
       int [][] obstacleGrid = {{0,0,0},{0,1,0},{0,0,0}};
        System.out.println(uniquePathsWithObstacles(obstacleGrid)); //2
    }


    public static  int uniquePathsWithObstacles(int[][] obstacleGrid) {
        return uniquePathsWithObstacles(0,0,obstacleGrid ,new Integer[obstacleGrid.length][obstacleGrid[0].length]);
    }

    public static int uniquePathsWithObstacles(int row, int col,int[][] obstacleGrid, Integer [][] memo) {
        if(!isValid(row, col, obstacleGrid)) return 0;
        int m = obstacleGrid.length , n = obstacleGrid[0].length;
        if(row == m-1 && col == n-1) return 1;
        if(memo[row][col] != null) return memo[row][col];
        return memo[row][col] = uniquePathsWithObstacles(row+1, col, obstacleGrid,memo) + uniquePathsWithObstacles(row, col+1, obstacleGrid,memo);
    }

    private static boolean isValid(int row, int col, int[][] obstacleGrid) {
        int m = obstacleGrid.length , n = obstacleGrid[0].length;
        return row < m && col < n && obstacleGrid[row][col] == 0;
    }
}
