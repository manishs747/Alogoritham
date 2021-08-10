package data_structure.arrays.matrix;


/**
 * https://leetcode.com/problems/check-if-move-is-legal/
 */
public class CheckMoveLegal {


    public static void main(String[] args) {
        char[][] arr = {{'B', 'B', 'B', '.', 'W', 'W', 'B', 'W'}, {'B', 'B', '.', 'B', '.', 'B', 'B', 'B'}, {'.', 'W', '.', '.', 'B', '.', 'B', 'W'}, {'B', 'W', '.', 'W', 'B', '.', 'B', '.'}, {'B', 'W', 'W', 'B', 'W', '.', 'B', 'B'}, {'.', '.', 'W', '.', '.', 'W', '.', '.'}, {'W', '.', 'W', 'B', '.', 'W', 'W', 'B'}, {'B', 'B', 'W', 'W', 'B', 'W', '.', '.'}};
        System.out.println(checkMove(arr, 5, 6, 'B'));
    }


    public static boolean checkMove(char[][] board, int rMove, int cMove, char color) {
        int[][] moves = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {-1, -1}, {1, -1}, {-1, 1}};
        for (int[] move : moves) {
            int row = rMove + move[0];
            int col = cMove + move[1];
            char prev = color;
            while (row >= 0 && row < 8 && col >= 0 && col < 8) {
                char cur = board[row][col];
                if ('.' == cur || (cur == color && cur == prev)) break;
                if (cur == color && cur != prev) return true;
                prev = cur;
                row += move[0];
                col += move[1];
            }
        }
        return false;
    }
}
