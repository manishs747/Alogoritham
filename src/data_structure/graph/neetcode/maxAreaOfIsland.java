package data_structure.graph.neetcode;


/**
 * https://leetcode.com/problems/max-area-of-island/description/
 */
public class maxAreaOfIsland {

    public static void main(String[] args) {
       int [][] grid = {{0,0,1,0,0,0,0,1,0,0,0,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,1,1,0,1,0,0,0,0,0,0,0,0},{0,1,0,0,1,1,0,0,1,0,1,0,0},{0,1,0,0,1,1,0,0,1,1,1,0,0},{0,0,0,0,0,0,0,0,0,0,1,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,0,0,0,0,0,0,1,1,0,0,0,0}};
        System.out.println(maxAreaOfIsland(grid)); //6
    }

    public static    int [][] paths = {{0,1},{0,-1},{1,0},{-1,0}};



    public  static int maxAreaOfIsland(int[][] grid) {
         int max = 0 ;
        for (int i = 0;i < grid.length ;i++) {
            for (int j = 0 ; j < grid[i].length ; j++){
                if(grid[i][j] == 1){
                 max = Math.max(max,dfs(grid,i,j));
                }
            }
        }
         return max;
    }


    public static int dfs(int [][] grid, int row, int col){
       if( row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == 0) return 0;
       grid[row][col] = 0;
       int count = 1;
        for (int [] path:paths) {
            count += dfs(grid,row + path[0],col + path[1]);
        }
       return count;
    }
}
