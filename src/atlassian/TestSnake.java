package atlassian;

public class TestSnake {

    public final static String  UP = "U";
    public final static String  DOWN = "D";
    public final static String  LEFT = "U";
    public final static String  RIGHT = "U";

    public static void main(String[] args) {
        ISnakeGame snakeGame = new SnakeGame();
        testSizeInc(snakeGame);


        //game over scenario
        //after five move size should be 6

    }

    private static void testSizeInc(ISnakeGame snakeGame) {
        snakeGame.moveSnake(UP);//3
        System.out.println(snakeGame.isGameOver());
        snakeGame.moveSnake(UP);
        System.out.println(snakeGame.isGameOver());
        snakeGame.moveSnake(UP);
        System.out.println(snakeGame.isGameOver());
        snakeGame.moveSnake(UP);
        System.out.println(snakeGame.isGameOver());
        snakeGame.moveSnake(UP);//4
        System.out.println(snakeGame.isGameOver());
    }
}
