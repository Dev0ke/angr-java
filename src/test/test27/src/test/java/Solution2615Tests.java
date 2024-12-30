import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2615Tests {
    private final Solution2615 solution2615 = new Solution2615();

    @Test
    public void example1() {
        int[] nums = {1, 3, 1, 1, 2};
        long[] expected = {5, 0, 3, 4, 0};
        Assertions.assertArrayEquals(expected, solution2615.distance(nums));
    }

    @Test
    public void example2() {
        int[] nums = {0, 5, 3};
        long[] expected = {0, 0, 0};
        Assertions.assertArrayEquals(expected, solution2615.distance(nums));
    }
}