import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP2992Tests {
    private final SolutionP2992 solutionP2992 = new SolutionP2992();

    @Test
    public void example1() {
        int n = 1;
        int expected = 1;
        Assertions.assertEquals(expected, solutionP2992.selfDivisiblePermutationCount(n));
    }

    @Test
    public void example2() {
        int n = 2;
        int expected = 1;
        Assertions.assertEquals(expected, solutionP2992.selfDivisiblePermutationCount(n));
    }

    @Test
    public void example3() {
        int n = 3;
        int expected = 3;
        Assertions.assertEquals(expected, solutionP2992.selfDivisiblePermutationCount(n));
    }
}