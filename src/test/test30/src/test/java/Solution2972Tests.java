import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2972Tests {
    private final Solution2972 solution2972 = new Solution2972();

    @Test
    public void example1() {
        int[] nums = {1, 2, 3, 4};
        long expected = 10;
        Assertions.assertEquals(expected, solution2972.incremovableSubarrayCount(nums));
    }

    @Test
    public void example2() {
        int[] nums = {6, 5, 7, 8};
        long expected = 7;
        Assertions.assertEquals(expected, solution2972.incremovableSubarrayCount(nums));
    }

    @Test
    public void example3() {
        int[] nums = {8, 7, 6, 6};
        long expected = 3;
        Assertions.assertEquals(expected, solution2972.incremovableSubarrayCount(nums));
    }
}