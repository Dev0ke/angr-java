import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP2524Tests {
    private final SolutionP2524 solutionP2524 = new SolutionP2524();

    @Test
    public void example1() {
        int[] nums = {1, 1, 1, 2, 1, 2};
        int k = 3;
        int expected = 5;
        Assertions.assertEquals(expected, solutionP2524.maxFrequencyScore(nums, k));
    }

    @Test
    public void example2() {
        int[] nums = {1, 1, 1, 1, 1, 1};
        int k = 4;
        int expected = 1;
        Assertions.assertEquals(expected, solutionP2524.maxFrequencyScore(nums, k));
    }
}