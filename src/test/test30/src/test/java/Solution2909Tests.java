import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2909Tests {
    private final Solution2909 solution2909 = new Solution2909();

    @Test
    public void example1() {
        int[] nums = {8, 6, 1, 5, 3};
        int expected = 9;
        Assertions.assertEquals(expected, solution2909.minimumSum(nums));
    }

    @Test
    public void example2() {
        int[] nums = {5, 4, 8, 7, 10, 2};
        int expected = 13;
        Assertions.assertEquals(expected, solution2909.minimumSum(nums));
    }

    @Test
    public void example3() {
        int[] nums = {6, 5, 4, 3, 4, 5};
        int expected = -1;
        Assertions.assertEquals(expected, solution2909.minimumSum(nums));
    }
}