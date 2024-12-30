import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP2599Tests {
    private final SolutionP2599 solutionP2599 = new SolutionP2599();

    @Test
    public void example1() {
        int[] nums = {2, 3, -5, 4};
        int expected = 0;
        Assertions.assertEquals(expected, solutionP2599.makePrefSumNonNegative(nums));
    }

    @Test
    public void example2() {
        int[] nums = {3, -5, -2, 6};
        int expected = 1;
        Assertions.assertEquals(expected, solutionP2599.makePrefSumNonNegative(nums));
    }
}