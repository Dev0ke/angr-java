import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2926Tests {
    private final Solution2926 solution2926 = new Solution2926();

    @Test
    public void example1() {
        int[] nums = {3, 3, 5, 6};
        long expected = 14;
        Assertions.assertEquals(expected, solution2926.maxBalancedSubsequenceSum(nums));
    }

    @Test
    public void example2() {
        int[] nums = {5, -1, -3, 8};
        long expected = 13;
        Assertions.assertEquals(expected, solution2926.maxBalancedSubsequenceSum(nums));
    }

    @Test
    public void example3() {
        int[] nums = {-2, -1};
        long expected = -1;
        Assertions.assertEquals(expected, solution2926.maxBalancedSubsequenceSum(nums));
    }
}