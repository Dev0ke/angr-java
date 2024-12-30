import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1365Tests {
    private final Solution1365 solution1365 = new Solution1365();

    @Test
    public void example1() {
        int[] nums = {8, 1, 2, 2, 3};
        int[] expected = {4, 0, 1, 1, 3};
        Assertions.assertArrayEquals(expected, solution1365.smallerNumbersThanCurrent(nums));
    }

    @Test
    public void example2() {
        int[] nums = {6, 5, 4, 8};
        int[] expected = {2, 1, 0, 3};
        Assertions.assertArrayEquals(expected, solution1365.smallerNumbersThanCurrent(nums));
    }

    @Test
    public void example3() {
        int[] nums = {7, 7, 7, 7};
        int[] expected = {0, 0, 0, 0};
        Assertions.assertArrayEquals(expected, solution1365.smallerNumbersThanCurrent(nums));
    }
}
