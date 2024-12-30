import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2970Tests {
    private final Solution2970 solution2970 = new Solution2970();

    @Test
    public void example1() {
        int[] nums = {1, 2, 3, 4};
        int expected = 10;
        Assertions.assertEquals(expected, solution2970.incremovableSubarrayCount(nums));
    }

    @Test
    public void example2() {
        int[] nums = {6, 5, 7, 8};
        int expected = 7;
        Assertions.assertEquals(expected, solution2970.incremovableSubarrayCount(nums));
    }

    @Test
    public void example3() {
        int[] nums = {8, 7, 6, 6};
        int expected = 3;
        Assertions.assertEquals(expected, solution2970.incremovableSubarrayCount(nums));
    }
}