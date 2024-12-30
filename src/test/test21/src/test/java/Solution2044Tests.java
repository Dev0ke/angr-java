import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2044Tests {
    private final Solution2044 solution2044 = new Solution2044();

    @Test
    public void example1() {
        int[] nums = {3, 1};
        int expected = 2;
        Assertions.assertEquals(expected, solution2044.countMaxOrSubsets(nums));
    }

    @Test
    public void example2() {
        int[] nums = {2, 2, 2};
        int expected = 7;
        Assertions.assertEquals(expected, solution2044.countMaxOrSubsets(nums));
    }

    @Test
    public void example3() {
        int[] nums = {3, 2, 1, 5};
        int expected = 6;
        Assertions.assertEquals(expected, solution2044.countMaxOrSubsets(nums));
    }
}
