import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3007Tests {
    private final Solution3007 solution3007 = new Solution3007();

    @Test
    public void example1() {
        long k = 9;
        int x = 1;
        long expected = 6;
        Assertions.assertEquals(expected, solution3007.findMaximumNumber(k, x));
    }

    @Test
    public void example2() {
        long k = 7;
        int x = 2;
        long expected = 9;
        Assertions.assertEquals(expected, solution3007.findMaximumNumber(k, x));
    }
}