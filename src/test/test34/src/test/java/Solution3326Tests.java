import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3326Tests {
    private final Solution3326 solution3326 = new Solution3326();

    @Test
    public void example1() {
        int[] nums = {25, 7};
        int expected = 1;
        Assertions.assertEquals(expected, solution3326.minOperations(nums));
    }

    @Test
    public void example2() {
        int[] nums = {7, 7, 6};
        int expected = -1;
        Assertions.assertEquals(expected, solution3326.minOperations(nums));
    }

    @Test
    public void example3() {
        int[] nums = {1, 1, 1, 1};
        int expected = 0;
        Assertions.assertEquals(expected, solution3326.minOperations(nums));
    }

    // 补充用例
    @Test
    public void example4() {
        // https://leetcode.cn/problems/minimum-division-operations-to-make-array-non-decreasing/submissions/574150183/
        // rej 用例
        int[] nums = {5, 40, 10};
        int expected = -1;
        Assertions.assertEquals(expected, solution3326.minOperations(nums));
    }
}