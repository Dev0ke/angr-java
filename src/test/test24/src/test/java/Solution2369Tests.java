import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2369Tests {
    private final Solution2369 solution2369 = new Solution2369();

    @Test
    public void example1() {
        int[] nums = {4, 4, 4, 5, 6};
        Assertions.assertTrue(solution2369.validPartition(nums));
    }

    @Test
    public void example2() {
        int[] nums = {1, 1, 1, 2};
        Assertions.assertFalse(solution2369.validPartition(nums));
    }

    // 补充用例
    @Test
    public void example3() {
        // https://leetcode.cn/submissions/detail/346938101/
        // 54 / 112 个通过测试用例 TLE
        int[] nums = UtUtils.loadingInts("solution2369-example3-input.txt", 0);
        Assertions.assertFalse(solution2369.validPartition(nums));
    }
}
