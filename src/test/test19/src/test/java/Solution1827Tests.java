import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1827Tests {
    private final Solution1827 solution1827 = new Solution1827();

    @Test
    public void example1() {
        int[] nums = {1, 1, 1};
        int expected = 3;
        Assertions.assertEquals(expected, solution1827.minOperations(nums));
    }

    @Test
    public void example2() {
        int[] nums = {1, 5, 2, 4, 1};
        int expected = 14;
        Assertions.assertEquals(expected, solution1827.minOperations(nums));
    }

    @Test
    public void example3() {
        int[] nums = {8};
        int expected = 0;
        Assertions.assertEquals(expected, solution1827.minOperations(nums));
    }
}
