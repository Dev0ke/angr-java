import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution416Tests {
    private final Solution416 solution416 = new Solution416();

    @Test
    public void example1() {
        int[] nums = {1, 5, 11, 5};
        Assertions.assertTrue(solution416.canPartition(nums));
    }

    @Test
    public void example2() {
        int[] nums = {1, 2, 3, 5};
        Assertions.assertFalse(solution416.canPartition(nums));
    }

    // 补充用例
    @Test
    public void example3() {
        // https://leetcode.cn/problems/partition-equal-subset-sum/submissions/
        int[] nums = {1, 2, 5};
        Assertions.assertFalse(solution416.canPartition(nums));
    }
}
