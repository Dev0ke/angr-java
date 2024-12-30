import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution994Tests {
    private final Solution994 solution994 = new Solution994();

    @Test
    public void example1() {
        int[][] grid = UtUtils.stringToInts2("[[2,1,1],[1,1,0],[0,1,1]]");
        int expected = 4;
        Assertions.assertEquals(expected, solution994.orangesRotting(grid));
    }

    @Test
    public void example2() {
        int[][] grid = UtUtils.stringToInts2("[[2,1,1],[0,1,1],[1,0,1]]");
        int expected = -1;
        Assertions.assertEquals(expected, solution994.orangesRotting(grid));
    }

    @Test
    public void example3() {
        int[][] grid = UtUtils.stringToInts2("[[0,2]]");
        int expected = 0;
        Assertions.assertEquals(expected, solution994.orangesRotting(grid));
    }
}
