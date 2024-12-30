import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2846Tests {
    private final Solution2846 solution2846 = new Solution2846();

    @Test
    public void example1() {
        int n = 7;
        int[][] edges = UtUtils.stringToInts2("[[0,1,1],[1,2,1],[2,3,1],[3,4,2],[4,5,2],[5,6,2]]");
        int[][] queries = UtUtils.stringToInts2("[[0,3],[3,6],[2,6],[0,6]]");
        int[] expected = {0, 0, 1, 3};
        Assertions.assertArrayEquals(expected, solution2846.minOperationsQueries(n, edges, queries));
    }

    @Test
    public void example2() {
        int n = 8;
        int[][] edges = UtUtils.stringToInts2("[[1,2,6],[1,3,4],[2,4,6],[2,5,3],[3,6,6],[3,0,8],[7,0,2]]");
        int[][] queries = UtUtils.stringToInts2("[[4,6],[0,4],[6,5],[7,4]]");
        int[] expected = {1, 2, 2, 3};
        Assertions.assertArrayEquals(expected, solution2846.minOperationsQueries(n, edges, queries));
    }
}