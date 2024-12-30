import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution645Tests {
    private final Solution645 solution645 = new Solution645();

    @Test
    public void example1() {
        int[] nums = {1, 2, 2, 4};
        int[] expected = {2, 3};
        Assertions.assertArrayEquals(expected, solution645.findErrorNums(nums));
    }

    @Test
    public void example2() {
        int[] nums = {1, 1};
        int[] expected = {1, 2};
        Assertions.assertArrayEquals(expected, solution645.findErrorNums(nums));
    }

    // 易遗留
    @Test
    public void example3() {
        int[] nums = {2, 2};
        int[] expected = {2, 1};
        Assertions.assertArrayEquals(expected, solution645.findErrorNums(nums));
    }
}
