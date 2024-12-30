import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution134Tests {
    private final Solution134 solution134 = new Solution134();

    @Test
    public void example1() {
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};
        int expected = 3;
        Assertions.assertEquals(expected, solution134.canCompleteCircuit(gas, cost));
    }

    @Test
    public void example2() {
        int[] gas = {2, 3, 4};
        int[] cost = {3, 4, 3};
        int expected = -1;
        Assertions.assertEquals(expected, solution134.canCompleteCircuit(gas, cost));
    }
}
