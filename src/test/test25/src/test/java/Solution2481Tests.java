import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2481Tests {
    private final Solution2481 solution2481 = new Solution2481();

    @Test
    public void example1() {
        int n = 4;
        int expected = 2;
        Assertions.assertEquals(expected, solution2481.numberOfCuts(n));
    }

    @Test
    public void example2() {
        int n = 3;
        int expected = 3;
        Assertions.assertEquals(expected, solution2481.numberOfCuts(n));
    }

    // 补充用例
    @Test
    public void example3() {
        // https://leetcode.cn/submissions/detail/385120051/
        int n = 1;
        int expected = 0;
        Assertions.assertEquals(expected, solution2481.numberOfCuts(n));
    }
}
