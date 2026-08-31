package data_structure.graph.neetcode;


/**
 * https://neetcode.io/problems/count-number-of-islands?list=neetcode150
 */
public class NoIsland {

    public static void main(String[] args) {

        char [][] paths =
                {
                        {'0','1','1','1','0'},
                        {'0','1','0','1','0'},
                        {'1','1','0','0','0'},
                        {'0','0','0','0','0'}
                }
                ;


        System.out.println(numIslands(paths));
    }

    public static int numIslands(char[][] grid) {
        int count = 0;
        for(int i = 0; i < grid.length ; i++){
            for (int j = 0; j < grid[0].length ;j++){
                if(grid[i][j] == '1'){
                    count++;
                    dfs(grid,i,j);
                }
            }
        }
        return count;
    }

    private static void dfs(char[][] grid, int i, int j) {
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j]== '0') return;
        grid[i][j] = '0';
        int [][] paths = {{1,0},{-1,0},{0,1},{0,-1}};
        for (int [] path : paths){
             dfs(grid,i + path[0],j +path[1]);
        }
    }
}
