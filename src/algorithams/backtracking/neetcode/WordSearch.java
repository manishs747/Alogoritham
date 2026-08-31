package algorithams.backtracking.neetcode;

import java.util.HashSet;
import java.util.Set;

/*
https://neetcode.io/problems/search-for-word/question?list=neetcode150
Complexity
Time: O(m × n × 4^L)
Space: O(L) recursion stack
 */
public class WordSearch {
    public static void main(String[] args) {
       char [][]  board = {
                       {'A','B','C','E'},
                       {'S','F','C','S'},
                       {'A','D','E','E'}
       };
         String word = "ABFS";
        System.out.println(exist(board,word));
    }

    public static boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
               if (exist(board,word,i,j,0)){
                   return true;
               }
            }
        }

        return false;
    }

    public static boolean exist(char[][] board, String word, int row, int col, int index) {
        if(word.length() == index) return true;
        if(  row < 0 || row >= board.length || col < 0 || col >= board[0].length || word.charAt(index) != board[row][col] || board[row][col] == '#') return  false;
        char temp = board[row][col];
        board[row][col] = '#';
        int [][] dfs = {{0,1},{1,0},{0,-1},{-1,0}};
        for (int[] d : dfs) {
            if (exist(board,word,row + d[0],col + d[1],index+1)) return true;
        }
        board[row][col] =  temp;
        return false;
    }
}
