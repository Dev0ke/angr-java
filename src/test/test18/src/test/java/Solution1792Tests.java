import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1792Tests {
    private final Solution1792 solution1792 = new Solution1792();
    // 与标准答案误差范围在 10^-5 以内的结果都会视为正确结果。
    private static final double DELTA = 1e-5;

    @Test
    public void example1() {
        int[][] classes = UtUtils.stringToInts2("[[1,2],[3,5],[2,2]]");
        int extraStudents = 2;
        double expected = 0.78333;
        Assertions.assertEquals(expected, solution1792.maxAverageRatio(classes, extraStudents), DELTA);
    }

    @Test
    public void example2() {
        int[][] classes = UtUtils.stringToInts2("[[2,4],[3,9],[4,5],[2,10]]");
        int extraStudents = 4;
        double expected = 0.53485;
        Assertions.assertEquals(expected, solution1792.maxAverageRatio(classes, extraStudents), DELTA);
    }
}