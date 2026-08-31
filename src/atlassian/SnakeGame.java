package atlassian;

import online.wallmart.Main;

import java.util.*;

public class SnakeGame implements ISnakeGame{


    private  static Map<String,int []> DIR = new HashMap<>();
        static {
            DIR.put("U",new int[]{-1,0});
            DIR.put("D",new int[]{1,0});
            DIR.put("R",new int[]{0,1});
            DIR.put("L",new int[]{0,1});
        }

    private final  Deque<int []> snake = new LinkedList<>();
    private final Set<String> occupied = new HashSet<>()  ;
    private int moves = 0;
    private boolean isGameOver = false;

    public SnakeGame(){

        snake.addFirst(new int[] {0,2});
        snake.addLast(new int[] {0,1});// 0,0 , 0,1 , 0,2
        snake.addLast(new int[]{0,0});
        occupied.add(getPath(new int[] {0,2}));
        occupied.add(getPath(new int[] {0,1}));
        occupied.add(getPath(new int[] {0,0}));
    }





    @Override
    public void moveSnake(String snakeDirection) {
        if(isGameOver){
            return;
        }
        if(!DIR.containsKey(snakeDirection)){
            throw new IllegalArgumentException("Invalid snake direction");
        }
        moves++;
        int [] head = snake.getFirst();
        int [] dir = DIR.get(snakeDirection);
        int [] newHead = new int[]{head[0]+dir[0],head[1] + dir[1]};
        String newHeadPosition = getPath(newHead);

        if(occupied.contains(newHeadPosition)) {
            isGameOver = true;
            return;
        }


        //remove the tail if not grown
        if(moves % 5 != 0) {// reminder != 0
          int [] tail  = snake.removeLast();
          occupied.remove(getPath(tail));
        }

        //add new head
        snake.addFirst(newHead);
        occupied.add(newHeadPosition);
        System.out.println("SNAKE SIZE:"+snake.size());
    }

    private boolean isValidMove(String newHeadPosition) {

        return true;
    }

    @Override
    public boolean isGameOver() {
        return isGameOver;
    }


    public String getPath(int [] path){
        return  path[0]+"_"+path[1];
    }
}
