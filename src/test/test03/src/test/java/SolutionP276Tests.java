import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP276Tests {
    private final SolutionP276 solutionP276 = new SolutionP276();

    @Test
    public void example1() {
        int n = 3;
        int k = 2;
        int expected = 6;
        Assertions.assertEquals(expected, solutionP276.numWays(n, k));
    }

    @Test
    public void example2() {
        int n = 1;
        int k = 1;
        int expected = 1;
        Assertions.assertEquals(expected, solutionP276.numWays(n, k));
    }

    @Test
    public void example3() {
        int n = 7;
        int k = 2;
        int expected = 42;
        Assertions.assertEquals(expected, solutionP276.numWays(n, k));
    }
}
