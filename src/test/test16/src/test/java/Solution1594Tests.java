import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1594Tests {
    private final Solution1594 solution1594 = new Solution1594();

    @Test
    public void example1() {
        int[][] grid = UtUtils.stringToInts2("[[-1,-2,-3],[-2,-3,-3],[-3,-3,-2]]");
        int expected = -1;
        Assertions.assertEquals(expected, solution1594.maxProductPath(grid));
    }

    @Test
    public void example2() {
        int[][] grid = UtUtils.stringToInts2("[[1,-2,1],[1,-2,1],[3,-4,1]]");
        int expected = 8;
        Assertions.assertEquals(expected, solution1594.maxProductPath(grid));
    }

    @Test
    public void example3() {
        int[][] grid = UtUtils.stringToInts2("[[1,3],[0,-4]]");
        int expected = 0;
        Assertions.assertEquals(expected, solution1594.maxProductPath(grid));
    }
}