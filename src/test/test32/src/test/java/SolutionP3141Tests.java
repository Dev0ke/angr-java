import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP3141Tests {
    private final SolutionP3141 solutionP3141 = new SolutionP3141();

    @Test
    public void example1() {
        int[] nums = {9, 12, 9, 11};
        int m = 4;
        int[] expected = {2, 3, 2, 3};
        Assertions.assertArrayEquals(expected, solutionP3141.maxHammingDistances(nums, m));
    }

    @Test
    public void example2() {
        int[] nums = {3, 4, 6, 10};
        int m = 4;
        int[] expected = {3, 3, 2, 3};
        Assertions.assertArrayEquals(expected, solutionP3141.maxHammingDistances(nums, m));
    }
}