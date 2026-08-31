package data_structure.arrays.matrix.premium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class NumberOfIsland2 {

    public static void main(String[] args) {
       int m = 3, n = 3;
       int [][] positions = {{0,0},{0,1},{1,2},{2,1}};
        System.out.println(numIslands2(3,3,positions));
    }

    private static int  [][]  paths = {{1,0},{-1,0},{0,1},{0,-1}};
    public static List<Integer> numIslands2(int m, int n, int[][] positions) {
        int [][] grid = new int[m][n];
        int count = 0;
       List<Integer> result = new ArrayList<>();
        for (int [] position : positions){
            grid[position[0]][position[1]] = 2;
            if(isIland(grid,position[0], position[1])){
                count +=1;
            }
            grid[position[0]][position[1]] = 1;
            result.add(count);
        }
        return result;
    }

    private static boolean isIland(int [][] grid , int r ,int c) {
        if(r < 0 || r >= grid.length || c < 0 || c >= grid[0].length  || grid[r][c] == 0)  return true;
        if(grid[r][c] == 1) return false;
        boolean res = true;
        for ( int [] path : paths){
            res  = res && isIland(grid,r+path[0],c+path[1]);
        }
        return res ;
    }
}
