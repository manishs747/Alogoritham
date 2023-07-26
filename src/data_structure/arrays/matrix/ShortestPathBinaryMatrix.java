package data_structure.arrays.matrix;


/**
 * https://leetcode.com/problems/shortest-path-in-binary-matrix/description/
 */
public class ShortestPathBinaryMatrix {

    public static void main(String[] args) {
       int [][] grid = {{0,0,0,1},{0,0,0,1},{0,1,1,1},{1,0,0,0}};
        System.out.println(shortestPathBinaryMatrix(grid));
    }

    public static int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if(grid[0][0] == 1 || grid[n-1][n-1] == 1 ) return -1;
        int count = 1;
        int x = 0,y = 0;
        while(x != n-1 && y != n-1){
           if(grid[x+1][y+1] == 0 ){
               x += 1;
               y +=1;
               count++;
               continue;
           }
            if(grid[x][y+1] == 0 ){
                y +=1;
                count++;
                continue;
            }
            if(grid[x+1][y] == 0 ){
                x += 1;
                count++;
                continue;
            }
            return -1;
        }
        return count;
    }
}
