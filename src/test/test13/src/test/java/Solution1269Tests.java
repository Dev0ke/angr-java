import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1269Tests {
    private final Solution1269 solution1269 = new Solution1269();

    @Test
    public void example1() {
        int steps = 3;
        int arrLen = 2;
        int expected = 4;
        Assertions.assertEquals(expected, solution1269.numWays(steps, arrLen));
    }

    @Test
    public void example2() {
        int steps = 2;
        int arrLen = 4;
        int expected = 2;
        Assertions.assertEquals(expected, solution1269.numWays(steps, arrLen));
    }

    @Test
    public void example3() {
        int steps = 4;
        int arrLen = 2;
        int expected = 8;
        Assertions.assertEquals(expected, solution1269.numWays(steps, arrLen));
    }

    // 补充用例
    @Test
    public void example4() {
        // https://leetcode.cn/submissions/detail/362509012/
        // MLE
        int steps = 430;
        int arrLen = 148488;
        int expected = 525833932;
        Assertions.assertEquals(expected, solution1269.numWays(steps, arrLen));
    }
}
