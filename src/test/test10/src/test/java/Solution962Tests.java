import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution962Tests {
    private final Solution962 solution962 = new Solution962();

    @Test
    public void example1() {
        int[] nums = {6, 0, 8, 2, 1, 5};
        int expected = 4;
        Assertions.assertEquals(expected, solution962.maxWidthRamp(nums));
    }

    @Test
    public void example2() {
        int[] nums = {9, 8, 1, 0, 1, 9, 4, 0, 4, 1};
        int expected = 7;
        Assertions.assertEquals(expected, solution962.maxWidthRamp(nums));
    }
}