import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution628Tests {
    private final Solution628 solution628 = new Solution628();

    @Test
    public void example1() {
        int[] nums = {1, 2, 3};
        int expected = 6;
        Assertions.assertEquals(expected, solution628.maximumProduct(nums));
    }

    @Test
    public void example2() {
        int[] nums = {1, 2, 3, 4};
        int expected = 24;
        Assertions.assertEquals(expected, solution628.maximumProduct(nums));
    }

    @Test
    public void example3() {
        int[] nums = {-1, -2, -3};
        int expected = -6;
        Assertions.assertEquals(expected, solution628.maximumProduct(nums));
    }
}
