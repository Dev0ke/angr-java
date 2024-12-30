import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1755Tests {
    private final Solution1755 solution1755 = new Solution1755();

    @Test
    public void example1() {
        int[] nums = {5, -7, 3, 5};
        int goal = 6;
        int expected = 0;
        Assertions.assertEquals(expected, solution1755.minAbsDifference(nums, goal));
    }

    @Test
    public void example2() {
        int[] nums = {7, -9, 15, -2};
        int goal = -5;
        int expected = 1;
        Assertions.assertEquals(expected, solution1755.minAbsDifference(nums, goal));
    }

    @Test
    public void example3() {
        int[] nums = {1, 2, 3};
        int goal = -7;
        int expected = 7;
        Assertions.assertEquals(expected, solution1755.minAbsDifference(nums, goal));
    }
}
