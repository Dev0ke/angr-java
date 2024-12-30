import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1277Tests {
    private final Solution1277 solution1277 = new Solution1277();

    @Test
    public void example1() {
        int[][] matrix = {
                {0, 1, 1, 1},
                {1, 1, 1, 1},
                {0, 1, 1, 1}
        };
        int expected = 15;
        Assertions.assertEquals(expected, solution1277.countSquares(matrix));
    }

    @Test
    public void example2() {
        int[][] matrix = {
                {1, 0, 1},
                {1, 1, 0},
                {1, 1, 0}
        };
        int expected = 7;
        Assertions.assertEquals(expected, solution1277.countSquares(matrix));
    }
}
