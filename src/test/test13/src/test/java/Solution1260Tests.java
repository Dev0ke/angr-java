import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution1260Tests {
    private final Solution1260 solution1260 = new Solution1260();

    @Test
    public void example1() {
        int[][] grid = UtUtils.stringToInts2("[[1,2,3],[4,5,6],[7,8,9]]");
        int k = 1;
        List<List<Integer>> expected = UtUtils.stringToIntegerList2("[[9,1,2],[3,4,5],[6,7,8]]");
        Assertions.assertEquals(expected, solution1260.shiftGrid(grid, k));
    }

    @Test
    public void example2() {
        int[][] grid = UtUtils.stringToInts2("[[3,8,1,9],[19,7,2,5],[4,6,11,10],[12,0,21,13]]");
        int k = 4;
        List<List<Integer>> expected = UtUtils.stringToIntegerList2("[[12,0,21,13],[3,8,1,9],[19,7,2,5],[4,6,11,10]]");
        Assertions.assertEquals(expected, solution1260.shiftGrid(grid, k));
    }

    @Test
    public void example3() {
        int[][] grid = UtUtils.stringToInts2("[[1,2,3],[4,5,6],[7,8,9]]");
        int k = 9;
        List<List<Integer>> expected = UtUtils.stringToIntegerList2("[[1,2,3],[4,5,6],[7,8,9]]");
        Assertions.assertEquals(expected, solution1260.shiftGrid(grid, k));
    }
}