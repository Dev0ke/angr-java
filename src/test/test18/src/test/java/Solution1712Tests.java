import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1712Tests {
    private final Solution1712 solution1712 = new Solution1712();

    @Test
    public void example1() {
        int[] nums = {1, 1, 1};
        int expected = 1;
        Assertions.assertEquals(expected, solution1712.waysToSplit(nums));
    }

    @Test
    public void example2() {
        int[] nums = {1, 2, 2, 2, 5, 0};
        int expected = 3;
        Assertions.assertEquals(expected, solution1712.waysToSplit(nums));
    }

    @Test
    public void example3() {
        int[] nums = {3, 2, 1};
        int expected = 0;
        Assertions.assertEquals(expected, solution1712.waysToSplit(nums));
    }

    // 补充用例
    @Test
    public void example4() {
        // https://leetcode.cn/submissions/detail/314590144/
        int[] nums = UtUtils.loadingInts("solution1712-example4-input.txt", 0);
        int expected = 999849973;
        Assertions.assertEquals(expected, solution1712.waysToSplit(nums));
    }
}
