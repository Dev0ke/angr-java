import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP1099Tests {
    private final SolutionP1099 solutionP1099 = new SolutionP1099();

    @Test
    public void example1() {
        int[] nums = {34, 23, 1, 24, 75, 33, 54, 8};
        int k = 60;
        int expected = 58;
        Assertions.assertEquals(expected, solutionP1099.twoSumLessThanK(nums, k));
    }

    @Test
    public void example2() {
        int[] nums = {10, 20, 30};
        int k = 15;
        int expected = -1;
        Assertions.assertEquals(expected, solutionP1099.twoSumLessThanK(nums, k));
    }
}
