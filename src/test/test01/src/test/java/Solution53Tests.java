import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution53Tests {
    private final Solution53 solution53 = new Solution53();
    private final Solution53.V2 solution53_v2 = new Solution53.V2();
    private final Solution53.V3 solution53_v3 = new Solution53.V3();
    private final Solution53.V4 solution53_v4 = new Solution53.V4();

    @Test
    public void example1() {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int expected = 6;
        Assertions.assertEquals(expected, solution53.maxSubArray(nums));
        Assertions.assertEquals(expected, solution53_v2.maxSubArray(nums));
        Assertions.assertEquals(expected, solution53_v3.maxSubArray(nums));
        Assertions.assertEquals(expected, solution53_v4.maxSubArray(nums));
    }

    @Test
    public void example2() {
        int[] nums = {1};
        int expected = 1;
        Assertions.assertEquals(expected, solution53.maxSubArray(nums));
        Assertions.assertEquals(expected, solution53_v2.maxSubArray(nums));
        Assertions.assertEquals(expected, solution53_v3.maxSubArray(nums));
        Assertions.assertEquals(expected, solution53_v4.maxSubArray(nums));
    }

    @Test
    public void example3() {
        int[] nums = {5, 4, -1, 7, 8};
        int expected = 23;
        Assertions.assertEquals(expected, solution53.maxSubArray(nums));
        Assertions.assertEquals(expected, solution53_v2.maxSubArray(nums));
        Assertions.assertEquals(expected, solution53_v3.maxSubArray(nums));
        Assertions.assertEquals(expected, solution53_v4.maxSubArray(nums));
    }

    // 补充用例
    @Test
    public void example4() {
        // https://leetcode.cn/problems/maximum-subarray/submissions/487903704/
        int[] nums = UtUtils.loadingInts("solution53-example4-input.txt", 0);
        int expected = 4750918;
        Assertions.assertEquals(expected, solution53.maxSubArray(nums));
        Assertions.assertEquals(expected, solution53_v2.maxSubArray(nums));
        Assertions.assertEquals(expected, solution53_v3.maxSubArray(nums));
        Assertions.assertEquals(expected, solution53_v4.maxSubArray(nums));
    }
}
