import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution2146Tests {
    private final Solution2146 solution2146 = new Solution2146();

    @Test
    public void example1() {
        int[][] grid = UtUtils.stringToInts2("[[1,2,0,1],[1,3,0,1],[0,2,5,1]]");
        int[] pricing = {2, 5};
        int[] start = {0, 0};
        int k = 3;
        List<List<Integer>> expected = UtUtils.stringToIntegerList2("[[0,1],[1,1],[2,1]]");
        Assertions.assertEquals(expected, solution2146.highestRankedKItems(grid, pricing, start, k));
    }

    @Test
    public void example2() {
        int[][] grid = UtUtils.stringToInts2("[[1,2,0,1],[1,3,3,1],[0,2,5,1]]");
        int[] pricing = {2, 3};
        int[] start = {2, 3};
        int k = 2;
        List<List<Integer>> expected = UtUtils.stringToIntegerList2("[[2,1],[1,2]]");
        Assertions.assertEquals(expected, solution2146.highestRankedKItems(grid, pricing, start, k));
    }

    @Test
    public void example3() {
        int[][] grid = UtUtils.stringToInts2("[[1,1,1],[0,0,1],[2,3,4]]");
        int[] pricing = {2, 3};
        int[] start = {0, 0};
        int k = 3;
        List<List<Integer>> expected = UtUtils.stringToIntegerList2("[[2,1],[2,0]]");
        Assertions.assertEquals(expected, solution2146.highestRankedKItems(grid, pricing, start, k));
    }
}
