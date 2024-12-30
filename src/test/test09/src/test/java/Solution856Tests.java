import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution856Tests {
    private final Solution856 solution856 = new Solution856();

    @Test
    public void example1() {
        String s = "()";
        int expected = 1;
        Assertions.assertEquals(expected, solution856.scoreOfParentheses(s));
    }

    @Test
    public void example2() {
        String s = "(())";
        int expected = 2;
        Assertions.assertEquals(expected, solution856.scoreOfParentheses(s));
    }

    @Test
    public void example3() {
        String s = "()()";
        int expected = 2;
        Assertions.assertEquals(expected, solution856.scoreOfParentheses(s));
    }

    @Test
    public void example4() {
        String s = "(()(()))";
        int expected = 6;
        Assertions.assertEquals(expected, solution856.scoreOfParentheses(s));
    }
}
