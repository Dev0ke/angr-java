import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution674Tests {
    private final Solution674 solution674 = new Solution674();

    @Test
    public void example1() {
        int[] nums = {1, 3, 5, 4, 7};
        int expected = 3;
        Assertions.assertEquals(expected, solution674.findLengthOfLCIS(nums));
    }

    @Test
    public void example2() {
        int[] nums = {2, 2, 2, 2, 2};
        int expected = 1;
        Assertions.assertEquals(expected, solution674.findLengthOfLCIS(nums));
    }
}