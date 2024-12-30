import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution840Tests {
    private final Solution840 solution840 = new Solution840();

    @Test
    public void example1() {
        int[][] grid = {
                {4, 3, 8, 4},
                {9, 5, 1, 9},
                {2, 7, 6, 2}
        };
        int expected = 1;
        Assertions.assertEquals(expected, solution840.numMagicSquaresInside(grid));
    }

    // 补充用例
    @Test
    public void example2() {
        int[][] grid = {
                {1, 8, 6},
                {10, 5, 0},
                {4, 2, 9}
        };
        int expected = 0;
        Assertions.assertEquals(expected, solution840.numMagicSquaresInside(grid));
    }

    @Test
    public void example3() {
        int[][] grid = {
                {5, 5, 5},
                {5, 5, 5},
                {5, 5, 5}
        };
        int expected = 0;
        Assertions.assertEquals(expected, solution840.numMagicSquaresInside(grid));
    }
}
