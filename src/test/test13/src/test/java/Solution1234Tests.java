import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1234Tests {
    private final Solution1234 solution1234 = new Solution1234();

    @Test
    public void example1() {
        String s = "QWER";
        int expected = 0;
        Assertions.assertEquals(expected, solution1234.balancedString(s));
    }

    @Test
    public void example2() {
        String s = "QQWE";
        int expected = 1;
        Assertions.assertEquals(expected, solution1234.balancedString(s));
    }

    @Test
    public void example3() {
        String s = "QQQW";
        int expected = 2;
        Assertions.assertEquals(expected, solution1234.balancedString(s));
    }

    @Test
    public void example4() {
        String s = "QQQQ";
        int expected = 3;
        Assertions.assertEquals(expected, solution1234.balancedString(s));
    }
}