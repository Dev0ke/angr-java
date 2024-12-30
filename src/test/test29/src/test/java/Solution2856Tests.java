import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution2856Tests {
    private final Solution2856 solution2856 = new Solution2856();

    @Test
    public void example1() {
        List<Integer> nums = List.of(1, 3, 4, 9);
        int expected = 0;
        Assertions.assertEquals(expected, solution2856.minLengthAfterRemovals(nums));
    }

    @Test
    public void example2() {
        List<Integer> nums = List.of(2, 3, 6, 9);
        int expected = 0;
        Assertions.assertEquals(expected, solution2856.minLengthAfterRemovals(nums));
    }

    @Test
    public void example3() {
        List<Integer> nums = List.of(1, 1, 2);
        int expected = 1;
        Assertions.assertEquals(expected, solution2856.minLengthAfterRemovals(nums));
    }

    // 补充用例
    @Test
    public void example4() {
        // https://leetcode.cn/problems/minimum-array-length-after-pair-removals/submissions/466859480/
        // 不能同向双指针（堆）贪心
        List<Integer> nums = List.of(2, 3, 4, 4, 4);
        int expected = 1;
        Assertions.assertEquals(expected, solution2856.minLengthAfterRemovals(nums));
    }

    @Test
    public void example5() {
        // https://leetcode.cn/problems/minimum-array-length-after-pair-removals/submissions/466860623/
        // 不能相向双指针贪心
        List<Integer> nums = List.of(1, 3, 3, 3, 4);
        int expected = 1;
        Assertions.assertEquals(expected, solution2856.minLengthAfterRemovals(nums));
    }

    @Test
    public void example6() {
        // https://leetcode.cn/problems/minimum-array-length-after-pair-removals/submissions/466874028/
        List<Integer> nums = List.of(1, 1, 1, 1, 1, 1, 1, 2, 2);
        int expected = 5;
        Assertions.assertEquals(expected, solution2856.minLengthAfterRemovals(nums));
    }
}