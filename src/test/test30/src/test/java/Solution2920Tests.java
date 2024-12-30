import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2920Tests {
    private final Solution2920 solution2920 = new Solution2920();

    @Test
    public void example1() {
        int[][] edges = UtUtils.stringToInts2("[[0,1],[1,2],[2,3]]");
        int[] coins = {10, 10, 3, 3};
        int k = 5;
        int expected = 11;
        Assertions.assertEquals(expected, solution2920.maximumPoints(edges, coins, k));
    }

    @Test
    public void example2() {
        int[][] edges = UtUtils.stringToInts2("[[0,1],[0,2]]");
        int[] coins = {8, 4, 4};
        int k = 0;
        int expected = 16;
        Assertions.assertEquals(expected, solution2920.maximumPoints(edges, coins, k));
    }

    // 补充用例
    @Test
    public void example3() {
        // https://leetcode.cn/problems/maximum-points-after-collecting-coins-from-all-nodes/submissions/478073684/
        // TLE
        String fileName = "solution2920-example3-input.txt";
        int[][] edges = UtUtils.loadingInts2(fileName, 0);
        int[] coins = UtUtils.loadingInts(fileName, 1);
        int k = UtUtils.loadingInt(fileName, 2);
        int expected = 1000000000;
        Assertions.assertEquals(expected, solution2920.maximumPoints2(edges, coins, k));
    }
}