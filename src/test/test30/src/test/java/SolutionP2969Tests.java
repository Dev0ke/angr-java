import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP2969Tests {
    private final SolutionP2969 solutionP2969 = new SolutionP2969();

    @Test
    public void example1() {
        int[] prices = {3, 1, 2};
        int expected = 4;
        Assertions.assertEquals(expected, solutionP2969.minimumCoins(prices));
    }

    @Test
    public void example2() {
        int[] prices = {1, 10, 1, 1};
        int expected = 2;
        Assertions.assertEquals(expected, solutionP2969.minimumCoins(prices));
    }
}