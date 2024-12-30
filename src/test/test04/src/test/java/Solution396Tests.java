import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution396Tests {
    private final Solution396 solution396 = new Solution396();

    @Test
    public void example1() {
        int[] nums = {4, 3, 2, 6};
        int expected = 26;
        Assertions.assertEquals(expected, solution396.maxRotateFunction(nums));
    }

    @Test
    public void example2() {
        int[] nums = {100};
        int expected = 0;
        Assertions.assertEquals(expected, solution396.maxRotateFunction(nums));
    }
}