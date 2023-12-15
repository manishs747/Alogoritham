package data_structure.graph.strcuty;

import java.util.List;

public class MinIslandCount {

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



    public static int minimumIsland(List<List<String>> grid) {
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
        int minIslandCount = 0;
        for (int i = 0 ; i < grid.length ;i++){
            for (int j = 0; j <grid[i].length ; j++) {
                if(grid[i][j] == '1'){
                    minIslandCount = Math.max(minIslandCount,dfs(grid, i ,j));
                }
            }
        }
        return minIslandCount;
    }

    public static int dfs(char[][] grid , int r , int c) {
        if(r >= grid.length || r < 0 || c >= grid[0].length || c < 0 || grid[r][c] == '0') return 0;
        grid[r][c] = '0';
        return 1+ dfs(grid,r+1,c)+ dfs(grid,r-1,c)+ dfs(grid,r,c+1)+ dfs(grid,r,c-1);
    }
}
