import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution123Tests {
    private final Solution123 solution123 = new Solution123();

    @Test
    public void example1() {
        int[] prices = {3, 3, 5, 0, 0, 3, 1, 4};
        int expected = 6;
        Assertions.assertEquals(expected, solution123.maxProfit(prices));
    }

    @Test
    public void example2() {
        int[] prices = {1, 2, 3, 4, 5};
        int expected = 4;
        Assertions.assertEquals(expected, solution123.maxProfit(prices));
    }

    @Test
    public void example3() {
        int[] prices = {7, 6, 4, 3, 1};
        int expected = 0;
        Assertions.assertEquals(expected, solution123.maxProfit(prices));
    }

    @Test
    public void example4() {
        int[] prices = {1};
        int expected = 0;
        Assertions.assertEquals(expected, solution123.maxProfit(prices));
    }
}
