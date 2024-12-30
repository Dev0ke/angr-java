import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1938Tests {
    private final Solution1938 solution1938 = new Solution1938();

    @Test
    public void example1() {
        int[] parents = {-1, 0, 1, 1};
        int[][] queries = UtUtils.stringToInts2("[[0,2],[3,2],[2,5]]");
        int[] expected = {2, 3, 7};
        Assertions.assertArrayEquals(expected, solution1938.maxGeneticDifference(parents, queries));
    }

    @Test
    public void example2() {
        int[] parents = {3, 7, -1, 2, 0, 7, 0, 2};
        int[][] queries = UtUtils.stringToInts2("[[4,6],[1,15],[0,5]]");
        int[] expected = {6, 14, 7};
        Assertions.assertArrayEquals(expected, solution1938.maxGeneticDifference(parents, queries));
    }
}