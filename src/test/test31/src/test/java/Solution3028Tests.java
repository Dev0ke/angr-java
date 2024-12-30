import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3028Tests {
    private final Solution3028 solution3028 = new Solution3028();

    @Test
    public void example1() {
        int[] nums = {2, 3, -5};
        int expected = 1;
        Assertions.assertEquals(expected, solution3028.returnToBoundaryCount(nums));
    }

    @Test
    public void example2() {
        int[] nums = {3, 2, -3, -4};
        int expected = 0;
        Assertions.assertEquals(expected, solution3028.returnToBoundaryCount(nums));
    }
}