import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP2098Tests {
    private final SolutionP2098 solutionP2098 = new SolutionP2098();

    @Test
    public void example1() {
        int[] nums = {4, 1, 5, 3, 1};
        int k = 3;
        long expected = 12;
        Assertions.assertEquals(expected, solutionP2098.largestEvenSum(nums, k));
    }

    @Test
    public void example2() {
        int[] nums = {4, 6, 2};
        int k = 3;
        long expected = 12;
        Assertions.assertEquals(expected, solutionP2098.largestEvenSum(nums, k));
    }

    @Test
    public void example3() {
        int[] nums = {1, 3, 5};
        int k = 1;
        long expected = -1;
        Assertions.assertEquals(expected, solutionP2098.largestEvenSum(nums, k));
    }
}