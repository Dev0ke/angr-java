import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1909Tests {
    private final Solution1909 solution1909 = new Solution1909();

    @Test
    public void example1() {
        int[] nums = {1, 2, 10, 5, 7};
        Assertions.assertTrue(solution1909.canBeIncreasing(nums));
    }

    @Test
    public void example2() {
        int[] nums = {2, 3, 1, 2};
        Assertions.assertFalse(solution1909.canBeIncreasing(nums));
    }

    @Test
    public void example3() {
        int[] nums = {1, 1, 1};
        Assertions.assertFalse(solution1909.canBeIncreasing(nums));
    }

    @Test
    public void example4() {
        int[] nums = {1, 2, 3};
        Assertions.assertTrue(solution1909.canBeIncreasing(nums));
    }

    /**
     * 89 / 109 个通过测试用例。原因为只考虑了删除 i 而没考虑删除 i+1 的场景
     */
    @Test
    public void example5() {
        int[] nums = {105, 924, 32, 968};
        Assertions.assertTrue(solution1909.canBeIncreasing(nums));
    }
}
