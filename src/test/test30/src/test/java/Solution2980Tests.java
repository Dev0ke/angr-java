import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2980Tests {
    private final Solution2980 solution2980 = new Solution2980();

    @Test
    public void example1() {
        int[] nums = {1, 2, 3, 4, 5};
        Assertions.assertTrue(solution2980.hasTrailingZeros(nums));
    }

    @Test
    public void example2() {
        int[] nums = {2, 4, 8, 16};
        Assertions.assertTrue(solution2980.hasTrailingZeros(nums));
    }

    @Test
    public void example3() {
        int[] nums = {1, 3, 5, 7, 9};
        Assertions.assertFalse(solution2980.hasTrailingZeros(nums));
    }
}