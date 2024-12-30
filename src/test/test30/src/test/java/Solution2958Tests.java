import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2958Tests {
    private final Solution2958 solution2958 = new Solution2958();

    @Test
    public void example1() {
        int[] nums = {1, 2, 3, 1, 2, 3, 1, 2};
        int k = 2;
        int expected = 6;
        Assertions.assertEquals(expected, solution2958.maxSubarrayLength(nums, k));
    }

    @Test
    public void example2() {
        int[] nums = {1, 2, 1, 2, 1, 2, 1, 2};
        int k = 1;
        int expected = 2;
        Assertions.assertEquals(expected, solution2958.maxSubarrayLength(nums, k));
    }

    @Test
    public void example3() {
        int[] nums = {5, 5, 5, 5, 5, 5, 5};
        int k = 4;
        int expected = 4;
        Assertions.assertEquals(expected, solution2958.maxSubarrayLength(nums, k));
    }
}