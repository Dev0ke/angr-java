import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2871Tests {
    private final Solution2871 solution2871 = new Solution2871();

    @Test
    public void example1() {
        int[] nums = {1, 0, 2, 0, 1, 2};
        int expected = 3;
        Assertions.assertEquals(expected, solution2871.maxSubarrays(nums));
    }

    @Test
    public void example2() {
        int[] nums = {5, 7, 1, 3};
        int expected = 1;
        Assertions.assertEquals(expected, solution2871.maxSubarrays(nums));
    }
}