import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2441Tests {
    private final Solution2441 solution2441 = new Solution2441();

    @Test
    public void example1() {
        int[] nums = {-1, 2, -3, 3};
        int expected = 3;
        Assertions.assertEquals(expected, solution2441.findMaxK(nums));
    }

    @Test
    public void example2() {
        int[] nums = {-1, 10, 6, 7, -7, 1};
        int expected = 7;
        Assertions.assertEquals(expected, solution2441.findMaxK(nums));
    }

    @Test
    public void example3() {
        int[] nums = {-10, 8, 6, 7, -2, -3};
        int expected = -1;
        Assertions.assertEquals(expected, solution2441.findMaxK(nums));
    }
}
