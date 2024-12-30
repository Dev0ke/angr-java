import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2529Tests {
    private final Solution2529 solution2529 = new Solution2529();

    @Test
    public void example1() {
        int[] nums = {-2, -1, -1, 1, 2, 3};
        int expected = 3;
        Assertions.assertEquals(expected, solution2529.maximumCount(nums));
    }

    @Test
    public void example2() {
        int[] nums = {-3, -2, -1, 0, 0, 1, 2};
        int expected = 3;
        Assertions.assertEquals(expected, solution2529.maximumCount(nums));
    }

    @Test
    public void example3() {
        int[] nums = {5, 20, 66, 1314};
        int expected = 4;
        Assertions.assertEquals(expected, solution2529.maximumCount(nums));
    }
}
