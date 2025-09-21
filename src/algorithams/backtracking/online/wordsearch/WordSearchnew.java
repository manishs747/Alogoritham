package algorithams.backtracking.online.wordsearch;

public class WordSearchnew {


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

    private static boolean backtrack(char[][] board, String word, int index, int row, int col) {
         if(row < 0 || row >= board.length || col < 0 || col >= board[0].length  || board[row][col] != word.charAt(index) ||board[row][col] == '*' ) return false;
         if(index == word.length()-1) return true;
         char tmp = board[row][col];
         board[row][col] = '*';
        int [][] paths = {{0, 1},{0,-1},{1,0},{-1,0}};
        for (int [] path:paths)
            if( backtrack(board,word,index+1,row+path[0],col+path[1])) return true;
         board[row][col] = tmp;
        return false;
    }


}
