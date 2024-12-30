import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2289Tests {
    private final Solution2289 solution2289 = new Solution2289();

    @Test
    public void example1() {
        int[] nums = {5, 3, 4, 4, 7, 3, 6, 11, 8, 5, 11};
        int expected = 3;
        Assertions.assertEquals(expected, solution2289.totalSteps(nums));
    }

    @Test
    public void example2() {
        int[] nums = {4, 5, 7, 7, 13};
        int expected = 0;
        Assertions.assertEquals(expected, solution2289.totalSteps(nums));
    }

    // 补充用例
    @Test
    public void example3() {
        // https://leetcode.cn/submissions/detail/319384529/
        // 61 / 86 个通过测试用例
        int[] nums = {7, 14, 4, 14, 13, 2, 6, 13};
        int expected = 3;
        Assertions.assertEquals(expected, solution2289.totalSteps(nums));
    }
}
