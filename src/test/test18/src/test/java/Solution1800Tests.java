import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1800Tests {
    private final Solution1800 solution1800 = new Solution1800();

    @Test
    public void example1() {
        int[] nums = {10, 20, 30, 5, 10, 50};
        int expected = 65;
        Assertions.assertEquals(expected, solution1800.maxAscendingSum(nums));
    }

    @Test
    public void example2() {
        int[] nums = {10, 20, 30, 40, 50};
        int expected = 150;
        Assertions.assertEquals(expected, solution1800.maxAscendingSum(nums));
    }

    @Test
    public void example3() {
        int[] nums = {12, 17, 15, 13, 10, 11, 12};
        int expected = 33;
        Assertions.assertEquals(expected, solution1800.maxAscendingSum(nums));
    }

    @Test
    public void example4() {
        int[] nums = {100, 10, 1};
        int expected = 100;
        Assertions.assertEquals(expected, solution1800.maxAscendingSum(nums));
    }
}
