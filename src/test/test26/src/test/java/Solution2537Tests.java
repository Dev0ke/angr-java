import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2537Tests {
    private final Solution2537 solution2537 = new Solution2537();

    @Test
    public void example1() {
        int[] nums = {1, 1, 1, 1, 1};
        int k = 10;
        long expected = 1;
        Assertions.assertEquals(expected, solution2537.countGood(nums, k));
    }

    @Test
    public void example2() {
        int[] nums = {3, 1, 4, 3, 2, 2, 4};
        int k = 2;
        long expected = 4;
        Assertions.assertEquals(expected, solution2537.countGood(nums, k));
    }

    // 补充用例
    @Test
    public void example3() {
        // https://leetcode.cn/submissions/detail/395374895/
        // HashMap TLE
        String fileName = "solution2537-example3-input.txt";
        int[] nums = UtUtils.loadingInts(fileName, 0);
        int k = UtUtils.loadingInt(fileName, 1);
        long expected = 449378425;
        Assertions.assertEquals(expected, solution2537.countGood(nums, k));
    }
}
