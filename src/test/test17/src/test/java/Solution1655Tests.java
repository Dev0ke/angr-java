import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1655Tests {
    private final Solution1655 solution1655 = new Solution1655();

    @Test
    public void example1() {
        int[] nums = {1, 2, 3, 4};
        int[] quantity = {2};
        Assertions.assertFalse(solution1655.canDistribute(nums, quantity));
    }

    @Test
    public void example2() {
        int[] nums = {1, 2, 3, 3};
        int[] quantity = {2};
        Assertions.assertTrue(solution1655.canDistribute(nums, quantity));
    }

    @Test
    public void example3() {
        int[] nums = {1, 1, 2, 2};
        int[] quantity = {2, 2};
        Assertions.assertTrue(solution1655.canDistribute(nums, quantity));
    }
}
