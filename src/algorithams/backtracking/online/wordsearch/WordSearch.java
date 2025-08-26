package algorithams.backtracking.online.wordsearch;

import java.util.Set;

/**
 * https://leetcode.com/problems/word-search-ii/description/
 */
public class WordSearch {


    public static void main(String[] args) {
       char [][] board = {
                          {'A','B','C','E'},
                          {'S','F','E','S'},
                          {'A','D','E','E'}
                         };
       String word = "ABCESEEEFS";
        System.out.println(exist(board,word));
    }


    public static boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length ; i++) {
            for (int j = 0; j < board[0].length; j++)
                  if(backtrack(board,word,0,i,j))
                      return true;
        }
        return false;
    }


    public static boolean backtrack(char[][] board, String word, int index, int row , int col) {
        char key = '#';
        if(row < 0 || row > board.length-1 || col < 0 || col > board[0].length-1  || board[row][col] == key || board[row][col] != word.charAt(index)) return false;
        if(index == word.length()-1) return true;
        char tmp = board[row][col];
        board[row][col] = key;
        int [][] paths = {{0,1},{1,0},{0,-1},{-1,0}};
        for (int [] path : paths) {
            if(backtrack(board,word,index+1,row + path[0],col+path[1])) return true;
        }
        board[row][col] = tmp;
        return false;
    }



    private static boolean backtrackothetr(char[][] board, int i, int j, String word, int index) {
        if (index == word.length())
            return true;
        // Check boundaries and current character match
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(index)) {
            return false;
        }

        // Mark current cell as visited by replacing it with a sentinel character
        char temp = board[i][j];
        board[i][j] = '#';

        // Explore all 4 directions
        boolean found = backtrackothetr(board, i + 1, j, word, index + 1) ||
                backtrackothetr(board, i - 1, j, word, index + 1) ||
                backtrackothetr(board, i, j + 1, word, index + 1) ||
                backtrackothetr(board, i, j - 1, word, index + 1);

        // Restore the original value (backtrack)
        board[i][j] = temp;
        return found;
    }



    private static boolean check(char[][] board, int i, int j, int index, String word , Set<String> memo) {
        if(index == word.length()) return true;
        String key = i+"_"+j;
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || word.charAt(index) != board[i][j] || memo.contains(key)) return false;
        memo.add(key);
        boolean found =  check(board,i+1,j,index+1,word,memo) || check(board,i-1,j,index+1,word,memo)|| check(board,i,j+1,index+1,word,memo)||check(board,i,j-1,index+1,word,memo);
        memo.remove(key);
        return found;
    }


}
