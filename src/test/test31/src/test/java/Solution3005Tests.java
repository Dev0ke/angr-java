import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3005Tests {
    private final Solution3005 solution3005 = new Solution3005();

    @Test
    public void example1() {
        int[] nums = {1, 2, 2, 3, 1, 4};
        int expected = 4;
        Assertions.assertEquals(expected, solution3005.maxFrequencyElements(nums));
    }

    @Test
    public void example2() {
        int[] nums = {1, 2, 3, 4, 5};
        int expected = 5;
        Assertions.assertEquals(expected, solution3005.maxFrequencyElements(nums));
    }
}