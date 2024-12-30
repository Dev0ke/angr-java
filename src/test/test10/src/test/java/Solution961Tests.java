import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution961Tests {
    private final Solution961 solution961 = new Solution961();

    @Test
    public void example1() {
        int[] nums = {1, 2, 3, 3};
        int expected = 3;
        Assertions.assertEquals(expected, solution961.repeatedNTimes(nums));
    }

    @Test
    public void example2() {
        int[] nums = {2, 1, 2, 5, 3, 2};
        int expected = 2;
        Assertions.assertEquals(expected, solution961.repeatedNTimes(nums));
    }

    @Test
    public void example3() {
        int[] nums = {5, 1, 5, 2, 5, 3, 5, 4};
        int expected = 5;
        Assertions.assertEquals(expected, solution961.repeatedNTimes(nums));
    }
}
