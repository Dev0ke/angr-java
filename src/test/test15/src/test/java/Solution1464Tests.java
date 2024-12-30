import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1464Tests {
    private final Solution1464 solution1464 = new Solution1464();

    @Test
    public void example1() {
        int[] nums = {3, 4, 5, 2};
        int expected = 12;
        Assertions.assertEquals(expected, solution1464.maxProduct(nums));
    }

    @Test
    public void example2() {
        int[] nums = {1, 5, 4, 5};
        int expected = 16;
        Assertions.assertEquals(expected, solution1464.maxProduct(nums));
    }

    @Test
    public void example3() {
        int[] nums = {3, 7};
        int expected = 12;
        Assertions.assertEquals(expected, solution1464.maxProduct(nums));
    }
}
