import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2149Tests {
    private final Solution2149 solution2149 = new Solution2149();

    @Test
    public void example1() {
        int[] nums = {3, 1, -2, -5, 2, -4};
        int[] expected = {3, -2, 1, -5, 2, -4};
        Assertions.assertArrayEquals(expected, solution2149.rearrangeArray(nums));
    }

    @Test
    public void example2() {
        int[] nums = {-1, 1};
        int[] expected = {1, -1};
        Assertions.assertArrayEquals(expected, solution2149.rearrangeArray(nums));
    }
}
