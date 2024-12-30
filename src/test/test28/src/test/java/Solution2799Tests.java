import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2799Tests {
    private final Solution2799 solution2799 = new Solution2799();

    @Test
    public void example1() {
        int[] nums = {1, 3, 1, 2, 2};
        int expected = 4;
        Assertions.assertEquals(expected, solution2799.countCompleteSubarrays(nums));
    }

    @Test
    public void example2() {
        int[] nums = {5, 5, 5, 5};
        int expected = 10;
        Assertions.assertEquals(expected, solution2799.countCompleteSubarrays(nums));
    }
}