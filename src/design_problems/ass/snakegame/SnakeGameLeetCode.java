package design_problems.ass.snakegame;


import java.util.*;

/**
 * https://leetcode.com/problems/design-snake-game/
 */
public class SnakeGameLeetCode {

    public static void main(String[] args) {
       // ["SnakeGame","move","move","move","move","move","move"]
        //[[3,2,[[1,2],[0,1]]],["R"],["D"],["R"],["U"],["L"],["U"]]
        //[null, 0, 0, 1, 1, 2, -1]

        SnakeGameLeetCode snakeGameLeetCode = new SnakeGameLeetCode(3,2, new int[][]{{1,2},{0,1}});
        System.out.println(snakeGameLeetCode.move("R"));
        System.out.println(snakeGameLeetCode.move("D"));
        System.out.println(snakeGameLeetCode.move("R"));
        System.out.println(snakeGameLeetCode.move("U"));
        System.out.println(snakeGameLeetCode.move("L"));
        System.out.println(snakeGameLeetCode.move("U"));
    }

    public static Map<String,int[]> DIRS = new HashMap<>();
    static {
        DIRS.put("R",new int[]{0,1});
        DIRS.put("L",new int[]{0,-1});
        DIRS.put("U",new int[]{-1,0});
        DIRS.put("D",new int[]{1,0});
    }

    private final int [][] food;
    int foodPointer ;

    LinkedList<int[]> snakeQueue = new LinkedList<>();
    Set<String>  snakeSet = new HashSet<>();
    //private int[] head; // explicit head pointer
    private  final int ROW ,COL ;
    int score = 0;


    public SnakeGameLeetCode(int width, int height, int[][] food) {
        ROW = height;
        COL = width;
        snakeQueue.add(new int[]{0, 0});
        this.food = food;
        foodPointer = 0;
        snakeSet.add(posToStr(new int[]{0, 0}));
    }

    public int move(String direction) {
        if(score == -1)  return  -1;

        int [] curHead = this.snakeQueue.peekFirst();
        // compute new head
        int[] dir = DIRS.get(direction);
        int nr = curHead[0] + dir[0];
        int nc = curHead[1] + dir[1];
        int[] newHead = new int[]{nr, nc};

        //as it get removed from head //first
       if(!isValidGame(newHead)) {
           return -1;
       }


       if( isEatFood(newHead) ){ //eats
           foodPointer++;
       }else{
           //remove tail
           int[] tail = snakeQueue.removeLast();
           snakeSet.remove(posToStr(tail));
       }

        //add new head
        snakeSet.add(posToStr(newHead));
        snakeQueue.addFirst(newHead);
        return  snakeQueue.size()-1;
    }


    private String posToStr(int[] pos) {
        return pos[0] + "_" + pos[1];
    }


/// get first will prev
    private boolean isValidGame(int[] pos) {
        int r = pos[0], c = pos[1];
        if (r >= ROW || r < 0 || c >= COL || c < 0) return false;
        String posStr = posToStr(pos);
        String tailStr = posToStr(snakeQueue.getLast());
        if (snakeSet.contains(posStr) && !posStr.equals(tailStr)) {
            return false;
        }
        return true;
    }

    private boolean isEatFood(int[] pos) {
        return foodPointer < food.length && food[foodPointer][0] == pos[0] && food[foodPointer][1] == pos[1];
    }

}
