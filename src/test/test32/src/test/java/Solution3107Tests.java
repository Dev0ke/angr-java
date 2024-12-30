import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3107Tests {
    private final Solution3107 solution3107 = new Solution3107();

    @Test
    public void example1() {
        int[] nums = {2, 5, 6, 8, 5};
        int k = 4;
        long expected = 2;
        Assertions.assertEquals(expected, solution3107.minOperationsToMakeMedianK(nums, k));
    }

    @Test
    public void example2() {
        int[] nums = {2, 5, 6, 8, 5};
        int k = 7;
        long expected = 3;
        Assertions.assertEquals(expected, solution3107.minOperationsToMakeMedianK(nums, k));
    }

    @Test
    public void example3() {
        int[] nums = {1, 2, 3, 4, 5, 6};
        int k = 4;
        long expected = 0;
        Assertions.assertEquals(expected, solution3107.minOperationsToMakeMedianK(nums, k));
    }
}