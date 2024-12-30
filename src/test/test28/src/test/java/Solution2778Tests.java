import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2778Tests {
    private final Solution2778 solution2778 = new Solution2778();

    @Test
    public void example1() {
        int[] nums = {1, 2, 3, 4};
        int expected = 21;
        Assertions.assertEquals(expected, solution2778.sumOfSquares(nums));
    }

    @Test
    public void example2() {
        int[] nums = {2, 7, 1, 19, 18, 3};
        int expected = 63;
        Assertions.assertEquals(expected, solution2778.sumOfSquares(nums));
    }
}