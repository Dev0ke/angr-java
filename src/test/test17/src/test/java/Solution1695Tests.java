import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1695Tests {
    private final Solution1695 solution1695 = new Solution1695();

    @Test
    public void example1() {
        int[] nums = {4, 2, 4, 5, 6};
        int expected = 17;
        Assertions.assertEquals(expected, solution1695.maximumUniqueSubarray(nums));
    }

    @Test
    public void example2() {
        int[] nums = {5, 2, 1, 2, 5, 2, 1, 2, 5};
        int expected = 8;
        Assertions.assertEquals(expected, solution1695.maximumUniqueSubarray(nums));
    }
}