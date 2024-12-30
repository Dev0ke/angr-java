import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2681Tests {
    private final Solution2681 solution2681 = new Solution2681();

    @Test
    public void example1() {
        int[] nums = {2, 1, 4};
        int expected = 141;
        Assertions.assertEquals(expected, solution2681.sumOfPower(nums));
    }

    @Test
    public void example2() {
        int[] nums = {1, 1, 1};
        int expected = 7;
        Assertions.assertEquals(expected, solution2681.sumOfPower(nums));
    }

    // 补充用例
    @Test
    public void example3() {
        // https://leetcode.cn/submissions/detail/432375286/
        // 爆 long
        int[] nums = {658, 489, 777, 2418, 1893, 130, 2448, 178, 1128, 2149, 1059, 1495, 1166, 608, 2006, 713, 1906, 2108, 680, 1348, 860, 1620, 146, 2447, 1895, 1083, 1465, 2351, 1359, 1187, 906, 533, 1943, 1814, 1808, 2065, 1744, 254, 1988, 1889, 1206};
        int expected = 567530242;
        Assertions.assertEquals(expected, solution2681.sumOfPower(nums));
    }
}