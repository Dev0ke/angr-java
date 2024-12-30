import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2183Tests {
    private final Solution2183 solution2183 = new Solution2183();

    @Test
    public void example1() {
        int[] nums = {1, 2, 3, 4, 5};
        int k = 2;
        long expected = 7;
        Assertions.assertEquals(expected, solution2183.countPairs(nums, k));
        Assertions.assertEquals(expected, solution2183.countPairs2(nums, k));
    }

    @Test
    public void example2() {
        int[] nums = {1, 2, 3, 4};
        int k = 5;
        long expected = 0;
        Assertions.assertEquals(expected, solution2183.countPairs(nums, k));
        Assertions.assertEquals(expected, solution2183.countPairs2(nums, k));
    }

    // 补充用例
    @Test
    public void example3() {
        int[] nums = UtUtils.loadingInts("solution2183-example3-input.txt", 0);
        int k = UtUtils.loadingInt("solution2183-example3-input.txt", 1);
        long expected = 112655;
        Assertions.assertEquals(expected, solution2183.countPairs(nums, k));
    }
}
