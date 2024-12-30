import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution400Tests {
    private final Solution400 solution400 = new Solution400();

    @Test
    public void example1() {
        int n = 3;
        int expected = 3;
        Assertions.assertEquals(expected, solution400.findNthDigit(n));
        Assertions.assertEquals(expected, solution400.findNthDigit2(n));
    }

    @Test
    public void example2() {
        int n = 11;
        int expected = 0;
        Assertions.assertEquals(expected, solution400.findNthDigit(n));
        Assertions.assertEquals(expected, solution400.findNthDigit2(n));
    }
}
