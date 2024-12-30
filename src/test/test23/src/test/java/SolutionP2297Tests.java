import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP2297Tests {
    private final SolutionP2297 solutionP2297 = new SolutionP2297();

    @Test
    public void example1() {
        int[] nums = {3, 2, 4, 4, 1};
        int[] costs = {3, 7, 6, 4, 2};
        long expected = 8;
        Assertions.assertEquals(expected, solutionP2297.minCost(nums, costs));
    }

    @Test
    public void example2() {
        int[] nums = {0, 1, 2};
        int[] costs = {1, 1, 1};
        long expected = 2;
        Assertions.assertEquals(expected, solutionP2297.minCost(nums, costs));
    }
}