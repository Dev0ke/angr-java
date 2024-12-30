import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution964Tests {
    private final Solution964 solution964 = new Solution964();

    @Test
    public void example1() {
        int x = 3;
        int target = 19;
        int expected = 5;
        Assertions.assertEquals(expected, solution964.leastOpsExpressTarget(x, target));
    }

    @Test
    public void example2() {
        int x = 5;
        int target = 501;
        int expected = 8;
        Assertions.assertEquals(expected, solution964.leastOpsExpressTarget(x, target));
    }

    @Test
    public void example3() {
        int x = 100;
        int target = 100000000;
        int expected = 3;
        Assertions.assertEquals(expected, solution964.leastOpsExpressTarget(x, target));
    }

    // 补充用例
    @Test
    public void example4() {
        // https://leetcode.cn/problems/least-operators-to-express-number/submissions/520376769/
        int x = 2;
        int target = 180500064;
        int expected = 158;
        Assertions.assertEquals(expected, solution964.leastOpsExpressTarget(x, target));
    }
}