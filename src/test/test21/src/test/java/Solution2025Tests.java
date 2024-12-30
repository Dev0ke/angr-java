import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2025Tests {
    private final Solution2025 solution2025 = new Solution2025();

    @Test
    public void example1() {
        int[] nums = {2, -1, 2};
        int k = 3;
        int expected = 1;
        Assertions.assertEquals(expected, solution2025.waysToPartition(nums, k));
        Assertions.assertEquals(expected, solution2025.waysToPartition2(nums, k));
    }

    @Test
    public void example2() {
        int[] nums = {0, 0, 0};
        int k = 1;
        int expected = 2;
        Assertions.assertEquals(expected, solution2025.waysToPartition(nums, k));
        Assertions.assertEquals(expected, solution2025.waysToPartition2(nums, k));
    }

    @Test
    public void example3() {
        int[] nums = {22, 4, -25, -20, -15, 15, -16, 7, 19, -10, 0, -13, -14};
        int k = -33;
        int expected = 4;
        Assertions.assertEquals(expected, solution2025.waysToPartition(nums, k));
        Assertions.assertEquals(expected, solution2025.waysToPartition2(nums, k));
    }

    // 补充用例
    @Test
    public void example4() {
        // 119 / 178 个通过测试用例
        int[] nums = UtUtils.loadingInts("solution2025-example4-input.txt", 0);
        int k = UtUtils.loadingInt("solution2025-example4-input.txt", 1);
        int expected = 5003;
        Assertions.assertEquals(expected, solution2025.waysToPartition(nums, k));
        Assertions.assertEquals(expected, solution2025.waysToPartition2(nums, k));
    }

    @Test
    public void example5() {
        // 123 / 178 个通过测试用例
        int[] nums = UtUtils.loadingInts("solution2025-example5-input.txt", 0);
        int k = UtUtils.loadingInt("solution2025-example5-input.txt", 1);
        int expected = 43;
        Assertions.assertEquals(expected, solution2025.waysToPartition(nums, k));
        Assertions.assertEquals(expected, solution2025.waysToPartition2(nums, k));
    }
}
