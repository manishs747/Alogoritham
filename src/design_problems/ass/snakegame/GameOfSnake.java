package design_problems.ass.snakegame;

import java.util.*;

public class GameOfSnake {

    private static final Map<String, int[]> DIRS = Map.of(
            "U", new int[]{-1, 0},
            "D", new int[]{1, 0},
            "L", new int[]{0, -1},
            "R", new int[]{0, 1}
    );

    private Deque<int[]> snake;        // snake body
    private Set<String> occupied;      // for O(1) collision detection
    private int moves;                 // total moves
    private boolean gameOver;


    public GameOfSnake() {
        snake = new LinkedList<>();
        occupied = new HashSet<>();
        moves = 0;
        gameOver = false;

        // Initial snake of size 3 at row 0, columns [0,1,2]
        snake.addFirst(new int[]{0, 2});
        snake.addLast(new int[]{0, 1});
        snake.addLast(new int[]{0, 0});
        occupied.add("0_2");
        occupied.add("0_1");
        occupied.add("0_0");
    }


    public void moveSnake(String direction) {
        if (gameOver) return;
        moves++;
        int[] head = snake.getFirst();
        int[] dir = DIRS.get(direction);
        int newRow = head[0] + dir[0];
        int newCol = head[1] + dir[1];
        String newPos = newRow + "_" + newCol;

        // Check self collision
        if (occupied.contains(newPos)) { //position of tail check is missed
            gameOver = true;
            return;
        }

        // Growth rule: every 5th move → grow (don’t remove tail)
        if (moves % 5 != 0) {
            int[] tail = snake.removeLast();
            occupied.remove(tail[0] + "_" + tail[1]);
        }

        // Add new head
        snake.addFirst(new int[]{newRow, newCol});
        occupied.add(newPos);
    }










}
