import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2354Tests {
    private final Solution2354 solution2354 = new Solution2354();

    @Test
    public void example1() {
        int[] nums = {1, 2, 3, 1};
        int k = 3;
        long expected = 5;
        Assertions.assertEquals(expected, solution2354.countExcellentPairs(nums, k));
    }

    @Test
    public void example2() {
        int[] nums = {5, 1, 1};
        int k = 10;
        long expected = 0;
        Assertions.assertEquals(expected, solution2354.countExcellentPairs(nums, k));
    }

    @Test
    public void example3() {
        // https://leetcode.cn/submissions/detail/340927667/
        // 没正确 "去重"
        int[] nums = {1, 2, 3, 1, 536870911};
        int k = 3;
        long expected = 12;
        Assertions.assertEquals(expected, solution2354.countExcellentPairs(nums, k));
    }
}