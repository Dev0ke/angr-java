import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution869Tests {
    private final Solution869 solution869 = new Solution869();

    @Test
    public void example1() {
        int n = 1;
        Assertions.assertTrue(solution869.reorderedPowerOf2(n));
    }

    @Test
    public void example2() {
        int n = 10;
        Assertions.assertFalse(solution869.reorderedPowerOf2(n));
    }

    @Test
    public void example3() {
        int n = 16;
        Assertions.assertTrue(solution869.reorderedPowerOf2(n));
    }

    @Test
    public void example4() {
        int n = 24;
        Assertions.assertFalse(solution869.reorderedPowerOf2(n));
    }

    @Test
    public void example5() {
        int n = 46;
        Assertions.assertTrue(solution869.reorderedPowerOf2(n));
    }
}
