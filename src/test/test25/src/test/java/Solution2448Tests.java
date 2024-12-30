import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2448Tests {
    private final Solution2448 solution2448 = new Solution2448();
    private final Solution2448.V2 solution2448_v2 = new Solution2448.V2();

    @Test
    public void example1() {
        int[] nums = {1, 3, 5, 2};
        int[] cost = {2, 3, 1, 14};
        long expected = 8;
        Assertions.assertEquals(expected, solution2448.minCost(nums, cost));
        Assertions.assertEquals(expected, solution2448_v2.minCost(nums, cost));
    }

    @Test
    public void example2() {
        int[] nums = {2, 2, 2, 2, 2};
        int[] cost = {4, 2, 8, 1, 3};
        long expected = 0;
        Assertions.assertEquals(expected, solution2448.minCost(nums, cost));
        Assertions.assertEquals(expected, solution2448_v2.minCost(nums, cost));
    }

    // 补充用例
    @Test
    public void example3() {
        // https://leetcode.cn/submissions/detail/375615952/
        int[] nums = {735103, 366367, 132236, 133334, 808160, 113001, 49051, 735598, 686615, 665317, 999793, 426087, 587000, 649989, 509946, 743518};
        int[] cost = {724182, 447415, 723725, 902336, 600863, 287644, 13836, 665183, 448859, 917248, 397790, 898215, 790754, 320604, 468575, 825614};
        long expected = 1907611126748L;
        Assertions.assertEquals(expected, solution2448.minCost(nums, cost));
        Assertions.assertEquals(expected, solution2448_v2.minCost(nums, cost));
    }
}