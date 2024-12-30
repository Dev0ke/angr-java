import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2466Tests {
    private final Solution2466 solution2466 = new Solution2466();

    @Test
    public void example1() {
        int low = 3;
        int high = 3;
        int zero = 1;
        int one = 1;
        int expected = 8;
        Assertions.assertEquals(expected, solution2466.countGoodStrings(low, high, zero, one));
    }

    @Test
    public void example2() {
        int low = 2;
        int high = 3;
        int zero = 1;
        int one = 2;
        int expected = 5;
        Assertions.assertEquals(expected, solution2466.countGoodStrings(low, high, zero, one));
    }

    // 补充用例
    @Test
    public void example3() {
        // https://leetcode.cn/submissions/detail/381524908/
        // 溢出
        int low = 500;
        int high = 500;
        int zero = 5;
        int one = 2;
        int expected = 873327137;
        Assertions.assertEquals(expected, solution2466.countGoodStrings(low, high, zero, one));
    }
}
