import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP3237Tests {
    private final SolutionP3237 solutionP3237 = new SolutionP3237();

    @Test
    public void example1() {
        int[] windows = {1, 2, 3};
        int[] queries = {3, 3, 2};
        int[] expected = {2, 3, 1};
        Assertions.assertArrayEquals(expected, solutionP3237.simulationResult(windows, queries));
    }

    @Test
    public void example2() {
        int[] windows = {1, 4, 2, 3};
        int[] queries = {4, 1, 3};
        int[] expected = {3, 1, 4, 2};
        Assertions.assertArrayEquals(expected, solutionP3237.simulationResult(windows, queries));
    }
}