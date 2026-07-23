package company.google;


/**
 * https://leetcode.com/problems/number-of-islands/
 */
public class NumberOfInsland {


    private static final int[][] DIRS = {
            {1,0},
            {-1,0},
            {0,1},
            {0,-1}
    };


    public static void main(String[] args) {
       char [][] grid = {
               {'1','1','1','1','0'},
               {'1','1','0','1','0'},
               {'1','1','0','0','0'},
               {'0','0','0','0','0'}
       };

        System.out.println(numIslands(grid));
    }


    public static int  numIslands(char[][] grid) {
      int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '1'){
                    count++;
                    dfs(grid,i,j);
                }
            }
        }

      return count;
    }

    public static void dfs(char [][] grid, int i , int j){
        if(i < 0 || i >= grid.length  || j < 0 || j >= grid[0].length || grid[i][j] == '0') return;
        grid[i][j] = '0';
        for(int [] dir : DIRS){
            int newRow = i + dir[0];
            int newCol = j + dir[1];
            dfs(grid, newRow, newCol);
        }
    }
}
