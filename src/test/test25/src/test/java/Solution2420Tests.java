import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution2420Tests {
    private final Solution2420 solution2420 = new Solution2420();

    @Test
    public void example1() {
        int[] nums = {2, 1, 1, 1, 3, 4, 1};
        int k = 2;
        List<Integer> expected = List.of(2, 3);
        Assertions.assertEquals(expected, solution2420.goodIndices(nums, k));
    }

    @Test
    public void example2() {
        int[] nums = {2, 1, 1, 2};
        int k = 2;
        List<Integer> expected = new ArrayList<>();
        Assertions.assertEquals(expected, solution2420.goodIndices(nums, k));
    }

    // 补充用例
    @Test
    public void example3() {
        // https://leetcode.cn/submissions/detail/368873726/
        // k = 1 时 特判
        int[] nums = {440043, 276285, 336957};
        int k = 1;
        List<Integer> expected = List.of(1);
        Assertions.assertEquals(expected, solution2420.goodIndices(nums, k));
    }
}
