import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1558Tests {
    private final Solution1558 solution1558 = new Solution1558();

    @Test
    public void example1() {
        int[] nums = {1, 5};
        int expected = 5;
        Assertions.assertEquals(expected, solution1558.minOperations(nums));
    }

    @Test
    public void example2() {
        int[] nums = {2, 2};
        int expected = 3;
        Assertions.assertEquals(expected, solution1558.minOperations(nums));
    }

    @Test
    public void example3() {
        int[] nums = {4, 2, 5};
        int expected = 6;
        Assertions.assertEquals(expected, solution1558.minOperations(nums));
    }

    @Test
    public void example4() {
        int[] nums = {3, 2, 2, 4};
        int expected = 7;
        Assertions.assertEquals(expected, solution1558.minOperations(nums));
    }

    @Test
    public void example5() {
        int[] nums = {2, 4, 8, 16};
        int expected = 8;
        Assertions.assertEquals(expected, solution1558.minOperations(nums));
    }
}