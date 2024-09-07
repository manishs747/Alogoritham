package data_structure.arrays.matrix;


import utils.ArrayUtils;

/**
 * https://leetcode.com/problems/game-of-life/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class GameLife {

    public static void main(String[] args) {
       int [][] board = {  {0,1,0},
                           {0,0,1},
                           {1,1,1},
                           {0,0,0}
       };
        //Output: [[0,0,0],[1,0,1],[0,1,1],[0,1,0]]
        ArrayUtils.print(board);
        System.out.println("After PRINT");
        gameOfLife(board);
        ArrayUtils.print(board);
    }

    public  static void gameOfLife(int[][] board) {
        int R = board.length, C = board[0].length;
        int [][] dummy = new int[R][C];
        for(int r = 0 ; r < R ; r++) {
            for (int c = 0; c < C; c++) {
                dummy[r][c] = board[r][c];
            }
        }



        for(int r = 0 ; r < R ; r++){
            for (int c = 0; c < C; c++) {
                int lc = getLiveCount(dummy,r,c,R,C);
                int cur = board[r][c];
                if(cur == 1){
                    cur = lc < 2 || lc > 3 ? 0 : cur;
                }else{
                  cur = lc == 3 ? 1 : cur;
                }
                board[r][c] = cur;
            }
        }
    }

    private static int getLiveCount(int[][] board, int r, int c,int R,int C) {
         int [][] movement = { {-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
         int count = 0;
        for (int i = 0; i < movement.length; i++) {
            int r1 = r + movement[i][0] , c1 = c + movement[i][1];
            if(r1 >= 0 && r1 < R && c1 >= 0 && c1 < C){
                count += board[r1][c1];
            }
        }
         return count;
    }
}
