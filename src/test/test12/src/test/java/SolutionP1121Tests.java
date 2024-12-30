import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP1121Tests {
    private final SolutionP1121 solutionP1121 = new SolutionP1121();

    @Test
    public void example1() {
        int[] nums = {1, 2, 2, 3, 3, 4, 4};
        int k = 3;
        Assertions.assertTrue(solutionP1121.canDivideIntoSubsequences(nums, k));
    }

    @Test
    public void example2() {
        int[] nums = {5, 6, 6, 7, 8};
        int k = 3;
        Assertions.assertFalse(solutionP1121.canDivideIntoSubsequences(nums, k));
    }
}