import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2411Tests {
    private final Solution2411 solution2411 = new Solution2411();

    @Test
    public void example1() {
        int[] nums = {1, 0, 2, 1, 3};
        int[] expected = {3, 3, 2, 2, 1};
        Assertions.assertArrayEquals(expected, solution2411.smallestSubarrays(nums));
    }

    @Test
    public void example2() {
        int[] nums = {1, 2};
        int[] expected = {2, 1};
        Assertions.assertArrayEquals(expected, solution2411.smallestSubarrays(nums));
    }

    // 补充用例
    @Test
    public void example3() {
        // https://leetcode.cn/submissions/detail/364420845/
        int[] nums = UtUtils.loadingInts("solution2411-example3-input.txt", 0);
        int[] expected = UtUtils.loadingInts("solution2411-example3-output.txt", 0);
        Assertions.assertArrayEquals(expected, solution2411.smallestSubarrays(nums));
    }
}
