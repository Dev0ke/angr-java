import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2454Tests {
    private final Solution2454 solution2454 = new Solution2454();

    @Test
    public void example1() {
        int[] nums = {2, 4, 0, 9, 6};
        int[] expected = {9, 6, 6, -1, -1};
        Assertions.assertArrayEquals(expected, solution2454.secondGreaterElement(nums));
    }

    @Test
    public void example2() {
        int[] nums = {3, 3};
        int[] expected = {-1, -1};
        Assertions.assertArrayEquals(expected, solution2454.secondGreaterElement(nums));
    }

    // 补充用例
    @Test
    public void example3() {
        // https://leetcode.cn/submissions/detail/377644778/ TLE
        int[] nums = UtUtils.loadingInts("solution2454-example3-input.txt", 0);
        int[] expected = UtUtils.loadingInts("solution2454-example3-output.txt", 0);
        Assertions.assertArrayEquals(expected, solution2454.secondGreaterElement(nums));
    }
}
