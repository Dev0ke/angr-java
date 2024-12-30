import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP2137Tests {
    private final SolutionP2137 solutionP2137 = new SolutionP2137();
    // 如果你的答案和标准答案的误差不超过 10-5，那么答案将被通过。
    private static final double DELTA = 1e-5;

    @Test
    public void example1() {
        int[] buckets = {1, 2, 7};
        int loss = 80;
        double expected = 2.00000;
        Assertions.assertEquals(expected, solutionP2137.equalizeWater(buckets, loss), DELTA);
    }

    @Test
    public void example2() {
        int[] buckets = {2, 4, 6};
        int loss = 50;
        double expected = 3.50000;
        Assertions.assertEquals(expected, solutionP2137.equalizeWater(buckets, loss), DELTA);
    }

    @Test
    public void example3() {
        int[] buckets = {3, 3, 3, 3};
        int loss = 40;
        double expected = 3.00000;
        Assertions.assertEquals(expected, solutionP2137.equalizeWater(buckets, loss), DELTA);
    }
}