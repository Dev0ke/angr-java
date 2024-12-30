import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution695Tests {
    private final Solution695 solution695 = new Solution695();

    @Test
    public void example1() {
        int[][] grid = {
                {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}
        };
        int expected = 6;
        Assertions.assertEquals(expected, solution695.maxAreaOfIsland(grid));
    }

    @Test
    public void example2() {
        int[][] grid = {
                {0, 0, 0, 0, 0, 0, 0, 0}
        };
        int expected = 0;
        Assertions.assertEquals(expected, solution695.maxAreaOfIsland(grid));
    }
}
