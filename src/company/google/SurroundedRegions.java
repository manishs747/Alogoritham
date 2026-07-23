package company.google;

public class SurroundedRegions {

    private static final int[][] DIRS = {
            {1,0},
            {-1,0},
            {0,1},
            {0,-1}
    };

    public static void main(String[] args) {
       char [][] board = {
               {'X','X','X','X'},
               {'X','O','O','X'},
               {'X','X','O','X'},
               {'X','O','X','X'}
       };

       // Output: [["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
    }

    public static void solve(char[][] board) {
      // iterate row
        int firstRow = 0, lastRow = board.length-1;
        for(int col = 0;col < board[0].length;col++){
            if(board[firstRow][col] == 'O') dfs(board,firstRow,col);
            if(board[lastRow][col] == 'O')dfs(board,lastRow,col);
        }
        int firstCol = 0, lastCol = board[0].length-1;
        //iterate col
        for (int row = 1; row < board.length-1; row++) {
            if(board[row][firstCol] == 'O') dfs(board,row,firstCol);
            if(board[row][lastCol] == 'O')dfs(board,row,lastCol);
        }

        //change all O to X
        changeVal(board,'O','X');

        // change all # to O
        changeVal(board,'#','O');
    }

    public static void changeVal(char[][] board , char org , char newChar){
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length ; j++) {
                if(board[i][j] == org){
                    board[i][j] = newChar;
                }
            }
        }
    }

    public static void dfs(char [][] board, int row,int col){
        if(row < 0 || row >= board.length  || col < 0 || col >= board[0].length || board[row][col] != 'O') return;
        board[row][col] = '#';
        for(int [] dir : DIRS){
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            dfs(board, newRow, newCol);
        }
    }

}
