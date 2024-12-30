import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP1852Tests {
    private final SolutionP1852 solutionP1852 = new SolutionP1852();

    @Test
    public void example1() {
        int[] nums = {1, 2, 3, 2, 2, 1, 3};
        int k = 3;
        int[] expected = {3, 2, 2, 2, 3};
        Assertions.assertArrayEquals(expected, solutionP1852.distinctNumbers(nums, k));
    }

    @Test
    public void example2() {
        int[] nums = {1, 1, 1, 1, 2, 3, 4};
        int k = 4;
        int[] expected = {1, 2, 3, 4};
        Assertions.assertArrayEquals(expected, solutionP1852.distinctNumbers(nums, k));
    }
}