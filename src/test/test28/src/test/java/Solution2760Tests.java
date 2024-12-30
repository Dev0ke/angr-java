import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2760Tests {
    private final Solution2760 solution2760 = new Solution2760();

    @Test
    public void example1() {
        int[] nums = {3, 2, 5, 4};
        int threshold = 5;
        int expected = 3;
        Assertions.assertEquals(expected, solution2760.longestAlternatingSubarray(nums, threshold));
    }

    @Test
    public void example2() {
        int[] nums = {1, 2};
        int threshold = 2;
        int expected = 1;
        Assertions.assertEquals(expected, solution2760.longestAlternatingSubarray(nums, threshold));
    }

    @Test
    public void example3() {
        int[] nums = {2, 3, 4, 5};
        int threshold = 4;
        int expected = 3;
        Assertions.assertEquals(expected, solution2760.longestAlternatingSubarray(nums, threshold));
    }
}