import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2104Tests {
    private final Solution2104 solution2104 = new Solution2104();

    @Test
    public void example1() {
        int[] nums = {1, 2, 3};
        long expected = 4;
        Assertions.assertEquals(expected, solution2104.subArrayRanges(nums));
    }

    @Test
    public void example2() {
        int[] nums = {1, 3, 3};
        long expected = 4;
        Assertions.assertEquals(expected, solution2104.subArrayRanges(nums));
    }

    @Test
    public void example3() {
        int[] nums = {4, -2, -3, 4, 1};
        long expected = 59;
        Assertions.assertEquals(expected, solution2104.subArrayRanges(nums));
    }
}
