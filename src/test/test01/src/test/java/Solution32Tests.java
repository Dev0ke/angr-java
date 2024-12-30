import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution32Tests {
    private final Solution32 solution32 = new Solution32();

    @Test
    public void example1() {
        String s = "(()";
        int expected = 2;
        Assertions.assertEquals(expected, solution32.longestValidParentheses(s));
    }

    @Test
    public void example2() {
        String s = ")()())";
        int expected = 4;
        Assertions.assertEquals(expected, solution32.longestValidParentheses(s));
    }

    @Test
    public void example3() {
        String s = "";
        int expected = 0;
        Assertions.assertEquals(expected, solution32.longestValidParentheses(s));
    }
}
