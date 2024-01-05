package data_structure.graph.leetcode;

import utils.ArrayUtils;

import java.util.HashSet;
import java.util.Set;

public class SurroundedRegions {

    public static void main(String[] args) {
      char [][]  board ={
              {'X','O','X'},
              {'O','X','O'},
              {'X','O','X'}
      };
        solve(board);
        ArrayUtils.prints(board);
    }

    public  static void solve(char[][] board) {
        Set<String> visited = new HashSet<>();
        for (int i = 0; i < board[0].length ; i++){
            dfs(board,0,i,visited);
            dfs(board,board.length-1,i,visited);
        }
        for (int i = 1; i < board.length-1 ; i++){
            dfs(board,i,0,visited);
            dfs(board,i,board[0].length-1,visited);
        }
        for (int i = 0; i < board.length ; i++) {
            for (int j = 0; j < board[0].length ; j++) {
                if(board[i][j] == 'O' && !visited.contains(i+"_"+j)) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private static void dfs(char[][] board, int i, int j, Set<String> visited) {
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length ||board[i][j] == 'X' ||!visited.add(i+"_"+j)) return ;
        dfs(board,i+1,j,visited);
        dfs(board,i-1,j,visited);
        dfs(board,i,j+1,visited) ;
        dfs(board,i,j-1,visited);
    }
}
