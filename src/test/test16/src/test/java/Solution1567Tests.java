import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1567Tests {
    private final Solution1567 solution1567 = new Solution1567();

    @Test
    public void example1() {
        int[] nums = {1, -2, -3, 4};
        int expected = 4;
        Assertions.assertEquals(expected, solution1567.getMaxLen(nums));
    }

    @Test
    public void example2() {
        int[] nums = {0, 1, -2, -3, -4};
        int expected = 3;
        Assertions.assertEquals(expected, solution1567.getMaxLen(nums));
    }

    @Test
    public void example3() {
        int[] nums = {-1, -2, -3, 0, 1};
        int expected = 2;
        Assertions.assertEquals(expected, solution1567.getMaxLen(nums));
    }

    @Test
    public void example4() {
        int[] nums = {-1, 2};
        int expected = 1;
        Assertions.assertEquals(expected, solution1567.getMaxLen(nums));
    }

    @Test
    public void example5() {
        int[] nums = {1, 2, 3, 5, -6, 4, 0, 10};
        int expected = 4;
        Assertions.assertEquals(expected, solution1567.getMaxLen(nums));
    }
}
