import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2503Tests {
    private final Solution2503 solution2503 = new Solution2503();

    @Test
    public void example1() {
        int[][] grid = UtUtils.stringToInts2("[[1,2,3],[2,5,7],[3,5,1]]");
        int[] queries = {5, 6, 2};
        int[] expected = {5, 8, 1};
        Assertions.assertArrayEquals(expected, solution2503.maxPoints(grid, queries));
    }

    @Test
    public void example2() {
        int[][] grid = UtUtils.stringToInts2("[[5,2,1],[1,1,2]]");
        int[] queries = {3};
        int[] expected = {0};
        Assertions.assertArrayEquals(expected, solution2503.maxPoints(grid, queries));
    }
}
