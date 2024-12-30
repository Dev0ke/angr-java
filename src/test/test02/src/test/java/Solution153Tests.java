import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution153Tests {
    private final Solution153 solution153 = new Solution153();

    @Test
    public void example1() {
        int[] nums = {3, 4, 5, 1, 2};
        int expected = 1;
        Assertions.assertEquals(expected, solution153.findMin(nums));
    }

    @Test
    public void example2() {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int expected = 0;
        Assertions.assertEquals(expected, solution153.findMin(nums));
    }

    @Test
    public void example3() {
        int[] nums = {11, 13, 15, 17};
        int expected = 11;
        Assertions.assertEquals(expected, solution153.findMin(nums));
    }
}
