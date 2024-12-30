import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP2005Tests {
    private final SolutionP2005 solutionP2005 = new SolutionP2005();

    @Test
    public void example1() {
        int n = 3;
        Assertions.assertTrue(solutionP2005.findGameWinner(n));
        Assertions.assertTrue(solutionP2005.findGameWinner2(n));
    }

    @Test
    public void example2() {
        int n = 1;
        Assertions.assertFalse(solutionP2005.findGameWinner(n));
        Assertions.assertFalse(solutionP2005.findGameWinner2(n));
    }

    @Test
    public void example3() {
        int n = 2;
        Assertions.assertTrue(solutionP2005.findGameWinner(n));
        Assertions.assertTrue(solutionP2005.findGameWinner2(n));
    }
}