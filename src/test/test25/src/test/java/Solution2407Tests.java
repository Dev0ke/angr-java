import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2407Tests {
    private final Solution2407 solution2407 = new Solution2407();

    @Test
    public void example1() {
        int[] nums = {4, 2, 1, 4, 3, 4, 5, 8, 15};
        int k = 3;
        int expected = 5;
        Assertions.assertEquals(expected, solution2407.lengthOfLIS(nums, k));
    }

    @Test
    public void example2() {
        int[] nums = {7, 4, 5, 1, 8, 12, 4, 7};
        int k = 5;
        int expected = 4;
        Assertions.assertEquals(expected, solution2407.lengthOfLIS(nums, k));
    }

    @Test
    public void example3() {
        int[] nums = {1, 5};
        int k = 1;
        int expected = 1;
        Assertions.assertEquals(expected, solution2407.lengthOfLIS(nums, k));
    }

    // 补充用例
    @Test
    public void example4() {
        // https://leetcode.cn/submissions/detail/361532901/
        // 并不是 LIS 的一个子序列
        int[] nums = {1, 4, 7, 15, 5};
        int k = 1;
        int expected = 2;
        Assertions.assertEquals(expected, solution2407.lengthOfLIS(nums, k));
    }
}
