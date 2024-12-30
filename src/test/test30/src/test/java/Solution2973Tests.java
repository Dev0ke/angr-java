import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2973Tests {
    private final Solution2973 solution2973 = new Solution2973();

    @Test
    public void example1() {
        int[][] edges = UtUtils.stringToInts2("[[0,1],[0,2],[0,3],[0,4],[0,5]]");
        int[] cost = {1, 2, 3, 4, 5, 6};
        long[] expected = {120, 1, 1, 1, 1, 1};
        Assertions.assertArrayEquals(expected, solution2973.placedCoins(edges, cost));
    }

    @Test
    public void example2() {
        int[][] edges = UtUtils.stringToInts2("[[0,1],[0,2],[1,3],[1,4],[1,5],[2,6],[2,7],[2,8]]");
        int[] cost = {1, 4, 2, 3, 5, 7, 8, -4, 2};
        long[] expected = {280, 140, 32, 1, 1, 1, 1, 1, 1};
        Assertions.assertArrayEquals(expected, solution2973.placedCoins(edges, cost));
    }

    @Test
    public void example3() {
        int[][] edges = UtUtils.stringToInts2("[[0,1],[0,2]]");
        int[] cost = {1, 2, -2};
        long[] expected = {0, 1, 1};
        Assertions.assertArrayEquals(expected, solution2973.placedCoins(edges, cost));
    }
}