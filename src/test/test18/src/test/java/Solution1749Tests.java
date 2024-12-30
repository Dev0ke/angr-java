import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1749Tests {
    private final Solution1749 solution1749 = new Solution1749();

    @Test
    public void example1() {
        int[] nums = {1, -3, 2, 3, -4};
        int expected = 5;
        Assertions.assertEquals(expected, solution1749.maxAbsoluteSum(nums));
    }

    @Test
    public void example2() {
        int[] nums = {2, -5, 1, -4, 3, -2};
        int expected = 8;
        Assertions.assertEquals(expected, solution1749.maxAbsoluteSum(nums));
    }
}