import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2875Tests {
    private final Solution2875 solution2875 = new Solution2875();

    @Test
    public void example1() {
        int[] nums = {1, 2, 3};
        int target = 5;
        int expected = 2;
        Assertions.assertEquals(expected, solution2875.minSizeSubarray(nums, target));
    }

    @Test
    public void example2() {
        int[] nums = {1, 1, 1, 2, 3};
        int target = 4;
        int expected = 2;
        Assertions.assertEquals(expected, solution2875.minSizeSubarray(nums, target));
    }

    @Test
    public void example3() {
        int[] nums = {2, 4, 6, 8};
        int target = 3;
        int expected = -1;
        Assertions.assertEquals(expected, solution2875.minSizeSubarray(nums, target));
    }
}