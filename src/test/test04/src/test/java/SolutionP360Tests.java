import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP360Tests {
    private final SolutionP360 solutionP360 = new SolutionP360();

    @Test
    public void example1() {
        int[] nums = {-4, -2, 2, 4};
        int a = 1;
        int b = 3;
        int c = 5;
        int[] expected = {3, 9, 15, 33};
        Assertions.assertArrayEquals(expected, solutionP360.sortTransformedArray(nums, a, b, c));
    }

    @Test
    public void example2() {
        int[] nums = {-4, -2, 2, 4};
        int a = -1;
        int b = 3;
        int c = 5;
        int[] expected = {-23, -5, 1, 7};
        Assertions.assertArrayEquals(expected, solutionP360.sortTransformedArray(nums, a, b, c));
    }
}
