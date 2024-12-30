import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1844Tests {
    private final Solution1844 solution1844 = new Solution1844();

    @Test
    public void example1() {
        String s = "a1c1e1";
        String expected = "abcdef";
        Assertions.assertEquals(expected, solution1844.replaceDigits(s));
    }

    @Test
    public void example2() {
        String s = "a1b2c3d4e";
        String expected = "abbdcfdhe";
        Assertions.assertEquals(expected, solution1844.replaceDigits(s));
    }
}