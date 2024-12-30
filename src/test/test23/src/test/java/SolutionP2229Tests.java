import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP2229Tests {
    private final SolutionP2229 solutionP2229 = new SolutionP2229();

    @Test
    public void example1() {
        int[] nums = {1, 3, 4, 2};
        Assertions.assertTrue(solutionP2229.isConsecutive(nums));
    }

    @Test
    public void example2() {
        int[] nums = {1, 3};
        Assertions.assertFalse(solutionP2229.isConsecutive(nums));
    }

    @Test
    public void example3() {
        int[] nums = {3, 5, 4};
        Assertions.assertTrue(solutionP2229.isConsecutive(nums));
    }
}