import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3357Tests {
    private final Solution3357 solution3357 = new Solution3357();

    @Test
    public void example1() {
        int[] nums = {1, 2, -1, 10, 8};
        int expected = 4;
        Assertions.assertEquals(expected, solution3357.minDifference(nums));
    }

    @Test
    public void example2() {
        int[] nums = {-1, -1, -1};
        int expected = 0;
        Assertions.assertEquals(expected, solution3357.minDifference(nums));
    }

    @Test
    public void example3() {
        int[] nums = {-1, 10, -1, 8};
        int expected = 1;
        Assertions.assertEquals(expected, solution3357.minDifference(nums));
    }
}