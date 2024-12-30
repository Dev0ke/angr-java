import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution2732Tests {
    private final Solution2732 solution2732 = new Solution2732();

    @Test
    public void example1() {
        int[][] grid = UtUtils.stringToInts2("[[0,1,1,0],[0,0,0,1],[1,1,1,1]]");
        List<Integer> expected = List.of(0, 1);
        Assertions.assertEquals(expected, solution2732.goodSubsetofBinaryMatrix(grid));
    }

    @Test
    public void example2() {
        int[][] grid = UtUtils.stringToInts2("[[0]]");
        List<Integer> expected = List.of(0);
        Assertions.assertEquals(expected, solution2732.goodSubsetofBinaryMatrix(grid));
    }

    @Test
    public void example3() {
        int[][] grid = UtUtils.stringToInts2("[[1,1,1],[1,1,1]]");
        List<Integer> expected = List.of();
        Assertions.assertEquals(expected, solution2732.goodSubsetofBinaryMatrix(grid));
    }
}