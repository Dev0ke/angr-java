import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution326Tests {
    private final Solution326 solution326 = new Solution326();

    @Test
    public void example1() {
        int n = 27;
        Assertions.assertTrue(solution326.isPowerOfThree(n));
    }

    @Test
    public void example2() {
        int n = 0;
        Assertions.assertFalse(solution326.isPowerOfThree(n));
    }

    @Test
    public void example3() {
        int n = 9;
        Assertions.assertTrue(solution326.isPowerOfThree(n));
    }

    @Test
    public void example4() {
        int n = 45;
        Assertions.assertFalse(solution326.isPowerOfThree(n));
    }
}
