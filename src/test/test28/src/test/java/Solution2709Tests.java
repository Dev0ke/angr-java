import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2709Tests {
    private final Solution2709 solution2709 = new Solution2709();

    @Test
    public void example1() {
        int[] nums = {2, 3, 6};
        Assertions.assertTrue(solution2709.canTraverseAllPairs(nums));
    }

    @Test
    public void example2() {
        int[] nums = {3, 9, 5};
        Assertions.assertFalse(solution2709.canTraverseAllPairs(nums));
    }

    @Test
    public void example3() {
        int[] nums = {4, 3, 12, 8};
        Assertions.assertTrue(solution2709.canTraverseAllPairs(nums));
    }

    // 补充用例
    @Test
    public void example4() {
        // https://leetcode.cn/submissions/detail/435766987/
        int[] nums = {1, 1};
        Assertions.assertFalse(solution2709.canTraverseAllPairs(nums));
    }
}