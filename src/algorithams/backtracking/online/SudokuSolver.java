package algorithams.backtracking.online;


import utils.ArrayUtils;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/***
 * https://leetcode.com/problems/sudoku-solver/?envType=problem-list-v2&envId=backtracking
 */
public class SudokuSolver {
    private static String ROW = "R-";
    private static String COL = "C-";

    private static String BOX = "B-";

    static int N = 9;
    static int[][] rows = new int[N][N + 1];
    static int [][] columns = new int[N][N + 1];
    static int[][] boxes = new int[N][N + 1];



    public static void main(String[] args) {

      char[][]  board = {
                          {'5','3','.','.','7','.','.','.','.'},
                          {'6','.','.','1','9','5','.','.','.'},
                          {'.','9','8','.','.','.','.','6','.'},
                          {'8','.','.','.','6','.','.','.','3'},
                          {'4','.','.','8','.','3','.','.','1'},
                          {'7','.','.','.','2','.','.','.','6'},
                          {'.','6','.','.','.','.','2','8','.'},
                          {'.','.','.','4','1','9','.','.','5'},
                          {'.','.','.','.','8','.','.','7','9'} };

        char[][]  boards =  {{'.','.','9','7','4','8','.','.','.'},
              {'7','.','.','.','.','.','.','.','.'},
              {'.','2','.','1','.','9','.','.','.'},
              {'.','.','7','.','.','.','2','4','.'},
              {'.','6','4','.','1','.','5','9','.'},
              {'.','9','8','.','.','.','3','.','.'},
              {'.','.','.','8','.','3','.','2','.'},
              {'.','.','.','.','.','.','.','.','6'},
              {'.','.','.','2','7','5','9','.','.'}};

        ArrayUtils.print(boards);
        //solveSudoku(board,new HashMap<>());
        solveSudoku(boards);
        System.out.println(" *********************************     ADVAITH   After CODING  *******************          ");
        ArrayUtils.print(boards);
    }

    public static void solveSudoku(char[][] board) {
        process(board);
        solveSudoku(board,0,0);
    }

    public static void process(char[][] board ){
        for (int i = 0; i < board.length ; i++) {
            for (int j = 0; j < board[0].length; j++) {
                char num = board[i][j];
                if(num != '.') {
                    addMemo(i, j, num);
                }
            }
        }
    }


    public static boolean solveSudoku(char[][] board , int row ,int col) {
        if (row >= board.length) return true;
        char num = board[row][col];
        int[] nextCell = getNextCell(row, col);
        if (num != '.')
            return solveSudoku(board, nextCell[0], nextCell[1]);
        else if (num == '.'){
            for (int i = 1; i <= 9; i++) {
                char candidate = (char) (i + '0');
                if(!isValid(candidate,row,col)) continue;
                board[row][col] = candidate;
                addMemo(row,col,candidate);
                if (solveSudoku(board,nextCell[0],nextCell[1])) return true;
                board[row][col] = '.';
                removeMemo(row,col,candidate);
            }
        }
        return false;
    }

    private static void addMemo(int row, int col, char num) {
        int digit = num - '0';  // convert char digit to int (e.g., '5' -> 5)
        rows[row][digit] = 1;
        columns[col][digit] = 1;
        boxes[getBox(row, col)][digit] = 1;
    }


    private static void removeMemo(int row, int col, char num) {
        int digit = num - '0';  // convert char digit to int (e.g., '5' -> 5)
        rows[row][digit] = 0;
        columns[col][digit] = 0;
        boxes[getBox(row, col)][digit] = 0;
    }



    private static boolean isValid(char ch, int r, int c) {
        int digit = ch - '0'; // convert char digit to int (e.g., '5' -> 5)
        return rows[r][digit] == 0 && columns[c][digit] == 0 && boxes[getBox(r, c)][digit] == 0;
    }


    public static int[] getNextCell(int row, int col) {
        if (col < 8) return new int[]{row, col + 1};
        return new int[]{row + 1, 0};
    }

    public static int getBox(int row, int col){
        return row/3*3+ col/3;
    }


    /**************************************************************************************************************/

    private static void removeMemo(int row, int col, Map<String, Set<Character>> memo, char num) {
        memo.computeIfAbsent(ROW + row, k -> new HashSet<>()).remove(num);
        memo.computeIfAbsent(COL + col, k -> new HashSet<>()).remove(num);
        memo.computeIfAbsent(BOX + getBox(row, col), k -> new HashSet<>()).remove(num);
    }

    private static void addMemo(int row, int col, Map<String, Set<Character>> memo, char num) {
        memo.computeIfAbsent(ROW + row, k -> new HashSet<>()).add(num);
        memo.computeIfAbsent(COL + col, k -> new HashSet<>()).add(num);
        memo.computeIfAbsent(BOX + getBox(row, col), k -> new HashSet<>()).add(num);
    }

    private static boolean isValidold(char ch, int r, int c, Map<String,Set<Character>> memo) {
        if(memo.getOrDefault(ROW+r,new HashSet<>()).contains(ch) ||memo.getOrDefault(COL+c,new HashSet<>()).contains(ch)
                || memo.getOrDefault(BOX+getBox(r,c),new HashSet<>()).contains(ch)) return false;
        return true;
    }




/*************************************************************************************************************************************/




}
