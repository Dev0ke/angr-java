import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2348Tests {
    private final Solution2348 solution2348 = new Solution2348();

    @Test
    public void example1() {
        int[] nums = {1, 3, 0, 0, 2, 0, 0, 4};
        long expected = 6;
        Assertions.assertEquals(expected, solution2348.zeroFilledSubarray(nums));
    }

    @Test
    public void example2() {
        int[] nums = {0, 0, 0, 2, 0, 0};
        long expected = 9;
        Assertions.assertEquals(expected, solution2348.zeroFilledSubarray(nums));
    }

    @Test
    public void example3() {
        int[] nums = {2, 10, 2019};
        long expected = 0;
        Assertions.assertEquals(expected, solution2348.zeroFilledSubarray(nums));
    }
}
