import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution2811Tests {
    private final Solution2811 solution2811 = new Solution2811();

    @Test
    public void example1() {
        List<Integer> nums = List.of(2, 2, 1);
        int m = 4;
        Assertions.assertTrue(solution2811.canSplitArray(nums, m));
    }

    @Test
    public void example2() {
        List<Integer> nums = List.of(2, 1, 3);
        int m = 5;
        Assertions.assertFalse(solution2811.canSplitArray(nums, m));
    }

    @Test
    public void example3() {
        List<Integer> nums = List.of(2, 3, 3, 2, 3);
        int m = 6;
        Assertions.assertTrue(solution2811.canSplitArray(nums, m));
    }

    // 补充用例
    @Test
    public void example4() {
        // https://leetcode.cn/submissions/detail/453792269/
        List<Integer> nums = List.of(1);
        int m = 1;
        Assertions.assertTrue(solution2811.canSplitArray(nums, m));
    }

    @Test
    public void example5() {
        // https://leetcode.cn/submissions/detail/453792330/
        List<Integer> nums = List.of(1, 1);
        int m = 3;
        Assertions.assertTrue(solution2811.canSplitArray(nums, m));
    }
}