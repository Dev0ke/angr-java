import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2162Tests {
    private final Solution2162 solution2162 = new Solution2162();

    @Test
    public void example1() {
        int startAt = 1;
        int moveCost = 2;
        int pushCost = 1;
        int targetSeconds = 600;
        int expected = 6;
        Assertions.assertEquals(expected, solution2162.minCostSetTime(startAt, moveCost, pushCost, targetSeconds));
    }

    @Test
    public void example2() {
        int startAt = 0;
        int moveCost = 1;
        int pushCost = 2;
        int targetSeconds = 76;
        int expected = 6;
        Assertions.assertEquals(expected, solution2162.minCostSetTime(startAt, moveCost, pushCost, targetSeconds));
    }
}
