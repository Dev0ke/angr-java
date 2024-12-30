import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2134Tests {
    private final Solution2134 solution2134 = new Solution2134();

    @Test
    public void example1() {
        int[] nums = {0, 1, 0, 1, 1, 0, 0};
        int expected = 1;
        Assertions.assertEquals(expected, solution2134.minSwaps(nums));
    }

    @Test
    public void example2() {
        int[] nums = {0, 1, 1, 1, 0, 0, 1, 1, 0};
        int expected = 2;
        Assertions.assertEquals(expected, solution2134.minSwaps(nums));
    }

    @Test
    public void example3() {
        int[] nums = {1, 1, 0, 0, 1};
        int expected = 0;
        Assertions.assertEquals(expected, solution2134.minSwaps(nums));
    }
}
