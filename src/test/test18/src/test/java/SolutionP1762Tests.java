import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP1762Tests {
    private final SolutionP1762 solutionP1762 = new SolutionP1762();

    @Test
    public void example1() {
        int[] heights = {4, 2, 3, 1};
        int[] expected = {0, 2, 3};
        Assertions.assertArrayEquals(expected, solutionP1762.findBuildings(heights));
    }

    @Test
    public void example2() {
        int[] heights = {4, 3, 2, 1};
        int[] expected = {0, 1, 2, 3};
        Assertions.assertArrayEquals(expected, solutionP1762.findBuildings(heights));
    }

    @Test
    public void example3() {
        int[] heights = {1, 3, 2, 4};
        int[] expected = {3};
        Assertions.assertArrayEquals(expected, solutionP1762.findBuildings(heights));
    }

    @Test
    public void example4() {
        int[] heights = {2, 2, 2, 2};
        int[] expected = {3};
        Assertions.assertArrayEquals(expected, solutionP1762.findBuildings(heights));
    }
}