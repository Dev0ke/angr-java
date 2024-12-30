import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP2921Tests {
    private final SolutionP2921 solutionP2921 = new SolutionP2921();

    @Test
    public void example1() {
        int[] prices = {10, 2, 3, 4};
        int[] profits = {100, 2, 7, 10};
        int expected = 19;
        Assertions.assertEquals(expected, solutionP2921.maxProfit(prices, profits));
    }

    @Test
    public void example2() {
        int[] prices = {1, 2, 3, 4, 5};
        int[] profits = {1, 5, 3, 4, 6};
        int expected = 15;
        Assertions.assertEquals(expected, solutionP2921.maxProfit(prices, profits));
    }

    @Test
    public void example3() {
        int[] prices = {4, 3, 2, 1};
        int[] profits = {33, 20, 19, 87};
        int expected = -1;
        Assertions.assertEquals(expected, solutionP2921.maxProfit(prices, profits));
    }
}