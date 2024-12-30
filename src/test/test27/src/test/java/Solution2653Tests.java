import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2653Tests {
    private final Solution2653 solution2653 = new Solution2653();

    @Test
    public void example1() {
        int[] nums = {1, -1, -3, -2, 3};
        int k = 3;
        int x = 2;
        int[] expected = {-1, -2, -2};
        Assertions.assertArrayEquals(expected, solution2653.getSubarrayBeauty(nums, k, x));
    }

    @Test
    public void example2() {
        int[] nums = {-1, -2, -3, -4, -5};
        int k = 2;
        int x = 2;
        int[] expected = {-1, -2, -3, -4};
        Assertions.assertArrayEquals(expected, solution2653.getSubarrayBeauty(nums, k, x));
    }

    @Test
    public void example3() {
        int[] nums = {-3, 1, 2, -3, 0, -3};
        int k = 2;
        int x = 1;
        int[] expected = {-3, 0, -3, -3, -3};
        Assertions.assertArrayEquals(expected, solution2653.getSubarrayBeauty(nums, k, x));
    }
}