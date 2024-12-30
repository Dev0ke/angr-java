import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2110Tests {
    private final Solution2110 solution2110 = new Solution2110();

    @Test
    public void example1() {
        int[] prices = {3, 2, 1, 4};
        int expected = 7;
        Assertions.assertEquals(expected, solution2110.getDescentPeriods(prices));
    }

    @Test
    public void example2() {
        int[] prices = {8, 6, 7, 7};
        int expected = 4;
        Assertions.assertEquals(expected, solution2110.getDescentPeriods(prices));
    }

    @Test
    public void example3() {
        int[] prices = {1};
        int expected = 1;
        Assertions.assertEquals(expected, solution2110.getDescentPeriods(prices));
    }
}
