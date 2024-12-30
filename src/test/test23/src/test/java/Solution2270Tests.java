import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2270Tests {
    private final Solution2270 solution2270 = new Solution2270();

    @Test
    public void example1() {
        int[] nums = {10, 4, -8, 7};
        int expected = 2;
        Assertions.assertEquals(expected, solution2270.waysToSplitArray(nums));
    }

    @Test
    public void example2() {
        int[] nums = {2, 3, 1, 0};
        int expected = 2;
        Assertions.assertEquals(expected, solution2270.waysToSplitArray(nums));
    }
}
