import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2232Tests {
    private final Solution2232 solution2232 = new Solution2232();

    @Test
    public void example1() {
        String expression = "247+38";
        String expected = "2(47+38)";
        Assertions.assertEquals(expected, solution2232.minimizeResult(expression));
    }

    @Test
    public void example2() {
        String expression = "12+34";
        String expected = "1(2+3)4";
        Assertions.assertEquals(expected, solution2232.minimizeResult(expression));
    }

    @Test
    public void example3() {
        String expression = "999+999";
        String expected = "(999+999)";
        Assertions.assertEquals(expected, solution2232.minimizeResult(expression));
    }
}
