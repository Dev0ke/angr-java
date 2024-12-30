import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution343Tests {
    private final Solution343 solution343 = new Solution343();

    @Test
    public void example1() {
        int n = 2;
        int expected = 1;
        Assertions.assertEquals(expected, solution343.integerBreak(n));
        Assertions.assertEquals(expected, solution343.integerBreak2(n));
        Assertions.assertEquals(expected, solution343.integerBreak3(n));
    }

    @Test
    public void example2() {
        int n = 10;
        int expected = 36;
        Assertions.assertEquals(expected, solution343.integerBreak(n));
        Assertions.assertEquals(expected, solution343.integerBreak2(n));
        Assertions.assertEquals(expected, solution343.integerBreak3(n));
    }
}
