import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2603Tests {
    private final Solution2603 solution2603 = new Solution2603();

    @Test
    public void example1() {
        int[] coins = {1, 0, 0, 0, 0, 1};
        int[][] edges = UtUtils.stringToInts2("[[0,1],[1,2],[2,3],[3,4],[4,5]]");
        int expected = 2;
        Assertions.assertEquals(expected, solution2603.collectTheCoins(coins, edges));
    }

    @Test
    public void example2() {
        int[] coins = {0, 0, 0, 1, 1, 0, 0, 1};
        int[][] edges = UtUtils.stringToInts2("[[0,1],[0,2],[1,3],[1,4],[2,5],[5,6],[5,7]]");
        int expected = 2;
        Assertions.assertEquals(expected, solution2603.collectTheCoins(coins, edges));
    }
}