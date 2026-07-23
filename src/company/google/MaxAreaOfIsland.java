package company.google;

public class MaxAreaOfIsland {

    private static final int[][] DIRS = {
            {1,0},
            {-1,0},
            {0,1},
            {0,-1}
    };

    public static void main(String[] args) {
      int [][] grid = {{0,0,1,0,0,0,0,1,0,0,0,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,1,1,0,1,0,0,0,0,0,0,0,0},{0,1,0,0,1,1,0,0,1,0,1,0,0},{0,1,0,0,1,1,0,0,1,1,1,0,0},{0,0,0,0,0,0,0,0,0,0,1,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,0,0,0,0,0,0,1,1,0,0,0,0}};
      System.out.println(maxAreaOfIsland(grid));



    }
    public static int  maxAreaOfIsland(int[][] grid) {
       int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length ; j++) {
                if(grid[i][j] == 1){
                 max = Math.max(max,dfs(grid,i,j));
                }
            }
        }
        return max;
    }


    public static int dfs(int [][] grid , int i ,int j){
        if(i < 0 || i >= grid.length  || j < 0 || j >= grid[0].length || grid[i][j] == 0) return 0;
        int count  = 1;
        grid[i][j] = 0;
        for(int[] path : DIRS) {
            count += dfs(grid, path[0] + i ,path[1]+j);
        }
        return count;
    }
}
