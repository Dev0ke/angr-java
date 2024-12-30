import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2401Tests {
    private final Solution2401 solution2401 = new Solution2401();

    @Test
    public void example1() {
        int[] nums = {1, 3, 8, 48, 10};
        int expected = 3;
        Assertions.assertEquals(expected, solution2401.longestNiceSubarray(nums));
    }

    @Test
    public void example2() {
        int[] nums = {3, 1, 5, 11, 13};
        int expected = 1;
        Assertions.assertEquals(expected, solution2401.longestNiceSubarray(nums));
    }
}
