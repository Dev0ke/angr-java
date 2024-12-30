import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1480Tests {
    private final Solution1480 solution1480 = new Solution1480();

    @Test
    public void example1() {
        int[] nums = {1, 2, 3, 4};
        int[] expected = {1, 3, 6, 10};
        Assertions.assertArrayEquals(expected, solution1480.runningSum(nums));
    }

    @Test
    public void example2() {
        int[] nums = {1, 1, 1, 1, 1};
        int[] expected = {1, 2, 3, 4, 5};
        Assertions.assertArrayEquals(expected, solution1480.runningSum(nums));
    }

    @Test
    public void example3() {
        int[] nums = {3, 1, 2, 10, 1};
        int[] expected = {3, 4, 6, 16, 17};
        Assertions.assertArrayEquals(expected, solution1480.runningSum(nums));
    }
}
