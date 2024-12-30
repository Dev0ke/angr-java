import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1590Tests {
    private final Solution1590 solution1590 = new Solution1590();

    @Test
    public void example1() {
        int[] nums = {3, 1, 4, 2};
        int p = 6;
        int expected = 1;
        Assertions.assertEquals(expected, solution1590.minSubarray(nums, p));
    }

    @Test
    public void example2() {
        int[] nums = {6, 3, 5, 2};
        int p = 9;
        int expected = 2;
        Assertions.assertEquals(expected, solution1590.minSubarray(nums, p));
    }

    @Test
    public void example3() {
        int[] nums = {1, 2, 3};
        int p = 3;
        int expected = 0;
        Assertions.assertEquals(expected, solution1590.minSubarray(nums, p));
    }

    @Test
    public void example4() {
        int[] nums = {1, 2, 3};
        int p = 7;
        int expected = -1;
        Assertions.assertEquals(expected, solution1590.minSubarray(nums, p));
    }

    @Test
    public void example5() {
        int[] nums = {1000000000, 1000000000, 1000000000};
        int p = 3;
        int expected = 0;
        Assertions.assertEquals(expected, solution1590.minSubarray(nums, p));
    }
}
