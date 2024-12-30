import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3351Tests {
    private final Solution3351 solution3351 = new Solution3351();

    @Test
    public void example1() {
        int[] nums = {1, 2, 1};
        int expected = 14;
        Assertions.assertEquals(expected, solution3351.sumOfGoodSubsequences(nums));
    }

    @Test
    public void example2() {
        int[] nums = {3, 4, 5};
        int expected = 40;
        Assertions.assertEquals(expected, solution3351.sumOfGoodSubsequences(nums));
    }
}