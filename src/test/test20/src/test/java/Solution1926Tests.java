import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1926Tests {
    private final Solution1926 solution1926 = new Solution1926();

    @Test
    public void example1() {
        char[][] maze = UtUtils.stringToChars2("""
                [["+","+",".","+"],[".",".",".","+"],["+","+","+","."]]
                """);
        int[] entrance = {1, 2};
        int expected = 1;
        Assertions.assertEquals(expected, solution1926.nearestExit(maze, entrance));
    }

    @Test
    public void example2() {
        char[][] maze = UtUtils.stringToChars2("""
                [["+","+","+"],[".",".","."],["+","+","+"]]
                """);
        int[] entrance = {1, 0};
        int expected = 2;
        Assertions.assertEquals(expected, solution1926.nearestExit(maze, entrance));
    }

    @Test
    public void example3() {
        char[][] maze = UtUtils.stringToChars2("""
                [[".","+"]]
                """);
        int[] entrance = {0, 0};
        int expected = -1;
        Assertions.assertEquals(expected, solution1926.nearestExit(maze, entrance));
    }
}
