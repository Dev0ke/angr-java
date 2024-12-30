import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP2464Tests {
    private final SolutionP2464 solutionP2464 = new SolutionP2464();

    @Test
    public void example1() {
        int[] nums = {2, 6, 3, 4, 3};
        int expected = 2;
        Assertions.assertEquals(expected, solutionP2464.validSubarraySplit(nums));
    }

    @Test
    public void example2() {
        int[] nums = {3, 5};
        int expected = 2;
        Assertions.assertEquals(expected, solutionP2464.validSubarraySplit(nums));
    }

    @Test
    public void example3() {
        int[] nums = {1, 2, 1};
        int expected = -1;
        Assertions.assertEquals(expected, solutionP2464.validSubarraySplit(nums));
    }
}