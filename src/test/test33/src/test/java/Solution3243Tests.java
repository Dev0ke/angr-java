import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3243Tests {
    private final Solution3243 solution3243 = new Solution3243();

    @Test
    public void example1() {
        int n = 5;
        int[][] queries = UtUtils.stringToInts2("[[2, 4], [0, 2], [0, 4]]");
        int[] expected = {3, 2, 1};
        Assertions.assertArrayEquals(expected, solution3243.shortestDistanceAfterQueries(n, queries));
    }

    @Test
    public void example2() {
        int n = 4;
        int[][] queries = UtUtils.stringToInts2("[[0, 3], [0, 2]]");
        int[] expected = {1, 1};
        Assertions.assertArrayEquals(expected, solution3243.shortestDistanceAfterQueries(n, queries));
    }
}