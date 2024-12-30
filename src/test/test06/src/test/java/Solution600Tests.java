import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution600Tests {
    private final Solution600 solution600 = new Solution600();

    @Test
    public void example1() {
        int n = 5;
        int expected = 5;
        Assertions.assertEquals(expected, solution600.findIntegers(n));
    }

    @Test
    public void example2() {
        int n = 1;
        int expected = 2;
        Assertions.assertEquals(expected, solution600.findIntegers(n));
    }

    @Test
    public void example3() {
        int n = 2;
        int expected = 3;
        Assertions.assertEquals(expected, solution600.findIntegers(n));
    }
}