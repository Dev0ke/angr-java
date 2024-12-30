import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2750Tests {
    private final Solution2750 solution2750 = new Solution2750();

    @Test
    public void example1() {
        int[] nums = {0, 1, 0, 0, 1};
        int expected = 3;
        Assertions.assertEquals(expected, solution2750.numberOfGoodSubarraySplits(nums));
    }

    @Test
    public void example2() {
        int[] nums = {0, 1, 0};
        int expected = 1;
        Assertions.assertEquals(expected, solution2750.numberOfGoodSubarraySplits(nums));
    }
}