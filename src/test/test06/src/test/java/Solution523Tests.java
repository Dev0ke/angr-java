import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution523Tests {
    private final Solution523 solution523 = new Solution523();

    @Test
    public void example1() {
        int[] nums = {23, 2, 4, 6, 7};
        int k = 6;
        Assertions.assertTrue(solution523.checkSubarraySum(nums, k));
    }

    @Test
    public void example2() {
        int[] nums = {23, 2, 6, 4, 7};
        int k = 6;
        Assertions.assertTrue(solution523.checkSubarraySum(nums, k));
    }

    @Test
    public void example3() {
        int[] nums = {23, 2, 6, 4, 7};
        int k = 13;
        Assertions.assertFalse(solution523.checkSubarraySum(nums, k));
    }
}
