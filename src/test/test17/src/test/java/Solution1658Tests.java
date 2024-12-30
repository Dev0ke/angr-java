import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1658Tests {
    private final Solution1658 solution1658 = new Solution1658();

    @Test
    public void example1() {
        int[] nums = {1, 1, 4, 2, 3};
        int x = 5;
        int expected = 2;
        Assertions.assertEquals(expected, solution1658.minOperations(nums, x));
    }

    @Test
    public void example2() {
        int[] nums = {5, 6, 7, 8, 9};
        int x = 4;
        int expected = -1;
        Assertions.assertEquals(expected, solution1658.minOperations(nums, x));
    }

    @Test
    public void example3() {
        int[] nums = {3, 2, 20, 1, 1, 3};
        int x = 10;
        int expected = 5;
        Assertions.assertEquals(expected, solution1658.minOperations(nums, x));
    }

    // 补充用例
    @Test
    public void example4() {
        // https://leetcode.cn/problems/minimum-operations-to-reduce-x-to-zero/submissions/527200697/
        // 需要特判边界
        int[] nums = {8828, 9581, 49, 9818, 9974, 9869, 9991, 10000, 10000, 10000, 9999, 9993, 9904, 8819, 1231, 6309};
        int x = 134365;
        int expected = 16;
        Assertions.assertEquals(expected, solution1658.minOperations(nums, x));
    }
}