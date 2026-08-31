package data_structure.arrays.matrix;

public class NumberOfIslandNew {

    public static void main(String[] args) {
        char [][] grid =   {  //3
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };
        System.out.println(numIslands(grid));
    }

    private static int  [][]  paths = {{1,0},{-1,0},{0,1},{0,-1}};

    public static int numIslands(char[][] grid) {
        int count = 0;
        for(int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '1') {
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private static void dfs(char[][] grid, int i, int j) {
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0') return ;
        grid[i][j] = '0';
        for ( int [] path : paths){
            dfs(grid,i+path[0],j+path[1]);
        }
    }


}
