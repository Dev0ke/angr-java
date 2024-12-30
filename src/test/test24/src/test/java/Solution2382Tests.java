import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2382Tests {
    private final Solution2382 solution2382 = new Solution2382();

    @Test
    public void example1() {
        int[] nums = {1, 2, 5, 6, 1};
        int[] removeQueries = {0, 3, 2, 4, 1};
        long[] expected = {14, 7, 2, 2, 0};
        Assertions.assertArrayEquals(expected, solution2382.maximumSegmentSum(nums, removeQueries));
    }

    @Test
    public void example2() {
        int[] nums = {3, 2, 11, 1};
        int[] removeQueries = {3, 2, 1, 0};
        long[] expected = {16, 5, 3, 0};
        Assertions.assertArrayEquals(expected, solution2382.maximumSegmentSum(nums, removeQueries));
    }

    // 补充用例
    @Test
    public void example3() {
        // https://leetcode.cn/submissions/detail/352812611/
        // 负值不够小
        int[] nums = UtUtils.loadingInts("solution2382-example3-input.txt", 0);
        int[] removeQueries = UtUtils.loadingInts("solution2382-example3-input.txt", 1);
        long[] expected = UtUtils.loadingLongs("solution2382-example3-output.txt", 0);
        Assertions.assertArrayEquals(expected, solution2382.maximumSegmentSum(nums, removeQueries));
    }

    @Test
    public void example4() {
        // https://leetcode.cn/submissions/detail/352816088/
        // TLE
        int[] nums = UtUtils.loadingInts("solution2382-example4-input.txt", 0);
        int[] removeQueries = UtUtils.loadingInts("solution2382-example4-input.txt", 1);
        long[] expected = UtUtils.loadingLongs("solution2382-example4-output.txt", 0);
        Assertions.assertArrayEquals(expected, solution2382.maximumSegmentSum(nums, removeQueries));
    }
}
