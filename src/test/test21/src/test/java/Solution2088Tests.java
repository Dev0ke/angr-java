import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2088Tests {
    private final Solution2088 solution2088 = new Solution2088();

    @Test
    public void example1() {
        int[][] grid = UtUtils.stringToInts2("[[0,1,1,0],[1,1,1,1]]");
        int expected = 2;
        Assertions.assertEquals(expected, solution2088.countPyramids(grid));
    }

    @Test
    public void example2() {
        int[][] grid = UtUtils.stringToInts2("[[1,1,1],[1,1,1]]");
        int expected = 2;
        Assertions.assertEquals(expected, solution2088.countPyramids(grid));
    }

    @Test
    public void example3() {
        int[][] grid = UtUtils.stringToInts2("[[1,0,1],[0,0,0],[1,0,1]]");
        int expected = 0;
        Assertions.assertEquals(expected, solution2088.countPyramids(grid));
    }

    @Test
    public void example4() {
        int[][] grid = UtUtils.stringToInts2("[[1,1,1,1,0],[1,1,1,1,1],[1,1,1,1,1],[0,1,0,0,1]]");
        int expected = 13;
        Assertions.assertEquals(expected, solution2088.countPyramids(grid));
    }
}
