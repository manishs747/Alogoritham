package data_structure.graph.strcuty;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

        List<List<String>> grid2 = List.of(
                List.of("W", "L", "W", "W", "W"),
                List.of("W", "L", "W", "W", "W"),
                List.of("W", "W", "W", "L", "W"),
                List.of("W", "W", "L", "L", "W"),
                List.of("L", "W", "W", "L", "L"),
                List.of("L", "L", "W", "W", "W")
        );

        //System.out.println(numIslands(grid));
        System.out.println(minimumIsland(grid2));
    }
    public static int minimumIsland(List<List<String>> grid) {
        int minCount = Integer.MAX_VALUE;
        Set<String> visited = new HashSet<>();
        for (int i = 0; i < grid.size() ; i++) {
            for (int j = 0; j < grid.get(0).size(); j++){
              int dfsCount = dfs1(grid,i,j,visited);
              if(dfsCount != 0)
                  minCount = Math.min(minCount,dfsCount);
            }
        }
        return minCount;
    }

    private static int dfs1(List<List<String>> grid, int i, int j, Set<String> visited) {
        if( i < 0 || i >= grid.size() || j < 0 || j >= grid.get(0).size() || grid.get(i).get(j).equals("W") || !visited.add(i+"_"+j)) return 0;
        return 1 + dfs1(grid,i+1,j,visited)+dfs1(grid,i-1,j,visited)+dfs1(grid,i,j+1,visited)+dfs1(grid,i,j-1,visited);
    }


    /*******************************************************************************************************/
    public static int minimumIsland2(List<List<String>> grid) {
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
