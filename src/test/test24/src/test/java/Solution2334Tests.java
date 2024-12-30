import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2334Tests {
    private final Solution2334 solution2334 = new Solution2334();

    @Test
    public void example1() {
        int[] nums = {1, 3, 4, 3, 1};
        int threshold = 6;
        int expected = 3;
        Assertions.assertEquals(expected, solution2334.validSubarraySize(nums, threshold));
    }

    @Test
    public void example2() {
        int[] nums = {6, 5, 6, 5, 8};
        int threshold = 7;
        int expected = 1;
        Assertions.assertEquals(expected, solution2334.validSubarraySize(nums, threshold));
    }

    // 补充用例
    @Test
    public void example3() {
        int[] nums = {818, 232, 595, 418, 608, 229, 37, 330, 876, 774, 931, 939, 479, 884, 354, 328};
        int threshold = 3790;
        int expected = -1;
        Assertions.assertEquals(expected, solution2334.validSubarraySize(nums, threshold));
    }
}
