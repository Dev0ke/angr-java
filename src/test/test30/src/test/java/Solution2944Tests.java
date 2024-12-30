import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2944Tests {
    private final Solution2944 solution2944 = new Solution2944();

    @Test
    public void example1() {
        int[] prices = {3, 1, 2};
        int expected = 4;
        Assertions.assertEquals(expected, solution2944.minimumCoins(prices));
        Assertions.assertEquals(expected, solution2944.minimumCoins1(prices));
        Assertions.assertEquals(expected, solution2944.minimumCoins2(prices));
        Assertions.assertEquals(expected, solution2944.minimumCoins3(prices));
    }

    @Test
    public void example2() {
        int[] prices = {1, 10, 1, 1};
        int expected = 2;
        Assertions.assertEquals(expected, solution2944.minimumCoins(prices));
        Assertions.assertEquals(expected, solution2944.minimumCoins1(prices));
        Assertions.assertEquals(expected, solution2944.minimumCoins2(prices));
        Assertions.assertEquals(expected, solution2944.minimumCoins3(prices));
    }
}