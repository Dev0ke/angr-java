import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution357Tests {
    private final Solution357 solution357 = new Solution357();

    @Test
    public void example1() {
        int n = 2;
        int expected = 91;
        Assertions.assertEquals(expected, solution357.countNumbersWithUniqueDigits(n));
    }

    @Test
    public void example2() {
        int n = 0;
        int expected = 1;
        Assertions.assertEquals(expected, solution357.countNumbersWithUniqueDigits(n));
    }
}
