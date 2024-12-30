import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution738Tests {
    private final Solution738 solution738 = new Solution738();

    @Test
    public void example1() {
        int n = 10;
        int expected = 9;
        Assertions.assertEquals(expected, solution738.monotoneIncreasingDigits(n));
    }

    @Test
    public void example2() {
        int n = 1234;
        int expected = 1234;
        Assertions.assertEquals(expected, solution738.monotoneIncreasingDigits(n));
    }

    @Test
    public void example3() {
        int n = 332;
        int expected = 299;
        Assertions.assertEquals(expected, solution738.monotoneIncreasingDigits(n));
    }

    // 补充用例
    @Test
    public void example4() {
        // https://leetcode.cn/submissions/detail/244662567/
        int n = 668841;
        int expected = 667999;
        Assertions.assertEquals(expected, solution738.monotoneIncreasingDigits(n));
    }
}