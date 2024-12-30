import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2364Tests {
    private final Solution2364 solution2364 = new Solution2364();

    @Test
    public void example1() {
        int[] nums = {4, 1, 3, 3};
        long expected = 5;
        Assertions.assertEquals(expected, solution2364.countBadPairs(nums));
    }

    @Test
    public void example2() {
        int[] nums = {1, 2, 3, 4, 5};
        long expected = 0;
        Assertions.assertEquals(expected, solution2364.countBadPairs(nums));
    }
}
