import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution829Tests {
    private final Solution829 solution829 = new Solution829();

    @Test
    public void example1() {
        int n = 5;
        int expected = 2;
        Assertions.assertEquals(expected, solution829.consecutiveNumbersSum(n));
    }

    @Test
    public void example2() {
        int n = 9;
        int expected = 3;
        Assertions.assertEquals(expected, solution829.consecutiveNumbersSum(n));
    }

    @Test
    public void example3() {
        int n = 15;
        int expected = 4;
        Assertions.assertEquals(expected, solution829.consecutiveNumbersSum(n));
    }
}