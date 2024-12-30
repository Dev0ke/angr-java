import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP2898Tests {
    private final SolutionP2898 solutionP2898 = new SolutionP2898();

    @Test
    public void example1() {
        int[] prices = {1, 5, 3, 7, 8};
        long expected = 20;
        Assertions.assertEquals(expected, solutionP2898.maxScore(prices));
    }

    @Test
    public void example2() {
        int[] prices = {5, 6, 7, 8, 9};
        long expected = 35;
        Assertions.assertEquals(expected, solutionP2898.maxScore(prices));
    }
}