import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP755Tests {
    private final SolutionP755 solutionP755 = new SolutionP755();

    @Test
    public void example1() {
        int[] heights = {2, 1, 1, 2, 1, 2, 2};
        int volume = 4;
        int k = 3;
        int[] expected = {2, 2, 2, 3, 2, 2, 2};
        Assertions.assertArrayEquals(expected, solutionP755.pourWater(heights, volume, k));
    }

    @Test
    public void example2() {
        int[] heights = {1, 2, 3, 4};
        int volume = 2;
        int k = 2;
        int[] expected = {2, 3, 3, 4};
        Assertions.assertArrayEquals(expected, solutionP755.pourWater(heights, volume, k));
    }

    @Test
    public void example3() {
        int[] heights = {3, 1, 3};
        int volume = 5;
        int k = 1;
        int[] expected = {4, 4, 4};
        Assertions.assertArrayEquals(expected, solutionP755.pourWater(heights, volume, k));
    }
}