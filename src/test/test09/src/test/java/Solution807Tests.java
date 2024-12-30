import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution807Tests {
    private final Solution807 solution807 = new Solution807();

    @Test
    public void example1() {
        int[][] grid = UtUtils.stringToInts2("[[3,0,8,4],[2,4,5,7],[9,2,6,3],[0,3,1,0]]");
        int expected = 35;
        Assertions.assertEquals(expected, solution807.maxIncreaseKeepingSkyline(grid));
    }

    @Test
    public void example2() {
        int[][] grid = UtUtils.stringToInts2("[[0,0,0],[0,0,0],[0,0,0]]");
        int expected = 0;
        Assertions.assertEquals(expected, solution807.maxIncreaseKeepingSkyline(grid));
    }
}
