import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2584Tests {
    private final Solution2584 solution2584 = new Solution2584();

    @Test
    public void example1() {
        int[] nums = {4, 7, 8, 15, 3, 5};
        int expected = 2;
        Assertions.assertEquals(expected, solution2584.findValidSplit(nums));
        Assertions.assertEquals(expected, solution2584.findValidSplit2(nums));
    }

    @Test
    public void example2() {
        int[] nums = {4, 7, 15, 8, 3, 5};
        int expected = -1;
        Assertions.assertEquals(expected, solution2584.findValidSplit(nums));
        Assertions.assertEquals(expected, solution2584.findValidSplit2(nums));
    }

    // 补充用例
    @Test
    public void example3() {
        // https://leetcode.cn/problems/split-the-array-to-make-coprime-products/submissions/462157477/
        int[] nums = {35, 83, 53, 58, 70, 85, 5};
        int expected = -1;
        Assertions.assertEquals(expected, solution2584.findValidSplit(nums));
        Assertions.assertEquals(expected, solution2584.findValidSplit2(nums));
    }
}