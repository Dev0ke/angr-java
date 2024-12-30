import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2815Tests {
    private final Solution2815 solution2815 = new Solution2815();

    @Test
    public void example1() {
        int[] nums = {51, 71, 17, 24, 42};
        int expected = 88;
        Assertions.assertEquals(expected, solution2815.maxSum(nums));
    }

    @Test
    public void example2() {
        int[] nums = {1, 2, 3, 4};
        int expected = -1;
        Assertions.assertEquals(expected, solution2815.maxSum(nums));
    }
}