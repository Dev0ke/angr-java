import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1293Tests {
    private final Solution1293 solution1293 = new Solution1293();

    @Test
    public void example1() {
        int[][] grid = {
                {0, 0, 0},
                {1, 1, 0},
                {0, 0, 0},
                {0, 1, 1},
                {0, 0, 0}
        };
        int k = 1;
        int expected = 6;
        Assertions.assertEquals(expected, solution1293.shortestPath(grid, k));
    }

    @Test
    public void example2() {
        int[][] grid = {
                {0, 1, 1},
                {1, 1, 1},
                {1, 0, 0}
        };
        int k = 1;
        int expected = -1;
        Assertions.assertEquals(expected, solution1293.shortestPath(grid, k));
    }
}
