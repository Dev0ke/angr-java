import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution736Tests {
    private final Solution736 solution736 = new Solution736();

    @Test
    public void example1() {
        String expression = "(let x 2 (mult x (let x 3 y 4 (add x y))))";
        int expected = 14;
        Assertions.assertEquals(expected, solution736.evaluate(expression));
    }

    @Test
    public void example2() {
        String expression = "(let x 3 x 2 x)";
        int expected = 2;
        Assertions.assertEquals(expected, solution736.evaluate(expression));
    }

    @Test
    public void example3() {
        String expression = "(let x 1 y 2 x (add x y) (add x y))";
        int expected = 5;
        Assertions.assertEquals(expected, solution736.evaluate(expression));
    }
}