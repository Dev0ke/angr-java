import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1546Tests {
    private final Solution1546 solution1546 = new Solution1546();

    @Test
    public void example1() {
        int[] nums = {1, 1, 1, 1, 1};
        int target = 2;
        int expected = 2;
        Assertions.assertEquals(expected, solution1546.maxNonOverlapping(nums, target));
    }

    @Test
    public void example2() {
        int[] nums = {-1, 3, 5, 1, 4, 2, -9};
        int target = 6;
        int expected = 2;
        Assertions.assertEquals(expected, solution1546.maxNonOverlapping(nums, target));
    }

    @Test
    public void example3() {
        int[] nums = {-2, 6, 6, 3, 5, 4, 1, 2, 8};
        int target = 10;
        int expected = 3;
        Assertions.assertEquals(expected, solution1546.maxNonOverlapping(nums, target));
    }

    @Test
    public void example4() {
        int[] nums = {0, 0, 0};
        int target = 0;
        int expected = 3;
        Assertions.assertEquals(expected, solution1546.maxNonOverlapping(nums, target));
    }
}