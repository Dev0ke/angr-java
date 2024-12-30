import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP2534Tests {
    private final SolutionP2534 solutionP2534 = new SolutionP2534();

    @Test
    public void example1() {
        int[] arrival = {0, 1, 1, 2, 4};
        int[] state = {0, 1, 0, 0, 1};
        int[] expected = {0, 3, 1, 2, 4};
        Assertions.assertArrayEquals(expected, solutionP2534.timeTaken(arrival, state));
    }

    @Test
    public void example2() {
        int[] arrival = {0, 0, 0};
        int[] state = {1, 0, 1};
        int[] expected = {0, 2, 1};
        Assertions.assertArrayEquals(expected, solutionP2534.timeTaken(arrival, state));
    }
}