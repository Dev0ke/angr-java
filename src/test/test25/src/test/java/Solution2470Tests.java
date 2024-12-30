import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2470Tests {
    private final Solution2470 solution2470 = new Solution2470();

    @Test
    public void example1() {
        int[] nums = {3, 6, 2, 7, 1};
        int k = 6;
        int expected = 4;
        Assertions.assertEquals(expected, solution2470.subarrayLCM(nums, k));
    }

    @Test
    public void example2() {
        int[] nums = {3};
        int k = 2;
        int expected = 0;
        Assertions.assertEquals(expected, solution2470.subarrayLCM(nums, k));
    }

    // 补充用例
    @Test
    public void example3() {
        // hack
        int[] nums = {8, 11, 103, 613, 773};
        int k = 40;
        int expected = 0;
        Assertions.assertEquals(expected, solution2470.subarrayLCM(nums, k));
    }
}
