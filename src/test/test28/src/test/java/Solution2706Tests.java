import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2706Tests {
    private final Solution2706 solution2706 = new Solution2706();

    @Test
    public void example1() {
        int[] prices = {1, 2, 2};
        int money = 3;
        int expected = 0;
        Assertions.assertEquals(expected, solution2706.buyChoco(prices, money));
    }

    @Test
    public void example2() {
        int[] prices = {3, 2, 3};
        int money = 3;
        int expected = 3;
        Assertions.assertEquals(expected, solution2706.buyChoco(prices, money));
    }
}