import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution446Tests {
    private final Solution446 solution446 = new Solution446();

    @Test
    public void example1() {
        int[] nums = {2, 4, 6, 8, 10};
        int expected = 7;
        Assertions.assertEquals(expected, solution446.numberOfArithmeticSlices(nums));
    }

    @Test
    public void example2() {
        int[] nums = {7, 7, 7, 7, 7};
        int expected = 16;
        Assertions.assertEquals(expected, solution446.numberOfArithmeticSlices(nums));
    }
}