import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution204Tests {
    private final Solution204 solution204 = new Solution204();

    @Test
    public void example1() {
        int n = 10;
        int expected = 4;
        Assertions.assertEquals(expected, solution204.countPrimes(n));
        Assertions.assertEquals(expected, solution204.countPrimes2(n));
    }

    @Test
    public void example2() {
        int n = 0;
        int expected = 0;
        Assertions.assertEquals(expected, solution204.countPrimes(n));
        Assertions.assertEquals(expected, solution204.countPrimes2(n));
    }

    @Test
    public void example3() {
        int n = 1;
        int expected = 0;
        Assertions.assertEquals(expected, solution204.countPrimes(n));
        Assertions.assertEquals(expected, solution204.countPrimes2(n));
    }
}
