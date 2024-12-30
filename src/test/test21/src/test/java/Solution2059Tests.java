import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2059Tests {
    private final Solution2059 solution2059 = new Solution2059();

    @Test
    public void example1() {
        int[] nums = {1, 3};
        int start = 6;
        int goal = 4;
        int expected = 2;
        Assertions.assertEquals(expected, solution2059.minimumOperations(nums, start, goal));
    }

    @Test
    public void example2() {
        int[] nums = {2, 4, 12};
        int start = 2;
        int goal = 12;
        int expected = 2;
        Assertions.assertEquals(expected, solution2059.minimumOperations(nums, start, goal));
    }

    @Test
    public void example3() {
        int[] nums = {3, 5, 7};
        int start = 0;
        int goal = -4;
        int expected = 2;
        Assertions.assertEquals(expected, solution2059.minimumOperations(nums, start, goal));
    }

    @Test
    public void example4() {
        int[] nums = {2, 8, 16};
        int start = 0;
        int goal = 1;
        int expected = -1;
        Assertions.assertEquals(expected, solution2059.minimumOperations(nums, start, goal));
    }

    @Test
    public void example5() {
        int[] nums = {1};
        int start = 0;
        int goal = 3;
        int expected = 3;
        Assertions.assertEquals(expected, solution2059.minimumOperations(nums, start, goal));
    }
}
