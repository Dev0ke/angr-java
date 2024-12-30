import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution879Tests {
    private final Solution879 solution879 = new Solution879();

    @Test
    public void example1() {
        int n = 5;
        int minProfit = 3;
        int[] group = {2, 2};
        int[] profit = {2, 3};
        int expected = 2;
        Assertions.assertEquals(expected, solution879.profitableSchemes(n, minProfit, group, profit));
    }

    @Test
    public void example2() {
        int n = 10;
        int minProfit = 5;
        int[] group = {2, 3, 5};
        int[] profit = {6, 7, 8};
        int expected = 7;
        Assertions.assertEquals(expected, solution879.profitableSchemes(n, minProfit, group, profit));
    }
}
