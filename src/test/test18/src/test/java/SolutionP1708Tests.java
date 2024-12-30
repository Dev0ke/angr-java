import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP1708Tests {
    private final SolutionP1708 solutionP1708 = new SolutionP1708();

    @Test
    public void example1() {
        int[] nums = {1, 4, 5, 2, 3};
        int k = 3;
        int[] expected = {5, 2, 3};
        Assertions.assertArrayEquals(expected, solutionP1708.largestSubarray(nums, k));
    }

    @Test
    public void example2() {
        int[] nums = {1, 4, 5, 2, 3};
        int k = 4;
        int[] expected = {4, 5, 2, 3};
        Assertions.assertArrayEquals(expected, solutionP1708.largestSubarray(nums, k));
    }

    @Test
    public void example3() {
        int[] nums = {1, 4, 5, 2, 3};
        int k = 1;
        int[] expected = {5};
        Assertions.assertArrayEquals(expected, solutionP1708.largestSubarray(nums, k));
    }
}