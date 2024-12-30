import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution805Tests {
    private final Solution805 solution805 = new Solution805();

    @Test
    public void example1() {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8};
        Assertions.assertTrue(solution805.splitArraySameAverage(nums));
    }

    @Test
    public void example2() {
        int[] nums = {3, 1};
        Assertions.assertFalse(solution805.splitArraySameAverage(nums));
    }

    // 补充用例
    @Test
    public void example3() {
        // https://leetcode.cn/submissions/detail/382150116/
        // avg = 8/3 nums = [-5, 10, -5]
        int[] nums = {1, 6, 1};
        Assertions.assertFalse(solution805.splitArraySameAverage(nums));
    }
}
