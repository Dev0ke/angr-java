import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2561Tests {
    private final Solution2561 solution2561 = new Solution2561();

    @Test
    public void example1() {
        int[] basket1 = {4, 2, 2, 2};
        int[] basket2 = {1, 4, 1, 2};
        long expected = 1;
        Assertions.assertEquals(expected, solution2561.minCost(basket1, basket2));
    }

    @Test
    public void example2() {
        int[] basket1 = {2, 3, 4, 1};
        int[] basket2 = {3, 2, 5, 1};
        long expected = -1;
        Assertions.assertEquals(expected, solution2561.minCost(basket1, basket2));
    }

    // 补充用例
    @Test
    public void example3() {
        // https://leetcode.cn/submissions/detail/399558904/
        // 可以和最小的换
        int[] basket1 = {84, 80, 43, 8, 80, 88, 43, 14, 100, 88};
        int[] basket2 = {32, 32, 42, 68, 68, 100, 42, 84, 14, 8};
        long expected = 48;
        Assertions.assertEquals(expected, solution2561.minCost(basket1, basket2));
    }
}
