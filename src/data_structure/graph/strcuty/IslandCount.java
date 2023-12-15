package data_structure.graph.strcuty;


import java.util.ArrayList;
import java.util.List;

/**
 * https://www.structy.net/problems/island-count
 * https://leetcode.com/problems/number-of-islands/description/
 * https://www.youtube.com/watch?v=tWVWeAqZ0WU&t=5982s
 */
public class IslandCount {

    public static void main(String[] args) {
           char [][] grid =
                   {
                           {'1','1','0','0','0'},
                           {'1','1','0','0','0'},
                           {'0','0','1','0','0'},
                           {'0','0','0','1','1'}
                   }
           ;

           System.out.println(numIslands(grid));
    }

    public static int islandCount(List<List<String>> grid) {
        char [][] gridArr = new char[grid.size()][grid.get(0).size()];
        for (int i = 0 ; i < grid.size() ;i++) {
            List<String> list = grid.get(i);
            for (int j = 0; j < list.size(); j++) {
                gridArr[i][j] = list.get(j).equals("W") ? '0': '1';
            }
        }
       return numIslands(gridArr);
    }





    public static int numIslands(char[][] grid) {
        int count = 0;
            for (int i = 0 ; i < grid.length ;i++){
                for (int j = 0; j <grid[i].length ; j++) {
                    if(grid[i][j] == '1'){
                        count++;
                        process(grid, i ,j);
                    }
                }
            }
        return count;
    }

    public static void process(char[][] grid , int r , int c) {
        if(r >= grid.length || r < 0 || c >= grid[0].length || c < 0 || grid[r][c] == '0') return;
        grid[r][c] = '0';
        process(grid,r+1,c);
        process(grid,r-1,c);
        process(grid,r,c+1);
        process(grid,r,c-1);
    }
}
