import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution494Tests {
    private final Solution494 solution494 = new Solution494();

    @Test
    public void example1() {
        int[] nums = {1, 1, 1, 1, 1};
        int target = 3;
        int expected = 5;
        Assertions.assertEquals(expected, solution494.findTargetSumWays(nums, target));
    }

    @Test
    public void example2() {
        int[] nums = {1};
        int target = 1;
        int expected = 1;
        Assertions.assertEquals(expected, solution494.findTargetSumWays(nums, target));
    }

    // 补充用例
    @Test
    public void example3() {
        int[] nums = {100};
        int target = -200;
        int expected = 0;
        Assertions.assertEquals(expected, solution494.findTargetSumWays(nums, target));
    }
}
