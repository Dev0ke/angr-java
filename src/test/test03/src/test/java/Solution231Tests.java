import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution231Tests {
    private final Solution231 solution231 = new Solution231();

    @Test
    public void example1() {
        int n = 1;
        Assertions.assertTrue(solution231.isPowerOfTwo(n));
        Assertions.assertTrue(solution231.isPowerOfTwo2(n));
    }

    @Test
    public void example2() {
        int n = 16;
        Assertions.assertTrue(solution231.isPowerOfTwo(n));
        Assertions.assertTrue(solution231.isPowerOfTwo2(n));
    }

    @Test
    public void example3() {
        int n = 3;
        Assertions.assertFalse(solution231.isPowerOfTwo(n));
        Assertions.assertFalse(solution231.isPowerOfTwo2(n));
    }

    @Test
    public void example4() {
        int n = 4;
        Assertions.assertTrue(solution231.isPowerOfTwo(n));
        Assertions.assertTrue(solution231.isPowerOfTwo2(n));
    }

    @Test
    public void example5() {
        int n = 5;
        Assertions.assertFalse(solution231.isPowerOfTwo(n));
        Assertions.assertFalse(solution231.isPowerOfTwo2(n));
    }
}
