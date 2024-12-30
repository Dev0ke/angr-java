import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP2291Tests {
    private final SolutionP2291 solutionP2291 = new SolutionP2291();

    @Test
    public void example1() {
        int[] present = {5, 4, 6, 2, 3};
        int[] future = {8, 5, 4, 3, 5};
        int budget = 10;
        int expected = 6;
        Assertions.assertEquals(expected, solutionP2291.maximumProfit(present, future, budget));
    }

    @Test
    public void example2() {
        int[] present = {2, 2, 5};
        int[] future = {3, 4, 10};
        int budget = 6;
        int expected = 5;
        Assertions.assertEquals(expected, solutionP2291.maximumProfit(present, future, budget));
    }

    @Test
    public void example3() {
        int[] present = {3, 3, 12};
        int[] future = {0, 3, 15};
        int budget = 10;
        int expected = 0;
        Assertions.assertEquals(expected, solutionP2291.maximumProfit(present, future, budget));
    }
}