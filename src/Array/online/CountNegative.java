package Array.online;

public class CountNegative {

    public static void main(String[] args) {
   /* int[][] grid = {
                {4, 3, 2, -1},
                {3, 2, 1, -1},
                {1, 1, -1, -2},
                {-1, -1, -2, -3},
        };*/



      int[][] grid = {
                {3,2},
                {1,0}
        };


        System.out.println(countNegatives(grid));

    }


    public static int countNegatives(int[][] grid) {
        int RM = grid.length;
        if (RM == 0) return 0;
        int CM = grid[0].length;
        int count = 0;
        for (int r = 0; r < RM; r++) {
            for (int c = 0; c < CM; c++) {
                if ( grid[r][c] < 0) {
                    CM = c;
                }else{
                    count++;
                }
            }
        }
        return grid.length * grid[0].length - count;
    }
}
