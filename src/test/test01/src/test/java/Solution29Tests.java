import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution29Tests {
    private final Solution29 solution29 = new Solution29();

    @Test
    public void example1() {
        int dividend = 15;
        int divisor = 2;
        int expected = 7;
        Assertions.assertEquals(expected, solution29.divide(dividend, divisor));
    }

    @Test
    public void example2() {
        int dividend = 7;
        int divisor = -3;
        int expected = -2;
        Assertions.assertEquals(expected, solution29.divide(dividend, divisor));
    }
}
