import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP1908Tests {
    private final SolutionP1908 solutionP1908 = new SolutionP1908();

    @Test
    public void example1() {
        int[] piles = {1};
        Assertions.assertTrue(solutionP1908.nimGame(piles));
    }

    @Test
    public void example2() {
        int[] piles = {1, 1};
        Assertions.assertFalse(solutionP1908.nimGame(piles));
    }

    @Test
    public void example3() {
        int[] piles = {1, 2, 3};
        Assertions.assertFalse(solutionP1908.nimGame(piles));
    }
}