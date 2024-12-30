import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1106Tests {
    private final Solution1106 solution1106 = new Solution1106();

    @Test
    public void example1() {
        String expression = "!(f)";
        Assertions.assertTrue(solution1106.parseBoolExpr(expression));
    }

    @Test
    public void example2() {
        String expression = "|(f,t)";
        Assertions.assertTrue(solution1106.parseBoolExpr(expression));
    }

    @Test
    public void example3() {
        String expression = "&(t,f)";
        Assertions.assertFalse(solution1106.parseBoolExpr(expression));
    }

    @Test
    public void example4() {
        String expression = "|(&(t,f,t),!(t))";
        Assertions.assertFalse(solution1106.parseBoolExpr(expression));
    }
}
