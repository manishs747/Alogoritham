package data_structure.arrays.matrix;



/**
 *Prob: https://leetcode.com/problems/number-of-islands/
 * Solution: https://www.youtube.com/watch?v=U6-X_QOwPcs&list=PLU_sdQYzUj2keVENTP0a5rdykRSgg9Wp-&index=2&t=0s
 *
 */
public class NumberOfIslands {


    public static void main(String[] args) {
      char [][] grid =   {  //3
              {'1','1','0','0','0'},
              {'1','1','0','0','0'},
              {'0','0','1','0','0'},
              {'0','0','0','1','1'}
        };
        System.out.println(numIslands(grid));
    }



    public static int numIslands(char[][] grid) {
         int iLandCount = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length ; j++) {
                if(grid[i][j] == '1'){
                    iLandCount++;
                    process(grid,i,j);
                }
            }
        }
        return iLandCount;
    }

    private static void process(char[][] grid,int r,int c) {
        if(r < 0 || r >= grid.length || c < 0 || c >= grid[0].length) return;
        if (grid[r][c] == '0') return;
        grid[r][c] = '0';
        process(grid,r+1,c);
        process(grid,r,c+1);
        process(grid,r-1,c);
        process(grid,r,c-1);
    }
}
