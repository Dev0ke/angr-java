import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2419Tests {
    private final Solution2419 solution2419 = new Solution2419();

    @Test
    public void example1() {
        int[] nums = {1, 2, 3, 3, 2, 2};
        int expected = 2;
        Assertions.assertEquals(expected, solution2419.longestSubarray(nums));
    }

    @Test
    public void example2() {
        int[] nums = {1, 2, 3, 4};
        int expected = 1;
        Assertions.assertEquals(expected, solution2419.longestSubarray(nums));
    }
}
