import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution233Tests {
    private final Solution233 solution233 = new Solution233();

    @Test
    public void example1() {
        int n = 13;
        int expected = 6;
        Assertions.assertEquals(expected, solution233.countDigitOne(n));
        Assertions.assertEquals(expected, solution233.countDigitOne2(n));
    }

    @Test
    public void example2() {
        int n = 0;
        int expected = 0;
        Assertions.assertEquals(expected, solution233.countDigitOne(n));
        Assertions.assertEquals(expected, solution233.countDigitOne2(n));
    }
}
