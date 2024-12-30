import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2547Tests {
    private final Solution2547 solution2547 = new Solution2547();

    @Test
    public void example1() {
        int[] nums = {1, 2, 1, 2, 1, 3, 3};
        int k = 2;
        int expected = 8;
        Assertions.assertEquals(expected, solution2547.minCost(nums, k));
    }

    @Test
    public void example2() {
        int[] nums = {1, 2, 1, 2, 1};
        int k = 2;
        int expected = 6;
        Assertions.assertEquals(expected, solution2547.minCost(nums, k));
    }

    @Test
    public void example3() {
        int[] nums = {1, 2, 1, 2, 1};
        int k = 5;
        int expected = 10;
        Assertions.assertEquals(expected, solution2547.minCost(nums, k));
    }
}