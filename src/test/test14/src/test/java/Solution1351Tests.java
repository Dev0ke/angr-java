import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1351Tests {
    private final Solution1351 solution1351 = new Solution1351();

    @Test
    public void example1() {
        int[][] grid = UtUtils.stringToInts2("[[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]");
        int expected = 8;
        Assertions.assertEquals(expected, solution1351.countNegatives(grid));
    }

    @Test
    public void example2() {
        int[][] grid = UtUtils.stringToInts2("[[3,2],[1,0]]");
        int expected = 0;
        Assertions.assertEquals(expected, solution1351.countNegatives(grid));
    }
}
