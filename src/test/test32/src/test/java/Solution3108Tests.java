import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3108Tests {
    private final Solution3108 solution3108 = new Solution3108();

    @Test
    public void example1() {
        int n = 5;
        int[][] edges = UtUtils.stringToInts2("[[0,1,7],[1,3,7],[1,2,1]]");
        int[][] query = UtUtils.stringToInts2("[[0,3],[3,4]]");
        int[] expected = {1, -1};
        Assertions.assertArrayEquals(expected, solution3108.minimumCost(n, edges, query));
    }

    @Test
    public void example2() {
        int n = 3;
        int[][] edges = UtUtils.stringToInts2("[[0,2,7],[0,1,15],[1,2,6],[1,2,1]]");
        int[][] query = UtUtils.stringToInts2("[[1,2]]");
        int[] expected = {0};
        Assertions.assertArrayEquals(expected, solution3108.minimumCost(n, edges, query));
    }
}