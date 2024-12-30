import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2735Tests {
    private final Solution2735 solution2735 = new Solution2735();

    @Test
    public void example1() {
        int[] nums = {20, 1, 15};
        int x = 5;
        long expected = 13;
        Assertions.assertEquals(expected, solution2735.minCost(nums, x));
    }

    @Test
    public void example2() {
        int[] nums = {1, 2, 3};
        int x = 4;
        long expected = 6;
        Assertions.assertEquals(expected, solution2735.minCost(nums, x));
    }
}