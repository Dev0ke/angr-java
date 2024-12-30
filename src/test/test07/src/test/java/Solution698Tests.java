import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution698Tests {
    private final Solution698 solution698 = new Solution698();

    @Test
    public void example1() {
        int[] nums = {4, 3, 2, 3, 5, 2, 1};
        int k = 4;
        Assertions.assertTrue(solution698.canPartitionKSubsets(nums, k));
    }

    @Test
    public void example2() {
        int[] nums = {1, 2, 3, 4};
        int k = 3;
        Assertions.assertFalse(solution698.canPartitionKSubsets(nums, k));
    }
}
