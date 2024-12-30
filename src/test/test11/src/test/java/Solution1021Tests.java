import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1021Tests {
    private final Solution1021 solution1021 = new Solution1021();

    @Test
    public void example1() {
        String s = "(()())(())";
        String expected = "()()()";
        Assertions.assertEquals(expected, solution1021.removeOuterParentheses(s));
    }

    @Test
    public void example2() {
        String s = "(()())(())(()(()))";
        String expected = "()()()()(())";
        Assertions.assertEquals(expected, solution1021.removeOuterParentheses(s));
    }

    @Test
    public void example3() {
        String s = "()()";
        String expected = "";
        Assertions.assertEquals(expected, solution1021.removeOuterParentheses(s));
    }
}