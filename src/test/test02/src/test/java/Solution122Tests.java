import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution122Tests {
    private final Solution122 solution122 = new Solution122();

    @Test
    public void example1() {
        int[] prices = {7, 1, 5, 3, 6, 4};
        int expected = 7;
        Assertions.assertEquals(expected, solution122.maxProfit(prices));
    }

    @Test
    public void example2() {
        int[] prices = {1, 2, 3, 4, 5};
        int expected = 4;
        Assertions.assertEquals(expected, solution122.maxProfit(prices));
    }

    @Test
    public void example3() {
        int[] prices = {7, 6, 4, 3, 1};
        int expected = 0;
        Assertions.assertEquals(expected, solution122.maxProfit(prices));
    }
}
