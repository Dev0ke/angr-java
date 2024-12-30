import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution309Tests {
    private final Solution309 solution309 = new Solution309();

    @Test
    public void example1() {
        int[] prices = {1, 2, 3, 0, 2};
        int expected = 3;
        Assertions.assertEquals(expected, solution309.maxProfit(prices));
    }
}
