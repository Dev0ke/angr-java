import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution342Tests {
    private final Solution342 solution342 = new Solution342();

    @Test
    public void example1() {
        int n = 16;
        Assertions.assertTrue(solution342.isPowerOfFour(n));
    }

    @Test
    public void example2() {
        int n = 5;
        Assertions.assertFalse(solution342.isPowerOfFour(n));
    }

    @Test
    public void example3() {
        int n = 1;
        Assertions.assertTrue(solution342.isPowerOfFour(n));
    }
}
