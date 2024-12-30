import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution902Tests {
    private final Solution902 solution902 = new Solution902();

    @Test
    public void example1() {
        String[] digits = {"1", "3", "5", "7"};
        int n = 100;
        int expected = 20;
        Assertions.assertEquals(expected, solution902.atMostNGivenDigitSet(digits, n));
    }

    @Test
    public void example2() {
        String[] digits = {"1", "4", "9"};
        int n = 1000000000;
        int expected = 29523;
        Assertions.assertEquals(expected, solution902.atMostNGivenDigitSet(digits, n));
    }

    @Test
    public void example3() {
        String[] digits = {"7"};
        int n = 8;
        int expected = 1;
        Assertions.assertEquals(expected, solution902.atMostNGivenDigitSet(digits, n));
    }
}
