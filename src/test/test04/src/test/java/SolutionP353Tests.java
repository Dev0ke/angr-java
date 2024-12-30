import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP353Tests {
    @Test
    public void example1() {
        int width = 3;
        int height = 2;
        int[][] food = UtUtils.stringToInts2("[[1, 2], [0, 1]]");

        SolutionP353.SnakeGame snakeGame = new SolutionP353.SnakeGame(width, height, food);
        // 返回 0
        Assertions.assertEquals(0, snakeGame.move("R"));
        // 返回 0
        Assertions.assertEquals(0, snakeGame.move("D"));
        // 返回 1 ，蛇吃掉了第一个食物，同时第二个食物出现在 (0, 1)
        Assertions.assertEquals(1, snakeGame.move("R"));
        // 返回 1
        Assertions.assertEquals(1, snakeGame.move("U"));
        // 返回 2 ，蛇吃掉了第二个食物，没有出现更多食物
        Assertions.assertEquals(2, snakeGame.move("L"));
        // 返回 -1 ，蛇与边界相撞，游戏结束
        Assertions.assertEquals(-1, snakeGame.move("U"));
    }
}
