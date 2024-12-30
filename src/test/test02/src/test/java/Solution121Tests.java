import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution121Tests {
    private final Solution121 solution121 = new Solution121();

    @Test
    public void example1() {
        int[] prices = {7, 1, 5, 3, 6, 4};
        int expected = 5;
        Assertions.assertEquals(expected, solution121.maxProfit(prices));
    }

    @Test
    public void example2() {
        int[] prices = {7, 6, 4, 3, 1};
        int expected = 0;
        Assertions.assertEquals(expected, solution121.maxProfit(prices));
    }
}
