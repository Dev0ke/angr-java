import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1878Tests {
    private final Solution1878 solution1878 = new Solution1878();

    @Test
    public void example1() {
        int[][] grid = UtUtils.stringToInts2("[[3,4,5,1,3],[3,3,4,2,3],[20,30,200,40,10],[1,5,5,4,1],[4,3,2,2,5]]");
        int[] expected = {228, 216, 211};
        Assertions.assertArrayEquals(expected, solution1878.getBiggestThree(grid));
    }

    @Test
    public void example2() {
        int[][] grid = UtUtils.stringToInts2("[[1,2,3],[4,5,6],[7,8,9]]");
        int[] expected = {20, 9, 8};
        Assertions.assertArrayEquals(expected, solution1878.getBiggestThree(grid));
    }

    @Test
    public void example3() {
        int[][] grid = UtUtils.stringToInts2("[[7,7,7]]");
        int[] expected = {7};
        Assertions.assertArrayEquals(expected, solution1878.getBiggestThree(grid));
    }
}