import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP2863Tests {
    private final SolutionP2863 solutionP2863 = new SolutionP2863();

    @Test
    public void example1() {
        int[] nums = {7, 6, 5, 4, 3, 2, 1, 6, 10, 11};
        int expected = 8;
        Assertions.assertEquals(expected, solutionP2863.maxSubarrayLength(nums));
    }

    @Test
    public void example2() {
        int[] nums = {57, 55, 50, 60, 61, 58, 63, 59, 64, 60, 63};
        int expected = 6;
        Assertions.assertEquals(expected, solutionP2863.maxSubarrayLength(nums));
    }

    @Test
    public void example3() {
        int[] nums = {1, 2, 3, 4};
        int expected = 0;
        Assertions.assertEquals(expected, solutionP2863.maxSubarrayLength(nums));
    }
}