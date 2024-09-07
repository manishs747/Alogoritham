package data_structure.arrays.matrix;

public class IslandPerimeter {

    public static void main(String[] args) {

        int [][] arr = {
                            {0,1,0,0},
                            {1,1,1,0},
                            {0,1,0,0},
                            {1,1,0,0}
        };
      int [][]  arr1 = {{1}};
        System.out.println(islandPerimeter(arr1));  // 16

    }


    public static int islandPerimeter(int[][] grid) {
        int sum = 0;
        for (int i = 0; i < grid.length ; i++) {
            for (int j = 0; j < grid[0].length ; j++) {
                if(grid[i][j] == 1){
                    sum += process(grid,i,j);
                }
            }
        }
        return sum;
    }


    public static int  process(int [][] grid,int i , int j){
        int sum = 0;
        int [][] arr = {{0,1},{0,-1},{1,0},{-1,0}};
        for (int [] ar:arr) {
            int r =i+ ar[0],c =j+ar[1];
            sum += r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == 0 ? 1 : 0;
        }
        return sum;
    }





}
