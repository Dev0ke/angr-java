import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2475Tests {
    private final Solution2475 solution2475 = new Solution2475();

    @Test
    public void example1() {
        int[] nums = {4, 4, 2, 4, 3};
        int expected = 3;
        Assertions.assertEquals(expected, solution2475.unequalTriplets(nums));
        Assertions.assertEquals(expected, solution2475.unequalTriplets2(nums));
    }

    @Test
    public void example2() {
        int[] nums = {1, 1, 1, 1, 1};
        int expected = 0;
        Assertions.assertEquals(expected, solution2475.unequalTriplets(nums));
        Assertions.assertEquals(expected, solution2475.unequalTriplets2(nums));
    }
}
