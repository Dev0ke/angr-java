import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1392Tests {
    private final Solution1392 solution1392 = new Solution1392();

    @Test
    public void example1() {
        String s = "level";
        String expected = "l";
        Assertions.assertEquals(expected, solution1392.longestPrefix(s));
        Assertions.assertEquals(expected, solution1392.longestPrefix2(s));
    }

    @Test
    public void example2() {
        String s = "ababab";
        String expected = "abab";
        Assertions.assertEquals(expected, solution1392.longestPrefix(s));
        Assertions.assertEquals(expected, solution1392.longestPrefix2(s));
    }

    // 补充用例
    @Test
    public void example3() {
        // https://leetcode.cn/submissions/detail/233529365/
        // 暴力法 TLE
        String s = UtUtils.loadingString("solution1392-example3-input.txt", 0);
        String expected = UtUtils.loadingString("solution1392-example3-output.txt", 0);
        Assertions.assertEquals(expected, solution1392.longestPrefix(s));
        Assertions.assertEquals(expected, solution1392.longestPrefix2(s));
    }

    @Test
    public void example4() {
        // https://leetcode.cn/submissions/detail/352749323/
        String s = "a";
        String expected = "";
        Assertions.assertEquals(expected, solution1392.longestPrefix(s));
        Assertions.assertEquals(expected, solution1392.longestPrefix2(s));
    }
}
