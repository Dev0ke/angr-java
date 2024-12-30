import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1509Tests {
    private final Solution1509 solution1509 = new Solution1509();

    @Test
    public void example1() {
        int[] nums = {5, 3, 2, 4};
        int expected = 0;
        Assertions.assertEquals(expected, solution1509.minDifference(nums));
    }

    @Test
    public void example2() {
        int[] nums = {1, 5, 0, 10, 14};
        int expected = 1;
        Assertions.assertEquals(expected, solution1509.minDifference(nums));
    }

    @Test
    public void example3() {
        int[] nums = {3, 100, 20};
        int expected = 0;
        Assertions.assertEquals(expected, solution1509.minDifference(nums));
    }
}