package algorithams.backtracking;


/*
https://leetcode.com/problems/path-with-maximum-gold/
 */
public class MaximumGold {


    public static void main(String[] args) {
        int [][] arr = {
                        {0,6,0},
                        {5,8,7},
                        {0,9,0}
                       };

        System.out.println(getMaximumGold(arr));

    }


    public static int getMaximumGold(int[][] grid) {
        int result = 0;
        for (int i = 0; i < grid.length ; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                result = Math.max(result,getMaximumGold(grid,i,j));
            }
        }
        return result;
    }
    public static int getMaximumGold(int[][] grid , int row , int col ){
        if(row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] == 0) return 0;
        int curGold = grid[row][col];
        grid[row][col] = 0 ;
        int maxGold = 0;
        int [][] paths = {{0,1},{1,0},{0,-1},{-1,0}};
        for (int[] path:paths) {
            maxGold = Math.max(maxGold,getMaximumGold(grid,row+path[0],col+path[1]));
        }
        grid[row][col] = curGold;
        return curGold+maxGold;
    }
}
