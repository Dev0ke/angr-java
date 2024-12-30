import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1706Tests {
    private final Solution1706 solution1706 = new Solution1706();

    @Test
    public void example1() {
        int[][] grid = UtUtils.stringToInts2("[[1,1,1,-1,-1],[1,1,1,-1,-1],[-1,-1,-1,1,1],[1,1,1,1,-1],[-1,-1,-1,-1,-1]]");
        int[] expected = {1, -1, -1, -1, -1};
        Assertions.assertArrayEquals(expected, solution1706.findBall(grid));
    }

    @Test
    public void example2() {
        int[][] grid = UtUtils.stringToInts2("[[-1]]");
        int[] expected = {-1};
        Assertions.assertArrayEquals(expected, solution1706.findBall(grid));
    }

    @Test
    public void example3() {
        int[][] grid = UtUtils.stringToInts2("[[1,1,1,1,1,1],[-1,-1,-1,-1,-1,-1],[1,1,1,1,1,1],[-1,-1,-1,-1,-1,-1]]");
        int[] expected = {0, 1, 2, 3, 4, -1};
        Assertions.assertArrayEquals(expected, solution1706.findBall(grid));
    }
}
