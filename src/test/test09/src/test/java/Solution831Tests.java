import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution831Tests {
    private final Solution831 solution831 = new Solution831();

    @Test
    public void example1() {
        String s = "LeetCode@LeetCode.com";
        String expected = "l*****e@leetcode.com";
        Assertions.assertEquals(expected, solution831.maskPII(s));
    }

    @Test
    public void example2() {
        String s = "AB@qq.com";
        String expected = "a*****b@qq.com";
        Assertions.assertEquals(expected, solution831.maskPII(s));
    }

    @Test
    public void example3() {
        String s = "1(234)567-890";
        String expected = "***-***-7890";
        Assertions.assertEquals(expected, solution831.maskPII(s));
    }

    @Test
    public void example4() {
        String s = "86-(10)12345678";
        String expected = "+**-***-***-5678";
        Assertions.assertEquals(expected, solution831.maskPII(s));
    }
}
