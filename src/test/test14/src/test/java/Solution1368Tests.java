import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1368Tests {
    private final Solution1368 solution1368 = new Solution1368();

    @Test
    public void example1() {
        int[][] grid = UtUtils.stringToInts2("[[1,1,1,1],[2,2,2,2],[1,1,1,1],[2,2,2,2]]");
        int expected = 3;
        Assertions.assertEquals(expected, solution1368.minCost(grid));
        Assertions.assertEquals(expected, solution1368.minCost2(grid));
    }

    @Test
    public void example2() {
        int[][] grid = UtUtils.stringToInts2("[[1,1,3],[3,2,2],[1,1,4]]");
        int expected = 0;
        Assertions.assertEquals(expected, solution1368.minCost(grid));
        Assertions.assertEquals(expected, solution1368.minCost2(grid));
    }

    @Test
    public void example3() {
        int[][] grid = UtUtils.stringToInts2("[[1,2],[4,3]]");
        int expected = 1;
        Assertions.assertEquals(expected, solution1368.minCost(grid));
        Assertions.assertEquals(expected, solution1368.minCost2(grid));
    }

    @Test
    public void example4() {
        int[][] grid = UtUtils.stringToInts2("[[2,2,2],[2,2,2]]");
        int expected = 3;
        Assertions.assertEquals(expected, solution1368.minCost(grid));
        Assertions.assertEquals(expected, solution1368.minCost2(grid));
    }

    @Test
    public void example5() {
        int[][] grid = UtUtils.stringToInts2("[[4]]");
        int expected = 0;
        Assertions.assertEquals(expected, solution1368.minCost(grid));
        Assertions.assertEquals(expected, solution1368.minCost2(grid));
    }
}
