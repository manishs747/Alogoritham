package data_structure.arrays.matrix;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/valid-sudoku/description/
 */
public class ValidSudoku {

    public static void main(String[] args) {

        char [][] board = {{'1','2','.','.','3','.','.','.','.'},
                {'4','.','.','5','.','.','.','.','.'},
                {'.','9','8','.','.','.','.','.','3'},
                {'5','.','.','.','6','.','.','.','4'},
                {'.','.','.','8','.','3','.','.','5'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','.','.','.','.','.','2','.','.'},
                {'.','.','.','4','1','9','.','.','8'},
                {'.','.','.','.','8','.','.','7','9'}};

    }

    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> rowMap = new HashMap<>();
        Map<Integer, Set<Character>> colMap = new HashMap<>();
        Map<String, Set<Character>> matrixMap = new HashMap<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length ; j++) {
                char c = board[i][j];
                if(c == '.') continue;

                String mkey = i/3+"-"+j/3;
               if ((rowMap.computeIfAbsent(i,k-> new HashSet<>()).contains(c)) ||
                (colMap.computeIfAbsent(j,k-> new HashSet<>()).contains(c)) ||
                        (matrixMap.computeIfAbsent(mkey,k-> new HashSet<>()).contains(c))) return false;

                rowMap.get(i).add(c);
                colMap.get(j).add(c);
                matrixMap.get(mkey).add(c);
            }
        }

        return true;
    }
}
