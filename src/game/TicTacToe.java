package game;

import java.util.Scanner;

public class TicTacToe {
    private static final char EMPTY = ' ';
    private static final char PLAYER_X = 'X';
    private static final char PLAYER_O = 'O';

    public static void main(String[] args) {
        char[][] board = new char[3][3];
        // Initialize board with empty spaces
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = EMPTY;
            }
        }

        Scanner scanner = new Scanner(System.in);
        char currentPlayer = PLAYER_X;
        while (true) {
            printBoard(board);
            System.out.println("Player " + currentPlayer + ", enter your move (row and column, 0-indexed):");
            int row = scanner.nextInt();
            int col = scanner.nextInt();

            // Validate move boundaries
            if (row < 0 || row >= 3 || col < 0 || col >= 3) {
                System.out.println("Invalid move. Try again.");
                continue;
            }

            // Check if cell is already occupied
            if (board[row][col] != EMPTY) {
                System.out.println("Cell already occupied. Try again.");
                continue;
            }

            // Place the player's mark
            board[row][col] = currentPlayer;

            // Check for win or tie
            if (hasWon(board, currentPlayer)) {
                printBoard(board);
                System.out.println("Player " + currentPlayer + " wins!");
                break;
            }
            if (isBoardFull(board)) {
                printBoard(board);
                System.out.println("The game is a tie!");
                break;
            }

            // Switch player
            currentPlayer = (currentPlayer == PLAYER_X) ? PLAYER_O : PLAYER_X;
        }

        scanner.close();
    }

    private static void printBoard(char[][] board) {
        System.out.println("Board:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);
                if (j < 2) {
                    System.out.print(" | ");
                }
            }
            System.out.println();
            if (i < 2) {
                System.out.println("---------");
            }
        }
    }

    private static boolean isBoardFull(char[][] board) {
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                if (board[i][j] == EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean hasWon(char[][] board, char player) {
        // Check rows
        for (int i = 0; i < 3; i++){
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) {
                return true;
            }
        }
        // Check columns
        for (int j = 0; j < 3; j++){
            if (board[0][j] == player && board[1][j] == player && board[2][j] == player) {
                return true;
            }
        }
        // Check diagonals
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
        }
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true;
        }
        return false;
    }
}
