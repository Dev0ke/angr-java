import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution673Tests {
    private final Solution673 solution673 = new Solution673();

    @Test
    public void example1() {
        int[] nums = {1, 3, 5, 4, 7};
        int expected = 2;
        Assertions.assertEquals(expected, solution673.findNumberOfLIS(nums));
    }

    @Test
    public void example2() {
        int[] nums = {2, 2, 2, 2, 2};
        int expected = 5;
        Assertions.assertEquals(expected, solution673.findNumberOfLIS(nums));
    }
}
