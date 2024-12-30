import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1572Tests {
    private final Solution1572 solution1572 = new Solution1572();

    @Test
    public void example1() {
        int[][] mat = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int expected = 25;
        Assertions.assertEquals(expected, solution1572.diagonalSum(mat));
    }

    @Test
    public void example2() {
        int[][] mat = {
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 1}
        };
        int expected = 8;
        Assertions.assertEquals(expected, solution1572.diagonalSum(mat));
    }

    @Test
    public void example3() {
        int[][] mat = {
                {5}
        };
        int expected = 5;
        Assertions.assertEquals(expected, solution1572.diagonalSum(mat));
    }
}
