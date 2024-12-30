import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2460Tests {
    private final Solution2460 solution2460 = new Solution2460();

    @Test
    public void example1() {
        int[] nums = {1, 2, 2, 1, 1, 0};
        int[] expected = {1, 4, 2, 0, 0, 0};
        Assertions.assertArrayEquals(expected, solution2460.applyOperations(nums));
    }

    @Test
    public void example2() {
        int[] nums = {0, 1};
        int[] expected = {1, 0};
        Assertions.assertArrayEquals(expected, solution2460.applyOperations(nums));
    }
}
