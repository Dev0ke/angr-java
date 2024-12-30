import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP2941Tests {
    private final SolutionP2941 solutionP2941 = new SolutionP2941();

    @Test
    public void example1() {
        int[] nums = {2, 1, 4, 4, 4, 2};
        int k = 2;
        long expected = 48;
        Assertions.assertEquals(expected, solutionP2941.maxGcdSum(nums, k));
    }

    @Test
    public void example2() {
        int[] nums = {7, 3, 9, 4};
        int k = 1;
        long expected = 81;
        Assertions.assertEquals(expected, solutionP2941.maxGcdSum(nums, k));
    }
}