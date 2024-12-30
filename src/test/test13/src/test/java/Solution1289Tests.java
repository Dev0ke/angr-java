import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1289Tests {
    private final Solution1289 solution1289 = new Solution1289();

    @Test
    public void example1() {
        int[][] grid = UtUtils.stringToInts2("[[1,2,3],[4,5,6],[7,8,9]]");
        int expected = 13;
        Assertions.assertEquals(expected, solution1289.minFallingPathSum(grid));
        Assertions.assertEquals(expected, solution1289.minFallingPathSum2(grid));
    }

    @Test
    public void example2() {
        int[][] grid = UtUtils.stringToInts2("[[7]]");
        int expected = 7;
        Assertions.assertEquals(expected, solution1289.minFallingPathSum(grid));
        Assertions.assertEquals(expected, solution1289.minFallingPathSum2(grid));
    }
}
