import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2122Tests {
    private final Solution2122 solution2122 = new Solution2122();

    @Test
    public void example1() {
        int[] nums = {2, 10, 6, 4, 8, 12};
        int[] expected = {3, 7, 11};
        Assertions.assertArrayEquals(expected, solution2122.recoverArray(nums));
    }

    @Test
    public void example2() {
        int[] nums = {1, 1, 3, 3};
        int[] expected = {2, 2};
        Assertions.assertArrayEquals(expected, solution2122.recoverArray(nums));
    }

    @Test
    public void example3() {
        int[] nums = {5, 435};
        int[] expected = {220};
        Assertions.assertArrayEquals(expected, solution2122.recoverArray(nums));
    }
}
