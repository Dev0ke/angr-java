import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1515Tests {
    private final Solution1515 solution1515 = new Solution1515();
    // 与真实值误差在 10^-5之内的答案将被视作正确答案。
    private static final double DELTA = 1e-5;

    @Test
    public void example1() {
        int[][] positions = UtUtils.stringToInts2("[[0,1],[1,0],[1,2],[2,1]]");
        double expected = 4.00000;
        Assertions.assertEquals(expected, solution1515.getMinDistSum(positions), DELTA);
    }

    @Test
    public void example2() {
        int[][] positions = UtUtils.stringToInts2("[[1,1],[3,3]]");
        double expected = 2.82843;
        Assertions.assertEquals(expected, solution1515.getMinDistSum(positions), DELTA);
    }

    // 补充用例
    @Test
    public void example3() {
        // https://leetcode.cn/problems/best-position-for-a-service-centre/submissions/540297155
        int[][] positions = UtUtils.stringToInts2("[[2,2],[2,2],[2,2],[2,2],[2,2]]");
        double expected = 0.00000;
        Assertions.assertEquals(expected, solution1515.getMinDistSum(positions), DELTA);
    }
}