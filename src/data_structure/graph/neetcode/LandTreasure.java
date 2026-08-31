package data_structure.graph.neetcode;


import utils.ArrayUtils;

import java.util.Arrays;

/**
 * https://neetcode.io/problems/islands-and-treasure?list=neetcode150
 * -1 water , dont do anything return  and for anything else current value is greater than new value replace it
 */
public class LandTreasure {

    public static void main(String[] args) {
        int [][] input =  {
                {2147483647,-1,0,2147483647},
                {2147483647,2147483647,2147483647,-1},
                {2147483647,-1,2147483647,-1},
                {0,-1,2147483647,2147483647}
        };


 /*       Output: [
  [3,-1,0,1],
  [2,2,1,-1],
  [1,-1,2,-1],
  [0,-1,3,4]
]
*/

        //System.out.println(MAX);
        islandsAndTreasure(input);
        ArrayUtils.print(input);
    }

    public static final int MAX = Integer.MAX_VALUE;

    public static void islandsAndTreasure(int[][] grid) {
        for (int i = 0; i < grid.length ; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 0){
                   dfs(grid,i,j,0);
                }
            }
        }
    }

    private static void dfs(int[][] grid, int i, int j, int curVal) {
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j]== -1) return;
        if(grid[i][j] <= curVal) return;
        if(grid[i][j] > curVal)
            grid[i][j] = curVal;
        curVal++;
        int [][] paths = {{1,0},{-1,0},{0,1},{0,-1}};
        for (int [] path : paths){
           dfs(grid,i+path[0],j+path[1],curVal);
        }
    }


}
