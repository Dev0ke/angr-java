import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution827Tests {
    private final Solution827 solution827 = new Solution827();

    @Test
    public void example1() {
        int[][] grid = UtUtils.stringToInts2("[[1, 0], [0, 1]]");
        int expected = 3;
        Assertions.assertEquals(expected, solution827.largestIsland(grid));
    }

    @Test
    public void example2() {
        int[][] grid = UtUtils.stringToInts2("[[1, 1], [1, 0]]");
        int expected = 4;
        Assertions.assertEquals(expected, solution827.largestIsland(grid));
    }

    @Test
    public void example3() {
        int[][] grid = UtUtils.stringToInts2("[[1, 1], [1, 1]]");
        int expected = 4;
        Assertions.assertEquals(expected, solution827.largestIsland(grid));
    }
}