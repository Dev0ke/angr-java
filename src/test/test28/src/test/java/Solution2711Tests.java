import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2711Tests {
    private final Solution2711 solution2711 = new Solution2711();

    @Test
    public void example1() {
        int[][] grid = UtUtils.stringToInts2("[[1,2,3],[3,1,5],[3,2,1]]");
        int[][] expected = UtUtils.stringToInts2("[[1,1,0],[1,0,1],[0,1,1]]");
        Assertions.assertArrayEquals(expected, solution2711.differenceOfDistinctValues(grid));
    }

    @Test
    public void example2() {
        int[][] grid = UtUtils.stringToInts2("[[1]]");
        int[][] expected = UtUtils.stringToInts2("[[0]]");
        Assertions.assertArrayEquals(expected, solution2711.differenceOfDistinctValues(grid));
    }
}