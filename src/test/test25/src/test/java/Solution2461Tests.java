import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2461Tests {
    private final Solution2461 solution2461 = new Solution2461();

    @Test
    public void example1() {
        int[] nums = {1, 5, 4, 2, 9, 9, 9};
        int k = 3;
        long expected = 15;
        Assertions.assertEquals(expected, solution2461.maximumSubarraySum(nums, k));
    }

    @Test
    public void example2() {
        int[] nums = {4, 4, 4};
        int k = 3;
        long expected = 0;
        Assertions.assertEquals(expected, solution2461.maximumSubarraySum(nums, k));
    }
}
