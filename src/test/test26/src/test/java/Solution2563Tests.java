import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2563Tests {
    private final Solution2563 solution2563 = new Solution2563();

    @Test
    public void example1() {
        int[] nums = {0, 1, 7, 4, 4, 5};
        int lower = 3;
        int upper = 6;
        long expected = 6;
        Assertions.assertEquals(expected, solution2563.countFairPairs(nums, lower, upper));
    }

    @Test
    public void example2() {
        int[] nums = {1, 7, 9, 2, 5};
        int lower = 11;
        int upper = 11;
        long expected = 1;
        Assertions.assertEquals(expected, solution2563.countFairPairs(nums, lower, upper));
    }

    // 补充用例
    @Test
    public void example3() {
        // https://leetcode.cn/submissions/detail/402704899/
        // 负数场景
        int[] nums = {-5, -7, -5, -7, -5};
        int lower = -12;
        int upper = -12;
        long expected = 6;
        Assertions.assertEquals(expected, solution2563.countFairPairs(nums, lower, upper));
    }
}