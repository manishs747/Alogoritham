package data_structure.graph.neetcode;


import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/number-of-islands/description/
 */
public class NumberOfIsland {

    public static int [][] paths = {{0,1},{0,-1},{1,0},{-1,0}};

    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        System.out.println(numIslands(grid));
    }


    public static int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length ; j++) {
                if(grid[i][j] == '1'){
                    count++;
                    //dfs(grid,i,j);
                    bfs(grid,i,j);
                }
            }
        }
        return count;
    }
    private static void bfs(char[][] grid, int r, int c) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{r,c});
        grid[r][c] = '0';
        while (!queue.isEmpty()){
            int[] current = queue.remove();
            int row = current[0] , col = current[1];
            for (int [] path:paths) {
                int nr =  row + path[0], nc =  col + path[1];
                if(nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length && grid[nr][nc] == '1'){
                    queue.add(new int[]{nr,nc});
                    grid[nr][nc] = '0';
                }
            }
        }
    }



    private static void dfs(char[][] grid, int i, int j) {
       if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0') return;
       grid[i][j] = '0';
        for (int [] path:paths) {
            dfs(grid,i+path[0],j+path[1]);
        }
    }
}
