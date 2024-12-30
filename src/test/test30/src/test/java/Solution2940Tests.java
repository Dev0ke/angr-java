import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2940Tests {
    private final Solution2940 solution2940 = new Solution2940();

    @Test
    public void example1() {
        int[] heights = {6, 4, 8, 5, 2, 7};
        int[][] queries = UtUtils.stringToInts2("[[0,1],[0,3],[2,4],[3,4],[2,2]]");
        int[] expected = {2, 5, -1, 5, 2};
        Assertions.assertArrayEquals(expected, solution2940.leftmostBuildingQueries(heights, queries));
    }

    @Test
    public void example2() {
        int[] heights = {5, 3, 8, 2, 6, 1, 4, 6};
        int[][] queries = UtUtils.stringToInts2("[[0,7],[3,5],[5,2],[3,0],[1,6]]");
        int[] expected = {7, 6, -1, 4, 6};
        Assertions.assertArrayEquals(expected, solution2940.leftmostBuildingQueries(heights, queries));
    }
}