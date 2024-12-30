import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1814Tests {
    private final Solution1814 solution1814 = new Solution1814();

    @Test
    public void example1() {
        int[] nums = {42, 11, 1, 97};
        int expected = 2;
        Assertions.assertEquals(expected, solution1814.countNicePairs(nums));
    }

    @Test
    public void example2() {
        int[] nums = {13, 10, 35, 24, 76};
        int expected = 4;
        Assertions.assertEquals(expected, solution1814.countNicePairs(nums));
    }

    // 补充用例
    @Test
    public void example3() {
        // https://leetcode.cn/submissions/detail/395810646/
        // 81 / 84 个通过测试用例 WA 没有取模
        int[] nums = UtUtils.loadingInts("solution1814-example3-input.txt", 0);
        int expected = 599959993;
        Assertions.assertEquals(expected, solution1814.countNicePairs(nums));
    }
}