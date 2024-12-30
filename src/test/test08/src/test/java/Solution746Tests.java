import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution746Tests {
    private final Solution746 solution746 = new Solution746();

    @Test
    public void example1() {
        int[] cost = {10, 15, 20};
        int expected = 15;
        Assertions.assertEquals(expected, solution746.minCostClimbingStairs(cost));
    }

    @Test
    public void example2() {
        int[] cost = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        int expected = 6;
        Assertions.assertEquals(expected, solution746.minCostClimbingStairs(cost));
    }
}
