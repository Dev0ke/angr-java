import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3081Tests {
    private final Solution3081 solution3081 = new Solution3081();

    @Test
    public void example1() {
        String s = "???";
        String expected = "abc";
        Assertions.assertEquals(expected, solution3081.minimizeStringValue(s));
    }

    @Test
    public void example2() {
        String s = "a?a?";
        String expected = "abac";
        Assertions.assertEquals(expected, solution3081.minimizeStringValue(s));
    }

    // 补充用例
    @Test
    public void example3() {
        // https://leetcode.cn/problems/replace-question-marks-in-string-to-minimize-its-value/submissions/512810070/
        String s = "abcdefghijklmnopqrstuvwxy??";
        String expected = "abcdefghijklmnopqrstuvwxyaz";
        Assertions.assertEquals(expected, solution3081.minimizeStringValue(s));
    }
}