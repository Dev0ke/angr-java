import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1615Tests {
    private final Solution1615 solution1615 = new Solution1615();

    @Test
    public void example1() {
        int n = 4;
        int[][] roads = UtUtils.stringToInts2("[[0,1],[0,3],[1,2],[1,3]]");
        int expected = 4;
        Assertions.assertEquals(expected, solution1615.maximalNetworkRank(n, roads));
    }

    @Test
    public void example2() {
        int n = 5;
        int[][] roads = UtUtils.stringToInts2("[[0,1],[0,3],[1,2],[1,3],[2,3],[2,4]]");
        int expected = 5;
        Assertions.assertEquals(expected, solution1615.maximalNetworkRank(n, roads));
    }

    @Test
    public void example3() {
        int n = 8;
        int[][] roads = UtUtils.stringToInts2("[[0,1],[1,2],[2,3],[2,4],[5,6],[5,7]]");
        int expected = 5;
        Assertions.assertEquals(expected, solution1615.maximalNetworkRank(n, roads));
    }
}
