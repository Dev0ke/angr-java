import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution188Tests {
    private final Solution188 solution188 = new Solution188();

    @Test
    public void example1() {
        int k = 2;
        int[] prices = {2, 4, 1};
        int expected = 2;
        Assertions.assertEquals(expected, solution188.maxProfit(k, prices));
    }

    @Test
    public void example2() {
        int k = 2;
        int[] prices = {3, 2, 6, 5, 0, 3};
        int expected = 7;
        Assertions.assertEquals(expected, solution188.maxProfit(k, prices));
    }
}
