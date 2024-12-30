import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution837Tests {
    private final Solution837 solution837 = new Solution837();
    // 与实际答案误差不超过 10^-5 的答案将被视为正确答案。
    private static final double DELTA = 1e-5;

    @Test
    public void example1() {
        int n = 10;
        int k = 1;
        int maxPts = 10;
        double expected = 1.00000;
        Assertions.assertEquals(expected, solution837.new21Game(n, k, maxPts), DELTA);
    }

    @Test
    public void example2() {
        int n = 6;
        int k = 1;
        int maxPts = 10;
        double expected = 0.60000;
        Assertions.assertEquals(expected, solution837.new21Game(n, k, maxPts), DELTA);
    }

    @Test
    public void example3() {
        int n = 21;
        int k = 17;
        int maxPts = 10;
        double expected = 0.73278;
        Assertions.assertEquals(expected, solution837.new21Game(n, k, maxPts), DELTA);
    }
}
