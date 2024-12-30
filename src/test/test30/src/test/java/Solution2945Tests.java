import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2945Tests {
    private final Solution2945 solution2945 = new Solution2945();

    @Test
    public void example1() {
        int[] nums = {5, 2, 2};
        int expected = 1;
        Assertions.assertEquals(expected, solution2945.findMaximumLength(nums));
    }

    @Test
    public void example2() {
        int[] nums = {1, 2, 3, 4};
        int expected = 4;
        Assertions.assertEquals(expected, solution2945.findMaximumLength(nums));
    }

    @Test
    public void example3() {
        int[] nums = {4, 3, 2, 6};
        int expected = 3;
        Assertions.assertEquals(expected, solution2945.findMaximumLength(nums));
    }

    // 补充用例
    @Test
    public void example4() {
        // https://leetcode.cn/problems/find-maximum-non-decreasing-array-length/submissions/484735799/
        int[] nums = {272, 482, 115, 925, 983};
        int expected = 4;
        Assertions.assertEquals(expected, solution2945.findMaximumLength(nums));
    }
}