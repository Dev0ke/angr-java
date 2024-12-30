import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2389Tests {
    private final Solution2389 solution2389 = new Solution2389();

    @Test
    public void example1() {
        int[] nums = {4, 5, 2, 1};
        int[] queries = {3, 10, 21};
        int[] expected = {2, 3, 4};
        Assertions.assertArrayEquals(expected, solution2389.answerQueries(nums, queries));
    }

    @Test
    public void example2() {
        int[] nums = {2, 3, 4, 5};
        int[] queries = {1};
        int[] expected = {0};
        Assertions.assertArrayEquals(expected, solution2389.answerQueries(nums, queries));
    }

    // 补充用例
    @Test
    public void example3() {
        // https://leetcode.cn/submissions/detail/355800758/
        int[] nums = {736411, 184882, 914641, 37925, 214915};
        int[] queries = {331244, 273144, 118983, 118252, 305688, 718089, 665450};
        int[] expected = {2, 2, 1, 1, 2, 3, 3};
        Assertions.assertArrayEquals(expected, solution2389.answerQueries(nums, queries));
    }
}
