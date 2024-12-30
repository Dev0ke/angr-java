import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution509Tests {
    private final Solution509 solution509 = new Solution509();

    @Test
    public void example1() {
        int n = 2;
        int expected = 1;
        Assertions.assertEquals(expected, solution509.fib(n));
        Assertions.assertEquals(expected, solution509.fib2(n));
    }

    @Test
    public void example2() {
        int n = 3;
        int expected = 2;
        Assertions.assertEquals(expected, solution509.fib(n));
        Assertions.assertEquals(expected, solution509.fib2(n));
    }

    @Test
    public void example3() {
        int n = 4;
        int expected = 3;
        Assertions.assertEquals(expected, solution509.fib(n));
        Assertions.assertEquals(expected, solution509.fib2(n));
    }
}
