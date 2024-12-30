import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2281Tests {
    private final Solution2281 solution2281 = new Solution2281();

    @Test
    public void example1() {
        int[] strength = {1, 3, 1, 2};
        int expected = 44;
        Assertions.assertEquals(expected, solution2281.totalStrength(strength));
    }

    @Test
    public void example2() {
        int[] strength = {5, 4, 6};
        int expected = 213;
        Assertions.assertEquals(expected, solution2281.totalStrength(strength));
    }

    // 补充用例
    @Test
    public void example3() {
        // https://leetcode.cn/submissions/detail/316558365/
        // 68 / 82 个通过测试用例 TLE/爆前缀和的前缀和
        int[] strength = UtUtils.loadingInts("solution2281-example3-input.txt", 0);
        int expected = 121473332;
        Assertions.assertEquals(expected, solution2281.totalStrength(strength));
    }

    @Test
    public void example4() {
        // https://leetcode.cn/submissions/detail/319486588/
        // 78 / 82 个通过测试用例 结果为负数
        int[] strength = UtUtils.loadingInts("solution2281-example4-input.txt", 0);
        int expected = 527398151;
        Assertions.assertEquals(expected, solution2281.totalStrength(strength));
    }
}
