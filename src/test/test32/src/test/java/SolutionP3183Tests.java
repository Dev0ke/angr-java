import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP3183Tests {
    private final SolutionP3183 solutionP3183 = new SolutionP3183();

    @Test
    public void example1() {
        int n = 4;
        int expected = 4;
        Assertions.assertEquals(expected, solutionP3183.numberOfWays(n));
    }

    @Test
    public void example2() {
        int n = 12;
        int expected = 22;
        Assertions.assertEquals(expected, solutionP3183.numberOfWays(n));
    }

    @Test
    public void example3() {
        int n = 5;
        int expected = 4;
        Assertions.assertEquals(expected, solutionP3183.numberOfWays(n));
    }
}