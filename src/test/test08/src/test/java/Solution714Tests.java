import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution714Tests {
    private final Solution714 solution714 = new Solution714();

    @Test
    public void example1() {
        int[] prices = {1, 3, 2, 8, 4, 9};
        int fee = 2;
        int expected = 8;
        Assertions.assertEquals(expected, solution714.maxProfit(prices, fee));
    }

    @Test
    public void example2() {
        int[] prices = {1, 3, 7, 5, 10, 3};
        int fee = 3;
        int expected = 6;
        Assertions.assertEquals(expected, solution714.maxProfit(prices, fee));
    }
}
