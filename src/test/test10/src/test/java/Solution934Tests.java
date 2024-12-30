import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution934Tests {
    private final Solution934 solution934 = new Solution934();

    @Test
    public void example1() {
        int[][] grid = UtUtils.stringToInts2("[[0,1],[1,0]]");
        int expected = 1;
        Assertions.assertEquals(expected, solution934.shortestBridge(grid));
    }

    @Test
    public void example2() {
        int[][] grid = UtUtils.stringToInts2("[[0,1,0],[0,0,0],[0,0,1]]");
        int expected = 2;
        Assertions.assertEquals(expected, solution934.shortestBridge(grid));
    }

    @Test
    public void example3() {
        int[][] grid = UtUtils.stringToInts2("[[1,1,1,1,1],[1,0,0,0,1],[1,0,1,0,1],[1,0,0,0,1],[1,1,1,1,1]]");
        int expected = 1;
        Assertions.assertEquals(expected, solution934.shortestBridge(grid));
    }
}
