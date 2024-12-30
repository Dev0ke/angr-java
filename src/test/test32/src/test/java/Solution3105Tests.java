import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3105Tests {
    private final Solution3105 solution3105 = new Solution3105();

    @Test
    public void example1() {
        int[] nums = {1, 4, 3, 3, 2};
        int expected = 2;
        Assertions.assertEquals(expected, solution3105.longestMonotonicSubarray(nums));
    }

    @Test
    public void example2() {
        int[] nums = {3, 3, 3, 3};
        int expected = 1;
        Assertions.assertEquals(expected, solution3105.longestMonotonicSubarray(nums));
    }

    @Test
    public void example3() {
        int[] nums = {3, 2, 1};
        int expected = 3;
        Assertions.assertEquals(expected, solution3105.longestMonotonicSubarray(nums));
    }
}