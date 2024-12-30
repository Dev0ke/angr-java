import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution2862Tests {
    private final Solution2862 solution2862 = new Solution2862();

    @Test
    public void example1() {
        List<Integer> nums = List.of(8, 7, 3, 5, 7, 2, 4, 9);
        long expected = 16;
        Assertions.assertEquals(expected, solution2862.maximumSum(nums));
    }

    @Test
    public void example2() {
        List<Integer> nums = List.of(5, 10, 3, 10, 1, 13, 7, 9, 4);
        long expected = 19;
        Assertions.assertEquals(expected, solution2862.maximumSum(nums));
    }

    // 补充用例
    @Test
    public void example3() {
        // https://leetcode.cn/problems/maximum-element-sum-of-a-complete-subset-of-indices/submissions/466977187/
        List<Integer> nums = List.of(23, 27, 42, 3, 33, 36, 43, 32, 27, 48, 40, 22, 5, 36, 48);
        long expected = 64;
        Assertions.assertEquals(expected, solution2862.maximumSum(nums));
    }
}